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
/* loaded from: classes7.dex */
public class h extends b {
    private ValueAnimator gIn;
    private ValueAnimator gIo;

    public h(g gVar, Intent intent) {
        super(gVar, intent);
        init();
    }

    private void init() {
        this.gIn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gIn.setDuration(270L);
        this.gIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    h.this.gIx.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gIn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.gIx.mRootView.setAlpha(1.0f);
                h.this.mState = 2;
                if (h.this.gIy != null) {
                    h.this.gIy.onStateChanged(h.this.mState);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gIo = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gIo.setDuration(500L);
        this.gIo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    h.this.gIx.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gIo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.gIx.mRootView.setAlpha(0.0f);
                h.this.mState = 0;
                if (h.this.gIy != null) {
                    h.this.gIy.onStateChanged(h.this.mState);
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
    public void bIl() {
        if (this.mState == 0) {
            this.mState = 1;
            if (this.gIy != null) {
                this.gIy.onStateChanged(this.mState);
            }
            this.gIn.start();
            bIp();
            bIo();
            bIn();
            if (this.gIz) {
                bIq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e.b
    public void bIm() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.gIy != null) {
                this.gIy.onStateChanged(this.mState);
            }
            this.gIo.start();
        }
    }

    private void bIn() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_head_background_rect")) != null) {
            ArrayList<Integer> integerArrayListExtra = this.mIntent.getIntegerArrayListExtra("info_forum_head_background_color");
            if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
                this.gIx.gIJ.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
            }
            String stringExtra = this.mIntent.getStringExtra("info_forum_head_background_vector");
            if (!aq.isEmpty(stringExtra)) {
                this.gIx.gIP.startLoad(stringExtra, 10, false);
            }
            this.gIx.esp.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.5
                @Override // java.lang.Runnable
                public void run() {
                    final float min = Math.min((rect.width() * 1.0f) / h.this.gIx.esp.getWidth(), (rect.height() * 1.0f) / h.this.gIx.esp.getHeight());
                    final float centerX = rect.centerX() - ((h.this.gIx.esp.getLeft() + h.this.gIx.esp.getRight()) / 2.0f);
                    final float centerY = rect.centerY() - ((h.this.gIx.esp.getTop() + h.this.gIx.esp.getBottom()) / 2.0f);
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            h.this.gIx.esp.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            h.this.gIx.esp.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            h.this.gIx.esp.setTranslationX(centerX - (((Float) valueAnimator.getAnimatedValue()).floatValue() * centerX));
                            h.this.gIx.esp.setTranslationY(centerY - (((Float) valueAnimator.getAnimatedValue()).floatValue() * centerY));
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.5.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            h.this.gIx.esp.setScaleX(1.0f);
                            h.this.gIx.esp.setScaleY(1.0f);
                            h.this.gIx.esp.setTranslationX(0.0f);
                            h.this.gIx.esp.setTranslationY(0.0f);
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

    private void bIo() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_name_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_name_text");
            if (!aq.isEmpty(stringExtra)) {
                this.gIx.gIL.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
                this.gIx.gIL.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - h.this.gIx.gIL.getLeft();
                        final float top = rect.top - h.this.gIx.gIL.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.6.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    h.this.gIx.gIL.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    h.this.gIx.gIL.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.6.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                h.this.gIx.gIL.setTranslationX(0.0f);
                                h.this.gIx.gIL.setTranslationY(0.0f);
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

    private void bIp() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_image_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_image_url");
            if (!aq.isEmpty(stringExtra)) {
                this.gIx.gIK.startLoad(stringExtra, 10, false);
                this.gIx.gIK.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - h.this.gIx.gIK.getLeft();
                        final float top = rect.top - h.this.gIx.gIK.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.7.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    h.this.gIx.gIK.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    h.this.gIx.gIK.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.7.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                h.this.gIx.gIK.setTranslationX(0.0f);
                                h.this.gIx.gIK.setTranslationY(0.0f);
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

    private void bIq() {
        if (this.mIntent != null) {
            this.gIx.gIN.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.8
                @Override // java.lang.Runnable
                public void run() {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    final int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds80);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.8.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (valueAnimator.isRunning()) {
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                h.this.gIx.gIN.setTranslationY((-dimens) * floatValue);
                                h.this.gIx.gIN.setScaleX((floatValue / 2.0f) + 0.5f);
                                h.this.gIx.gIN.setScaleY((floatValue / 2.0f) + 0.5f);
                                h.this.gIx.gIN.setAlpha(floatValue);
                            }
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.8.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            h.this.gIx.gIN.setTranslationY(-dimens);
                            h.this.gIx.gIN.setScaleX(1.0f);
                            h.this.gIx.gIN.setScaleY(1.0f);
                            h.this.gIx.gIN.setAlpha(1.0f);
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
