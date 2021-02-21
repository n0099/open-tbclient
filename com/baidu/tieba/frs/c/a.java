package com.baidu.tieba.frs.c;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends b {
    private ValueAnimator jIC;
    private ValueAnimator jID;

    public a(g gVar, Intent intent) {
        super(gVar, intent);
        init();
    }

    private void init() {
        this.jIC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jIC.setDuration(270L);
        this.jIC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.a.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    a.this.jIM.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jIC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.jIM.mRootView.setAlpha(1.0f);
                a.this.mState = 2;
                if (a.this.jIN != null) {
                    a.this.jIN.onStateChanged(a.this.mState);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jID = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jID.setDuration(500L);
        this.jID.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    a.this.jIM.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jID.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.jIM.mRootView.setAlpha(0.0f);
                a.this.mState = 0;
                if (a.this.jIN != null) {
                    a.this.jIN.onStateChanged(a.this.mState);
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
    public void cKs() {
        if (this.mState == 0) {
            this.mState = 1;
            if (this.jIN != null) {
                this.jIN.onStateChanged(this.mState);
            }
            this.jIC.start();
            cKw();
            cKv();
            cKu();
            cKx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.c.b
    public void cKt() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jIN != null) {
                this.jIN.onStateChanged(this.mState);
            }
            this.jID.start();
        }
    }

    private void cKu() {
        if (this.mIntent != null) {
            ArrayList<Integer> integerArrayListExtra = this.mIntent.getIntegerArrayListExtra("info_forum_head_background_color");
            if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
                this.jIM.jIY.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
            }
            String stringExtra = this.mIntent.getStringExtra("info_forum_head_background_vector");
            if (!au.isEmpty(stringExtra)) {
                this.jIM.jJf.startLoad(stringExtra, 10, false);
            }
            this.jIM.gOH.post(new Runnable() { // from class: com.baidu.tieba.frs.c.a.5
                @Override // java.lang.Runnable
                public void run() {
                    final float min = Math.min(269.0f / a.this.jIM.gOH.getWidth(), 141.0f / a.this.jIM.gOH.getHeight());
                    final float left = 516.0f - ((a.this.jIM.gOH.getLeft() + a.this.jIM.gOH.getRight()) / 2.0f);
                    final float top = 529.0f - ((a.this.jIM.gOH.getTop() + a.this.jIM.gOH.getBottom()) / 2.0f);
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.a.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            a.this.jIM.gOH.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            a.this.jIM.gOH.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            a.this.jIM.gOH.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                            a.this.jIM.gOH.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.a.5.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            a.this.jIM.gOH.setScaleX(1.0f);
                            a.this.jIM.gOH.setScaleY(1.0f);
                            a.this.jIM.gOH.setTranslationX(0.0f);
                            a.this.jIM.gOH.setTranslationY(0.0f);
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

    private void cKv() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_name_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_name_text");
            if (!au.isEmpty(stringExtra)) {
                this.jIM.jJa.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
                this.jIM.jJa.post(new Runnable() { // from class: com.baidu.tieba.frs.c.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - a.this.jIM.jJa.getLeft();
                        final float top = rect.top - a.this.jIM.jJa.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.a.6.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    a.this.jIM.jJa.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    a.this.jIM.jJa.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.a.6.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                a.this.jIM.jJa.setTranslationX(0.0f);
                                a.this.jIM.jJa.setTranslationY(0.0f);
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

    private void cKw() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_image_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_image_url");
            if (!au.isEmpty(stringExtra)) {
                this.jIM.jIZ.startLoad(stringExtra, 10, false);
                this.jIM.jIZ.post(new Runnable() { // from class: com.baidu.tieba.frs.c.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - a.this.jIM.jIZ.getLeft();
                        final float top = rect.top - a.this.jIM.jIZ.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.a.7.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    a.this.jIM.jIZ.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    a.this.jIM.jIZ.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.a.7.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                a.this.jIM.jIZ.setTranslationX(0.0f);
                                a.this.jIM.jIZ.setTranslationY(0.0f);
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

    private void cKx() {
        if (this.mIntent != null && this.jIM.jJc != null) {
            this.jIM.jJc.post(new Runnable() { // from class: com.baidu.tieba.frs.c.a.8
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
                                a.this.jIM.jJc.setTranslationY(dimens - (dimens * floatValue));
                                a.this.jIM.jJc.setAlpha((floatValue / 2.0f) + 0.5f);
                            }
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.a.8.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            a.this.jIM.jJc.setAlpha(1.0f);
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
