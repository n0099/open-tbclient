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
    private float bGL;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean fuE;
    private boolean fuF;
    private int fuG;
    private int fuH;
    private int fuI;
    private int fuJ;
    private int fuK;
    private int fuL;
    private int fuM;
    private float[] fuN;
    private float[] fuO;
    private RectF fuP;
    private RectF fuQ;
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
        this.fuH = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CornersImageView_is_cover_src) {
                this.fuF = obtainStyledAttributes.getBoolean(index, this.fuF);
            } else if (index == R.styleable.CornersImageView_is_circle) {
                this.fuE = obtainStyledAttributes.getBoolean(index, this.fuE);
            } else if (index == R.styleable.CornersImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.CornersImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.CornersImageView_inner_border_width) {
                this.fuG = obtainStyledAttributes.getDimensionPixelSize(index, this.fuG);
            } else if (index == R.styleable.CornersImageView_inner_border_color) {
                this.fuH = obtainStyledAttributes.getColor(index, this.fuH);
            } else if (index == R.styleable.CornersImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.CornersImageView_corner_top_left_radius) {
                this.fuI = obtainStyledAttributes.getDimensionPixelSize(index, this.fuI);
            } else if (index == R.styleable.CornersImageView_corner_top_right_radius) {
                this.fuJ = obtainStyledAttributes.getDimensionPixelSize(index, this.fuJ);
            } else if (index == R.styleable.CornersImageView_corner_bottom_left_radius) {
                this.fuK = obtainStyledAttributes.getDimensionPixelSize(index, this.fuK);
            } else if (index == R.styleable.CornersImageView_corner_bottom_right_radius) {
                this.fuL = obtainStyledAttributes.getDimensionPixelSize(index, this.fuL);
            } else if (index == R.styleable.CornersImageView_mask_color) {
                this.fuM = obtainStyledAttributes.getColor(index, this.fuM);
            }
        }
        obtainStyledAttributes.recycle();
        this.fuN = new float[8];
        this.fuO = new float[8];
        this.fuQ = new RectF();
        this.fuP = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bBV();
        bBW();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bBT();
        bBU();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.fuP, null, 31);
        if (!this.fuF) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.fuG * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.fuG * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.fuE) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.bGL, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.fuP, this.fuO, Path.Direction.CCW);
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
            path.addRect(this.fuP, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.fuM != 0) {
            this.paint.setColor(this.fuM);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        I(canvas);
    }

    private void I(Canvas canvas) {
        if (this.fuE) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.bGL - (this.borderWidth / 2.0f));
            }
            if (this.fuG > 0) {
                a(canvas, this.fuG, this.fuH, (this.bGL - this.borderWidth) - (this.fuG / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.fuQ, this.fuN);
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

    private void bBT() {
        if (!this.fuE) {
            this.fuQ.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bBU() {
        if (this.fuE) {
            this.bGL = Math.min(this.width, this.height) / 2.0f;
            this.fuP.set((this.width / 2.0f) - this.bGL, (this.height / 2.0f) - this.bGL, (this.width / 2.0f) + this.bGL, (this.height / 2.0f) + this.bGL);
            return;
        }
        this.fuP.set(0.0f, 0.0f, this.width, this.height);
        if (this.fuF) {
            this.fuP = this.fuQ;
        }
    }

    private void bBV() {
        if (!this.fuE) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.fuN.length; i++) {
                    this.fuN[i] = this.cornerRadius;
                    this.fuO[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.fuN;
            float[] fArr2 = this.fuN;
            float f = this.fuI;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.fuN;
            float[] fArr4 = this.fuN;
            float f2 = this.fuJ;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.fuN;
            float[] fArr6 = this.fuN;
            float f3 = this.fuL;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.fuN;
            float[] fArr8 = this.fuN;
            float f4 = this.fuK;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.fuO;
            float f5 = this.fuI - (this.borderWidth / 2.0f);
            this.fuO[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.fuO;
            float f6 = this.fuJ - (this.borderWidth / 2.0f);
            this.fuO[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.fuO;
            float f7 = this.fuL - (this.borderWidth / 2.0f);
            this.fuO[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.fuO;
            float f8 = this.fuK - (this.borderWidth / 2.0f);
            this.fuO[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void kC(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bBV();
        bBT();
        invalidate();
    }

    private void bBW() {
        if (!this.fuE) {
            this.fuG = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.fuM = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        kC(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.fuG = i;
        bBW();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.fuH = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        kC(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.fuI = i;
        kC(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.fuJ = i;
        kC(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.fuK = i;
        kC(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.fuL = i;
        kC(true);
    }
}
