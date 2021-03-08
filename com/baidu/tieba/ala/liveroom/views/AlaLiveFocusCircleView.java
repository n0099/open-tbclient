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
/* loaded from: classes10.dex */
public class AlaLiveFocusCircleView extends View {
    private Paint fCF;
    private ObjectAnimator hSf;
    private boolean hSg;
    private Bitmap hSh;
    private AnimatorSet haO;
    private int mBorderWidth;

    public AlaLiveFocusCircleView(Context context) {
        super(context);
        this.mBorderWidth = 4;
        this.hSg = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderWidth = 4;
        this.hSg = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderWidth = 4;
        this.hSg = false;
        init(context);
    }

    private void init(Context context) {
        this.fCF = new Paint();
        this.fCF.setAntiAlias(true);
        this.fCF.setStyle(Paint.Style.STROKE);
        this.fCF.setColor(Color.parseColor("#ffffffff"));
        this.fCF.setStrokeWidth(this.mBorderWidth);
        setAlpha(0.0f);
        this.hSh = BitmapFactory.decodeResource(context.getResources(), a.e.camera_focus);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.hSh, (getWidth() / 2) - 80, (getHeight() / 2) - 80, this.fCF);
    }

    public void cln() {
        this.hSg = true;
        if (this.haO == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 3.0f, 2.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 3.0f, 2.0f, 1.0f);
            this.haO = new AnimatorSet();
            this.haO.play(ofFloat).with(ofFloat2);
            this.haO.setInterpolator(new LinearInterpolator());
            this.haO.setDuration(500L);
            this.haO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AlaLiveFocusCircleView.this.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AlaLiveFocusCircleView.this.hSf == null) {
                        AlaLiveFocusCircleView.this.hSf = ObjectAnimator.ofFloat(AlaLiveFocusCircleView.this, "alpha", 1.0f, 0.0f);
                        AlaLiveFocusCircleView.this.hSf.setDuration(960L);
                        AlaLiveFocusCircleView.this.hSf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                AlaLiveFocusCircleView.this.hSg = false;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }
                        });
                    }
                    AlaLiveFocusCircleView.this.hSf.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }
            });
        } else {
            if (this.haO.isRunning()) {
                this.haO.cancel();
            }
            if (this.hSf != null && this.hSf.isRunning()) {
                this.hSf.cancel();
            }
        }
        this.haO.start();
    }
}
