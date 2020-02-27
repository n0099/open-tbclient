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
    public static final float eVY = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float eVZ = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float eWa = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean dBg;
    private float[] eWb;
    private float eWc;
    private int eWd;
    private float[] eWe;
    private float[] eWf;
    private float[] eWg;
    private float[] eWh;
    private float[] eWi;
    private int eWj;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.eWb = new float[]{eVY, eVZ, eWa};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWb = new float[]{eVY, eVZ, eWa};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWb = new float[]{eVY, eVZ, eWa};
        init();
    }

    private void init() {
        this.eWj = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.eWc = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.eWd = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.eWd);
        this.mPaint.setStrokeWidth(this.eWc);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.eWf = fArr;
        if (this.eWf != null) {
            this.eWe = new float[this.eWf.length];
            for (int i = 0; i < this.eWf.length; i++) {
                this.eWe[i] = this.eWf[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.eWi = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.eWi[i] = fArr[i];
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
                if (this.eWe != null && this.eWe.length > 0) {
                    size = (int) (size + (this.eWc * this.eWe.length) + ((this.eWe.length - 1) * this.eWj));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.eWe != null) {
                i3 = 0;
                while (i4 < this.eWe.length) {
                    if (this.eWe[i4] > i3) {
                        i3 = (int) this.eWe[i4];
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
        if (this.eWe != null) {
            this.dBg = false;
            this.eWh = getDifValueArray();
            this.eWg = new float[this.eWe.length];
            for (int i = 0; i < this.eWe.length; i++) {
                this.eWg[i] = this.eWe[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.dBg) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.eWe.length; i2++) {
                            AlaChallengeWaveView.this.eWe[i2] = AlaChallengeWaveView.this.eWg[i2] + (AlaChallengeWaveView.this.eWh[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.dBg) {
                        if (AlaChallengeWaveView.this.eWi == null) {
                            if (AlaChallengeWaveView.this.eWe != null && AlaChallengeWaveView.this.eWf != null && AlaChallengeWaveView.this.eWe.length == AlaChallengeWaveView.this.eWf.length) {
                                while (i2 < AlaChallengeWaveView.this.eWf.length) {
                                    AlaChallengeWaveView.this.eWe[i2] = AlaChallengeWaveView.this.eWf[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.eWe = new float[AlaChallengeWaveView.this.eWi.length];
                            while (i2 < AlaChallengeWaveView.this.eWi.length) {
                                AlaChallengeWaveView.this.eWe[i2] = AlaChallengeWaveView.this.eWi[i2];
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
        this.dBg = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.eWe == null) {
            return null;
        }
        float[] fArr = new float[this.eWe.length];
        if (this.eWb.length <= 1) {
            for (int i = 0; i < this.eWe.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.eWe.length];
        for (int i2 = 0; i2 < this.eWe.length; i2++) {
            for (int i3 = 0; i3 < this.eWb.length; i3++) {
                if (this.eWe[i2] == this.eWb[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.eWb.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.eWb.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.eWb[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.eWe.length; i4++) {
            fArr[i4] = fArr2[i4] - this.eWe[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.eWe != null) {
            for (int i = 0; i < this.eWe.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.eWc) + (this.eWj * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.eWe[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.eWc + f, this.eWe[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
