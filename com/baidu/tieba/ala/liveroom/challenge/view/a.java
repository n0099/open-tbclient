package com.baidu.tieba.ala.liveroom.challenge.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.utils.h;
/* loaded from: classes4.dex */
public class a {
    private InterfaceC0657a gYA;
    private AnimatorSet gYB;
    private ValueAnimator gYC;
    private ValueAnimator gYD;
    private int gYE;
    private int gYF;
    private int gYs;

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0657a {
        void bYm();

        void bYn();

        void bYo();

        void bYp();
    }

    public a(Context context) {
        this.gYs = 0;
        this.gYs = h.aC(context);
    }

    public void bQ(int i, int i2) {
        this.gYE = i;
        this.gYF = i2;
    }

    private void a(AlaChallengeLiveView alaChallengeLiveView, int i, int i2, int i3) {
        View anchorAnimLiveLayout = alaChallengeLiveView.getAnchorAnimLiveLayout();
        anchorAnimLiveLayout.setAlpha(1.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) anchorAnimLiveLayout.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        anchorAnimLiveLayout.setLayoutParams(layoutParams);
        anchorAnimLiveLayout.setY(i3);
    }

    private void b(AlaChallengeLiveView alaChallengeLiveView, int i, int i2, int i3) {
        View anchorAnimLiveLayout = alaChallengeLiveView.getAnchorAnimLiveLayout();
        anchorAnimLiveLayout.setAlpha(1.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) anchorAnimLiveLayout.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        anchorAnimLiveLayout.setLayoutParams(layoutParams);
        anchorAnimLiveLayout.setY(i3);
    }

    private void a(AlaChallengeLiveView alaChallengeLiveView, int i) {
        View rivalAnimLiveLayout = alaChallengeLiveView.getRivalAnimLiveLayout();
        rivalAnimLiveLayout.setX(i);
        rivalAnimLiveLayout.setAlpha(1.0f);
        rivalAnimLiveLayout.setVisibility(0);
    }

    private void c(AlaChallengeLiveView alaChallengeLiveView) {
        alaChallengeLiveView.getRivalAnimLiveLayout().setAlpha(0.0f);
    }

    private ValueAnimator d(AlaChallengeLiveView alaChallengeLiveView) {
        final View leftTimeView = alaChallengeLiveView.getLeftTimeView();
        int i = this.gYs;
        leftTimeView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) leftTimeView.getLayoutParams();
        layoutParams.topMargin = i;
        leftTimeView.setLayoutParams(layoutParams);
        leftTimeView.setAlpha(0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                leftTimeView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(280L);
        return ofFloat;
    }

    private void e(AlaChallengeLiveView alaChallengeLiveView) {
        View leftTimeView = alaChallengeLiveView.getLeftTimeView();
        int i = this.gYs;
        int height = leftTimeView.getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) leftTimeView.getLayoutParams();
        layoutParams.topMargin = i - height;
        leftTimeView.setLayoutParams(layoutParams);
        leftTimeView.setVisibility(4);
        leftTimeView.setAlpha(0.0f);
    }

    private ValueAnimator f(AlaChallengeLiveView alaChallengeLiveView) {
        final View rivalUserInfoView = alaChallengeLiveView.getRivalUserInfoView();
        rivalUserInfoView.setAlpha(0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                rivalUserInfoView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(280L);
        return ofFloat;
    }

    private void g(AlaChallengeLiveView alaChallengeLiveView) {
        alaChallengeLiveView.getRivalUserInfoView().setAlpha(0.0f);
    }

    private ValueAnimator h(AlaChallengeLiveView alaChallengeLiveView) {
        View scoreProgressLayout = alaChallengeLiveView.getScoreProgressLayout();
        final View jinzhuLayout = alaChallengeLiveView.getJinzhuLayout();
        scoreProgressLayout.setAlpha(1.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        jinzhuLayout.setAlpha(0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                jinzhuLayout.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(500L);
        return ofFloat;
    }

    private void i(AlaChallengeLiveView alaChallengeLiveView) {
        View scoreProgressLayout = alaChallengeLiveView.getScoreProgressLayout();
        View jinzhuLayout = alaChallengeLiveView.getJinzhuLayout();
        scoreProgressLayout.setAlpha(0.0f);
        jinzhuLayout.setAlpha(0.0f);
    }

    public void j(AlaChallengeLiveView alaChallengeLiveView) {
        final View rivalAnimLiveLayout;
        if (alaChallengeLiveView != null && (rivalAnimLiveLayout = alaChallengeLiveView.getRivalAnimLiveLayout()) != null && rivalAnimLiveLayout.getAlpha() != 0.0f) {
            if (this.gYD != null) {
                this.gYD.cancel();
            }
            this.gYD = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.gYD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    rivalAnimLiveLayout.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.gYD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (a.this.gYA != null) {
                        a.this.gYA.bYp();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.gYD.setDuration(300L);
            this.gYD.start();
        }
    }

    public void k(AlaChallengeLiveView alaChallengeLiveView) {
        View anchorAnimLiveLayout;
        if (alaChallengeLiveView != null && (anchorAnimLiveLayout = alaChallengeLiveView.getAnchorAnimLiveLayout()) != null && anchorAnimLiveLayout.getAlpha() != 0.0f) {
            anchorAnimLiveLayout.setAlpha(0.0f);
            if (this.gYA != null) {
                this.gYA.bYo();
            }
        }
    }

    public void Ho() {
        if (this.gYB != null) {
            this.gYB.cancel();
        }
        if (this.gYC != null) {
            this.gYC.cancel();
        }
        if (this.gYD != null) {
            this.gYD.cancel();
        }
    }

    public void a(Activity activity, AlaChallengeLiveView alaChallengeLiveView) {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(activity);
        int i = screenFullSize[0] / 2;
        a(alaChallengeLiveView, i, h.fU(i), this.gYs);
        a(alaChallengeLiveView, screenFullSize[0] / 2);
        ValueAnimator h = h(alaChallengeLiveView);
        ValueAnimator d = d(alaChallengeLiveView);
        ValueAnimator f = f(alaChallengeLiveView);
        if (this.gYB != null) {
            this.gYB.cancel();
        }
        this.gYB = new AnimatorSet();
        this.gYB.setDuration(500L);
        this.gYB.playTogether(h, d, f);
        this.gYB.setStartDelay(200L);
        this.gYB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.gYA != null) {
                    a.this.gYA.bYm();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gYB.start();
        alaChallengeLiveView.bYi();
    }

    public void b(Activity activity, AlaChallengeLiveView alaChallengeLiveView) {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(activity);
        e(alaChallengeLiveView);
        g(alaChallengeLiveView);
        i(alaChallengeLiveView);
        alaChallengeLiveView.bYj();
        c(alaChallengeLiveView);
        b(alaChallengeLiveView, screenFullSize[0], screenFullSize[1], 0);
        if (this.gYA != null) {
            this.gYA.bYn();
        }
    }

    public void a(InterfaceC0657a interfaceC0657a) {
        this.gYA = interfaceC0657a;
    }
}
