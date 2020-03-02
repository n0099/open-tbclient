package com.baidu.tieba.frs.ad;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private TextView gtp;
    private TextView gtq;
    private FrameLayout gtr;
    private FrameLayout gts;
    private ValueAnimator gtt;
    private List<i> gtu;
    private int gtv;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.gtv;
        frsAdCommentScrollView.gtv = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.gtv = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bGi();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.gtv = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bGi();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.gtv = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bGi();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.gtu = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.gtp = (TextView) findViewById(R.id.cur_display_view);
        this.gtq = (TextView) findViewById(R.id.next_display_view);
        this.gtr = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.gtr.setTag(this.gtp);
        this.gts = (FrameLayout) findViewById(R.id.next_display_layout);
        this.gts.setTag(this.gtq);
    }

    public void onPrimary(boolean z) {
        if (z) {
            bGg();
        }
    }

    public void bf(List<i> list) {
        if (v.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.gtu.clear();
        this.gtu.addAll(list);
        setVisibility(0);
        this.gtv = 0;
        bGh();
        bGg();
    }

    private void bGg() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.getCount(this.gtu) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGh() {
        i iVar;
        i iVar2 = (i) v.getItem(this.gtu, this.gtv);
        if (this.gtv + 1 >= this.gtu.size()) {
            iVar = (i) v.getItem(this.gtu, 0);
        } else {
            iVar = (i) v.getItem(this.gtu, this.gtv + 1);
        }
        if ((this.gtr.getTag() instanceof TextView) && iVar2 != null) {
            String title = iVar2.getTitle();
            if (iVar2.cKg()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.gtr.getTag()).setText(title);
        }
        if ((this.gts.getTag() instanceof TextView) && iVar != null) {
            String title2 = iVar.getTitle();
            ((TextView) this.gts.getTag()).setText(iVar.cKg() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGi() {
        final float y = this.gts.getY();
        this.gtt = ValueAnimator.ofFloat(0.0f, this.gtr.getMeasuredHeight());
        this.gtt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.gtr.setY(-floatValue);
                FrsAdCommentScrollView.this.gts.setY(y - floatValue);
            }
        });
        this.gtt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.gtv == FrsAdCommentScrollView.this.gtu.size()) {
                    FrsAdCommentScrollView.this.gtv = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.gtr;
                FrsAdCommentScrollView.this.gtr = FrsAdCommentScrollView.this.gts;
                FrsAdCommentScrollView.this.gts = frameLayout;
                FrsAdCommentScrollView.this.gts.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bGh();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gtt.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.gtt != null) {
            this.gtt.cancel();
        }
    }
}
