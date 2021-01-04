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
/* loaded from: classes11.dex */
public class AlaLiveFocusCircleView extends View {
    private Paint fDz;
    private ObjectAnimator hQu;
    private boolean hQv;
    private Bitmap hQw;
    private AnimatorSet haN;
    private int mBorderWidth;

    public AlaLiveFocusCircleView(Context context) {
        super(context);
        this.mBorderWidth = 4;
        this.hQv = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderWidth = 4;
        this.hQv = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderWidth = 4;
        this.hQv = false;
        init(context);
    }

    private void init(Context context) {
        this.fDz = new Paint();
        this.fDz.setAntiAlias(true);
        this.fDz.setStyle(Paint.Style.STROKE);
        this.fDz.setColor(Color.parseColor("#ffffffff"));
        this.fDz.setStrokeWidth(this.mBorderWidth);
        setAlpha(0.0f);
        this.hQw = BitmapFactory.decodeResource(context.getResources(), a.e.camera_focus);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.hQw, (getWidth() / 2) - 80, (getHeight() / 2) - 80, this.fDz);
    }

    public void cnT() {
        this.hQv = true;
        if (this.haN == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 3.0f, 2.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 3.0f, 2.0f, 1.0f);
            this.haN = new AnimatorSet();
            this.haN.play(ofFloat).with(ofFloat2);
            this.haN.setInterpolator(new LinearInterpolator());
            this.haN.setDuration(500L);
            this.haN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AlaLiveFocusCircleView.this.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AlaLiveFocusCircleView.this.hQu == null) {
                        AlaLiveFocusCircleView.this.hQu = ObjectAnimator.ofFloat(AlaLiveFocusCircleView.this, "alpha", 1.0f, 0.0f);
                        AlaLiveFocusCircleView.this.hQu.setDuration(960L);
                        AlaLiveFocusCircleView.this.hQu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                AlaLiveFocusCircleView.this.hQv = false;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }
                        });
                    }
                    AlaLiveFocusCircleView.this.hQu.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }
            });
        } else {
            if (this.haN.isRunning()) {
                this.haN.cancel();
            }
            if (this.hQu != null && this.hQu.isRunning()) {
                this.hQu.cancel();
            }
        }
        this.haN.start();
    }
}
