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
    public static final float fBd = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float fBe = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float fBf = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean ebx;
    private float[] fBg;
    private float fBh;
    private int fBi;
    private float[] fBj;
    private float[] fBk;
    private float[] fBl;
    private float[] fBm;
    private float[] fBn;
    private int fBo;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.fBg = new float[]{fBd, fBe, fBf};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBg = new float[]{fBd, fBe, fBf};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBg = new float[]{fBd, fBe, fBf};
        init();
    }

    private void init() {
        this.fBo = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.fBh = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fBi = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.fBi);
        this.mPaint.setStrokeWidth(this.fBh);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.fBk = fArr;
        if (this.fBk != null) {
            this.fBj = new float[this.fBk.length];
            for (int i = 0; i < this.fBk.length; i++) {
                this.fBj[i] = this.fBk[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.fBn = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.fBn[i] = fArr[i];
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
                if (this.fBj != null && this.fBj.length > 0) {
                    size = (int) (size + (this.fBh * this.fBj.length) + ((this.fBj.length - 1) * this.fBo));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.fBj != null) {
                i3 = 0;
                while (i4 < this.fBj.length) {
                    if (this.fBj[i4] > i3) {
                        i3 = (int) this.fBj[i4];
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
        if (this.fBj != null) {
            this.ebx = false;
            this.fBm = getDifValueArray();
            this.fBl = new float[this.fBj.length];
            for (int i = 0; i < this.fBj.length; i++) {
                this.fBl[i] = this.fBj[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.ebx) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.fBj.length; i2++) {
                            AlaChallengeWaveView.this.fBj[i2] = AlaChallengeWaveView.this.fBl[i2] + (AlaChallengeWaveView.this.fBm[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.ebx) {
                        if (AlaChallengeWaveView.this.fBn == null) {
                            if (AlaChallengeWaveView.this.fBj != null && AlaChallengeWaveView.this.fBk != null && AlaChallengeWaveView.this.fBj.length == AlaChallengeWaveView.this.fBk.length) {
                                while (i2 < AlaChallengeWaveView.this.fBk.length) {
                                    AlaChallengeWaveView.this.fBj[i2] = AlaChallengeWaveView.this.fBk[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.fBj = new float[AlaChallengeWaveView.this.fBn.length];
                            while (i2 < AlaChallengeWaveView.this.fBn.length) {
                                AlaChallengeWaveView.this.fBj[i2] = AlaChallengeWaveView.this.fBn[i2];
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
        this.ebx = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.fBj == null) {
            return null;
        }
        float[] fArr = new float[this.fBj.length];
        if (this.fBg.length <= 1) {
            for (int i = 0; i < this.fBj.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.fBj.length];
        for (int i2 = 0; i2 < this.fBj.length; i2++) {
            for (int i3 = 0; i3 < this.fBg.length; i3++) {
                if (this.fBj[i2] == this.fBg[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.fBg.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.fBg.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.fBg[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.fBj.length; i4++) {
            fArr[i4] = fArr2[i4] - this.fBj[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.fBj != null) {
            for (int i = 0; i < this.fBj.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.fBh) + (this.fBo * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.fBj[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.fBh + f, this.fBj[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
