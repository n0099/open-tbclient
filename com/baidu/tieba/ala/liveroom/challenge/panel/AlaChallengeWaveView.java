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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class AlaChallengeWaveView extends View {
    public static final float eSh = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float eSi = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float eSj = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean dxd;
    private float[] eSk;
    private float eSl;
    private int eSm;
    private float[] eSn;
    private float[] eSo;
    private float[] eSp;
    private float[] eSq;
    private float[] eSr;
    private int eSs;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.eSk = new float[]{eSh, eSi, eSj};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eSk = new float[]{eSh, eSi, eSj};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eSk = new float[]{eSh, eSi, eSj};
        init();
    }

    private void init() {
        this.eSs = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.eSl = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.eSm = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.eSm);
        this.mPaint.setStrokeWidth(this.eSl);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.eSo = fArr;
        if (this.eSo != null) {
            this.eSn = new float[this.eSo.length];
            for (int i = 0; i < this.eSo.length; i++) {
                this.eSn[i] = this.eSo[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.eSr = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.eSr[i] = fArr[i];
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
                if (this.eSn != null && this.eSn.length > 0) {
                    size = (int) (size + (this.eSl * this.eSn.length) + ((this.eSn.length - 1) * this.eSs));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.eSn != null) {
                i3 = 0;
                while (i4 < this.eSn.length) {
                    if (this.eSn[i4] > i3) {
                        i3 = (int) this.eSn[i4];
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
        if (this.eSn != null) {
            this.dxd = false;
            this.eSq = getDifValueArray();
            this.eSp = new float[this.eSn.length];
            for (int i = 0; i < this.eSn.length; i++) {
                this.eSp[i] = this.eSn[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.dxd) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.eSn.length; i2++) {
                            AlaChallengeWaveView.this.eSn[i2] = AlaChallengeWaveView.this.eSp[i2] + (AlaChallengeWaveView.this.eSq[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.dxd) {
                        if (AlaChallengeWaveView.this.eSr == null) {
                            if (AlaChallengeWaveView.this.eSn != null && AlaChallengeWaveView.this.eSo != null && AlaChallengeWaveView.this.eSn.length == AlaChallengeWaveView.this.eSo.length) {
                                while (i2 < AlaChallengeWaveView.this.eSo.length) {
                                    AlaChallengeWaveView.this.eSn[i2] = AlaChallengeWaveView.this.eSo[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.eSn = new float[AlaChallengeWaveView.this.eSr.length];
                            while (i2 < AlaChallengeWaveView.this.eSr.length) {
                                AlaChallengeWaveView.this.eSn[i2] = AlaChallengeWaveView.this.eSr[i2];
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
        this.dxd = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.eSn == null) {
            return null;
        }
        float[] fArr = new float[this.eSn.length];
        if (this.eSk.length <= 1) {
            for (int i = 0; i < this.eSn.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.eSn.length];
        for (int i2 = 0; i2 < this.eSn.length; i2++) {
            for (int i3 = 0; i3 < this.eSk.length; i3++) {
                if (this.eSn[i2] == this.eSk[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.eSk.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.eSk.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.eSk[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.eSn.length; i4++) {
            fArr[i4] = fArr2[i4] - this.eSn[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.eSn != null) {
            for (int i = 0; i < this.eSn.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.eSl) + (this.eSs * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.eSn[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.eSl + f, this.eSn[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
