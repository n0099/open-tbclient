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
    private TextView fzH;
    private TextView fzI;
    private FrameLayout fzJ;
    private FrameLayout fzK;
    private ValueAnimator fzL;
    private List<i> fzM;
    private int fzN;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.fzN;
        frsAdCommentScrollView.fzN = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.fzN = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bmf();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.fzN = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bmf();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.fzN = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bmf();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.fzM = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.fzH = (TextView) findViewById(R.id.cur_display_view);
        this.fzI = (TextView) findViewById(R.id.next_display_view);
        this.fzJ = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.fzJ.setTag(this.fzH);
        this.fzK = (FrameLayout) findViewById(R.id.next_display_layout);
        this.fzK.setTag(this.fzI);
    }

    public void jJ(boolean z) {
        if (z) {
            bmd();
        }
    }

    public void bh(List<i> list) {
        if (v.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.fzM.clear();
        this.fzM.addAll(list);
        setVisibility(0);
        this.fzN = 0;
        bme();
        bmd();
    }

    private void bmd() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.getCount(this.fzM) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bme() {
        i iVar;
        i iVar2 = (i) v.getItem(this.fzM, this.fzN);
        if (this.fzN + 1 >= this.fzM.size()) {
            iVar = (i) v.getItem(this.fzM, 0);
        } else {
            iVar = (i) v.getItem(this.fzM, this.fzN + 1);
        }
        if ((this.fzJ.getTag() instanceof TextView) && iVar2 != null) {
            String title = iVar2.getTitle();
            if (iVar2.cno()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.fzJ.getTag()).setText(title);
        }
        if ((this.fzK.getTag() instanceof TextView) && iVar != null) {
            String title2 = iVar.getTitle();
            ((TextView) this.fzK.getTag()).setText(iVar.cno() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmf() {
        final float y = this.fzK.getY();
        this.fzL = ValueAnimator.ofFloat(0.0f, this.fzJ.getMeasuredHeight());
        this.fzL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.fzJ.setY(-floatValue);
                FrsAdCommentScrollView.this.fzK.setY(y - floatValue);
            }
        });
        this.fzL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.fzN == FrsAdCommentScrollView.this.fzM.size()) {
                    FrsAdCommentScrollView.this.fzN = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.fzJ;
                FrsAdCommentScrollView.this.fzJ = FrsAdCommentScrollView.this.fzK;
                FrsAdCommentScrollView.this.fzK = frameLayout;
                FrsAdCommentScrollView.this.fzK.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bme();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fzL.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.fzL != null) {
            this.fzL.cancel();
        }
    }
}
