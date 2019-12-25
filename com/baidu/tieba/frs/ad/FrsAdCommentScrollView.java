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
/* loaded from: classes6.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private TextView god;
    private TextView goe;
    private FrameLayout gof;
    private FrameLayout gog;
    private ValueAnimator goh;
    private List<i> goi;
    private int goj;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.goj;
        frsAdCommentScrollView.goj = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.goj = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bDC();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.goj = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bDC();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.goj = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bDC();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.goi = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.god = (TextView) findViewById(R.id.cur_display_view);
        this.goe = (TextView) findViewById(R.id.next_display_view);
        this.gof = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.gof.setTag(this.god);
        this.gog = (FrameLayout) findViewById(R.id.next_display_layout);
        this.gog.setTag(this.goe);
    }

    public void kV(boolean z) {
        if (z) {
            bDA();
        }
    }

    public void bg(List<i> list) {
        if (v.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.goi.clear();
        this.goi.addAll(list);
        setVisibility(0);
        this.goj = 0;
        bDB();
        bDA();
    }

    private void bDA() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.getCount(this.goi) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDB() {
        i iVar;
        i iVar2 = (i) v.getItem(this.goi, this.goj);
        if (this.goj + 1 >= this.goi.size()) {
            iVar = (i) v.getItem(this.goi, 0);
        } else {
            iVar = (i) v.getItem(this.goi, this.goj + 1);
        }
        if ((this.gof.getTag() instanceof TextView) && iVar2 != null) {
            String title = iVar2.getTitle();
            if (iVar2.cHu()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.gof.getTag()).setText(title);
        }
        if ((this.gog.getTag() instanceof TextView) && iVar != null) {
            String title2 = iVar.getTitle();
            ((TextView) this.gog.getTag()).setText(iVar.cHu() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDC() {
        final float y = this.gog.getY();
        this.goh = ValueAnimator.ofFloat(0.0f, this.gof.getMeasuredHeight());
        this.goh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.gof.setY(-floatValue);
                FrsAdCommentScrollView.this.gog.setY(y - floatValue);
            }
        });
        this.goh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.goj == FrsAdCommentScrollView.this.goi.size()) {
                    FrsAdCommentScrollView.this.goj = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.gof;
                FrsAdCommentScrollView.this.gof = FrsAdCommentScrollView.this.gog;
                FrsAdCommentScrollView.this.gog = frameLayout;
                FrsAdCommentScrollView.this.gog.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bDB();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.goh.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.goh != null) {
            this.goh.cancel();
        }
    }
}
