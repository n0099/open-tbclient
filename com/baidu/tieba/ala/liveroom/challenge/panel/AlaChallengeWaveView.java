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
    public static final float hlG = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds16);
    public static final float hlH = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds24);
    public static final float hlI = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds32);
    private boolean fzL;
    private float[] hlJ;
    private float hlK;
    private int hlL;
    private float[] hlM;
    private float[] hlN;
    private float[] hlO;
    private float[] hlP;
    private float[] hlQ;
    private int hlR;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.hlJ = new float[]{hlG, hlH, hlI};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hlJ = new float[]{hlG, hlH, hlI};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hlJ = new float[]{hlG, hlH, hlI};
        init();
    }

    private void init() {
        this.hlR = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.hlK = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hlL = getContext().getResources().getColor(a.c.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.hlL);
        this.mPaint.setStrokeWidth(this.hlK);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.hlN = fArr;
        if (this.hlN != null) {
            this.hlM = new float[this.hlN.length];
            for (int i = 0; i < this.hlN.length; i++) {
                this.hlM[i] = this.hlN[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.hlQ = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.hlQ[i] = fArr[i];
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
                if (this.hlM != null && this.hlM.length > 0) {
                    size = (int) (size + (this.hlK * this.hlM.length) + ((this.hlM.length - 1) * this.hlR));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.hlM != null) {
                i3 = 0;
                while (i4 < this.hlM.length) {
                    if (this.hlM[i4] > i3) {
                        i3 = (int) this.hlM[i4];
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
        if (this.hlM != null) {
            this.fzL = false;
            this.hlP = getDifValueArray();
            this.hlO = new float[this.hlM.length];
            for (int i = 0; i < this.hlM.length; i++) {
                this.hlO[i] = this.hlM[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.fzL) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.hlM.length; i2++) {
                            AlaChallengeWaveView.this.hlM[i2] = AlaChallengeWaveView.this.hlO[i2] + (AlaChallengeWaveView.this.hlP[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.fzL) {
                        if (AlaChallengeWaveView.this.hlQ == null) {
                            if (AlaChallengeWaveView.this.hlM != null && AlaChallengeWaveView.this.hlN != null && AlaChallengeWaveView.this.hlM.length == AlaChallengeWaveView.this.hlN.length) {
                                while (i2 < AlaChallengeWaveView.this.hlN.length) {
                                    AlaChallengeWaveView.this.hlM[i2] = AlaChallengeWaveView.this.hlN[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.hlM = new float[AlaChallengeWaveView.this.hlQ.length];
                            while (i2 < AlaChallengeWaveView.this.hlQ.length) {
                                AlaChallengeWaveView.this.hlM[i2] = AlaChallengeWaveView.this.hlQ[i2];
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
        this.fzL = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.hlM == null) {
            return null;
        }
        float[] fArr = new float[this.hlM.length];
        if (this.hlJ.length <= 1) {
            for (int i = 0; i < this.hlM.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.hlM.length];
        for (int i2 = 0; i2 < this.hlM.length; i2++) {
            for (int i3 = 0; i3 < this.hlJ.length; i3++) {
                if (this.hlM[i2] == this.hlJ[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.hlJ.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.hlJ.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.hlJ[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.hlM.length; i4++) {
            fArr[i4] = fArr2[i4] - this.hlM[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.hlM != null) {
            for (int i = 0; i < this.hlM.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.hlK) + (this.hlR * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.hlM[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.hlK + f, this.hlM[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
