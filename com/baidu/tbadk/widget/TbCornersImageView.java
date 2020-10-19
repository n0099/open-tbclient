package com.baidu.tbadk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCornersImageView extends AppCompatImageView {
    private float bDP;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean fmd;
    private boolean fme;
    private int fmf;
    private int fmg;
    private int fmh;
    private int fmi;
    private int fmj;
    private int fmk;
    private int fml;
    private float[] fmm;
    private float[] fmn;
    private RectF fmo;
    private RectF fmq;
    private int height;
    private Paint paint;
    private Path path;
    private int width;

    public TbCornersImageView(Context context) {
        this(context, null);
    }

    public TbCornersImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbCornersImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.borderColor = -1;
        this.fmg = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CornersImageView_is_cover_src) {
                this.fme = obtainStyledAttributes.getBoolean(index, this.fme);
            } else if (index == R.styleable.CornersImageView_is_circle) {
                this.fmd = obtainStyledAttributes.getBoolean(index, this.fmd);
            } else if (index == R.styleable.CornersImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.CornersImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.CornersImageView_inner_border_width) {
                this.fmf = obtainStyledAttributes.getDimensionPixelSize(index, this.fmf);
            } else if (index == R.styleable.CornersImageView_inner_border_color) {
                this.fmg = obtainStyledAttributes.getColor(index, this.fmg);
            } else if (index == R.styleable.CornersImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.CornersImageView_corner_top_left_radius) {
                this.fmh = obtainStyledAttributes.getDimensionPixelSize(index, this.fmh);
            } else if (index == R.styleable.CornersImageView_corner_top_right_radius) {
                this.fmi = obtainStyledAttributes.getDimensionPixelSize(index, this.fmi);
            } else if (index == R.styleable.CornersImageView_corner_bottom_left_radius) {
                this.fmj = obtainStyledAttributes.getDimensionPixelSize(index, this.fmj);
            } else if (index == R.styleable.CornersImageView_corner_bottom_right_radius) {
                this.fmk = obtainStyledAttributes.getDimensionPixelSize(index, this.fmk);
            } else if (index == R.styleable.CornersImageView_mask_color) {
                this.fml = obtainStyledAttributes.getColor(index, this.fml);
            }
        }
        obtainStyledAttributes.recycle();
        this.fmm = new float[8];
        this.fmn = new float[8];
        this.fmq = new RectF();
        this.fmo = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bAc();
        bAd();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bAa();
        bAb();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.fmo, null, 31);
        if (!this.fme) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.fmf * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.fmf * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.fmd) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.bDP, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.fmo, this.fmn, Path.Direction.CCW);
        }
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.path, this.paint);
        if (Build.VERSION.SDK_INT <= 27) {
            this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.path, this.paint);
        } else {
            this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Path path = new Path();
            path.addRect(this.fmo, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.fml != 0) {
            this.paint.setColor(this.fml);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        I(canvas);
    }

    private void I(Canvas canvas) {
        if (this.fmd) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.bDP - (this.borderWidth / 2.0f));
            }
            if (this.fmf > 0) {
                a(canvas, this.fmf, this.fmg, (this.bDP - this.borderWidth) - (this.fmf / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.fmq, this.fmm);
        }
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        bi(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        bi(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void bi(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void bAa() {
        if (!this.fmd) {
            this.fmq.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bAb() {
        if (this.fmd) {
            this.bDP = Math.min(this.width, this.height) / 2.0f;
            this.fmo.set((this.width / 2.0f) - this.bDP, (this.height / 2.0f) - this.bDP, (this.width / 2.0f) + this.bDP, (this.height / 2.0f) + this.bDP);
            return;
        }
        this.fmo.set(0.0f, 0.0f, this.width, this.height);
        if (this.fme) {
            this.fmo = this.fmq;
        }
    }

    private void bAc() {
        if (!this.fmd) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.fmm.length; i++) {
                    this.fmm[i] = this.cornerRadius;
                    this.fmn[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.fmm;
            float[] fArr2 = this.fmm;
            float f = this.fmh;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.fmm;
            float[] fArr4 = this.fmm;
            float f2 = this.fmi;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.fmm;
            float[] fArr6 = this.fmm;
            float f3 = this.fmk;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.fmm;
            float[] fArr8 = this.fmm;
            float f4 = this.fmj;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.fmn;
            float f5 = this.fmh - (this.borderWidth / 2.0f);
            this.fmn[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.fmn;
            float f6 = this.fmi - (this.borderWidth / 2.0f);
            this.fmn[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.fmn;
            float f7 = this.fmk - (this.borderWidth / 2.0f);
            this.fmn[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.fmn;
            float f8 = this.fmj - (this.borderWidth / 2.0f);
            this.fmn[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void kp(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bAc();
        bAa();
        invalidate();
    }

    private void bAd() {
        if (!this.fmd) {
            this.fmf = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.fml = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        kp(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.fmf = i;
        bAd();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.fmg = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        kp(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.fmh = i;
        kp(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.fmi = i;
        kp(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.fmj = i;
        kp(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.fmk = i;
        kp(true);
    }
}
