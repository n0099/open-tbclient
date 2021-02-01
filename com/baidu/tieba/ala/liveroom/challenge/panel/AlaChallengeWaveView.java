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
/* loaded from: classes11.dex */
public class AlaChallengeWaveView extends View {
    public static final float hxh = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds16);
    public static final float hxi = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds24);
    public static final float hxj = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds32);
    private boolean fGW;
    private float[] hxk;
    private float hxl;
    private int hxm;
    private float[] hxn;
    private float[] hxo;
    private float[] hxp;
    private float[] hxq;
    private float[] hxr;
    private int hxs;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.hxk = new float[]{hxh, hxi, hxj};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hxk = new float[]{hxh, hxi, hxj};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hxk = new float[]{hxh, hxi, hxj};
        init();
    }

    private void init() {
        this.hxs = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.hxl = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hxm = getContext().getResources().getColor(a.c.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.hxm);
        this.mPaint.setStrokeWidth(this.hxl);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.hxo = fArr;
        if (this.hxo != null) {
            this.hxn = new float[this.hxo.length];
            for (int i = 0; i < this.hxo.length; i++) {
                this.hxn[i] = this.hxo[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.hxr = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.hxr[i] = fArr[i];
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
            i3 = (this.hxn == null || this.hxn.length <= 0) ? paddingLeft : (int) (paddingLeft + (this.hxl * this.hxn.length) + ((this.hxn.length - 1) * this.hxs));
        } else {
            i3 = 0;
        }
        if (mode2 == 1073741824) {
            i5 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            if (this.hxn != null) {
                int i6 = 0;
                while (true) {
                    i4 = i5;
                    if (i6 >= this.hxn.length) {
                        break;
                    }
                    i5 = this.hxn[i6] > ((float) i4) ? (int) this.hxn[i6] : i4;
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
        if (this.hxn != null) {
            this.fGW = false;
            this.hxq = getDifValueArray();
            this.hxp = new float[this.hxn.length];
            for (int i = 0; i < this.hxn.length; i++) {
                this.hxp[i] = this.hxn[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.fGW) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.hxn.length; i2++) {
                            AlaChallengeWaveView.this.hxn[i2] = AlaChallengeWaveView.this.hxp[i2] + (AlaChallengeWaveView.this.hxq[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.fGW) {
                        if (AlaChallengeWaveView.this.hxr == null) {
                            if (AlaChallengeWaveView.this.hxn != null && AlaChallengeWaveView.this.hxo != null && AlaChallengeWaveView.this.hxn.length == AlaChallengeWaveView.this.hxo.length) {
                                while (i2 < AlaChallengeWaveView.this.hxo.length) {
                                    AlaChallengeWaveView.this.hxn[i2] = AlaChallengeWaveView.this.hxo[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.hxn = new float[AlaChallengeWaveView.this.hxr.length];
                            while (i2 < AlaChallengeWaveView.this.hxr.length) {
                                AlaChallengeWaveView.this.hxn[i2] = AlaChallengeWaveView.this.hxr[i2];
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
        this.fGW = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.hxn == null) {
            return null;
        }
        float[] fArr = new float[this.hxn.length];
        if (this.hxk.length <= 1) {
            for (int i = 0; i < this.hxn.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.hxn.length];
        for (int i2 = 0; i2 < this.hxn.length; i2++) {
            for (int i3 = 0; i3 < this.hxk.length; i3++) {
                if (this.hxn[i2] == this.hxk[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.hxk.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.hxk.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.hxk[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.hxn.length; i4++) {
            fArr[i4] = fArr2[i4] - this.hxn[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.hxn != null) {
            for (int i = 0; i < this.hxn.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.hxl) + (this.hxs * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.hxn[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.hxl + f, this.hxn[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
