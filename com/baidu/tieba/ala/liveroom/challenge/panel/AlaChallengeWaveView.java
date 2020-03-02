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
    public static final float eVZ = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float eWa = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float eWb = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean dBh;
    private float[] eWc;
    private float eWd;
    private int eWe;
    private float[] eWf;
    private float[] eWg;
    private float[] eWh;
    private float[] eWi;
    private float[] eWj;
    private int eWk;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.eWc = new float[]{eVZ, eWa, eWb};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWc = new float[]{eVZ, eWa, eWb};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWc = new float[]{eVZ, eWa, eWb};
        init();
    }

    private void init() {
        this.eWk = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.eWd = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.eWe = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.eWe);
        this.mPaint.setStrokeWidth(this.eWd);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.eWg = fArr;
        if (this.eWg != null) {
            this.eWf = new float[this.eWg.length];
            for (int i = 0; i < this.eWg.length; i++) {
                this.eWf[i] = this.eWg[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.eWj = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.eWj[i] = fArr[i];
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
                if (this.eWf != null && this.eWf.length > 0) {
                    size = (int) (size + (this.eWd * this.eWf.length) + ((this.eWf.length - 1) * this.eWk));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.eWf != null) {
                i3 = 0;
                while (i4 < this.eWf.length) {
                    if (this.eWf[i4] > i3) {
                        i3 = (int) this.eWf[i4];
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
        if (this.eWf != null) {
            this.dBh = false;
            this.eWi = getDifValueArray();
            this.eWh = new float[this.eWf.length];
            for (int i = 0; i < this.eWf.length; i++) {
                this.eWh[i] = this.eWf[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.dBh) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.eWf.length; i2++) {
                            AlaChallengeWaveView.this.eWf[i2] = AlaChallengeWaveView.this.eWh[i2] + (AlaChallengeWaveView.this.eWi[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.dBh) {
                        if (AlaChallengeWaveView.this.eWj == null) {
                            if (AlaChallengeWaveView.this.eWf != null && AlaChallengeWaveView.this.eWg != null && AlaChallengeWaveView.this.eWf.length == AlaChallengeWaveView.this.eWg.length) {
                                while (i2 < AlaChallengeWaveView.this.eWg.length) {
                                    AlaChallengeWaveView.this.eWf[i2] = AlaChallengeWaveView.this.eWg[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.eWf = new float[AlaChallengeWaveView.this.eWj.length];
                            while (i2 < AlaChallengeWaveView.this.eWj.length) {
                                AlaChallengeWaveView.this.eWf[i2] = AlaChallengeWaveView.this.eWj[i2];
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
        this.dBh = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.eWf == null) {
            return null;
        }
        float[] fArr = new float[this.eWf.length];
        if (this.eWc.length <= 1) {
            for (int i = 0; i < this.eWf.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.eWf.length];
        for (int i2 = 0; i2 < this.eWf.length; i2++) {
            for (int i3 = 0; i3 < this.eWc.length; i3++) {
                if (this.eWf[i2] == this.eWc[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.eWc.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.eWc.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.eWc[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.eWf.length; i4++) {
            fArr[i4] = fArr2[i4] - this.eWf[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.eWf != null) {
            for (int i = 0; i < this.eWf.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.eWd) + (this.eWk * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.eWf[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.eWd + f, this.eWf[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
