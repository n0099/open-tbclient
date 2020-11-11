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
    private float bMq;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private int fAA;
    private int fAB;
    private int fAC;
    private float[] fAD;
    private float[] fAE;
    private RectF fAF;
    private RectF fAG;
    private boolean fAu;
    private boolean fAv;
    private int fAw;
    private int fAx;
    private int fAy;
    private int fAz;
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
        this.fAx = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CornersImageView_is_cover_src) {
                this.fAv = obtainStyledAttributes.getBoolean(index, this.fAv);
            } else if (index == R.styleable.CornersImageView_is_circle) {
                this.fAu = obtainStyledAttributes.getBoolean(index, this.fAu);
            } else if (index == R.styleable.CornersImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.CornersImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.CornersImageView_inner_border_width) {
                this.fAw = obtainStyledAttributes.getDimensionPixelSize(index, this.fAw);
            } else if (index == R.styleable.CornersImageView_inner_border_color) {
                this.fAx = obtainStyledAttributes.getColor(index, this.fAx);
            } else if (index == R.styleable.CornersImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.CornersImageView_corner_top_left_radius) {
                this.fAy = obtainStyledAttributes.getDimensionPixelSize(index, this.fAy);
            } else if (index == R.styleable.CornersImageView_corner_top_right_radius) {
                this.fAz = obtainStyledAttributes.getDimensionPixelSize(index, this.fAz);
            } else if (index == R.styleable.CornersImageView_corner_bottom_left_radius) {
                this.fAA = obtainStyledAttributes.getDimensionPixelSize(index, this.fAA);
            } else if (index == R.styleable.CornersImageView_corner_bottom_right_radius) {
                this.fAB = obtainStyledAttributes.getDimensionPixelSize(index, this.fAB);
            } else if (index == R.styleable.CornersImageView_mask_color) {
                this.fAC = obtainStyledAttributes.getColor(index, this.fAC);
            }
        }
        obtainStyledAttributes.recycle();
        this.fAD = new float[8];
        this.fAE = new float[8];
        this.fAG = new RectF();
        this.fAF = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bEu();
        bEv();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bEs();
        bEt();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.fAF, null, 31);
        if (!this.fAv) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.fAw * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.fAw * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.fAu) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.bMq, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.fAF, this.fAE, Path.Direction.CCW);
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
            path.addRect(this.fAF, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.fAC != 0) {
            this.paint.setColor(this.fAC);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        I(canvas);
    }

    private void I(Canvas canvas) {
        if (this.fAu) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.bMq - (this.borderWidth / 2.0f));
            }
            if (this.fAw > 0) {
                a(canvas, this.fAw, this.fAx, (this.bMq - this.borderWidth) - (this.fAw / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.fAG, this.fAD);
        }
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        bj(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        bj(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void bj(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void bEs() {
        if (!this.fAu) {
            this.fAG.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bEt() {
        if (this.fAu) {
            this.bMq = Math.min(this.width, this.height) / 2.0f;
            this.fAF.set((this.width / 2.0f) - this.bMq, (this.height / 2.0f) - this.bMq, (this.width / 2.0f) + this.bMq, (this.height / 2.0f) + this.bMq);
            return;
        }
        this.fAF.set(0.0f, 0.0f, this.width, this.height);
        if (this.fAv) {
            this.fAF = this.fAG;
        }
    }

    private void bEu() {
        if (!this.fAu) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.fAD.length; i++) {
                    this.fAD[i] = this.cornerRadius;
                    this.fAE[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.fAD;
            float[] fArr2 = this.fAD;
            float f = this.fAy;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.fAD;
            float[] fArr4 = this.fAD;
            float f2 = this.fAz;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.fAD;
            float[] fArr6 = this.fAD;
            float f3 = this.fAB;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.fAD;
            float[] fArr8 = this.fAD;
            float f4 = this.fAA;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.fAE;
            float f5 = this.fAy - (this.borderWidth / 2.0f);
            this.fAE[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.fAE;
            float f6 = this.fAz - (this.borderWidth / 2.0f);
            this.fAE[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.fAE;
            float f7 = this.fAB - (this.borderWidth / 2.0f);
            this.fAE[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.fAE;
            float f8 = this.fAA - (this.borderWidth / 2.0f);
            this.fAE[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void kL(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bEu();
        bEs();
        invalidate();
    }

    private void bEv() {
        if (!this.fAu) {
            this.fAw = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.fAC = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        kL(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.fAw = i;
        bEv();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.fAx = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        kL(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.fAy = i;
        kL(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.fAz = i;
        kL(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.fAA = i;
        kL(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.fAB = i;
        kL(true);
    }
}
