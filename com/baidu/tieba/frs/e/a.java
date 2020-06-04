package com.baidu.tieba.frs.e;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends b {
    private ValueAnimator hKD;
    private ValueAnimator hKE;

    public a(g gVar, Intent intent) {
        super(gVar, intent);
        init();
    }

    private void init() {
        this.hKD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hKD.setDuration(270L);
        this.hKD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.a.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    a.this.hKN.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hKD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.hKN.mRootView.setAlpha(1.0f);
                a.this.mState = 2;
                if (a.this.hKO != null) {
                    a.this.hKO.onStateChanged(a.this.mState);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hKE = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hKE.setDuration(500L);
        this.hKE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    a.this.hKN.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hKE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.a.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.hKN.mRootView.setAlpha(0.0f);
                a.this.mState = 0;
                if (a.this.hKO != null) {
                    a.this.hKO.onStateChanged(a.this.mState);
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
    public void cbe() {
        if (this.mState == 0) {
            this.mState = 1;
            if (this.hKO != null) {
                this.hKO.onStateChanged(this.mState);
            }
            this.hKD.start();
            cbi();
            cbh();
            cbg();
            cbj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e.b
    public void cbf() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.hKO != null) {
                this.hKO.onStateChanged(this.mState);
            }
            this.hKE.start();
        }
    }

    private void cbg() {
        if (this.mIntent != null) {
            ArrayList<Integer> integerArrayListExtra = this.mIntent.getIntegerArrayListExtra("info_forum_head_background_color");
            if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
                this.hKN.hKZ.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
            }
            String stringExtra = this.mIntent.getStringExtra("info_forum_head_background_vector");
            if (!aq.isEmpty(stringExtra)) {
                this.hKN.hLg.startLoad(stringExtra, 10, false);
            }
            this.hKN.fpe.post(new Runnable() { // from class: com.baidu.tieba.frs.e.a.5
                @Override // java.lang.Runnable
                public void run() {
                    final float min = Math.min(269.0f / a.this.hKN.fpe.getWidth(), 141.0f / a.this.hKN.fpe.getHeight());
                    final float left = 516.0f - ((a.this.hKN.fpe.getLeft() + a.this.hKN.fpe.getRight()) / 2.0f);
                    final float top2 = 529.0f - ((a.this.hKN.fpe.getTop() + a.this.hKN.fpe.getBottom()) / 2.0f);
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.a.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            a.this.hKN.fpe.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            a.this.hKN.fpe.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            a.this.hKN.fpe.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                            a.this.hKN.fpe.setTranslationY(top2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top2));
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.a.5.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            a.this.hKN.fpe.setScaleX(1.0f);
                            a.this.hKN.fpe.setScaleY(1.0f);
                            a.this.hKN.fpe.setTranslationX(0.0f);
                            a.this.hKN.fpe.setTranslationY(0.0f);
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

    private void cbh() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_name_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_name_text");
            if (!aq.isEmpty(stringExtra)) {
                this.hKN.hLb.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
                this.hKN.hLb.post(new Runnable() { // from class: com.baidu.tieba.frs.e.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - a.this.hKN.hLb.getLeft();
                        final float top2 = rect.top - a.this.hKN.hLb.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.a.6.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    a.this.hKN.hLb.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    a.this.hKN.hLb.setTranslationY(top2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top2));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.a.6.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                a.this.hKN.hLb.setTranslationX(0.0f);
                                a.this.hKN.hLb.setTranslationY(0.0f);
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

    private void cbi() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_image_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_image_url");
            if (!aq.isEmpty(stringExtra)) {
                this.hKN.hLa.startLoad(stringExtra, 10, false);
                this.hKN.hLa.post(new Runnable() { // from class: com.baidu.tieba.frs.e.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - a.this.hKN.hLa.getLeft();
                        final float top2 = rect.top - a.this.hKN.hLa.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.a.7.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    a.this.hKN.hLa.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    a.this.hKN.hLa.setTranslationY(top2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top2));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.a.7.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                a.this.hKN.hLa.setTranslationX(0.0f);
                                a.this.hKN.hLa.setTranslationY(0.0f);
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

    private void cbj() {
        if (this.mIntent != null && this.hKN.hLd != null) {
            this.hKN.hLd.post(new Runnable() { // from class: com.baidu.tieba.frs.e.a.8
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
                                a.this.hKN.hLd.setTranslationY(dimens - (dimens * floatValue));
                                a.this.hKN.hLd.setAlpha((floatValue / 2.0f) + 0.5f);
                            }
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.a.8.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            a.this.hKN.hLd.setAlpha(1.0f);
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
