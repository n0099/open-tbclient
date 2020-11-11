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
    private Paint fnh;
    private AnimatorSet gGk;
    private ObjectAnimator hvi;
    private boolean hvj;
    private Bitmap hvk;
    private int mBorderWidth;

    public AlaLiveFocusCircleView(Context context) {
        super(context);
        this.mBorderWidth = 4;
        this.hvj = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderWidth = 4;
        this.hvj = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderWidth = 4;
        this.hvj = false;
        init(context);
    }

    private void init(Context context) {
        this.fnh = new Paint();
        this.fnh.setAntiAlias(true);
        this.fnh.setStyle(Paint.Style.STROKE);
        this.fnh.setColor(Color.parseColor("#ffffffff"));
        this.fnh.setStrokeWidth(this.mBorderWidth);
        setAlpha(0.0f);
        this.hvk = BitmapFactory.decodeResource(context.getResources(), a.e.camera_focus);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.hvk, (getWidth() / 2) - 80, (getHeight() / 2) - 80, this.fnh);
    }

    public void chO() {
        this.hvj = true;
        if (this.gGk == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 3.0f, 2.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 3.0f, 2.0f, 1.0f);
            this.gGk = new AnimatorSet();
            this.gGk.play(ofFloat).with(ofFloat2);
            this.gGk.setInterpolator(new LinearInterpolator());
            this.gGk.setDuration(500L);
            this.gGk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AlaLiveFocusCircleView.this.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AlaLiveFocusCircleView.this.hvi == null) {
                        AlaLiveFocusCircleView.this.hvi = ObjectAnimator.ofFloat(AlaLiveFocusCircleView.this, "alpha", 1.0f, 0.0f);
                        AlaLiveFocusCircleView.this.hvi.setDuration(960L);
                        AlaLiveFocusCircleView.this.hvi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                AlaLiveFocusCircleView.this.hvj = false;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }
                        });
                    }
                    AlaLiveFocusCircleView.this.hvi.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }
            });
        } else {
            if (this.gGk.isRunning()) {
                this.gGk.cancel();
            }
            if (this.hvi != null && this.hvi.isRunning()) {
                this.hvi.cancel();
            }
        }
        this.gGk.start();
    }
}
