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
    public static final float fAY = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float fAZ = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float fBa = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean ebs;
    private float[] fBb;
    private float fBc;
    private int fBd;
    private float[] fBe;
    private float[] fBf;
    private float[] fBg;
    private float[] fBh;
    private float[] fBi;
    private int fBj;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.fBb = new float[]{fAY, fAZ, fBa};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBb = new float[]{fAY, fAZ, fBa};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBb = new float[]{fAY, fAZ, fBa};
        init();
    }

    private void init() {
        this.fBj = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.fBc = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fBd = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.fBd);
        this.mPaint.setStrokeWidth(this.fBc);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.fBf = fArr;
        if (this.fBf != null) {
            this.fBe = new float[this.fBf.length];
            for (int i = 0; i < this.fBf.length; i++) {
                this.fBe[i] = this.fBf[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.fBi = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.fBi[i] = fArr[i];
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
                if (this.fBe != null && this.fBe.length > 0) {
                    size = (int) (size + (this.fBc * this.fBe.length) + ((this.fBe.length - 1) * this.fBj));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.fBe != null) {
                i3 = 0;
                while (i4 < this.fBe.length) {
                    if (this.fBe[i4] > i3) {
                        i3 = (int) this.fBe[i4];
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
        if (this.fBe != null) {
            this.ebs = false;
            this.fBh = getDifValueArray();
            this.fBg = new float[this.fBe.length];
            for (int i = 0; i < this.fBe.length; i++) {
                this.fBg[i] = this.fBe[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.ebs) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.fBe.length; i2++) {
                            AlaChallengeWaveView.this.fBe[i2] = AlaChallengeWaveView.this.fBg[i2] + (AlaChallengeWaveView.this.fBh[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.ebs) {
                        if (AlaChallengeWaveView.this.fBi == null) {
                            if (AlaChallengeWaveView.this.fBe != null && AlaChallengeWaveView.this.fBf != null && AlaChallengeWaveView.this.fBe.length == AlaChallengeWaveView.this.fBf.length) {
                                while (i2 < AlaChallengeWaveView.this.fBf.length) {
                                    AlaChallengeWaveView.this.fBe[i2] = AlaChallengeWaveView.this.fBf[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.fBe = new float[AlaChallengeWaveView.this.fBi.length];
                            while (i2 < AlaChallengeWaveView.this.fBi.length) {
                                AlaChallengeWaveView.this.fBe[i2] = AlaChallengeWaveView.this.fBi[i2];
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
        this.ebs = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.fBe == null) {
            return null;
        }
        float[] fArr = new float[this.fBe.length];
        if (this.fBb.length <= 1) {
            for (int i = 0; i < this.fBe.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.fBe.length];
        for (int i2 = 0; i2 < this.fBe.length; i2++) {
            for (int i3 = 0; i3 < this.fBb.length; i3++) {
                if (this.fBe[i2] == this.fBb[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.fBb.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.fBb.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.fBb[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.fBe.length; i4++) {
            fArr[i4] = fArr2[i4] - this.fBe[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.fBe != null) {
            for (int i = 0; i < this.fBe.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.fBc) + (this.fBj * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.fBe[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.fBc + f, this.fBe[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
