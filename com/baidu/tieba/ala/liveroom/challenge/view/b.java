package com.baidu.tieba.ala.liveroom.challenge.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.utils.f;
import com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView;
/* loaded from: classes6.dex */
public class b {
    private a edA;
    private AnimatorSet edB;
    private ValueAnimator edC;
    private ValueAnimator edD;
    private com.baidu.tieba.ala.liveroom.challenge.a.b<String> edE;
    private int edF;
    private int edG;
    private int edx;

    /* loaded from: classes6.dex */
    public interface a {
        void aRd();

        void aRe();

        void aRf();

        void aRg();
    }

    public b(Context context) {
        this.edx = 0;
        this.edx = f.au(context);
    }

    public void aX(int i, int i2) {
        this.edF = i;
        this.edG = i2;
        this.edE = new com.baidu.tieba.ala.liveroom.challenge.a.a(this.edF, this.edG);
    }

    public void a(final TbPageContext tbPageContext, final FrameAnimationView frameAnimationView) {
        frameAnimationView.a(com.baidu.tieba.ala.liveroom.challenge.d.a(com.baidu.tieba.ala.liveroom.challenge.d.aPX(), "challenge_all_in_fire_anim_", 1, 31, 5), 1500, false, this.edE);
        frameAnimationView.setOnFrameAnimationCallback(new FrameAnimationView.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
            @Override // com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.b
            public void aRb() {
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.b
            public void aRc() {
                frameAnimationView.setOnFrameAnimationCallback(null);
                b.this.b(tbPageContext, frameAnimationView);
            }
        });
        frameAnimationView.setBdUniqueId(tbPageContext.getUniqueId());
        frameAnimationView.startAnim();
    }

    public void b(TbPageContext tbPageContext, FrameAnimationView frameAnimationView) {
        frameAnimationView.setVisibility(0);
        frameAnimationView.setAlpha(1.0f);
        frameAnimationView.a(com.baidu.tieba.ala.liveroom.challenge.d.a(com.baidu.tieba.ala.liveroom.challenge.d.aPX(), "challenge_allin_anim_", 1, 12, 5), 1000, true, this.edE);
        frameAnimationView.setBdUniqueId(tbPageContext.getUniqueId());
        frameAnimationView.startAnim();
    }

    public void a(boolean z, FrameAnimationView frameAnimationView, FrameAnimationView frameAnimationView2) {
        if (frameAnimationView != null) {
            frameAnimationView.release();
        }
        if (frameAnimationView2 != null) {
            frameAnimationView2.release();
        }
    }

    private ValueAnimator a(AlaChallengeLiveView alaChallengeLiveView, final int i, final int i2, final int i3, final int i4, final int i5, final int i6, final boolean z) {
        final View anchorAnimLiveLayout = alaChallengeLiveView.getAnchorAnimLiveLayout();
        final View anchorAnimLiveForeBg = alaChallengeLiveView.getAnchorAnimLiveForeBg();
        anchorAnimLiveLayout.setVisibility(0);
        anchorAnimLiveLayout.setAlpha(1.0f);
        int i7 = i > i2 ? i : i2;
        final int i8 = i7 - ((i + i2) - i7);
        int i9 = i3 > i4 ? i3 : i4;
        final int i10 = i9 - ((i3 + i4) - i9);
        int i11 = i5 > i6 ? i5 : i6;
        final int i12 = i11 - ((i5 + i6) - i11);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f;
                float f2;
                float f3;
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float f4 = i8 * animatedFraction;
                if (i > i2) {
                    f = i - f4;
                } else {
                    f = f4 + i;
                }
                float f5 = i10 * animatedFraction;
                if (i3 > i4) {
                    f2 = i3 - f5;
                } else {
                    f2 = f5 + i3;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) anchorAnimLiveLayout.getLayoutParams();
                layoutParams.width = (int) f;
                layoutParams.height = (int) f2;
                anchorAnimLiveLayout.setLayoutParams(layoutParams);
                float animatedFraction2 = valueAnimator.getAnimatedFraction() * i12;
                if (i5 > i6) {
                    f3 = i5 - animatedFraction2;
                } else {
                    f3 = animatedFraction2 + i5;
                }
                anchorAnimLiveLayout.setY(f3);
                if (z) {
                    anchorAnimLiveForeBg.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.setDuration(350L);
        return ofFloat;
    }

    private ValueAnimator a(AlaChallengeLiveView alaChallengeLiveView, final int i, final int i2, final int i3, final boolean z) {
        final View rivalAnimLiveLayout = alaChallengeLiveView.getRivalAnimLiveLayout();
        final View rivalAnimLiveForeBg = alaChallengeLiveView.getRivalAnimLiveForeBg();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f;
                float animatedFraction = valueAnimator.getAnimatedFraction() * i3;
                if (i > i2) {
                    f = i - animatedFraction;
                } else {
                    f = animatedFraction + i;
                }
                rivalAnimLiveLayout.setX(f);
                if (z) {
                    rivalAnimLiveForeBg.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.9
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                rivalAnimLiveForeBg.setAlpha(0.0f);
                rivalAnimLiveLayout.setX(i);
                rivalAnimLiveLayout.setAlpha(1.0f);
                rivalAnimLiveLayout.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.setDuration(300L);
        return ofFloat;
    }

    private ValueAnimator a(AlaChallengeLiveView alaChallengeLiveView, final boolean z) {
        final View leftTimeView = alaChallengeLiveView.getLeftTimeView();
        int i = this.edx;
        int height = leftTimeView.getHeight();
        final int i2 = z ? i - height : i;
        int i3 = z ? i : i - height;
        leftTimeView.setVisibility(z ? 8 : 0);
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) leftTimeView.getLayoutParams();
                layoutParams.topMargin = intValue;
                leftTimeView.setLayoutParams(layoutParams);
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) leftTimeView.getLayoutParams();
                layoutParams.topMargin = i2;
                leftTimeView.setLayoutParams(layoutParams);
                leftTimeView.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                leftTimeView.setVisibility(z ? 0 : 4);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofInt.setDuration(300L);
        return ofInt;
    }

    private ValueAnimator b(AlaChallengeLiveView alaChallengeLiveView, boolean z) {
        final View rivalUserInfoView = alaChallengeLiveView.getRivalUserInfoView();
        rivalUserInfoView.setAlpha(z ? 0.0f : 1.0f);
        ValueAnimator ofFloat = z ? ValueAnimator.ofFloat(0.0f, 1.0f) : ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                rivalUserInfoView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(300L);
        return ofFloat;
    }

    private ValueAnimator c(AlaChallengeLiveView alaChallengeLiveView, boolean z) {
        final View topAdvViewLayout = alaChallengeLiveView.getTopAdvViewLayout();
        final View bottomAdvViewLayout = alaChallengeLiveView.getBottomAdvViewLayout();
        final View scoreProgressLayout = alaChallengeLiveView.getScoreProgressLayout();
        ValueAnimator ofFloat = z ? ValueAnimator.ofFloat(0.0f, 1.0f) : ValueAnimator.ofFloat(1.0f, 0.0f);
        topAdvViewLayout.setAlpha(z ? 0.0f : 1.0f);
        bottomAdvViewLayout.setAlpha(z ? 0.0f : 1.0f);
        scoreProgressLayout.setAlpha(z ? 0.0f : 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                topAdvViewLayout.setAlpha(floatValue);
                bottomAdvViewLayout.setAlpha(floatValue);
                scoreProgressLayout.setAlpha(floatValue);
            }
        });
        ofFloat.setDuration(300L);
        return ofFloat;
    }

    public void b(AlaChallengeLiveView alaChallengeLiveView) {
        final View rivalAnimLiveLayout;
        if (alaChallengeLiveView != null && (rivalAnimLiveLayout = alaChallengeLiveView.getRivalAnimLiveLayout()) != null && rivalAnimLiveLayout.getAlpha() != 0.0f) {
            this.edD = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.edD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.14
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    rivalAnimLiveLayout.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.edD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.edA != null) {
                        b.this.edA.aRg();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.edD.setDuration(300L);
            this.edD.start();
        }
    }

    public void c(AlaChallengeLiveView alaChallengeLiveView) {
        final View anchorAnimLiveLayout;
        if (alaChallengeLiveView != null && (anchorAnimLiveLayout = alaChallengeLiveView.getAnchorAnimLiveLayout()) != null && anchorAnimLiveLayout.getAlpha() != 0.0f) {
            this.edC = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.edC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    anchorAnimLiveLayout.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.edC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.edA != null) {
                        b.this.edA.aRf();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.edC.setDuration(300L);
            this.edC.start();
        }
    }

    public void aRa() {
        if (this.edB != null) {
            this.edB.cancel();
        }
        if (this.edC != null) {
            this.edC.cancel();
        }
        if (this.edD != null) {
            this.edD.cancel();
        }
    }

    public void a(Activity activity, AlaChallengeLiveView alaChallengeLiveView) {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(activity);
        int i = screenFullSize[0];
        int i2 = screenFullSize[1];
        int i3 = screenFullSize[0] / 2;
        ValueAnimator a2 = a(alaChallengeLiveView, i, i3, i2, (i3 * 4) / 3, 0, this.edx, true);
        int i4 = screenFullSize[0];
        int i5 = screenFullSize[0] / 2;
        int i6 = i4 > i5 ? i4 : i5;
        ValueAnimator a3 = a(alaChallengeLiveView, i4, i5, i6 - ((i4 + i5) - i6), true);
        ValueAnimator c = c(alaChallengeLiveView, true);
        ValueAnimator a4 = a(alaChallengeLiveView, true);
        ValueAnimator b = b(alaChallengeLiveView, true);
        if (this.edB != null) {
            this.edB.cancel();
        }
        this.edB = new AnimatorSet();
        this.edB.play(a2);
        this.edB.play(a3).with(c).after(a2);
        this.edB.play(a4).with(b).after(a3);
        this.edB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.edA != null) {
                    b.this.edA.aRd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.edB.start();
    }

    public void b(Activity activity, AlaChallengeLiveView alaChallengeLiveView) {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(activity);
        ValueAnimator a2 = a(alaChallengeLiveView, false);
        ValueAnimator b = b(alaChallengeLiveView, false);
        ValueAnimator c = c(alaChallengeLiveView, false);
        int i = screenFullSize[0] / 2;
        int i2 = screenFullSize[0];
        int i3 = i > i2 ? i : i2;
        ValueAnimator a3 = a(alaChallengeLiveView, i, i2, i3 - ((i + i2) - i3), false);
        int i4 = screenFullSize[0] / 2;
        ValueAnimator a4 = a(alaChallengeLiveView, i4, screenFullSize[0], (i4 * 4) / 3, screenFullSize[1], this.edx, 0, false);
        if (this.edB != null) {
            this.edB.cancel();
        }
        this.edB = new AnimatorSet();
        this.edB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.edA != null) {
                    b.this.edA.aRe();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.edB.play(a2).with(b);
        this.edB.play(a3).after(a2);
        this.edB.play(a4).with(c).after(a3);
        this.edB.start();
    }

    public void a(a aVar) {
        this.edA = aVar;
    }
}
