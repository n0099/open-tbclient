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
    public static final float gwe = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float gwf = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float gwg = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean eSn;
    private float[] gwh;
    private float gwi;
    private int gwj;
    private float[] gwk;
    private float[] gwl;
    private float[] gwm;
    private float[] gwn;
    private float[] gwo;
    private int gwp;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.gwh = new float[]{gwe, gwf, gwg};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gwh = new float[]{gwe, gwf, gwg};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwh = new float[]{gwe, gwf, gwg};
        init();
    }

    private void init() {
        this.gwp = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.gwi = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gwj = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.gwj);
        this.mPaint.setStrokeWidth(this.gwi);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.gwl = fArr;
        if (this.gwl != null) {
            this.gwk = new float[this.gwl.length];
            for (int i = 0; i < this.gwl.length; i++) {
                this.gwk[i] = this.gwl[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.gwo = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.gwo[i] = fArr[i];
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
                if (this.gwk != null && this.gwk.length > 0) {
                    size = (int) (size + (this.gwi * this.gwk.length) + ((this.gwk.length - 1) * this.gwp));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.gwk != null) {
                i3 = 0;
                while (i4 < this.gwk.length) {
                    if (this.gwk[i4] > i3) {
                        i3 = (int) this.gwk[i4];
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
        if (this.gwk != null) {
            this.eSn = false;
            this.gwn = getDifValueArray();
            this.gwm = new float[this.gwk.length];
            for (int i = 0; i < this.gwk.length; i++) {
                this.gwm[i] = this.gwk[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.eSn) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.gwk.length; i2++) {
                            AlaChallengeWaveView.this.gwk[i2] = AlaChallengeWaveView.this.gwm[i2] + (AlaChallengeWaveView.this.gwn[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.eSn) {
                        if (AlaChallengeWaveView.this.gwo == null) {
                            if (AlaChallengeWaveView.this.gwk != null && AlaChallengeWaveView.this.gwl != null && AlaChallengeWaveView.this.gwk.length == AlaChallengeWaveView.this.gwl.length) {
                                while (i2 < AlaChallengeWaveView.this.gwl.length) {
                                    AlaChallengeWaveView.this.gwk[i2] = AlaChallengeWaveView.this.gwl[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.gwk = new float[AlaChallengeWaveView.this.gwo.length];
                            while (i2 < AlaChallengeWaveView.this.gwo.length) {
                                AlaChallengeWaveView.this.gwk[i2] = AlaChallengeWaveView.this.gwo[i2];
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
        this.eSn = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.gwk == null) {
            return null;
        }
        float[] fArr = new float[this.gwk.length];
        if (this.gwh.length <= 1) {
            for (int i = 0; i < this.gwk.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.gwk.length];
        for (int i2 = 0; i2 < this.gwk.length; i2++) {
            for (int i3 = 0; i3 < this.gwh.length; i3++) {
                if (this.gwk[i2] == this.gwh[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.gwh.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.gwh.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.gwh[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.gwk.length; i4++) {
            fArr[i4] = fArr2[i4] - this.gwk[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.gwk != null) {
            for (int i = 0; i < this.gwk.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.gwi) + (this.gwp * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.gwk[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.gwi + f, this.gwk[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
