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
/* loaded from: classes7.dex */
public class AlaLiveFocusCircleView extends View {
    private Paint eKp;
    private ObjectAnimator gLd;
    private boolean gLe;
    private Bitmap gLf;
    private AnimatorSet gaK;
    private int mBorderWidth;

    public AlaLiveFocusCircleView(Context context) {
        super(context);
        this.mBorderWidth = 4;
        this.gLe = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderWidth = 4;
        this.gLe = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderWidth = 4;
        this.gLe = false;
        init(context);
    }

    private void init(Context context) {
        this.eKp = new Paint();
        this.eKp.setAntiAlias(true);
        this.eKp.setStyle(Paint.Style.STROKE);
        this.eKp.setColor(Color.parseColor("#ffffffff"));
        this.eKp.setStrokeWidth(this.mBorderWidth);
        setAlpha(0.0f);
        this.gLf = BitmapFactory.decodeResource(context.getResources(), a.f.camera_focus);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.gLf, (getWidth() / 2) - 80, (getHeight() / 2) - 80, this.eKp);
    }

    public void bWZ() {
        this.gLe = true;
        if (this.gaK == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 3.0f, 2.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 3.0f, 2.0f, 1.0f);
            this.gaK = new AnimatorSet();
            this.gaK.play(ofFloat).with(ofFloat2);
            this.gaK.setInterpolator(new LinearInterpolator());
            this.gaK.setDuration(500L);
            this.gaK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AlaLiveFocusCircleView.this.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AlaLiveFocusCircleView.this.gLd == null) {
                        AlaLiveFocusCircleView.this.gLd = ObjectAnimator.ofFloat(AlaLiveFocusCircleView.this, "alpha", 1.0f, 0.0f);
                        AlaLiveFocusCircleView.this.gLd.setDuration(960L);
                        AlaLiveFocusCircleView.this.gLd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                AlaLiveFocusCircleView.this.gLe = false;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }
                        });
                    }
                    AlaLiveFocusCircleView.this.gLd.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }
            });
        } else {
            if (this.gaK.isRunning()) {
                this.gaK.cancel();
            }
            if (this.gLd != null && this.gLd.isRunning()) {
                this.gLd.cancel();
            }
        }
        this.gaK.start();
    }
}
