package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes11.dex */
public class AlaChallengeWaveView extends View {
    public static final float hxv = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds16);
    public static final float hxw = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds24);
    public static final float hxx = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds32);
    private boolean fGW;
    private int hxA;
    private float[] hxB;
    private float[] hxC;
    private float[] hxD;
    private float[] hxE;
    private float[] hxF;
    private int hxG;
    private float[] hxy;
    private float hxz;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.hxy = new float[]{hxv, hxw, hxx};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hxy = new float[]{hxv, hxw, hxx};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hxy = new float[]{hxv, hxw, hxx};
        init();
    }

    private void init() {
        this.hxG = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.hxz = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hxA = getContext().getResources().getColor(a.c.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.hxA);
        this.mPaint.setStrokeWidth(this.hxz);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.hxC = fArr;
        if (this.hxC != null) {
            this.hxB = new float[this.hxC.length];
            for (int i = 0; i < this.hxC.length; i++) {
                this.hxB[i] = this.hxC[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.hxF = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.hxF[i] = fArr[i];
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            i3 = size;
        } else if (mode == Integer.MIN_VALUE) {
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            i3 = (this.hxB == null || this.hxB.length <= 0) ? paddingLeft : (int) (paddingLeft + (this.hxz * this.hxB.length) + ((this.hxB.length - 1) * this.hxG));
        } else {
            i3 = 0;
        }
        if (mode2 == 1073741824) {
            i5 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            if (this.hxB != null) {
                int i6 = 0;
                while (true) {
                    i4 = i5;
                    if (i6 >= this.hxB.length) {
                        break;
                    }
                    i5 = this.hxB[i6] > ((float) i4) ? (int) this.hxB[i6] : i4;
                    i6++;
                }
            } else {
                i4 = 0;
            }
            i5 = paddingBottom + i4;
        }
        setMeasuredDimension(i3, i5);
    }

    public void startAnimation() {
        if (this.hxB != null) {
            this.fGW = false;
            this.hxE = getDifValueArray();
            this.hxD = new float[this.hxB.length];
            for (int i = 0; i < this.hxB.length; i++) {
                this.hxD[i] = this.hxB[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.fGW) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.hxB.length; i2++) {
                            AlaChallengeWaveView.this.hxB[i2] = AlaChallengeWaveView.this.hxD[i2] + (AlaChallengeWaveView.this.hxE[i2] * floatValue);
                        }
                        AlaChallengeWaveView.this.invalidate();
                    }
                }
            });
            this.mValueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    int i2 = 0;
                    if (AlaChallengeWaveView.this.fGW) {
                        if (AlaChallengeWaveView.this.hxF == null) {
                            if (AlaChallengeWaveView.this.hxB != null && AlaChallengeWaveView.this.hxC != null && AlaChallengeWaveView.this.hxB.length == AlaChallengeWaveView.this.hxC.length) {
                                while (i2 < AlaChallengeWaveView.this.hxC.length) {
                                    AlaChallengeWaveView.this.hxB[i2] = AlaChallengeWaveView.this.hxC[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.hxB = new float[AlaChallengeWaveView.this.hxF.length];
                            while (i2 < AlaChallengeWaveView.this.hxF.length) {
                                AlaChallengeWaveView.this.hxB[i2] = AlaChallengeWaveView.this.hxF[i2];
                                i2++;
                            }
                        }
                        AlaChallengeWaveView.this.invalidate();
                        return;
                    }
                    AlaChallengeWaveView.this.startAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mValueAnimator.start();
        }
    }

    public void endAnimation() {
        this.fGW = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.hxB == null) {
            return null;
        }
        float[] fArr = new float[this.hxB.length];
        if (this.hxy.length <= 1) {
            for (int i = 0; i < this.hxB.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.hxB.length];
        for (int i2 = 0; i2 < this.hxB.length; i2++) {
            for (int i3 = 0; i3 < this.hxy.length; i3++) {
                if (this.hxB[i2] == this.hxy[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.hxy.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.hxy.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.hxy[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.hxB.length; i4++) {
            fArr[i4] = fArr2[i4] - this.hxB[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.hxB != null) {
            for (int i = 0; i < this.hxB.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.hxz) + (this.hxG * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.hxB[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.hxz + f, this.hxB[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
