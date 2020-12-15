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
    public static final float hlI = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds16);
    public static final float hlJ = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds24);
    public static final float hlK = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds32);
    private boolean fzL;
    private float[] hlL;
    private float hlM;
    private int hlN;
    private float[] hlO;
    private float[] hlP;
    private float[] hlQ;
    private float[] hlR;
    private float[] hlS;
    private int hlT;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.hlL = new float[]{hlI, hlJ, hlK};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hlL = new float[]{hlI, hlJ, hlK};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hlL = new float[]{hlI, hlJ, hlK};
        init();
    }

    private void init() {
        this.hlT = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.hlM = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hlN = getContext().getResources().getColor(a.c.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.hlN);
        this.mPaint.setStrokeWidth(this.hlM);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.hlP = fArr;
        if (this.hlP != null) {
            this.hlO = new float[this.hlP.length];
            for (int i = 0; i < this.hlP.length; i++) {
                this.hlO[i] = this.hlP[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.hlS = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.hlS[i] = fArr[i];
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
                if (this.hlO != null && this.hlO.length > 0) {
                    size = (int) (size + (this.hlM * this.hlO.length) + ((this.hlO.length - 1) * this.hlT));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.hlO != null) {
                i3 = 0;
                while (i4 < this.hlO.length) {
                    if (this.hlO[i4] > i3) {
                        i3 = (int) this.hlO[i4];
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
        if (this.hlO != null) {
            this.fzL = false;
            this.hlR = getDifValueArray();
            this.hlQ = new float[this.hlO.length];
            for (int i = 0; i < this.hlO.length; i++) {
                this.hlQ[i] = this.hlO[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.fzL) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.hlO.length; i2++) {
                            AlaChallengeWaveView.this.hlO[i2] = AlaChallengeWaveView.this.hlQ[i2] + (AlaChallengeWaveView.this.hlR[i2] * floatValue);
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
                        if (AlaChallengeWaveView.this.hlS == null) {
                            if (AlaChallengeWaveView.this.hlO != null && AlaChallengeWaveView.this.hlP != null && AlaChallengeWaveView.this.hlO.length == AlaChallengeWaveView.this.hlP.length) {
                                while (i2 < AlaChallengeWaveView.this.hlP.length) {
                                    AlaChallengeWaveView.this.hlO[i2] = AlaChallengeWaveView.this.hlP[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.hlO = new float[AlaChallengeWaveView.this.hlS.length];
                            while (i2 < AlaChallengeWaveView.this.hlS.length) {
                                AlaChallengeWaveView.this.hlO[i2] = AlaChallengeWaveView.this.hlS[i2];
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
        if (this.hlO == null) {
            return null;
        }
        float[] fArr = new float[this.hlO.length];
        if (this.hlL.length <= 1) {
            for (int i = 0; i < this.hlO.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.hlO.length];
        for (int i2 = 0; i2 < this.hlO.length; i2++) {
            for (int i3 = 0; i3 < this.hlL.length; i3++) {
                if (this.hlO[i2] == this.hlL[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.hlL.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.hlL.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.hlL[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.hlO.length; i4++) {
            fArr[i4] = fArr2[i4] - this.hlO[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.hlO != null) {
            for (int i = 0; i < this.hlO.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.hlM) + (this.hlT * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.hlO[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.hlM + f, this.hlO[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
