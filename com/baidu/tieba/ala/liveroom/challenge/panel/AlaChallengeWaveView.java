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
    public static final float hxD = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds16);
    public static final float hxE = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds24);
    public static final float hxF = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds32);
    private boolean fJr;
    private float[] hxG;
    private float hxH;
    private int hxI;
    private float[] hxJ;
    private float[] hxK;
    private float[] hxL;
    private float[] hxM;
    private float[] hxN;
    private int hxO;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.hxG = new float[]{hxD, hxE, hxF};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hxG = new float[]{hxD, hxE, hxF};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hxG = new float[]{hxD, hxE, hxF};
        init();
    }

    private void init() {
        this.hxO = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.hxH = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hxI = getContext().getResources().getColor(a.c.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.hxI);
        this.mPaint.setStrokeWidth(this.hxH);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.hxK = fArr;
        if (this.hxK != null) {
            this.hxJ = new float[this.hxK.length];
            for (int i = 0; i < this.hxK.length; i++) {
                this.hxJ[i] = this.hxK[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.hxN = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.hxN[i] = fArr[i];
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
            i3 = (this.hxJ == null || this.hxJ.length <= 0) ? paddingLeft : (int) (paddingLeft + (this.hxH * this.hxJ.length) + ((this.hxJ.length - 1) * this.hxO));
        } else {
            i3 = 0;
        }
        if (mode2 == 1073741824) {
            i5 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            if (this.hxJ != null) {
                int i6 = 0;
                while (true) {
                    i4 = i5;
                    if (i6 >= this.hxJ.length) {
                        break;
                    }
                    i5 = this.hxJ[i6] > ((float) i4) ? (int) this.hxJ[i6] : i4;
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
        if (this.hxJ != null) {
            this.fJr = false;
            this.hxM = getDifValueArray();
            this.hxL = new float[this.hxJ.length];
            for (int i = 0; i < this.hxJ.length; i++) {
                this.hxL[i] = this.hxJ[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.fJr) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.hxJ.length; i2++) {
                            AlaChallengeWaveView.this.hxJ[i2] = AlaChallengeWaveView.this.hxL[i2] + (AlaChallengeWaveView.this.hxM[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.fJr) {
                        if (AlaChallengeWaveView.this.hxN == null) {
                            if (AlaChallengeWaveView.this.hxJ != null && AlaChallengeWaveView.this.hxK != null && AlaChallengeWaveView.this.hxJ.length == AlaChallengeWaveView.this.hxK.length) {
                                while (i2 < AlaChallengeWaveView.this.hxK.length) {
                                    AlaChallengeWaveView.this.hxJ[i2] = AlaChallengeWaveView.this.hxK[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.hxJ = new float[AlaChallengeWaveView.this.hxN.length];
                            while (i2 < AlaChallengeWaveView.this.hxN.length) {
                                AlaChallengeWaveView.this.hxJ[i2] = AlaChallengeWaveView.this.hxN[i2];
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
        this.fJr = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.hxJ == null) {
            return null;
        }
        float[] fArr = new float[this.hxJ.length];
        if (this.hxG.length <= 1) {
            for (int i = 0; i < this.hxJ.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.hxJ.length];
        for (int i2 = 0; i2 < this.hxJ.length; i2++) {
            for (int i3 = 0; i3 < this.hxG.length; i3++) {
                if (this.hxJ[i2] == this.hxG[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.hxG.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.hxG.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.hxG[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.hxJ.length; i4++) {
            fArr[i4] = fArr2[i4] - this.hxJ[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.hxJ != null) {
            for (int i = 0; i < this.hxJ.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.hxH) + (this.hxO * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.hxJ[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.hxH + f, this.hxJ[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
