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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes6.dex */
public class AlaChallengeWaveView extends View {
    public static final float ebA = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float ebB = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float ebC = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean cKc;
    private float[] ebD;
    private float ebE;
    private int ebF;
    private float[] ebG;
    private float[] ebH;
    private float[] ebI;
    private float[] ebJ;
    private float[] ebK;
    private int ebL;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.ebD = new float[]{ebA, ebB, ebC};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ebD = new float[]{ebA, ebB, ebC};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ebD = new float[]{ebA, ebB, ebC};
        init();
    }

    private void init() {
        this.ebL = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.ebE = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.ebF = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.ebF);
        this.mPaint.setStrokeWidth(this.ebE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.ebH = fArr;
        if (this.ebH != null) {
            this.ebG = new float[this.ebH.length];
            for (int i = 0; i < this.ebH.length; i++) {
                this.ebG[i] = this.ebH[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.ebK = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.ebK[i] = fArr[i];
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
                if (this.ebG != null && this.ebG.length > 0) {
                    size = (int) (size + (this.ebE * this.ebG.length) + ((this.ebG.length - 1) * this.ebL));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.ebG != null) {
                i3 = 0;
                while (i4 < this.ebG.length) {
                    if (this.ebG[i4] > i3) {
                        i3 = (int) this.ebG[i4];
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
        if (this.ebG != null) {
            this.cKc = false;
            this.ebJ = getDifValueArray();
            this.ebI = new float[this.ebG.length];
            for (int i = 0; i < this.ebG.length; i++) {
                this.ebI[i] = this.ebG[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.cKc) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.ebG.length; i2++) {
                            AlaChallengeWaveView.this.ebG[i2] = AlaChallengeWaveView.this.ebI[i2] + (AlaChallengeWaveView.this.ebJ[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.cKc) {
                        if (AlaChallengeWaveView.this.ebK == null) {
                            if (AlaChallengeWaveView.this.ebG != null && AlaChallengeWaveView.this.ebH != null && AlaChallengeWaveView.this.ebG.length == AlaChallengeWaveView.this.ebH.length) {
                                while (i2 < AlaChallengeWaveView.this.ebH.length) {
                                    AlaChallengeWaveView.this.ebG[i2] = AlaChallengeWaveView.this.ebH[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.ebG = new float[AlaChallengeWaveView.this.ebK.length];
                            while (i2 < AlaChallengeWaveView.this.ebK.length) {
                                AlaChallengeWaveView.this.ebG[i2] = AlaChallengeWaveView.this.ebK[i2];
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
        this.cKc = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.ebG == null) {
            return null;
        }
        float[] fArr = new float[this.ebG.length];
        if (this.ebD.length <= 1) {
            for (int i = 0; i < this.ebG.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.ebG.length];
        for (int i2 = 0; i2 < this.ebG.length; i2++) {
            for (int i3 = 0; i3 < this.ebD.length; i3++) {
                if (this.ebG[i2] == this.ebD[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.ebD.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.ebD.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.ebD[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.ebG.length; i4++) {
            fArr[i4] = fArr2[i4] - this.ebG[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.ebG != null) {
            for (int i = 0; i < this.ebG.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.ebE) + (this.ebL * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.ebG[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.ebE + f, this.ebG[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
