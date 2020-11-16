package com.baidu.tieba.ala.liveroom.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaLiveFocusCircleView extends View {
    private Paint fmo;
    private AnimatorSet gFR;
    private ObjectAnimator huP;
    private boolean huQ;
    private Bitmap huR;
    private int mBorderWidth;

    public AlaLiveFocusCircleView(Context context) {
        super(context);
        this.mBorderWidth = 4;
        this.huQ = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderWidth = 4;
        this.huQ = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderWidth = 4;
        this.huQ = false;
        init(context);
    }

    private void init(Context context) {
        this.fmo = new Paint();
        this.fmo.setAntiAlias(true);
        this.fmo.setStyle(Paint.Style.STROKE);
        this.fmo.setColor(Color.parseColor("#ffffffff"));
        this.fmo.setStrokeWidth(this.mBorderWidth);
        setAlpha(0.0f);
        this.huR = BitmapFactory.decodeResource(context.getResources(), a.e.camera_focus);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.huR, (getWidth() / 2) - 80, (getHeight() / 2) - 80, this.fmo);
    }

    public void chh() {
        this.huQ = true;
        if (this.gFR == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 3.0f, 2.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 3.0f, 2.0f, 1.0f);
            this.gFR = new AnimatorSet();
            this.gFR.play(ofFloat).with(ofFloat2);
            this.gFR.setInterpolator(new LinearInterpolator());
            this.gFR.setDuration(500L);
            this.gFR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AlaLiveFocusCircleView.this.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AlaLiveFocusCircleView.this.huP == null) {
                        AlaLiveFocusCircleView.this.huP = ObjectAnimator.ofFloat(AlaLiveFocusCircleView.this, "alpha", 1.0f, 0.0f);
                        AlaLiveFocusCircleView.this.huP.setDuration(960L);
                        AlaLiveFocusCircleView.this.huP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                AlaLiveFocusCircleView.this.huQ = false;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }
                        });
                    }
                    AlaLiveFocusCircleView.this.huP.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }
            });
        } else {
            if (this.gFR.isRunning()) {
                this.gFR.cancel();
            }
            if (this.huP != null && this.huP.isRunning()) {
                this.huP.cancel();
            }
        }
        this.gFR.start();
    }
}
