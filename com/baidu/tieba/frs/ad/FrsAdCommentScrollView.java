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
/* loaded from: classes4.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private FrameLayout fAA;
    private FrameLayout fAB;
    private ValueAnimator fAC;
    private List<i> fAD;
    private int fAE;
    private TextView fAy;
    private TextView fAz;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.fAE;
        frsAdCommentScrollView.fAE = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.fAE = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bmh();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.fAE = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bmh();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.fAE = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bmh();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.fAD = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.fAy = (TextView) findViewById(R.id.cur_display_view);
        this.fAz = (TextView) findViewById(R.id.next_display_view);
        this.fAA = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.fAA.setTag(this.fAy);
        this.fAB = (FrameLayout) findViewById(R.id.next_display_layout);
        this.fAB.setTag(this.fAz);
    }

    public void jJ(boolean z) {
        if (z) {
            bmf();
        }
    }

    public void bh(List<i> list) {
        if (v.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.fAD.clear();
        this.fAD.addAll(list);
        setVisibility(0);
        this.fAE = 0;
        bmg();
        bmf();
    }

    private void bmf() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.getCount(this.fAD) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmg() {
        i iVar;
        i iVar2 = (i) v.getItem(this.fAD, this.fAE);
        if (this.fAE + 1 >= this.fAD.size()) {
            iVar = (i) v.getItem(this.fAD, 0);
        } else {
            iVar = (i) v.getItem(this.fAD, this.fAE + 1);
        }
        if ((this.fAA.getTag() instanceof TextView) && iVar2 != null) {
            String title = iVar2.getTitle();
            if (iVar2.cnq()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.fAA.getTag()).setText(title);
        }
        if ((this.fAB.getTag() instanceof TextView) && iVar != null) {
            String title2 = iVar.getTitle();
            ((TextView) this.fAB.getTag()).setText(iVar.cnq() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmh() {
        final float y = this.fAB.getY();
        this.fAC = ValueAnimator.ofFloat(0.0f, this.fAA.getMeasuredHeight());
        this.fAC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.fAA.setY(-floatValue);
                FrsAdCommentScrollView.this.fAB.setY(y - floatValue);
            }
        });
        this.fAC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.fAE == FrsAdCommentScrollView.this.fAD.size()) {
                    FrsAdCommentScrollView.this.fAE = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.fAA;
                FrsAdCommentScrollView.this.fAA = FrsAdCommentScrollView.this.fAB;
                FrsAdCommentScrollView.this.fAB = frameLayout;
                FrsAdCommentScrollView.this.fAB.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bmg();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fAC.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.fAC != null) {
            this.fAC.cancel();
        }
    }
}
