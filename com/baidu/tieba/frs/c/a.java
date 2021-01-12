package com.baidu.tieba.frs.c;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends b {
    private ValueAnimator jCK;
    private ValueAnimator jCL;

    public a(g gVar, Intent intent) {
        super(gVar, intent);
        init();
    }

    private void init() {
        this.jCK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jCK.setDuration(270L);
        this.jCK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.a.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    a.this.jCU.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jCK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.jCU.mRootView.setAlpha(1.0f);
                a.this.mState = 2;
                if (a.this.jCV != null) {
                    a.this.jCV.onStateChanged(a.this.mState);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jCL = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jCL.setDuration(500L);
        this.jCL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    a.this.jCU.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jCL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.jCU.mRootView.setAlpha(0.0f);
                a.this.mState = 0;
                if (a.this.jCV != null) {
                    a.this.jCV.onStateChanged(a.this.mState);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.c.b
    public void cIY() {
        if (this.mState == 0) {
            this.mState = 1;
            if (this.jCV != null) {
                this.jCV.onStateChanged(this.mState);
            }
            this.jCK.start();
            cJc();
            cJb();
            cJa();
            cJd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.c.b
    public void cIZ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jCV != null) {
                this.jCV.onStateChanged(this.mState);
            }
            this.jCL.start();
        }
    }

    private void cJa() {
        if (this.mIntent != null) {
            ArrayList<Integer> integerArrayListExtra = this.mIntent.getIntegerArrayListExtra("info_forum_head_background_color");
            if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
                this.jCU.jDg.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
            }
            String stringExtra = this.mIntent.getStringExtra("info_forum_head_background_vector");
            if (!at.isEmpty(stringExtra)) {
                this.jCU.jDn.startLoad(stringExtra, 10, false);
            }
            this.jCU.gLN.post(new Runnable() { // from class: com.baidu.tieba.frs.c.a.5
                @Override // java.lang.Runnable
                public void run() {
                    final float min = Math.min(269.0f / a.this.jCU.gLN.getWidth(), 141.0f / a.this.jCU.gLN.getHeight());
                    final float left = 516.0f - ((a.this.jCU.gLN.getLeft() + a.this.jCU.gLN.getRight()) / 2.0f);
                    final float top = 529.0f - ((a.this.jCU.gLN.getTop() + a.this.jCU.gLN.getBottom()) / 2.0f);
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.a.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            a.this.jCU.gLN.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            a.this.jCU.gLN.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            a.this.jCU.gLN.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                            a.this.jCU.gLN.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.a.5.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            a.this.jCU.gLN.setScaleX(1.0f);
                            a.this.jCU.gLN.setScaleY(1.0f);
                            a.this.jCU.gLN.setTranslationX(0.0f);
                            a.this.jCU.gLN.setTranslationY(0.0f);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    ofFloat.start();
                }
            });
        }
    }

    private void cJb() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_name_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_name_text");
            if (!at.isEmpty(stringExtra)) {
                this.jCU.jDi.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
                this.jCU.jDi.post(new Runnable() { // from class: com.baidu.tieba.frs.c.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - a.this.jCU.jDi.getLeft();
                        final float top = rect.top - a.this.jCU.jDi.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.a.6.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    a.this.jCU.jDi.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    a.this.jCU.jDi.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.a.6.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                a.this.jCU.jDi.setTranslationX(0.0f);
                                a.this.jCU.jDi.setTranslationY(0.0f);
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator) {
                            }
                        });
                        ofFloat.start();
                    }
                });
            }
        }
    }

    private void cJc() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_image_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_image_url");
            if (!at.isEmpty(stringExtra)) {
                this.jCU.jDh.startLoad(stringExtra, 10, false);
                this.jCU.jDh.post(new Runnable() { // from class: com.baidu.tieba.frs.c.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - a.this.jCU.jDh.getLeft();
                        final float top = rect.top - a.this.jCU.jDh.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.a.7.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    a.this.jCU.jDh.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    a.this.jCU.jDh.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.a.7.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                a.this.jCU.jDh.setTranslationX(0.0f);
                                a.this.jCU.jDh.setTranslationY(0.0f);
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator) {
                            }
                        });
                        ofFloat.start();
                    }
                });
            }
        }
    }

    private void cJd() {
        if (this.mIntent != null && this.jCU.jDk != null) {
            this.jCU.jDk.post(new Runnable() { // from class: com.baidu.tieba.frs.c.a.8
                @Override // java.lang.Runnable
                public void run() {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    final int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.a.8.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (valueAnimator.isRunning()) {
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                a.this.jCU.jDk.setTranslationY(dimens - (dimens * floatValue));
                                a.this.jCU.jDk.setAlpha((floatValue / 2.0f) + 0.5f);
                            }
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.a.8.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            a.this.jCU.jDk.setAlpha(1.0f);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    ofFloat.start();
                }
            });
        }
    }
}
