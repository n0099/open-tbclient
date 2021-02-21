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
    private Paint fBg;
    private AnimatorSet gZf;
    private ObjectAnimator hQw;
    private boolean hQx;
    private Bitmap hQy;
    private int mBorderWidth;

    public AlaLiveFocusCircleView(Context context) {
        super(context);
        this.mBorderWidth = 4;
        this.hQx = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderWidth = 4;
        this.hQx = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderWidth = 4;
        this.hQx = false;
        init(context);
    }

    private void init(Context context) {
        this.fBg = new Paint();
        this.fBg.setAntiAlias(true);
        this.fBg.setStyle(Paint.Style.STROKE);
        this.fBg.setColor(Color.parseColor("#ffffffff"));
        this.fBg.setStrokeWidth(this.mBorderWidth);
        setAlpha(0.0f);
        this.hQy = BitmapFactory.decodeResource(context.getResources(), a.e.camera_focus);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.hQy, (getWidth() / 2) - 80, (getHeight() / 2) - 80, this.fBg);
    }

    public void clh() {
        this.hQx = true;
        if (this.gZf == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 3.0f, 2.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 3.0f, 2.0f, 1.0f);
            this.gZf = new AnimatorSet();
            this.gZf.play(ofFloat).with(ofFloat2);
            this.gZf.setInterpolator(new LinearInterpolator());
            this.gZf.setDuration(500L);
            this.gZf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AlaLiveFocusCircleView.this.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AlaLiveFocusCircleView.this.hQw == null) {
                        AlaLiveFocusCircleView.this.hQw = ObjectAnimator.ofFloat(AlaLiveFocusCircleView.this, "alpha", 1.0f, 0.0f);
                        AlaLiveFocusCircleView.this.hQw.setDuration(960L);
                        AlaLiveFocusCircleView.this.hQw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                AlaLiveFocusCircleView.this.hQx = false;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }
                        });
                    }
                    AlaLiveFocusCircleView.this.hQw.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }
            });
        } else {
            if (this.gZf.isRunning()) {
                this.gZf.cancel();
            }
            if (this.hQw != null && this.hQw.isRunning()) {
                this.hQw.cancel();
            }
        }
        this.gZf.start();
    }
}
