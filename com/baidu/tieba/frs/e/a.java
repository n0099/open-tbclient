package com.baidu.tieba.frs.e;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends b {
    private ValueAnimator hXP;
    private ValueAnimator hXQ;

    public a(g gVar, Intent intent) {
        super(gVar, intent);
        init();
    }

    private void init() {
        this.hXP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hXP.setDuration(270L);
        this.hXP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.a.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    a.this.hXZ.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hXP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.hXZ.mRootView.setAlpha(1.0f);
                a.this.mState = 2;
                if (a.this.hYa != null) {
                    a.this.hYa.onStateChanged(a.this.mState);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hXQ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hXQ.setDuration(500L);
        this.hXQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    a.this.hXZ.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hXQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.hXZ.mRootView.setAlpha(0.0f);
                a.this.mState = 0;
                if (a.this.hYa != null) {
                    a.this.hYa.onStateChanged(a.this.mState);
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
    @Override // com.baidu.tieba.frs.e.b
    public void cex() {
        if (this.mState == 0) {
            this.mState = 1;
            if (this.hYa != null) {
                this.hYa.onStateChanged(this.mState);
            }
            this.hXP.start();
            ceB();
            ceA();
            cez();
            ceC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e.b
    public void cey() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.hYa != null) {
                this.hYa.onStateChanged(this.mState);
            }
            this.hXQ.start();
        }
    }

    private void cez() {
        if (this.mIntent != null) {
            ArrayList<Integer> integerArrayListExtra = this.mIntent.getIntegerArrayListExtra("info_forum_head_background_color");
            if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
                this.hXZ.hYl.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
            }
            String stringExtra = this.mIntent.getStringExtra("info_forum_head_background_vector");
            if (!ar.isEmpty(stringExtra)) {
                this.hXZ.hYs.startLoad(stringExtra, 10, false);
            }
            this.hXZ.fAq.post(new Runnable() { // from class: com.baidu.tieba.frs.e.a.5
                @Override // java.lang.Runnable
                public void run() {
                    final float min = Math.min(269.0f / a.this.hXZ.fAq.getWidth(), 141.0f / a.this.hXZ.fAq.getHeight());
                    final float left = 516.0f - ((a.this.hXZ.fAq.getLeft() + a.this.hXZ.fAq.getRight()) / 2.0f);
                    final float top2 = 529.0f - ((a.this.hXZ.fAq.getTop() + a.this.hXZ.fAq.getBottom()) / 2.0f);
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.a.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            a.this.hXZ.fAq.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            a.this.hXZ.fAq.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            a.this.hXZ.fAq.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                            a.this.hXZ.fAq.setTranslationY(top2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top2));
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.a.5.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            a.this.hXZ.fAq.setScaleX(1.0f);
                            a.this.hXZ.fAq.setScaleY(1.0f);
                            a.this.hXZ.fAq.setTranslationX(0.0f);
                            a.this.hXZ.fAq.setTranslationY(0.0f);
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

    private void ceA() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_name_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_name_text");
            if (!ar.isEmpty(stringExtra)) {
                this.hXZ.hYn.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
                this.hXZ.hYn.post(new Runnable() { // from class: com.baidu.tieba.frs.e.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - a.this.hXZ.hYn.getLeft();
                        final float top2 = rect.top - a.this.hXZ.hYn.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.a.6.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    a.this.hXZ.hYn.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    a.this.hXZ.hYn.setTranslationY(top2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top2));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.a.6.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                a.this.hXZ.hYn.setTranslationX(0.0f);
                                a.this.hXZ.hYn.setTranslationY(0.0f);
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

    private void ceB() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_image_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_image_url");
            if (!ar.isEmpty(stringExtra)) {
                this.hXZ.hYm.startLoad(stringExtra, 10, false);
                this.hXZ.hYm.post(new Runnable() { // from class: com.baidu.tieba.frs.e.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - a.this.hXZ.hYm.getLeft();
                        final float top2 = rect.top - a.this.hXZ.hYm.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.a.7.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    a.this.hXZ.hYm.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    a.this.hXZ.hYm.setTranslationY(top2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top2));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.a.7.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                a.this.hXZ.hYm.setTranslationX(0.0f);
                                a.this.hXZ.hYm.setTranslationY(0.0f);
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

    private void ceC() {
        if (this.mIntent != null && this.hXZ.hYp != null) {
            this.hXZ.hYp.post(new Runnable() { // from class: com.baidu.tieba.frs.e.a.8
                @Override // java.lang.Runnable
                public void run() {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    final int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.a.8.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (valueAnimator.isRunning()) {
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                a.this.hXZ.hYp.setTranslationY(dimens - (dimens * floatValue));
                                a.this.hXZ.hYp.setAlpha((floatValue / 2.0f) + 0.5f);
                            }
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.a.8.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            a.this.hXZ.hYp.setAlpha(1.0f);
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
