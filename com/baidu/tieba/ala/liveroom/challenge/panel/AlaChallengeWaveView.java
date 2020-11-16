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
    public static final float hbX = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds16);
    public static final float hbY = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds24);
    public static final float hbZ = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds32);
    private boolean frX;
    private float[] hca;
    private float hcb;
    private int hcc;
    private float[] hcd;
    private float[] hce;
    private float[] hcf;
    private float[] hcg;
    private float[] hch;
    private int hci;
    private Paint mPaint;
    private ValueAnimator mValueAnimator;

    public AlaChallengeWaveView(Context context) {
        super(context);
        this.hca = new float[]{hbX, hbY, hbZ};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hca = new float[]{hbX, hbY, hbZ};
        init();
    }

    public AlaChallengeWaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hca = new float[]{hbX, hbY, hbZ};
        init();
    }

    private void init() {
        this.hci = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        this.hcb = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hcc = getContext().getResources().getColor(a.c.ala_challenge_yellow_color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.hcc);
        this.mPaint.setStrokeWidth(this.hcb);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public void setWaveArray(float[] fArr) {
        this.hce = fArr;
        if (this.hce != null) {
            this.hcd = new float[this.hce.length];
            for (int i = 0; i < this.hce.length; i++) {
                this.hcd[i] = this.hce[i];
            }
        }
    }

    public void setEndWaveArray(float[] fArr) {
        if (fArr != null) {
            this.hch = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.hch[i] = fArr[i];
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
                if (this.hcd != null && this.hcd.length > 0) {
                    size = (int) (size + (this.hcb * this.hcd.length) + ((this.hcd.length - 1) * this.hci));
                }
            } else {
                size = 0;
            }
        }
        if (mode2 == 1073741824) {
            i4 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (this.hcd != null) {
                i3 = 0;
                while (i4 < this.hcd.length) {
                    if (this.hcd[i4] > i3) {
                        i3 = (int) this.hcd[i4];
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
        if (this.hcd != null) {
            this.frX = false;
            this.hcg = getDifValueArray();
            this.hcf = new float[this.hcd.length];
            for (int i = 0; i < this.hcd.length; i++) {
                this.hcf[i] = this.hcd[i];
            }
            this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator.setDuration(300L);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.AlaChallengeWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!AlaChallengeWaveView.this.frX) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < AlaChallengeWaveView.this.hcd.length; i2++) {
                            AlaChallengeWaveView.this.hcd[i2] = AlaChallengeWaveView.this.hcf[i2] + (AlaChallengeWaveView.this.hcg[i2] * floatValue);
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
                    if (AlaChallengeWaveView.this.frX) {
                        if (AlaChallengeWaveView.this.hch == null) {
                            if (AlaChallengeWaveView.this.hcd != null && AlaChallengeWaveView.this.hce != null && AlaChallengeWaveView.this.hcd.length == AlaChallengeWaveView.this.hce.length) {
                                while (i2 < AlaChallengeWaveView.this.hce.length) {
                                    AlaChallengeWaveView.this.hcd[i2] = AlaChallengeWaveView.this.hce[i2];
                                    i2++;
                                }
                            }
                        } else {
                            AlaChallengeWaveView.this.hcd = new float[AlaChallengeWaveView.this.hch.length];
                            while (i2 < AlaChallengeWaveView.this.hch.length) {
                                AlaChallengeWaveView.this.hcd[i2] = AlaChallengeWaveView.this.hch[i2];
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
        this.frX = true;
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    private float[] getDifValueArray() {
        if (this.hcd == null) {
            return null;
        }
        float[] fArr = new float[this.hcd.length];
        if (this.hca.length <= 1) {
            for (int i = 0; i < this.hcd.length; i++) {
                fArr[i] = 0.0f;
            }
        }
        float[] fArr2 = new float[this.hcd.length];
        for (int i2 = 0; i2 < this.hcd.length; i2++) {
            for (int i3 = 0; i3 < this.hca.length; i3++) {
                if (this.hcd[i2] == this.hca[i3]) {
                    int abs = Math.abs(new Random().nextInt()) % this.hca.length;
                    if (abs == i3) {
                        abs = abs + 1 >= this.hca.length ? 0 : abs + 1;
                    }
                    fArr2[i2] = this.hca[abs];
                }
            }
        }
        for (int i4 = 0; i4 < this.hcd.length; i4++) {
            fArr[i4] = fArr2[i4] - this.hcd[i4];
        }
        return fArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.hcd != null) {
            for (int i = 0; i < this.hcd.length; i++) {
                if (i == 0) {
                    f = 0.0f;
                } else {
                    f = (i * this.hcb) + (this.hci * i);
                }
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.hcd[i]) / 2.0f;
                canvas.drawRoundRect(new RectF(f, height, this.hcb + f, this.hcd[i] + height), 3.0f, 3.0f, this.mPaint);
            }
        }
    }
}
