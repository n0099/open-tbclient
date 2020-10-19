package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes4.dex */
public class AlaChallengeWaveView extends View {
    public static final float gKx = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float gKy = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float gKz = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean fev;
    private float[] gKA;
    private float gKB;
    private int gKC;
    private float[] gKD;
    private float[] gKE;
    private float[] gKF;
    private float[] gKG;
    private float[] gKH;
    private int gKI;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.gKA = new float[]{gKx, gKy, gKz};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gKA = new float[]{gKx, gKy, gKz};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gKA = new float[]{gKx, gKy, gKz};
        init();
    }

    private void init() {
        this.gKI = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.gKB = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gKC = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.gKC);
        this.mPaint.setStrokeWidth(this.gKB);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.gKE = fArr;
        if (this.gKE != null) {
            this.gKD = new float[this.gKE.length];
            for (int i = 0; i < this.gKE.length; i++) {
                this.gKD[i] = this.gKE[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.gKH = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.gKH[i] = fArr[i];
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = getPaddingLeft() + getPaddingRight();
                if (this.gKD != null && this.gKD.length > 0) {
                    size = (int) (size + (this.gKB * this.gKD.length) + ((this.gKD.length - 1) * this.gKI));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.gKD != null) {
                i3 = 0;
                while (i4 < this.gKD.length) {
                    if (this.gKD[i4] > i3) {
                        i3 = (int) this.gKD[i4];
                    }
                    i4++;
                }
            } else {
                i3 = 0;
            }
            i4 = paddingTop + i3;
        }
        setMeasuredDimension(size, i4);
    }

    public void startAnimation() {
        if (this.gKD != null) {
            this.fev = false;
            this.gKG = getDifValueArray();
            this.gKF = new float[this.gKD.length];
            for (int i = 0; i < this.gKD.length; i++) {
                this.gKF[i] = this.gKD[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.fev) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.gKD.length; i2++) {
                            AlaChallengeWaveView.this.gKD[i2] = AlaChallengeWaveView.this.gKF[i2] + (AlaChallengeWaveView.this.gKG[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.fev) {
                        if (AlaChallengeWaveView.this.gKH == null) {
                            if (AlaChallengeWaveView.this.gKD != null && AlaChallengeWaveView.this.gKE != null && AlaChallengeWaveView.this.gKD.length == AlaChallengeWaveView.this.gKE.length) {
                                while (i2 < AlaChallengeWaveView.this.gKE.length) {
                                    AlaChallengeWaveView.this.gKD[i2] = AlaChallengeWaveView.this.gKE[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.gKD = new float[AlaChallengeWaveView.this.gKH.length];
                            while (i2 < AlaChallengeWaveView.this.gKH.length) {
                                AlaChallengeWaveView.this.gKD[i2] = AlaChallengeWaveView.this.gKH[i2];
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
        this.fev = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.gKD == null) {
            return null;
        }
        float[] fArr = new float[this.gKD.length];
        if (this.gKA.length <= 1) {
            for (int i = 0; i < this.gKD.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.gKD.length];
        for (int i2 = 0; i2 < this.gKD.length; i2++) {
            for (int i3 = 0; i3 < this.gKA.length; i3++) {
                if (this.gKD[i2] == this.gKA[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.gKA.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.gKA.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.gKA[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.gKD.length; i4++) {
            fArr[i4] = fArr2[i4] - this.gKD[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.gKD != null) {
            for (int i = 0; i < this.gKD.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.gKB) + (this.gKI * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.gKD[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.gKB + f, this.gKD[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
