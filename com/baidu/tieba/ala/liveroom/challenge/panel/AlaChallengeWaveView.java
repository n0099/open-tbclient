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
    public static final float ggv = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float ggw = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float ggx = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean eER;
    private int ggA;
    private float[] ggB;
    private float[] ggC;
    private float[] ggD;
    private float[] ggE;
    private float[] ggF;
    private int ggG;
    private float[] ggy;
    private float ggz;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.ggy = new float[]{ggv, ggw, ggx};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggy = new float[]{ggv, ggw, ggx};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggy = new float[]{ggv, ggw, ggx};
        init();
    }

    private void init() {
        this.ggG = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.ggz = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.ggA = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.ggA);
        this.mPaint.setStrokeWidth(this.ggz);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.ggC = fArr;
        if (this.ggC != null) {
            this.ggB = new float[this.ggC.length];
            for (int i = 0; i < this.ggC.length; i++) {
                this.ggB[i] = this.ggC[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.ggF = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.ggF[i] = fArr[i];
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
                if (this.ggB != null && this.ggB.length > 0) {
                    size = (int) (size + (this.ggz * this.ggB.length) + ((this.ggB.length - 1) * this.ggG));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.ggB != null) {
                i3 = 0;
                while (i4 < this.ggB.length) {
                    if (this.ggB[i4] > i3) {
                        i3 = (int) this.ggB[i4];
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
        if (this.ggB != null) {
            this.eER = false;
            this.ggE = getDifValueArray();
            this.ggD = new float[this.ggB.length];
            for (int i = 0; i < this.ggB.length; i++) {
                this.ggD[i] = this.ggB[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.eER) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.ggB.length; i2++) {
                            AlaChallengeWaveView.this.ggB[i2] = AlaChallengeWaveView.this.ggD[i2] + (AlaChallengeWaveView.this.ggE[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.eER) {
                        if (AlaChallengeWaveView.this.ggF == null) {
                            if (AlaChallengeWaveView.this.ggB != null && AlaChallengeWaveView.this.ggC != null && AlaChallengeWaveView.this.ggB.length == AlaChallengeWaveView.this.ggC.length) {
                                while (i2 < AlaChallengeWaveView.this.ggC.length) {
                                    AlaChallengeWaveView.this.ggB[i2] = AlaChallengeWaveView.this.ggC[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.ggB = new float[AlaChallengeWaveView.this.ggF.length];
                            while (i2 < AlaChallengeWaveView.this.ggF.length) {
                                AlaChallengeWaveView.this.ggB[i2] = AlaChallengeWaveView.this.ggF[i2];
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
        this.eER = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.ggB == null) {
            return null;
        }
        float[] fArr = new float[this.ggB.length];
        if (this.ggy.length <= 1) {
            for (int i = 0; i < this.ggB.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.ggB.length];
        for (int i2 = 0; i2 < this.ggB.length; i2++) {
            for (int i3 = 0; i3 < this.ggy.length; i3++) {
                if (this.ggB[i2] == this.ggy[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.ggy.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.ggy.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.ggy[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.ggB.length; i4++) {
            fArr[i4] = fArr2[i4] - this.ggB[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.ggB != null) {
            for (int i = 0; i < this.ggB.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.ggz) + (this.ggG * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.ggB[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.ggz + f, this.ggB[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
