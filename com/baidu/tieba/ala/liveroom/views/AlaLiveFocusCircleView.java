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
    private Paint eKt;
    private ObjectAnimator gLh;
    private boolean gLi;
    private Bitmap gLj;
    private AnimatorSet gaO;
    private int mBorderWidth;

    public AlaLiveFocusCircleView(Context context) {
        super(context);
        this.mBorderWidth = 4;
        this.gLi = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderWidth = 4;
        this.gLi = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderWidth = 4;
        this.gLi = false;
        init(context);
    }

    private void init(Context context) {
        this.eKt = new Paint();
        this.eKt.setAntiAlias(true);
        this.eKt.setStyle(Paint.Style.STROKE);
        this.eKt.setColor(Color.parseColor("#ffffffff"));
        this.eKt.setStrokeWidth(this.mBorderWidth);
        setAlpha(0.0f);
        this.gLj = BitmapFactory.decodeResource(context.getResources(), a.f.camera_focus);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.gLj, (getWidth() / 2) - 80, (getHeight() / 2) - 80, this.eKt);
    }

    public void bXa() {
        this.gLi = true;
        if (this.gaO == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 3.0f, 2.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 3.0f, 2.0f, 1.0f);
            this.gaO = new AnimatorSet();
            this.gaO.play(ofFloat).with(ofFloat2);
            this.gaO.setInterpolator(new LinearInterpolator());
            this.gaO.setDuration(500L);
            this.gaO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AlaLiveFocusCircleView.this.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AlaLiveFocusCircleView.this.gLh == null) {
                        AlaLiveFocusCircleView.this.gLh = ObjectAnimator.ofFloat(AlaLiveFocusCircleView.this, "alpha", 1.0f, 0.0f);
                        AlaLiveFocusCircleView.this.gLh.setDuration(960L);
                        AlaLiveFocusCircleView.this.gLh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                AlaLiveFocusCircleView.this.gLi = false;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }
                        });
                    }
                    AlaLiveFocusCircleView.this.gLh.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }
            });
        } else {
            if (this.gaO.isRunning()) {
                this.gaO.cancel();
            }
            if (this.gLh != null && this.gLh.isRunning()) {
                this.gLh.cancel();
            }
        }
        this.gaO.start();
    }
}
