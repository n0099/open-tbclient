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
    public static final float fPg = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float fPh = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float fPi = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean epJ;
    private float[] fPj;
    private float fPk;
    private int fPl;
    private float[] fPm;
    private float[] fPn;
    private float[] fPo;
    private float[] fPp;
    private float[] fPq;
    private int fPr;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.fPj = new float[]{fPg, fPh, fPi};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fPj = new float[]{fPg, fPh, fPi};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fPj = new float[]{fPg, fPh, fPi};
        init();
    }

    private void init() {
        this.fPr = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.fPk = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fPl = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.fPl);
        this.mPaint.setStrokeWidth(this.fPk);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.fPn = fArr;
        if (this.fPn != null) {
            this.fPm = new float[this.fPn.length];
            for (int i = 0; i < this.fPn.length; i++) {
                this.fPm[i] = this.fPn[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.fPq = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.fPq[i] = fArr[i];
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
                if (this.fPm != null && this.fPm.length > 0) {
                    size = (int) (size + (this.fPk * this.fPm.length) + ((this.fPm.length - 1) * this.fPr));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.fPm != null) {
                i3 = 0;
                while (i4 < this.fPm.length) {
                    if (this.fPm[i4] > i3) {
                        i3 = (int) this.fPm[i4];
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
        if (this.fPm != null) {
            this.epJ = false;
            this.fPp = getDifValueArray();
            this.fPo = new float[this.fPm.length];
            for (int i = 0; i < this.fPm.length; i++) {
                this.fPo[i] = this.fPm[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.epJ) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.fPm.length; i2++) {
                            AlaChallengeWaveView.this.fPm[i2] = AlaChallengeWaveView.this.fPo[i2] + (AlaChallengeWaveView.this.fPp[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.epJ) {
                        if (AlaChallengeWaveView.this.fPq == null) {
                            if (AlaChallengeWaveView.this.fPm != null && AlaChallengeWaveView.this.fPn != null && AlaChallengeWaveView.this.fPm.length == AlaChallengeWaveView.this.fPn.length) {
                                while (i2 < AlaChallengeWaveView.this.fPn.length) {
                                    AlaChallengeWaveView.this.fPm[i2] = AlaChallengeWaveView.this.fPn[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.fPm = new float[AlaChallengeWaveView.this.fPq.length];
                            while (i2 < AlaChallengeWaveView.this.fPq.length) {
                                AlaChallengeWaveView.this.fPm[i2] = AlaChallengeWaveView.this.fPq[i2];
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
        this.epJ = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.fPm == null) {
            return null;
        }
        float[] fArr = new float[this.fPm.length];
        if (this.fPj.length <= 1) {
            for (int i = 0; i < this.fPm.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.fPm.length];
        for (int i2 = 0; i2 < this.fPm.length; i2++) {
            for (int i3 = 0; i3 < this.fPj.length; i3++) {
                if (this.fPm[i2] == this.fPj[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.fPj.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.fPj.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.fPj[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.fPm.length; i4++) {
            fArr[i4] = fArr2[i4] - this.fPm[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.fPm != null) {
            for (int i = 0; i < this.fPm.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.fPk) + (this.fPr * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.fPm[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.fPk + f, this.fPm[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
