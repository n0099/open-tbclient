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
public class h extends b {
    private ValueAnimator jHq;
    private ValueAnimator jHr;

    public h(g gVar, Intent intent) {
        super(gVar, intent);
        init();
    }

    private void init() {
        this.jHq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jHq.setDuration(270L);
        this.jHq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.h.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    h.this.jHA.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jHq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.h.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.jHA.mRootView.setAlpha(1.0f);
                h.this.mState = 2;
                if (h.this.jHB != null) {
                    h.this.jHB.onStateChanged(h.this.mState);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jHr = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jHr.setDuration(800L);
        this.jHr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.h.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    h.this.jHA.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jHr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.h.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.jHA.mRootView.setAlpha(0.0f);
                h.this.mState = 0;
                if (h.this.jHB != null) {
                    h.this.jHB.onStateChanged(h.this.mState);
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
    public void cMP() {
        if (this.mState == 0) {
            this.mState = 1;
            if (this.jHB != null) {
                this.jHB.onStateChanged(this.mState);
            }
            this.jHq.start();
            cMT();
            cMS();
            cMR();
            cMU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.c.b
    public void cMQ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jHB != null) {
                this.jHB.onStateChanged(this.mState);
            }
            this.jHr.start();
        }
    }

    private void cMR() {
        if (this.mIntent != null) {
            ArrayList<Integer> integerArrayListExtra = this.mIntent.getIntegerArrayListExtra("info_forum_head_background_color");
            if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
                this.jHA.jHM.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
            }
            final Rect rect = (Rect) this.mIntent.getParcelableExtra("info_forum_head_background_rect");
            if (rect != null) {
                String stringExtra = this.mIntent.getStringExtra("info_forum_head_background_vector");
                if (!at.isEmpty(stringExtra)) {
                    this.jHA.jHT.startLoad(stringExtra, 10, false);
                }
                this.jHA.gQt.post(new Runnable() { // from class: com.baidu.tieba.frs.c.h.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final float min = Math.min((rect.width() * 1.0f) / h.this.jHA.gQt.getWidth(), (rect.height() * 1.0f) / h.this.jHA.gQt.getHeight());
                        final float centerX = rect.centerX() - ((h.this.jHA.gQt.getLeft() + h.this.jHA.gQt.getRight()) / 2.0f);
                        final float centerY = rect.centerY() - ((h.this.jHA.gQt.getTop() + h.this.jHA.gQt.getBottom()) / 2.0f);
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.h.5.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                h.this.jHA.gQt.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                                h.this.jHA.gQt.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                                h.this.jHA.gQt.setTranslationX(centerX - (((Float) valueAnimator.getAnimatedValue()).floatValue() * centerX));
                                h.this.jHA.gQt.setTranslationY(centerY - (((Float) valueAnimator.getAnimatedValue()).floatValue() * centerY));
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.h.5.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                h.this.jHA.gQt.setScaleX(1.0f);
                                h.this.jHA.gQt.setScaleY(1.0f);
                                h.this.jHA.gQt.setTranslationX(0.0f);
                                h.this.jHA.gQt.setTranslationY(0.0f);
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

    private void cMS() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_name_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_name_text");
            if (!at.isEmpty(stringExtra)) {
                this.jHA.jHO.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
                this.jHA.jHO.post(new Runnable() { // from class: com.baidu.tieba.frs.c.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - h.this.jHA.jHO.getLeft();
                        final float top = rect.top - h.this.jHA.jHO.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.h.6.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    h.this.jHA.jHO.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    h.this.jHA.jHO.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.h.6.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                h.this.jHA.jHO.setTranslationX(0.0f);
                                h.this.jHA.jHO.setTranslationY(0.0f);
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

    private void cMT() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_image_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_image_url");
            if (!at.isEmpty(stringExtra)) {
                this.jHA.jHN.startLoad(stringExtra, 10, false);
                this.jHA.jHN.post(new Runnable() { // from class: com.baidu.tieba.frs.c.h.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - h.this.jHA.jHN.getLeft();
                        final float top = rect.top - h.this.jHA.jHN.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.h.7.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    h.this.jHA.jHN.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    h.this.jHA.jHN.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.h.7.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                h.this.jHA.jHN.setTranslationX(0.0f);
                                h.this.jHA.jHN.setTranslationY(0.0f);
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

    private void cMU() {
        if (this.mIntent != null && this.jHA.jHQ != null) {
            this.jHA.jHQ.post(new Runnable() { // from class: com.baidu.tieba.frs.c.h.8
                @Override // java.lang.Runnable
                public void run() {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    final int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.c.h.8.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (valueAnimator.isRunning()) {
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                h.this.jHA.jHQ.setTranslationY(dimens - (dimens * floatValue));
                                h.this.jHA.jHQ.setAlpha((floatValue / 2.0f) + 0.5f);
                            }
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.c.h.8.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            h.this.jHA.jHQ.setAlpha(1.0f);
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
