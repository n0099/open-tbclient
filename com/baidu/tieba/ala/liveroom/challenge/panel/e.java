package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public abstract class e {
    private static final int eaY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds589);
    protected k eaZ;
    protected Context mContext;
    protected View mRootView;

    protected abstract View createView();

    public e(Context context, k kVar) {
        this.mContext = context;
        this.eaZ = kVar;
        if (this.mContext != null) {
            this.mRootView = createView();
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
                this.mRootView.setBackgroundResource(a.f.ala_challenge_panel_bg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aQB() {
        return eaY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(FrameLayout frameLayout, int i) {
        if (frameLayout != null && this.mRootView != null) {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.mRootView.getLayoutParams() == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, aQB());
                layoutParams.gravity = 80;
                frameLayout.addView(this.mRootView, layoutParams);
            } else {
                frameLayout.addView(this.mRootView);
            }
            if (i <= 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0068a.sdk_push_up_in);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.e.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        e.this.aax();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mRootView.startAnimation(loadAnimation);
            } else if (i != aQB()) {
                ValueAnimator ofInt = ValueAnimator.ofInt(i, aQB());
                ofInt.setDuration(300L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.e.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator != null) {
                            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) e.this.mRootView.getLayoutParams();
                            layoutParams2.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            e.this.mRootView.setLayoutParams(layoutParams2);
                        }
                    }
                });
                ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.e.4
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        e.this.aax();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                ofInt.start();
            } else {
                aax();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aax() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onBackKeyDown() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startAnimation(Animation animation) {
        this.mRootView.startAnimation(animation);
    }
}
