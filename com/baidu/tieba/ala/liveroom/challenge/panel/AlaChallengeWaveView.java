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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class AlaChallengeWaveView extends View {
    public static final float eQE = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float eQF = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float eQG = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean dwV;
    private float[] eQH;
    private float eQI;
    private int eQJ;
    private float[] eQK;
    private float[] eQL;
    private float[] eQM;
    private float[] eQN;
    private float[] eQO;
    private int eQP;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.eQH = new float[]{eQE, eQF, eQG};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eQH = new float[]{eQE, eQF, eQG};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eQH = new float[]{eQE, eQF, eQG};
        init();
    }

    private void init() {
        this.eQP = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.eQI = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.eQJ = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.eQJ);
        this.mPaint.setStrokeWidth(this.eQI);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.eQL = fArr;
        if (this.eQL != null) {
            this.eQK = new float[this.eQL.length];
            for (int i = 0; i < this.eQL.length; i++) {
                this.eQK[i] = this.eQL[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.eQO = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.eQO[i] = fArr[i];
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
                if (this.eQK != null && this.eQK.length > 0) {
                    size = (int) (size + (this.eQI * this.eQK.length) + ((this.eQK.length - 1) * this.eQP));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.eQK != null) {
                i3 = 0;
                while (i4 < this.eQK.length) {
                    if (this.eQK[i4] > i3) {
                        i3 = (int) this.eQK[i4];
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
        if (this.eQK != null) {
            this.dwV = false;
            this.eQN = getDifValueArray();
            this.eQM = new float[this.eQK.length];
            for (int i = 0; i < this.eQK.length; i++) {
                this.eQM[i] = this.eQK[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.dwV) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.eQK.length; i2++) {
                            AlaChallengeWaveView.this.eQK[i2] = AlaChallengeWaveView.this.eQM[i2] + (AlaChallengeWaveView.this.eQN[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.dwV) {
                        if (AlaChallengeWaveView.this.eQO == null) {
                            if (AlaChallengeWaveView.this.eQK != null && AlaChallengeWaveView.this.eQL != null && AlaChallengeWaveView.this.eQK.length == AlaChallengeWaveView.this.eQL.length) {
                                while (i2 < AlaChallengeWaveView.this.eQL.length) {
                                    AlaChallengeWaveView.this.eQK[i2] = AlaChallengeWaveView.this.eQL[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.eQK = new float[AlaChallengeWaveView.this.eQO.length];
                            while (i2 < AlaChallengeWaveView.this.eQO.length) {
                                AlaChallengeWaveView.this.eQK[i2] = AlaChallengeWaveView.this.eQO[i2];
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
        this.dwV = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.eQK == null) {
            return null;
        }
        float[] fArr = new float[this.eQK.length];
        if (this.eQH.length <= 1) {
            for (int i = 0; i < this.eQK.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.eQK.length];
        for (int i2 = 0; i2 < this.eQK.length; i2++) {
            for (int i3 = 0; i3 < this.eQH.length; i3++) {
                if (this.eQK[i2] == this.eQH[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.eQH.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.eQH.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.eQH[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.eQK.length; i4++) {
            fArr[i4] = fArr2[i4] - this.eQK[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.eQK != null) {
            for (int i = 0; i < this.eQK.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.eQI) + (this.eQP * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.eQK[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.eQI + f, this.eQK[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
