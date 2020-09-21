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
    private Paint eMK;
    private ObjectAnimator gOx;
    private boolean gOy;
    private Bitmap gOz;
    private AnimatorSet geb;
    private int mBorderWidth;

    public AlaLiveFocusCircleView(Context context) {
        super(context);
        this.mBorderWidth = 4;
        this.gOy = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderWidth = 4;
        this.gOy = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderWidth = 4;
        this.gOy = false;
        init(context);
    }

    private void init(Context context) {
        this.eMK = new Paint();
        this.eMK.setAntiAlias(true);
        this.eMK.setStyle(Paint.Style.STROKE);
        this.eMK.setColor(Color.parseColor("#ffffffff"));
        this.eMK.setStrokeWidth(this.mBorderWidth);
        setAlpha(0.0f);
        this.gOz = BitmapFactory.decodeResource(context.getResources(), a.f.camera_focus);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.gOz, (getWidth() / 2) - 80, (getHeight() / 2) - 80, this.eMK);
    }

    public void bYH() {
        this.gOy = true;
        if (this.geb == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 3.0f, 2.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 3.0f, 2.0f, 1.0f);
            this.geb = new AnimatorSet();
            this.geb.play(ofFloat).with(ofFloat2);
            this.geb.setInterpolator(new LinearInterpolator());
            this.geb.setDuration(500L);
            this.geb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AlaLiveFocusCircleView.this.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AlaLiveFocusCircleView.this.gOx == null) {
                        AlaLiveFocusCircleView.this.gOx = ObjectAnimator.ofFloat(AlaLiveFocusCircleView.this, "alpha", 1.0f, 0.0f);
                        AlaLiveFocusCircleView.this.gOx.setDuration(960L);
                        AlaLiveFocusCircleView.this.gOx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                AlaLiveFocusCircleView.this.gOy = false;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }
                        });
                    }
                    AlaLiveFocusCircleView.this.gOx.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }
            });
        } else {
            if (this.geb.isRunning()) {
                this.geb.cancel();
            }
            if (this.gOx != null && this.gOx.isRunning()) {
                this.gOx.cancel();
            }
        }
        this.geb.start();
    }
}
