package com.baidu.tbadk.k;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g extends a {
    private final int arrayLength;
    private int currentIndex;
    private boolean eUm;
    private final Animator.AnimatorListener eUu;
    private ContinuousAnimationView frR;
    private ValueAnimator.AnimatorUpdateListener frS;
    private TextView loadingTextView;
    private int mSkinType;
    private Runnable runnable;
    private String[] textArray;
    private TextView textView;

    /* JADX INFO: Access modifiers changed from: private */
    public int getNextIndex() {
        this.currentIndex++;
        if (this.currentIndex >= this.arrayLength) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public g(Context context) {
        this(context, 0);
    }

    public g(Context context, int i) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.runnable = new Runnable() { // from class: com.baidu.tbadk.k.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (!g.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.runnable);
                    return;
                }
                g.this.textView.setText(g.this.textArray[g.this.getNextIndex()]);
                TbadkCoreApplication.getInst().handler.postDelayed(g.this.runnable, 200L);
            }
        };
        this.frS = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.k.g.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!g.this.eUm) {
                    g.this.frR.setAlpha(Math.min(1.0f, (valueAnimator.getAnimatedFraction() * 24.0f) / 6.0f));
                }
            }
        };
        this.eUu = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.k.g.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                g.this.eUm = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                g.this.eUm = true;
            }
        };
        this.frR = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.frR.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.frR.setLayoutParams(marginLayoutParams);
            }
        }
        ap.a(this.frR, R.raw.lottie_full_screen_refresh);
        this.frR.setMinAndMaxProgress(0.0f, 1.0f);
        this.frR.setRepeatMode(1);
        this.frR.addAnimatorUpdateListener(this.frS);
        this.frR.addAnimatorListener(this.eUu);
        this.frR.setSpeed(1.2f);
        this.textView = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.loadingTextView = (TextView) this.attachedView.findViewById(R.id.loading_text);
        this.textArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.arrayLength = this.textArray.length;
    }

    private void startLoadingAnimation() {
        if (this.frR != null) {
            this.frR.playAnimation();
        }
    }

    private void stopLoadingAnimation() {
        if (this.frR != null) {
            this.frR.pauseAnimation();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewAttached() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        ap.a(this.frR, R.raw.lottie_full_screen_refresh);
        startLoadingAnimation();
        ap.setViewTextColor(this.textView, R.color.CAM_X0108, 1, this.mSkinType);
        ap.setViewTextColor(this.loadingTextView, R.color.CAM_X0108, 1, this.mSkinType);
        this.textView.setText(this.textArray[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        TbadkCoreApplication.getInst().handler.postDelayed(this.runnable, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        stopLoadingAnimation();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            ap.setViewTextColor(this.textView, R.color.CAM_X0108, 1, this.mSkinType);
            ap.setViewTextColor(this.loadingTextView, R.color.CAM_X0108, 1, this.mSkinType);
            startLoadingAnimation();
        }
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.textView, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.loadingTextView, R.color.CAM_X0108, 1, i);
        ap.a(this.frR, R.raw.lottie_full_screen_refresh);
        if (isViewAttached()) {
            startLoadingAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        TbadkCoreApplication.getInst().handler.postDelayed(this.runnable, 200L);
        this.mSkinType = i;
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.k.a
    public void dettachView(View view) {
        if (this.frR != null) {
            this.frR.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        super.dettachView(view);
    }

    public void setBackground(int i) {
        if (this.attachedView != null) {
            this.attachedView.setBackgroundColor(i);
        }
    }

    public void setTopMargin(int i) {
        if (this.frR != null) {
            ViewGroup.LayoutParams layoutParams = this.frR.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.frR.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void br(int i) {
        if (this.frR != null && this.loadingTextView != null) {
            if (this.loadingTextView.getVisibility() == 8) {
                ViewGroup.LayoutParams layoutParams = this.frR.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.bottomMargin = i;
                    this.frR.setLayoutParams(marginLayoutParams);
                    return;
                }
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.loadingTextView.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.bottomMargin = i;
                this.loadingTextView.setLayoutParams(marginLayoutParams2);
            }
        }
    }

    public void bAw() {
        if (this.frR != null) {
            ((RelativeLayout.LayoutParams) this.frR.getLayoutParams()).addRule(15, 0);
        }
    }

    public TextView getLoadingTextView() {
        return this.loadingTextView;
    }
}
