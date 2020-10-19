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
    private Paint eYR;
    private AnimatorSet gqr;
    private ObjectAnimator hdu;
    private boolean hdv;
    private Bitmap hdw;
    private int mBorderWidth;

    public AlaLiveFocusCircleView(Context context) {
        super(context);
        this.mBorderWidth = 4;
        this.hdv = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderWidth = 4;
        this.hdv = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderWidth = 4;
        this.hdv = false;
        init(context);
    }

    private void init(Context context) {
        this.eYR = new Paint();
        this.eYR.setAntiAlias(true);
        this.eYR.setStyle(Paint.Style.STROKE);
        this.eYR.setColor(Color.parseColor("#ffffffff"));
        this.eYR.setStrokeWidth(this.mBorderWidth);
        setAlpha(0.0f);
        this.hdw = BitmapFactory.decodeResource(context.getResources(), a.f.camera_focus);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.hdw, (getWidth() / 2) - 80, (getHeight() / 2) - 80, this.eYR);
    }

    public void cch() {
        this.hdv = true;
        if (this.gqr == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 3.0f, 2.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 3.0f, 2.0f, 1.0f);
            this.gqr = new AnimatorSet();
            this.gqr.play(ofFloat).with(ofFloat2);
            this.gqr.setInterpolator(new LinearInterpolator());
            this.gqr.setDuration(500L);
            this.gqr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AlaLiveFocusCircleView.this.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AlaLiveFocusCircleView.this.hdu == null) {
                        AlaLiveFocusCircleView.this.hdu = ObjectAnimator.ofFloat(AlaLiveFocusCircleView.this, "alpha", 1.0f, 0.0f);
                        AlaLiveFocusCircleView.this.hdu.setDuration(960L);
                        AlaLiveFocusCircleView.this.hdu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                AlaLiveFocusCircleView.this.hdv = false;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }
                        });
                    }
                    AlaLiveFocusCircleView.this.hdu.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }
            });
        } else {
            if (this.gqr.isRunning()) {
                this.gqr.cancel();
            }
            if (this.hdu != null && this.hdu.isRunning()) {
                this.hdu.cancel();
            }
        }
        this.gqr.start();
    }
}
