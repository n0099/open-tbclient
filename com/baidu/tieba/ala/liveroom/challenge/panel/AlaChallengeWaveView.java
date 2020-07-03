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
/* loaded from: classes3.dex */
public class AlaChallengeWaveView extends View {
    public static final float gbn = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float gbo = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float gbp = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean eyB;
    private float[] gbq;
    private float gbr;
    private int gbs;
    private float[] gbt;
    private float[] gbu;
    private float[] gbv;
    private float[] gbw;
    private float[] gbx;
    private int gby;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.gbq = new float[]{gbn, gbo, gbp};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbq = new float[]{gbn, gbo, gbp};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbq = new float[]{gbn, gbo, gbp};
        init();
    }

    private void init() {
        this.gby = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.gbr = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gbs = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.gbs);
        this.mPaint.setStrokeWidth(this.gbr);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.gbu = fArr;
        if (this.gbu != null) {
            this.gbt = new float[this.gbu.length];
            for (int i = 0; i < this.gbu.length; i++) {
                this.gbt[i] = this.gbu[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.gbx = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.gbx[i] = fArr[i];
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
                if (this.gbt != null && this.gbt.length > 0) {
                    size = (int) (size + (this.gbr * this.gbt.length) + ((this.gbt.length - 1) * this.gby));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.gbt != null) {
                i3 = 0;
                while (i4 < this.gbt.length) {
                    if (this.gbt[i4] > i3) {
                        i3 = (int) this.gbt[i4];
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
        if (this.gbt != null) {
            this.eyB = false;
            this.gbw = getDifValueArray();
            this.gbv = new float[this.gbt.length];
            for (int i = 0; i < this.gbt.length; i++) {
                this.gbv[i] = this.gbt[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.eyB) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.gbt.length; i2++) {
                            AlaChallengeWaveView.this.gbt[i2] = AlaChallengeWaveView.this.gbv[i2] + (AlaChallengeWaveView.this.gbw[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.eyB) {
                        if (AlaChallengeWaveView.this.gbx == null) {
                            if (AlaChallengeWaveView.this.gbt != null && AlaChallengeWaveView.this.gbu != null && AlaChallengeWaveView.this.gbt.length == AlaChallengeWaveView.this.gbu.length) {
                                while (i2 < AlaChallengeWaveView.this.gbu.length) {
                                    AlaChallengeWaveView.this.gbt[i2] = AlaChallengeWaveView.this.gbu[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.gbt = new float[AlaChallengeWaveView.this.gbx.length];
                            while (i2 < AlaChallengeWaveView.this.gbx.length) {
                                AlaChallengeWaveView.this.gbt[i2] = AlaChallengeWaveView.this.gbx[i2];
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
        this.eyB = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.gbt == null) {
            return null;
        }
        float[] fArr = new float[this.gbt.length];
        if (this.gbq.length <= 1) {
            for (int i = 0; i < this.gbt.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.gbt.length];
        for (int i2 = 0; i2 < this.gbt.length; i2++) {
            for (int i3 = 0; i3 < this.gbq.length; i3++) {
                if (this.gbt[i2] == this.gbq[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.gbq.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.gbq.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.gbq[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.gbt.length; i4++) {
            fArr[i4] = fArr2[i4] - this.gbt[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.gbt != null) {
            for (int i = 0; i < this.gbt.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.gbr) + (this.gby * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.gbt[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.gbr + f, this.gbt[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
