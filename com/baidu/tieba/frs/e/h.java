package com.baidu.tieba.frs.e;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class h extends b {
    private ValueAnimator juV;
    private ValueAnimator juW;

    public h(g gVar, Intent intent) {
        super(gVar, intent);
        init();
    }

    private void init() {
        this.juV = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.juV.setDuration(270L);
        this.juV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    h.this.jvf.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.juV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.jvf.mRootView.setAlpha(1.0f);
                h.this.mState = 2;
                if (h.this.jvg != null) {
                    h.this.jvg.onStateChanged(h.this.mState);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.juW = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.juW.setDuration(800L);
        this.juW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    h.this.jvf.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.juW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.jvf.mRootView.setAlpha(0.0f);
                h.this.mState = 0;
                if (h.this.jvg != null) {
                    h.this.jvg.onStateChanged(h.this.mState);
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
    public void cJO() {
        if (this.mState == 0) {
            this.mState = 1;
            if (this.jvg != null) {
                this.jvg.onStateChanged(this.mState);
            }
            this.juV.start();
            cJS();
            cJR();
            cJQ();
            cJT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e.b
    public void cJP() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jvg != null) {
                this.jvg.onStateChanged(this.mState);
            }
            this.juW.start();
        }
    }

    private void cJQ() {
        if (this.mIntent != null) {
            ArrayList<Integer> integerArrayListExtra = this.mIntent.getIntegerArrayListExtra("info_forum_head_background_color");
            if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
                this.jvf.jvr.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
            }
            final Rect rect = (Rect) this.mIntent.getParcelableExtra("info_forum_head_background_rect");
            if (rect != null) {
                String stringExtra = this.mIntent.getStringExtra("info_forum_head_background_vector");
                if (!au.isEmpty(stringExtra)) {
                    this.jvf.jvy.startLoad(stringExtra, 10, false);
                }
                this.jvf.gEI.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final float min = Math.min((rect.width() * 1.0f) / h.this.jvf.gEI.getWidth(), (rect.height() * 1.0f) / h.this.jvf.gEI.getHeight());
                        final float centerX = rect.centerX() - ((h.this.jvf.gEI.getLeft() + h.this.jvf.gEI.getRight()) / 2.0f);
                        final float centerY = rect.centerY() - ((h.this.jvf.gEI.getTop() + h.this.jvf.gEI.getBottom()) / 2.0f);
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.5.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                h.this.jvf.gEI.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                                h.this.jvf.gEI.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                                h.this.jvf.gEI.setTranslationX(centerX - (((Float) valueAnimator.getAnimatedValue()).floatValue() * centerX));
                                h.this.jvf.gEI.setTranslationY(centerY - (((Float) valueAnimator.getAnimatedValue()).floatValue() * centerY));
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.5.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                h.this.jvf.gEI.setScaleX(1.0f);
                                h.this.jvf.gEI.setScaleY(1.0f);
                                h.this.jvf.gEI.setTranslationX(0.0f);
                                h.this.jvf.gEI.setTranslationY(0.0f);
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

    private void cJR() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_name_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_name_text");
            if (!au.isEmpty(stringExtra)) {
                this.jvf.jvt.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
                this.jvf.jvt.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - h.this.jvf.jvt.getLeft();
                        final float top = rect.top - h.this.jvf.jvt.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.6.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    h.this.jvf.jvt.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    h.this.jvf.jvt.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.6.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                h.this.jvf.jvt.setTranslationX(0.0f);
                                h.this.jvf.jvt.setTranslationY(0.0f);
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

    private void cJS() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_image_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_image_url");
            if (!au.isEmpty(stringExtra)) {
                this.jvf.jvs.startLoad(stringExtra, 10, false);
                this.jvf.jvs.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - h.this.jvf.jvs.getLeft();
                        final float top = rect.top - h.this.jvf.jvs.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.7.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    h.this.jvf.jvs.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    h.this.jvf.jvs.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.7.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                h.this.jvf.jvs.setTranslationX(0.0f);
                                h.this.jvf.jvs.setTranslationY(0.0f);
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

    private void cJT() {
        if (this.mIntent != null && this.jvf.jvv != null) {
            this.jvf.jvv.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.8
                @Override // java.lang.Runnable
                public void run() {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    final int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.8.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (valueAnimator.isRunning()) {
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                h.this.jvf.jvv.setTranslationY(dimens - (dimens * floatValue));
                                h.this.jvf.jvv.setAlpha((floatValue / 2.0f) + 0.5f);
                            }
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.8.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            h.this.jvf.jvv.setAlpha(1.0f);
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
