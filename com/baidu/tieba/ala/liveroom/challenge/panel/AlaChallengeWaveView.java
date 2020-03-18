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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import java.util.Random;
/* loaded from: classes3.dex */
public class AlaChallengeWaveView extends View {
    public static final float eWK = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float eWL = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float eWM = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean dBH;
    private float[] eWN;
    private float eWO;
    private int eWP;
    private float[] eWQ;
    private float[] eWR;
    private float[] eWS;
    private float[] eWT;
    private float[] eWU;
    private int eWV;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.eWN = new float[]{eWK, eWL, eWM};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWN = new float[]{eWK, eWL, eWM};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWN = new float[]{eWK, eWL, eWM};
        init();
    }

    private void init() {
        this.eWV = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.eWO = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.eWP = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.eWP);
        this.mPaint.setStrokeWidth(this.eWO);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.eWR = fArr;
        if (this.eWR != null) {
            this.eWQ = new float[this.eWR.length];
            for (int i = 0; i < this.eWR.length; i++) {
                this.eWQ[i] = this.eWR[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.eWU = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.eWU[i] = fArr[i];
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
                if (this.eWQ != null && this.eWQ.length > 0) {
                    size = (int) (size + (this.eWO * this.eWQ.length) + ((this.eWQ.length - 1) * this.eWV));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.eWQ != null) {
                i3 = 0;
                while (i4 < this.eWQ.length) {
                    if (this.eWQ[i4] > i3) {
                        i3 = (int) this.eWQ[i4];
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
        if (this.eWQ != null) {
            this.dBH = false;
            this.eWT = getDifValueArray();
            this.eWS = new float[this.eWQ.length];
            for (int i = 0; i < this.eWQ.length; i++) {
                this.eWS[i] = this.eWQ[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.dBH) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.eWQ.length; i2++) {
                            AlaChallengeWaveView.this.eWQ[i2] = AlaChallengeWaveView.this.eWS[i2] + (AlaChallengeWaveView.this.eWT[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.dBH) {
                        if (AlaChallengeWaveView.this.eWU == null) {
                            if (AlaChallengeWaveView.this.eWQ != null && AlaChallengeWaveView.this.eWR != null && AlaChallengeWaveView.this.eWQ.length == AlaChallengeWaveView.this.eWR.length) {
                                while (i2 < AlaChallengeWaveView.this.eWR.length) {
                                    AlaChallengeWaveView.this.eWQ[i2] = AlaChallengeWaveView.this.eWR[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.eWQ = new float[AlaChallengeWaveView.this.eWU.length];
                            while (i2 < AlaChallengeWaveView.this.eWU.length) {
                                AlaChallengeWaveView.this.eWQ[i2] = AlaChallengeWaveView.this.eWU[i2];
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
        this.dBH = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.eWQ == null) {
            return null;
        }
        float[] fArr = new float[this.eWQ.length];
        if (this.eWN.length <= 1) {
            for (int i = 0; i < this.eWQ.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.eWQ.length];
        for (int i2 = 0; i2 < this.eWQ.length; i2++) {
            for (int i3 = 0; i3 < this.eWN.length; i3++) {
                if (this.eWQ[i2] == this.eWN[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.eWN.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.eWN.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.eWN[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.eWQ.length; i4++) {
            fArr[i4] = fArr2[i4] - this.eWQ[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.eWQ != null) {
            for (int i = 0; i < this.eWQ.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.eWO) + (this.eWV * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.eWQ[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.eWO + f, this.eWQ[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
