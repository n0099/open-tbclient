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
    private float bnJ;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean eFU;
    private boolean eFV;
    private int eFW;
    private int eFX;
    private int eFY;
    private int eFZ;
    private int eGa;
    private int eGb;
    private int eGc;
    private float[] eGd;
    private float[] eGe;
    private RectF eGf;
    private RectF eGg;
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
        this.eFX = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 7) {
                this.eFV = obtainStyledAttributes.getBoolean(index, this.eFV);
            } else if (index == 4) {
                this.eFU = obtainStyledAttributes.getBoolean(index, this.eFU);
            } else if (index == 1) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == 2) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == 6) {
                this.eFW = obtainStyledAttributes.getDimensionPixelSize(index, this.eFW);
            } else if (index == 3) {
                this.eFX = obtainStyledAttributes.getColor(index, this.eFX);
            } else if (index == 0) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == 11) {
                this.eFY = obtainStyledAttributes.getDimensionPixelSize(index, this.eFY);
            } else if (index == 10) {
                this.eFZ = obtainStyledAttributes.getDimensionPixelSize(index, this.eFZ);
            } else if (index == 5) {
                this.eGa = obtainStyledAttributes.getDimensionPixelSize(index, this.eGa);
            } else if (index == 8) {
                this.eGb = obtainStyledAttributes.getDimensionPixelSize(index, this.eGb);
            } else if (index == 9) {
                this.eGc = obtainStyledAttributes.getColor(index, this.eGc);
            }
        }
        obtainStyledAttributes.recycle();
        this.eGd = new float[8];
        this.eGe = new float[8];
        this.eGg = new RectF();
        this.eGf = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bjB();
        bjC();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bjz();
        bjA();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.eGf, null, 31);
        if (!this.eFV) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.eFW * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.eFW * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.eFU) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.bnJ, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.eGf, this.eGe, Path.Direction.CCW);
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
            path.addRect(this.eGf, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.eGc != 0) {
            this.paint.setColor(this.eGc);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        D(canvas);
    }

    private void D(Canvas canvas) {
        if (this.eFU) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.bnJ - (this.borderWidth / 2.0f));
            }
            if (this.eFW > 0) {
                a(canvas, this.eFW, this.eFX, (this.bnJ - this.borderWidth) - (this.eFW / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.eGg, this.eGd);
        }
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        aX(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        aX(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void aX(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void bjz() {
        if (!this.eFU) {
            this.eGg.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bjA() {
        if (this.eFU) {
            this.bnJ = Math.min(this.width, this.height) / 2.0f;
            this.eGf.set((this.width / 2.0f) - this.bnJ, (this.height / 2.0f) - this.bnJ, (this.width / 2.0f) + this.bnJ, (this.height / 2.0f) + this.bnJ);
            return;
        }
        this.eGf.set(0.0f, 0.0f, this.width, this.height);
        if (this.eFV) {
            this.eGf = this.eGg;
        }
    }

    private void bjB() {
        if (!this.eFU) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.eGd.length; i++) {
                    this.eGd[i] = this.cornerRadius;
                    this.eGe[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.eGd;
            float[] fArr2 = this.eGd;
            float f = this.eFY;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.eGd;
            float[] fArr4 = this.eGd;
            float f2 = this.eFZ;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.eGd;
            float[] fArr6 = this.eGd;
            float f3 = this.eGb;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.eGd;
            float[] fArr8 = this.eGd;
            float f4 = this.eGa;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.eGe;
            float f5 = this.eFY - (this.borderWidth / 2.0f);
            this.eGe[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.eGe;
            float f6 = this.eFZ - (this.borderWidth / 2.0f);
            this.eGe[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.eGe;
            float f7 = this.eGb - (this.borderWidth / 2.0f);
            this.eGe[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.eGe;
            float f8 = this.eGa - (this.borderWidth / 2.0f);
            this.eGe[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void iL(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bjB();
        bjz();
        invalidate();
    }

    private void bjC() {
        if (!this.eFU) {
            this.eFW = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.eGc = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        iL(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.eFW = i;
        bjC();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.eFX = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        iL(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.eFY = i;
        iL(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.eFZ = i;
        iL(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.eGa = i;
        iL(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.eGb = i;
        iL(true);
    }
}
