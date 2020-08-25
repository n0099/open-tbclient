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
    public static final float gsE = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float gsF = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float gsG = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean ePs;
    private float[] gsH;
    private float gsI;
    private int gsJ;
    private float[] gsK;
    private float[] gsL;
    private float[] gsM;
    private float[] gsN;
    private float[] gsO;
    private int gsP;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.gsH = new float[]{gsE, gsF, gsG};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gsH = new float[]{gsE, gsF, gsG};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gsH = new float[]{gsE, gsF, gsG};
        init();
    }

    private void init() {
        this.gsP = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.gsI = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gsJ = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.gsJ);
        this.mPaint.setStrokeWidth(this.gsI);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.gsL = fArr;
        if (this.gsL != null) {
            this.gsK = new float[this.gsL.length];
            for (int i = 0; i < this.gsL.length; i++) {
                this.gsK[i] = this.gsL[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.gsO = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.gsO[i] = fArr[i];
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
                if (this.gsK != null && this.gsK.length > 0) {
                    size = (int) (size + (this.gsI * this.gsK.length) + ((this.gsK.length - 1) * this.gsP));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.gsK != null) {
                i3 = 0;
                while (i4 < this.gsK.length) {
                    if (this.gsK[i4] > i3) {
                        i3 = (int) this.gsK[i4];
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
        if (this.gsK != null) {
            this.ePs = false;
            this.gsN = getDifValueArray();
            this.gsM = new float[this.gsK.length];
            for (int i = 0; i < this.gsK.length; i++) {
                this.gsM[i] = this.gsK[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.ePs) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.gsK.length; i2++) {
                            AlaChallengeWaveView.this.gsK[i2] = AlaChallengeWaveView.this.gsM[i2] + (AlaChallengeWaveView.this.gsN[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.ePs) {
                        if (AlaChallengeWaveView.this.gsO == null) {
                            if (AlaChallengeWaveView.this.gsK != null && AlaChallengeWaveView.this.gsL != null && AlaChallengeWaveView.this.gsK.length == AlaChallengeWaveView.this.gsL.length) {
                                while (i2 < AlaChallengeWaveView.this.gsL.length) {
                                    AlaChallengeWaveView.this.gsK[i2] = AlaChallengeWaveView.this.gsL[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.gsK = new float[AlaChallengeWaveView.this.gsO.length];
                            while (i2 < AlaChallengeWaveView.this.gsO.length) {
                                AlaChallengeWaveView.this.gsK[i2] = AlaChallengeWaveView.this.gsO[i2];
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
        this.ePs = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.gsK == null) {
            return null;
        }
        float[] fArr = new float[this.gsK.length];
        if (this.gsH.length <= 1) {
            for (int i = 0; i < this.gsK.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.gsK.length];
        for (int i2 = 0; i2 < this.gsK.length; i2++) {
            for (int i3 = 0; i3 < this.gsH.length; i3++) {
                if (this.gsK[i2] == this.gsH[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.gsH.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.gsH.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.gsH[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.gsK.length; i4++) {
            fArr[i4] = fArr2[i4] - this.gsK[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.gsK != null) {
            for (int i = 0; i < this.gsK.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.gsI) + (this.gsP * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.gsK[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.gsI + f, this.gsK[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
