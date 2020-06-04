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
    public static final float fPr = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds16);
    public static final float fPs = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds24);
    public static final float fPt = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds32);
    private boolean epJ;
    private float[] fPA;
    private float[] fPB;
    private int fPC;
    private float[] fPu;
    private float fPv;
    private int fPw;
    private float[] fPx;
    private float[] fPy;
    private float[] fPz;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.fPu = new float[]{fPr, fPs, fPt};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fPu = new float[]{fPr, fPs, fPt};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fPu = new float[]{fPr, fPs, fPt};
        init();
    }

    private void init() {
        this.fPC = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.fPv = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fPw = getContext().getResources().getColor(a.d.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.fPw);
        this.mPaint.setStrokeWidth(this.fPv);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.fPy = fArr;
        if (this.fPy != null) {
            this.fPx = new float[this.fPy.length];
            for (int i = 0; i < this.fPy.length; i++) {
                this.fPx[i] = this.fPy[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.fPB = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.fPB[i] = fArr[i];
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
                if (this.fPx != null && this.fPx.length > 0) {
                    size = (int) (size + (this.fPv * this.fPx.length) + ((this.fPx.length - 1) * this.fPC));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.fPx != null) {
                i3 = 0;
                while (i4 < this.fPx.length) {
                    if (this.fPx[i4] > i3) {
                        i3 = (int) this.fPx[i4];
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
        if (this.fPx != null) {
            this.epJ = false;
            this.fPA = getDifValueArray();
            this.fPz = new float[this.fPx.length];
            for (int i = 0; i < this.fPx.length; i++) {
                this.fPz[i] = this.fPx[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.epJ) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.fPx.length; i2++) {
                            AlaChallengeWaveView.this.fPx[i2] = AlaChallengeWaveView.this.fPz[i2] + (AlaChallengeWaveView.this.fPA[i2] * floatValue);
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
                        if (AlaChallengeWaveView.this.fPB == null) {
                            if (AlaChallengeWaveView.this.fPx != null && AlaChallengeWaveView.this.fPy != null && AlaChallengeWaveView.this.fPx.length == AlaChallengeWaveView.this.fPy.length) {
                                while (i2 < AlaChallengeWaveView.this.fPy.length) {
                                    AlaChallengeWaveView.this.fPx[i2] = AlaChallengeWaveView.this.fPy[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.fPx = new float[AlaChallengeWaveView.this.fPB.length];
                            while (i2 < AlaChallengeWaveView.this.fPB.length) {
                                AlaChallengeWaveView.this.fPx[i2] = AlaChallengeWaveView.this.fPB[i2];
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
        if (this.fPx == null) {
            return null;
        }
        float[] fArr = new float[this.fPx.length];
        if (this.fPu.length <= 1) {
            for (int i = 0; i < this.fPx.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.fPx.length];
        for (int i2 = 0; i2 < this.fPx.length; i2++) {
            for (int i3 = 0; i3 < this.fPu.length; i3++) {
                if (this.fPx[i2] == this.fPu[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.fPu.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.fPu.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.fPu[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.fPx.length; i4++) {
            fArr[i4] = fArr2[i4] - this.fPx[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.fPx != null) {
            for (int i = 0; i < this.fPx.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.fPv) + (this.fPC * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.fPx[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.fPv + f, this.fPx[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
