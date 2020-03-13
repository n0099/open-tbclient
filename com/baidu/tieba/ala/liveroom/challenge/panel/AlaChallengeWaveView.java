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
    public static final float eWm = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float eWn = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float eWo = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean dBu;
    private float[] eWp;
    private float eWq;
    private int eWr;
    private float[] eWs;
    private float[] eWt;
    private float[] eWu;
    private float[] eWv;
    private float[] eWw;
    private int eWx;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.eWp = new float[]{eWm, eWn, eWo};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWp = new float[]{eWm, eWn, eWo};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWp = new float[]{eWm, eWn, eWo};
        init();
    }

    private void init() {
        this.eWx = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.eWq = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.eWr = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.eWr);
        this.mPaint.setStrokeWidth(this.eWq);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.eWt = fArr;
        if (this.eWt != null) {
            this.eWs = new float[this.eWt.length];
            for (int i = 0; i < this.eWt.length; i++) {
                this.eWs[i] = this.eWt[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.eWw = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.eWw[i] = fArr[i];
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
                if (this.eWs != null && this.eWs.length > 0) {
                    size = (int) (size + (this.eWq * this.eWs.length) + ((this.eWs.length - 1) * this.eWx));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.eWs != null) {
                i3 = 0;
                while (i4 < this.eWs.length) {
                    if (this.eWs[i4] > i3) {
                        i3 = (int) this.eWs[i4];
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
        if (this.eWs != null) {
            this.dBu = false;
            this.eWv = getDifValueArray();
            this.eWu = new float[this.eWs.length];
            for (int i = 0; i < this.eWs.length; i++) {
                this.eWu[i] = this.eWs[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.dBu) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.eWs.length; i2++) {
                            AlaChallengeWaveView.this.eWs[i2] = AlaChallengeWaveView.this.eWu[i2] + (AlaChallengeWaveView.this.eWv[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.dBu) {
                        if (AlaChallengeWaveView.this.eWw == null) {
                            if (AlaChallengeWaveView.this.eWs != null && AlaChallengeWaveView.this.eWt != null && AlaChallengeWaveView.this.eWs.length == AlaChallengeWaveView.this.eWt.length) {
                                while (i2 < AlaChallengeWaveView.this.eWt.length) {
                                    AlaChallengeWaveView.this.eWs[i2] = AlaChallengeWaveView.this.eWt[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.eWs = new float[AlaChallengeWaveView.this.eWw.length];
                            while (i2 < AlaChallengeWaveView.this.eWw.length) {
                                AlaChallengeWaveView.this.eWs[i2] = AlaChallengeWaveView.this.eWw[i2];
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
        this.dBu = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.eWs == null) {
            return null;
        }
        float[] fArr = new float[this.eWs.length];
        if (this.eWp.length <= 1) {
            for (int i = 0; i < this.eWs.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.eWs.length];
        for (int i2 = 0; i2 < this.eWs.length; i2++) {
            for (int i3 = 0; i3 < this.eWp.length; i3++) {
                if (this.eWs[i2] == this.eWp[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.eWp.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.eWp.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.eWp[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.eWs.length; i4++) {
            fArr[i4] = fArr2[i4] - this.eWs[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.eWs != null) {
            for (int i = 0; i < this.eWs.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.eWq) + (this.eWx * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.eWs[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.eWq + f, this.eWs[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
