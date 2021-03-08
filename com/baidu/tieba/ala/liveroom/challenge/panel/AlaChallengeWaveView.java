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
    public static final float hze = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds16);
    public static final float hzf = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds24);
    public static final float hzg = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds32);
    private boolean fIv;
    private float[] hzh;
    private float hzi;
    private int hzj;
    private float[] hzk;
    private float[] hzl;
    private float[] hzm;
    private float[] hzn;
    private float[] hzo;
    private int hzp;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.hzh = new float[]{hze, hzf, hzg};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hzh = new float[]{hze, hzf, hzg};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hzh = new float[]{hze, hzf, hzg};
        init();
    }

    private void init() {
        this.hzp = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.hzi = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hzj = getContext().getResources().getColor(a.c.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.hzj);
        this.mPaint.setStrokeWidth(this.hzi);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.hzl = fArr;
        if (this.hzl != null) {
            this.hzk = new float[this.hzl.length];
            for (int i = 0; i < this.hzl.length; i++) {
                this.hzk[i] = this.hzl[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.hzo = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.hzo[i] = fArr[i];
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
            i3 = (this.hzk == null || this.hzk.length <= 0) ? paddingLeft : (int) (paddingLeft + (this.hzi * this.hzk.length) + ((this.hzk.length - 1) * this.hzp));
        } else {
            i3 = 0;
        }
        if (mode2 == 1073741824) {
            i5 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            if (this.hzk != null) {
                int i6 = 0;
                while (true) {
                    i4 = i5;
                    if (i6 >= this.hzk.length) {
                        break;
                    }
                    i5 = this.hzk[i6] > ((float) i4) ? (int) this.hzk[i6] : i4;
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
        if (this.hzk != null) {
            this.fIv = false;
            this.hzn = getDifValueArray();
            this.hzm = new float[this.hzk.length];
            for (int i = 0; i < this.hzk.length; i++) {
                this.hzm[i] = this.hzk[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.fIv) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.hzk.length; i2++) {
                            AlaChallengeWaveView.this.hzk[i2] = AlaChallengeWaveView.this.hzm[i2] + (AlaChallengeWaveView.this.hzn[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.fIv) {
                        if (AlaChallengeWaveView.this.hzo == null) {
                            if (AlaChallengeWaveView.this.hzk != null && AlaChallengeWaveView.this.hzl != null && AlaChallengeWaveView.this.hzk.length == AlaChallengeWaveView.this.hzl.length) {
                                while (i2 < AlaChallengeWaveView.this.hzl.length) {
                                    AlaChallengeWaveView.this.hzk[i2] = AlaChallengeWaveView.this.hzl[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.hzk = new float[AlaChallengeWaveView.this.hzo.length];
                            while (i2 < AlaChallengeWaveView.this.hzo.length) {
                                AlaChallengeWaveView.this.hzk[i2] = AlaChallengeWaveView.this.hzo[i2];
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
        this.fIv = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.hzk == null) {
            return null;
        }
        float[] fArr = new float[this.hzk.length];
        if (this.hzh.length <= 1) {
            for (int i = 0; i < this.hzk.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.hzk.length];
        for (int i2 = 0; i2 < this.hzk.length; i2++) {
            for (int i3 = 0; i3 < this.hzh.length; i3++) {
                if (this.hzk[i2] == this.hzh[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.hzh.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.hzh.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.hzh[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.hzk.length; i4++) {
            fArr[i4] = fArr2[i4] - this.hzk[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.hzk != null) {
            for (int i = 0; i < this.hzk.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.hzi) + (this.hzp * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.hzk[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.hzi + f, this.hzk[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
