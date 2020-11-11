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
    public static final float hcq = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds16);
    public static final float hcr = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds24);
    public static final float hcs = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds32);
    private boolean fsN;
    private float[] hcA;
    private int hcB;
    private float[] hct;
    private float hcu;
    private int hcv;
    private float[] hcw;
    private float[] hcx;
    private float[] hcy;
    private float[] hcz;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.hct = new float[]{hcq, hcr, hcs};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hct = new float[]{hcq, hcr, hcs};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hct = new float[]{hcq, hcr, hcs};
        init();
    }

    private void init() {
        this.hcB = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.hcu = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hcv = getContext().getResources().getColor(a.c.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.hcv);
        this.mPaint.setStrokeWidth(this.hcu);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.hcx = fArr;
        if (this.hcx != null) {
            this.hcw = new float[this.hcx.length];
            for (int i = 0; i < this.hcx.length; i++) {
                this.hcw[i] = this.hcx[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.hcA = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.hcA[i] = fArr[i];
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
                if (this.hcw != null && this.hcw.length > 0) {
                    size = (int) (size + (this.hcu * this.hcw.length) + ((this.hcw.length - 1) * this.hcB));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.hcw != null) {
                i3 = 0;
                while (i4 < this.hcw.length) {
                    if (this.hcw[i4] > i3) {
                        i3 = (int) this.hcw[i4];
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
        if (this.hcw != null) {
            this.fsN = false;
            this.hcz = getDifValueArray();
            this.hcy = new float[this.hcw.length];
            for (int i = 0; i < this.hcw.length; i++) {
                this.hcy[i] = this.hcw[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.fsN) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.hcw.length; i2++) {
                            AlaChallengeWaveView.this.hcw[i2] = AlaChallengeWaveView.this.hcy[i2] + (AlaChallengeWaveView.this.hcz[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.fsN) {
                        if (AlaChallengeWaveView.this.hcA == null) {
                            if (AlaChallengeWaveView.this.hcw != null && AlaChallengeWaveView.this.hcx != null && AlaChallengeWaveView.this.hcw.length == AlaChallengeWaveView.this.hcx.length) {
                                while (i2 < AlaChallengeWaveView.this.hcx.length) {
                                    AlaChallengeWaveView.this.hcw[i2] = AlaChallengeWaveView.this.hcx[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.hcw = new float[AlaChallengeWaveView.this.hcA.length];
                            while (i2 < AlaChallengeWaveView.this.hcA.length) {
                                AlaChallengeWaveView.this.hcw[i2] = AlaChallengeWaveView.this.hcA[i2];
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
        this.fsN = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.hcw == null) {
            return null;
        }
        float[] fArr = new float[this.hcw.length];
        if (this.hct.length <= 1) {
            for (int i = 0; i < this.hcw.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.hcw.length];
        for (int i2 = 0; i2 < this.hcw.length; i2++) {
            for (int i3 = 0; i3 < this.hct.length; i3++) {
                if (this.hcw[i2] == this.hct[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.hct.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.hct.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.hct[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.hcw.length; i4++) {
            fArr[i4] = fArr2[i4] - this.hcw[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.hcw != null) {
            for (int i = 0; i < this.hcw.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.hcu) + (this.hcB * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.hcw[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.hcu + f, this.hcw[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
