package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes10.dex */
public class AlaChallengeWaveView extends View {
    public static final float hsX = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds16);
    public static final float hsY = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds24);
    public static final float hsZ = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds32);
    private boolean fEK;
    private float[] hta;
    private float htb;
    private int htc;
    private float[] htd;
    private float[] hte;
    private float[] htf;
    private float[] htg;
    private float[] hth;
    private int hti;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.hta = new float[]{hsX, hsY, hsZ};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hta = new float[]{hsX, hsY, hsZ};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hta = new float[]{hsX, hsY, hsZ};
        init();
    }

    private void init() {
        this.hti = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.htb = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.htc = getContext().getResources().getColor(a.c.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.htc);
        this.mPaint.setStrokeWidth(this.htb);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.hte = fArr;
        if (this.hte != null) {
            this.htd = new float[this.hte.length];
            for (int i = 0; i < this.hte.length; i++) {
                this.htd[i] = this.hte[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.hth = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.hth[i] = fArr[i];
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            i3 = size;
        } else if (mode == Integer.MIN_VALUE) {
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            i3 = (this.htd == null || this.htd.length <= 0) ? paddingLeft : (int) (paddingLeft + (this.htb * this.htd.length) + ((this.htd.length - 1) * this.hti));
        } else {
            i3 = 0;
        }
        if (mode2 == 1073741824) {
            i5 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            if (this.htd != null) {
                int i6 = 0;
                while (true) {
                    i4 = i5;
                    if (i6 >= this.htd.length) {
                        break;
                    }
                    i5 = this.htd[i6] > ((float) i4) ? (int) this.htd[i6] : i4;
                    i6++;
                }
            } else {
                i4 = 0;
            }
            i5 = paddingBottom + i4;
        }
        setMeasuredDimension(i3, i5);
    }

    public void startAnimation() {
        if (this.htd != null) {
            this.fEK = false;
            this.htg = getDifValueArray();
            this.htf = new float[this.htd.length];
            for (int i = 0; i < this.htd.length; i++) {
                this.htf[i] = this.htd[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.fEK) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.htd.length; i2++) {
                            AlaChallengeWaveView.this.htd[i2] = AlaChallengeWaveView.this.htf[i2] + (AlaChallengeWaveView.this.htg[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.fEK) {
                        if (AlaChallengeWaveView.this.hth == null) {
                            if (AlaChallengeWaveView.this.htd != null && AlaChallengeWaveView.this.hte != null && AlaChallengeWaveView.this.htd.length == AlaChallengeWaveView.this.hte.length) {
                                while (i2 < AlaChallengeWaveView.this.hte.length) {
                                    AlaChallengeWaveView.this.htd[i2] = AlaChallengeWaveView.this.hte[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.htd = new float[AlaChallengeWaveView.this.hth.length];
                            while (i2 < AlaChallengeWaveView.this.hth.length) {
                                AlaChallengeWaveView.this.htd[i2] = AlaChallengeWaveView.this.hth[i2];
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
        this.fEK = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.htd == null) {
            return null;
        }
        float[] fArr = new float[this.htd.length];
        if (this.hta.length <= 1) {
            for (int i = 0; i < this.htd.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.htd.length];
        for (int i2 = 0; i2 < this.htd.length; i2++) {
            for (int i3 = 0; i3 < this.hta.length; i3++) {
                if (this.htd[i2] == this.hta[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.hta.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.hta.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.hta[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.htd.length; i4++) {
            fArr[i4] = fArr2[i4] - this.htd[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.htd != null) {
            for (int i = 0; i < this.htd.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.htb) + (this.hti * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.htd[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.htb + f, this.htd[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
