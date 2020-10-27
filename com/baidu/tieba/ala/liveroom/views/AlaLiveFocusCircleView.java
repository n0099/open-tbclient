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
    private Paint fhn;
    private AnimatorSet gAw;
    private ObjectAnimator hpk;
    private boolean hpl;
    private Bitmap hpm;
    private int mBorderWidth;

    public AlaLiveFocusCircleView(Context context) {
        super(context);
        this.mBorderWidth = 4;
        this.hpl = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderWidth = 4;
        this.hpl = false;
        init(context);
    }

    public AlaLiveFocusCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderWidth = 4;
        this.hpl = false;
        init(context);
    }

    private void init(Context context) {
        this.fhn = new Paint();
        this.fhn.setAntiAlias(true);
        this.fhn.setStyle(Paint.Style.STROKE);
        this.fhn.setColor(Color.parseColor("#ffffffff"));
        this.fhn.setStrokeWidth(this.mBorderWidth);
        setAlpha(0.0f);
        this.hpm = BitmapFactory.decodeResource(context.getResources(), a.f.camera_focus);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.hpm, (getWidth() / 2) - 80, (getHeight() / 2) - 80, this.fhn);
    }

    public void cfl() {
        this.hpl = true;
        if (this.gAw == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 3.0f, 2.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 3.0f, 2.0f, 1.0f);
            this.gAw = new AnimatorSet();
            this.gAw.play(ofFloat).with(ofFloat2);
            this.gAw.setInterpolator(new LinearInterpolator());
            this.gAw.setDuration(500L);
            this.gAw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AlaLiveFocusCircleView.this.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AlaLiveFocusCircleView.this.hpk == null) {
                        AlaLiveFocusCircleView.this.hpk = ObjectAnimator.ofFloat(AlaLiveFocusCircleView.this, "alpha", 1.0f, 0.0f);
                        AlaLiveFocusCircleView.this.hpk.setDuration(960L);
                        AlaLiveFocusCircleView.this.hpk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFocusCircleView.1.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                AlaLiveFocusCircleView.this.hpl = false;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }
                        });
                    }
                    AlaLiveFocusCircleView.this.hpk.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }
            });
        } else {
            if (this.gAw.isRunning()) {
                this.gAw.cancel();
            }
            if (this.hpk != null && this.hpk.isRunning()) {
                this.hpk.cancel();
            }
        }
        this.gAw.start();
    }
}
