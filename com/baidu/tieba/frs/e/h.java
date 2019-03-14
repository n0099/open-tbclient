package com.baidu.tieba.frs.e;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h extends b {
    private ValueAnimator fuc;
    private ValueAnimator fud;

    public h(g gVar, Intent intent) {
        super(gVar, intent);
        init();
    }

    private void init() {
        this.fuc = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fuc.setDuration(270L);
        this.fuc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    h.this.fuo.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fuc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.fuo.mRootView.setAlpha(1.0f);
                h.this.mState = 2;
                if (h.this.fup != null) {
                    h.this.fup.onStateChanged(h.this.mState);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fud = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fud.setDuration(500L);
        this.fud.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    h.this.fuo.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fud.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.fuo.mRootView.setAlpha(0.0f);
                h.this.mState = 0;
                if (h.this.fup != null) {
                    h.this.fup.onStateChanged(h.this.mState);
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
    public void bis() {
        if (this.mState == 0) {
            this.mState = 1;
            if (this.fup != null) {
                this.fup.onStateChanged(this.mState);
            }
            this.fuc.start();
            biw();
            biv();
            biu();
            if (this.fuq) {
                bix();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e.b
    public void bit() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.fup != null) {
                this.fup.onStateChanged(this.mState);
            }
            this.fud.start();
        }
    }

    private void biu() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_head_background_rect")) != null) {
            ArrayList<Integer> integerArrayListExtra = this.mIntent.getIntegerArrayListExtra("info_forum_head_background_color");
            if (integerArrayListExtra != null && integerArrayListExtra.size() == 4) {
                this.fuo.fuy.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue());
            }
            String stringExtra = this.mIntent.getStringExtra("info_forum_head_background_vector");
            if (!ap.isEmpty(stringExtra)) {
                this.fuo.fuE.startLoad(stringExtra, 10, false);
            }
            this.fuo.dlo.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.5
                @Override // java.lang.Runnable
                public void run() {
                    final float min = Math.min((rect.width() * 1.0f) / h.this.fuo.dlo.getWidth(), (rect.height() * 1.0f) / h.this.fuo.dlo.getHeight());
                    final float centerX = rect.centerX() - ((h.this.fuo.dlo.getLeft() + h.this.fuo.dlo.getRight()) / 2.0f);
                    final float centerY = rect.centerY() - ((h.this.fuo.dlo.getTop() + h.this.fuo.dlo.getBottom()) / 2.0f);
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            h.this.fuo.dlo.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            h.this.fuo.dlo.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            h.this.fuo.dlo.setTranslationX(centerX - (((Float) valueAnimator.getAnimatedValue()).floatValue() * centerX));
                            h.this.fuo.dlo.setTranslationY(centerY - (((Float) valueAnimator.getAnimatedValue()).floatValue() * centerY));
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.5.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            h.this.fuo.dlo.setScaleX(1.0f);
                            h.this.fuo.dlo.setScaleY(1.0f);
                            h.this.fuo.dlo.setTranslationX(0.0f);
                            h.this.fuo.dlo.setTranslationY(0.0f);
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

    private void biv() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_name_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_name_text");
            if (!ap.isEmpty(stringExtra)) {
                this.fuo.fuA.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.chosen_pb_original_bar), stringExtra));
                this.fuo.fuA.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - h.this.fuo.fuA.getLeft();
                        final float top = rect.top - h.this.fuo.fuA.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.6.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    h.this.fuo.fuA.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    h.this.fuo.fuA.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.6.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                h.this.fuo.fuA.setTranslationX(0.0f);
                                h.this.fuo.fuA.setTranslationY(0.0f);
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

    private void biw() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_image_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_image_url");
            if (!ap.isEmpty(stringExtra)) {
                this.fuo.fuz.startLoad(stringExtra, 10, false);
                this.fuo.fuz.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - h.this.fuo.fuz.getLeft();
                        final float top = rect.top - h.this.fuo.fuz.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.7.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    h.this.fuo.fuz.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    h.this.fuo.fuz.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.7.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                h.this.fuo.fuz.setTranslationX(0.0f);
                                h.this.fuo.fuz.setTranslationY(0.0f);
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

    private void bix() {
        if (this.mIntent != null) {
            this.fuo.fuC.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.8
                @Override // java.lang.Runnable
                public void run() {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    final int h = l.h(TbadkCoreApplication.getInst(), d.e.tbds80);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.8.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (valueAnimator.isRunning()) {
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                h.this.fuo.fuC.setTranslationY((-h) * floatValue);
                                h.this.fuo.fuC.setScaleX((floatValue / 2.0f) + 0.5f);
                                h.this.fuo.fuC.setScaleY((floatValue / 2.0f) + 0.5f);
                                h.this.fuo.fuC.setAlpha(floatValue);
                            }
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.8.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            h.this.fuo.fuC.setTranslationY(-h);
                            h.this.fuo.fuC.setScaleX(1.0f);
                            h.this.fuo.fuC.setScaleY(1.0f);
                            h.this.fuo.fuC.setAlpha(1.0f);
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
