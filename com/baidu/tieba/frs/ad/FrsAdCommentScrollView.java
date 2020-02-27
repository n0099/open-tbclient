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
    private TextView gtn;
    private TextView gto;
    private FrameLayout gtp;
    private FrameLayout gtq;
    private ValueAnimator gtr;
    private List<i> gts;
    private int gtt;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.gtt;
        frsAdCommentScrollView.gtt = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.gtt = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bGg();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.gtt = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bGg();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.gtt = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bGg();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.gts = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.gtn = (TextView) findViewById(R.id.cur_display_view);
        this.gto = (TextView) findViewById(R.id.next_display_view);
        this.gtp = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.gtp.setTag(this.gtn);
        this.gtq = (FrameLayout) findViewById(R.id.next_display_layout);
        this.gtq.setTag(this.gto);
    }

    public void onPrimary(boolean z) {
        if (z) {
            bGe();
        }
    }

    public void bf(List<i> list) {
        if (v.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.gts.clear();
        this.gts.addAll(list);
        setVisibility(0);
        this.gtt = 0;
        bGf();
        bGe();
    }

    private void bGe() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.getCount(this.gts) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGf() {
        i iVar;
        i iVar2 = (i) v.getItem(this.gts, this.gtt);
        if (this.gtt + 1 >= this.gts.size()) {
            iVar = (i) v.getItem(this.gts, 0);
        } else {
            iVar = (i) v.getItem(this.gts, this.gtt + 1);
        }
        if ((this.gtp.getTag() instanceof TextView) && iVar2 != null) {
            String title = iVar2.getTitle();
            if (iVar2.cKe()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.gtp.getTag()).setText(title);
        }
        if ((this.gtq.getTag() instanceof TextView) && iVar != null) {
            String title2 = iVar.getTitle();
            ((TextView) this.gtq.getTag()).setText(iVar.cKe() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGg() {
        final float y = this.gtq.getY();
        this.gtr = ValueAnimator.ofFloat(0.0f, this.gtp.getMeasuredHeight());
        this.gtr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.gtp.setY(-floatValue);
                FrsAdCommentScrollView.this.gtq.setY(y - floatValue);
            }
        });
        this.gtr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.gtt == FrsAdCommentScrollView.this.gts.size()) {
                    FrsAdCommentScrollView.this.gtt = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.gtp;
                FrsAdCommentScrollView.this.gtp = FrsAdCommentScrollView.this.gtq;
                FrsAdCommentScrollView.this.gtq = frameLayout;
                FrsAdCommentScrollView.this.gtq.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bGf();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gtr.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.gtr != null) {
            this.gtr.cancel();
        }
    }
}
