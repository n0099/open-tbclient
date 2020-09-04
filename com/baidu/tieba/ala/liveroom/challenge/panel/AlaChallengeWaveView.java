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
/* loaded from: classes7.dex */
public class AlaChallengeWaveView extends View {
    public static final float gsI = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float gsJ = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float gsK = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean ePw;
    private float[] gsL;
    private float gsM;
    private int gsN;
    private float[] gsO;
    private float[] gsP;
    private float[] gsQ;
    private float[] gsR;
    private float[] gsS;
    private int gsT;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.gsL = new float[]{gsI, gsJ, gsK};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gsL = new float[]{gsI, gsJ, gsK};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gsL = new float[]{gsI, gsJ, gsK};
        init();
    }

    private void init() {
        this.gsT = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.gsM = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gsN = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.gsN);
        this.mPaint.setStrokeWidth(this.gsM);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.gsP = fArr;
        if (this.gsP != null) {
            this.gsO = new float[this.gsP.length];
            for (int i = 0; i < this.gsP.length; i++) {
                this.gsO[i] = this.gsP[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.gsS = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.gsS[i] = fArr[i];
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
                if (this.gsO != null && this.gsO.length > 0) {
                    size = (int) (size + (this.gsM * this.gsO.length) + ((this.gsO.length - 1) * this.gsT));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.gsO != null) {
                i3 = 0;
                while (i4 < this.gsO.length) {
                    if (this.gsO[i4] > i3) {
                        i3 = (int) this.gsO[i4];
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
        if (this.gsO != null) {
            this.ePw = false;
            this.gsR = getDifValueArray();
            this.gsQ = new float[this.gsO.length];
            for (int i = 0; i < this.gsO.length; i++) {
                this.gsQ[i] = this.gsO[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.ePw) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.gsO.length; i2++) {
                            AlaChallengeWaveView.this.gsO[i2] = AlaChallengeWaveView.this.gsQ[i2] + (AlaChallengeWaveView.this.gsR[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.ePw) {
                        if (AlaChallengeWaveView.this.gsS == null) {
                            if (AlaChallengeWaveView.this.gsO != null && AlaChallengeWaveView.this.gsP != null && AlaChallengeWaveView.this.gsO.length == AlaChallengeWaveView.this.gsP.length) {
                                while (i2 < AlaChallengeWaveView.this.gsP.length) {
                                    AlaChallengeWaveView.this.gsO[i2] = AlaChallengeWaveView.this.gsP[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.gsO = new float[AlaChallengeWaveView.this.gsS.length];
                            while (i2 < AlaChallengeWaveView.this.gsS.length) {
                                AlaChallengeWaveView.this.gsO[i2] = AlaChallengeWaveView.this.gsS[i2];
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
        this.ePw = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.gsO == null) {
            return null;
        }
        float[] fArr = new float[this.gsO.length];
        if (this.gsL.length <= 1) {
            for (int i = 0; i < this.gsO.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.gsO.length];
        for (int i2 = 0; i2 < this.gsO.length; i2++) {
            for (int i3 = 0; i3 < this.gsL.length; i3++) {
                if (this.gsO[i2] == this.gsL[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.gsL.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.gsL.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.gsL[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.gsO.length; i4++) {
            fArr[i4] = fArr2[i4] - this.gsO[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.gsO != null) {
            for (int i = 0; i < this.gsO.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.gsM) + (this.gsT * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.gsO[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.gsM + f, this.gsO[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
