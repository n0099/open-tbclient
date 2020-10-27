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
    public static final float gWm = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float gWn = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float gWo = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean fmU;
    private float[] gWp;
    private float gWq;
    private int gWr;
    private float[] gWs;
    private float[] gWt;
    private float[] gWu;
    private float[] gWv;
    private float[] gWw;
    private int gWx;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.gWp = new float[]{gWm, gWn, gWo};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gWp = new float[]{gWm, gWn, gWo};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gWp = new float[]{gWm, gWn, gWo};
        init();
    }

    private void init() {
        this.gWx = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.gWq = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gWr = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.gWr);
        this.mPaint.setStrokeWidth(this.gWq);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.gWt = fArr;
        if (this.gWt != null) {
            this.gWs = new float[this.gWt.length];
            for (int i = 0; i < this.gWt.length; i++) {
                this.gWs[i] = this.gWt[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.gWw = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.gWw[i] = fArr[i];
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
                if (this.gWs != null && this.gWs.length > 0) {
                    size = (int) (size + (this.gWq * this.gWs.length) + ((this.gWs.length - 1) * this.gWx));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.gWs != null) {
                i3 = 0;
                while (i4 < this.gWs.length) {
                    if (this.gWs[i4] > i3) {
                        i3 = (int) this.gWs[i4];
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
        if (this.gWs != null) {
            this.fmU = false;
            this.gWv = getDifValueArray();
            this.gWu = new float[this.gWs.length];
            for (int i = 0; i < this.gWs.length; i++) {
                this.gWu[i] = this.gWs[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.fmU) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.gWs.length; i2++) {
                            AlaChallengeWaveView.this.gWs[i2] = AlaChallengeWaveView.this.gWu[i2] + (AlaChallengeWaveView.this.gWv[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.fmU) {
                        if (AlaChallengeWaveView.this.gWw == null) {
                            if (AlaChallengeWaveView.this.gWs != null && AlaChallengeWaveView.this.gWt != null && AlaChallengeWaveView.this.gWs.length == AlaChallengeWaveView.this.gWt.length) {
                                while (i2 < AlaChallengeWaveView.this.gWt.length) {
                                    AlaChallengeWaveView.this.gWs[i2] = AlaChallengeWaveView.this.gWt[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.gWs = new float[AlaChallengeWaveView.this.gWw.length];
                            while (i2 < AlaChallengeWaveView.this.gWw.length) {
                                AlaChallengeWaveView.this.gWs[i2] = AlaChallengeWaveView.this.gWw[i2];
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
        this.fmU = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.gWs == null) {
            return null;
        }
        float[] fArr = new float[this.gWs.length];
        if (this.gWp.length <= 1) {
            for (int i = 0; i < this.gWs.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.gWs.length];
        for (int i2 = 0; i2 < this.gWs.length; i2++) {
            for (int i3 = 0; i3 < this.gWp.length; i3++) {
                if (this.gWs[i2] == this.gWp[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.gWp.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.gWp.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.gWp[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.gWs.length; i4++) {
            fArr[i4] = fArr2[i4] - this.gWs[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.gWs != null) {
            for (int i = 0; i < this.gWs.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.gWq) + (this.gWx * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.gWs[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.gWq + f, this.gWs[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
