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
    public static final float eaJ = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float eaK = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float eaL = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean cJl;
    private float[] eaM;
    private float eaN;
    private int eaO;
    private float[] eaP;
    private float[] eaQ;
    private float[] eaR;
    private float[] eaS;
    private float[] eaT;
    private int eaU;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.eaM = new float[]{eaJ, eaK, eaL};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eaM = new float[]{eaJ, eaK, eaL};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eaM = new float[]{eaJ, eaK, eaL};
        init();
    }

    private void init() {
        this.eaU = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.eaN = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.eaO = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.eaO);
        this.mPaint.setStrokeWidth(this.eaN);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.eaQ = fArr;
        if (this.eaQ != null) {
            this.eaP = new float[this.eaQ.length];
            for (int i = 0; i < this.eaQ.length; i++) {
                this.eaP[i] = this.eaQ[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.eaT = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.eaT[i] = fArr[i];
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
                if (this.eaP != null && this.eaP.length > 0) {
                    size = (int) (size + (this.eaN * this.eaP.length) + ((this.eaP.length - 1) * this.eaU));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.eaP != null) {
                i3 = 0;
                while (i4 < this.eaP.length) {
                    if (this.eaP[i4] > i3) {
                        i3 = (int) this.eaP[i4];
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
        if (this.eaP != null) {
            this.cJl = false;
            this.eaS = getDifValueArray();
            this.eaR = new float[this.eaP.length];
            for (int i = 0; i < this.eaP.length; i++) {
                this.eaR[i] = this.eaP[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.cJl) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.eaP.length; i2++) {
                            AlaChallengeWaveView.this.eaP[i2] = AlaChallengeWaveView.this.eaR[i2] + (AlaChallengeWaveView.this.eaS[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.cJl) {
                        if (AlaChallengeWaveView.this.eaT == null) {
                            if (AlaChallengeWaveView.this.eaP != null && AlaChallengeWaveView.this.eaQ != null && AlaChallengeWaveView.this.eaP.length == AlaChallengeWaveView.this.eaQ.length) {
                                while (i2 < AlaChallengeWaveView.this.eaQ.length) {
                                    AlaChallengeWaveView.this.eaP[i2] = AlaChallengeWaveView.this.eaQ[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.eaP = new float[AlaChallengeWaveView.this.eaT.length];
                            while (i2 < AlaChallengeWaveView.this.eaT.length) {
                                AlaChallengeWaveView.this.eaP[i2] = AlaChallengeWaveView.this.eaT[i2];
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
        this.cJl = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.eaP == null) {
            return null;
        }
        float[] fArr = new float[this.eaP.length];
        if (this.eaM.length <= 1) {
            for (int i = 0; i < this.eaP.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.eaP.length];
        for (int i2 = 0; i2 < this.eaP.length; i2++) {
            for (int i3 = 0; i3 < this.eaM.length; i3++) {
                if (this.eaP[i2] == this.eaM[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.eaM.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.eaM.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.eaM[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.eaP.length; i4++) {
            fArr[i4] = fArr2[i4] - this.eaP[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.eaP != null) {
            for (int i = 0; i < this.eaP.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.eaN) + (this.eaU * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.eaP[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.eaN + f, this.eaP[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
