package com.baidu.tieba.frs.e;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class h extends b {
    private ValueAnimator idR;
    private ValueAnimator idS;

    public h(g gVar, Intent intent) {
        super(gVar, intent);
        init();
    }

    private void init() {
        this.idR = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.idR.setDuration(270L);
        this.idR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    h.this.ieb.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.idR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.ieb.mRootView.setAlpha(1.0f);
                h.this.mState = 2;
                if (h.this.iec != null) {
                    h.this.iec.onStateChanged(h.this.mState);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.idS = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.idS.setDuration(800L);
        this.idS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    h.this.ieb.mRootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.idS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.ieb.mRootView.setAlpha(0.0f);
                h.this.mState = 0;
                if (h.this.iec != null) {
                    h.this.iec.onStateChanged(h.this.mState);
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
    public void chW() {
        if (this.mState == 0) {
            this.mState = 1;
            if (this.iec != null) {
                this.iec.onStateChanged(this.mState);
            }
            this.idR.start();
            cia();
            chZ();
            chY();
            cib();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e.b
    public void chX() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.iec != null) {
                this.iec.onStateChanged(this.mState);
            }
            this.idS.start();
        }
    }

    private void chY() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_head_background_rect")) != null) {
            ArrayList<Integer> integerArrayListExtra = this.mIntent.getIntegerArrayListExtra("info_forum_head_background_color");
            if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
                this.ieb.ien.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
            }
            String stringExtra = this.mIntent.getStringExtra("info_forum_head_background_vector");
            if (!as.isEmpty(stringExtra)) {
                this.ieb.ieu.startLoad(stringExtra, 10, false);
            }
            this.ieb.fFA.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.5
                @Override // java.lang.Runnable
                public void run() {
                    final float min = Math.min((rect.width() * 1.0f) / h.this.ieb.fFA.getWidth(), (rect.height() * 1.0f) / h.this.ieb.fFA.getHeight());
                    final float centerX = rect.centerX() - ((h.this.ieb.fFA.getLeft() + h.this.ieb.fFA.getRight()) / 2.0f);
                    final float centerY = rect.centerY() - ((h.this.ieb.fFA.getTop() + h.this.ieb.fFA.getBottom()) / 2.0f);
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(220L);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            h.this.ieb.fFA.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            h.this.ieb.fFA.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - min)) + min);
                            h.this.ieb.fFA.setTranslationX(centerX - (((Float) valueAnimator.getAnimatedValue()).floatValue() * centerX));
                            h.this.ieb.fFA.setTranslationY(centerY - (((Float) valueAnimator.getAnimatedValue()).floatValue() * centerY));
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.5.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            h.this.ieb.fFA.setScaleX(1.0f);
                            h.this.ieb.fFA.setScaleY(1.0f);
                            h.this.ieb.fFA.setTranslationX(0.0f);
                            h.this.ieb.fFA.setTranslationY(0.0f);
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

    private void chZ() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_name_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_name_text");
            if (!as.isEmpty(stringExtra)) {
                this.ieb.iep.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
                this.ieb.iep.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - h.this.ieb.iep.getLeft();
                        final float top = rect.top - h.this.ieb.iep.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.6.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    h.this.ieb.iep.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    h.this.ieb.iep.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.6.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                h.this.ieb.iep.setTranslationX(0.0f);
                                h.this.ieb.iep.setTranslationY(0.0f);
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

    private void cia() {
        final Rect rect;
        if (this.mIntent != null && (rect = (Rect) this.mIntent.getParcelableExtra("info_forum_image_rect")) != null) {
            String stringExtra = this.mIntent.getStringExtra("info_forum_image_url");
            if (!as.isEmpty(stringExtra)) {
                this.ieb.ieo.startLoad(stringExtra, 10, false);
                this.ieb.ieo.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final float left = rect.left - h.this.ieb.ieo.getLeft();
                        final float top = rect.top - h.this.ieb.ieo.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.setDuration(220L);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.e.h.7.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (valueAnimator.isRunning()) {
                                    h.this.ieb.ieo.setTranslationX(left - (((Float) valueAnimator.getAnimatedValue()).floatValue() * left));
                                    h.this.ieb.ieo.setTranslationY(top - (((Float) valueAnimator.getAnimatedValue()).floatValue() * top));
                                }
                            }
                        });
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.7.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                h.this.ieb.ieo.setTranslationX(0.0f);
                                h.this.ieb.ieo.setTranslationY(0.0f);
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

    private void cib() {
        if (this.mIntent != null && this.ieb.ier != null) {
            this.ieb.ier.post(new Runnable() { // from class: com.baidu.tieba.frs.e.h.8
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
                                h.this.ieb.ier.setTranslationY(dimens - (dimens * floatValue));
                                h.this.ieb.ier.setAlpha((floatValue / 2.0f) + 0.5f);
                            }
                        }
                    });
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.e.h.8.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            h.this.ieb.ier.setAlpha(1.0f);
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
