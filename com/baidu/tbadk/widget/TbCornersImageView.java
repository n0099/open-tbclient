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
    private int borderColor;
    private int borderWidth;
    private float bxm;
    private int cornerRadius;
    private boolean eZR;
    private boolean eZS;
    private int eZT;
    private int eZU;
    private int eZV;
    private int eZW;
    private int eZX;
    private int eZY;
    private int eZZ;
    private float[] faa;
    private float[] fab;
    private RectF fac;
    private RectF fad;
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
        this.eZU = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CornersImageView_is_cover_src) {
                this.eZS = obtainStyledAttributes.getBoolean(index, this.eZS);
            } else if (index == R.styleable.CornersImageView_is_circle) {
                this.eZR = obtainStyledAttributes.getBoolean(index, this.eZR);
            } else if (index == R.styleable.CornersImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.CornersImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.CornersImageView_inner_border_width) {
                this.eZT = obtainStyledAttributes.getDimensionPixelSize(index, this.eZT);
            } else if (index == R.styleable.CornersImageView_inner_border_color) {
                this.eZU = obtainStyledAttributes.getColor(index, this.eZU);
            } else if (index == R.styleable.CornersImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.CornersImageView_corner_top_left_radius) {
                this.eZV = obtainStyledAttributes.getDimensionPixelSize(index, this.eZV);
            } else if (index == R.styleable.CornersImageView_corner_top_right_radius) {
                this.eZW = obtainStyledAttributes.getDimensionPixelSize(index, this.eZW);
            } else if (index == R.styleable.CornersImageView_corner_bottom_left_radius) {
                this.eZX = obtainStyledAttributes.getDimensionPixelSize(index, this.eZX);
            } else if (index == R.styleable.CornersImageView_corner_bottom_right_radius) {
                this.eZY = obtainStyledAttributes.getDimensionPixelSize(index, this.eZY);
            } else if (index == R.styleable.CornersImageView_mask_color) {
                this.eZZ = obtainStyledAttributes.getColor(index, this.eZZ);
            }
        }
        obtainStyledAttributes.recycle();
        this.faa = new float[8];
        this.fab = new float[8];
        this.fad = new RectF();
        this.fac = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bxs();
        bxt();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bxq();
        bxr();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.fac, null, 31);
        if (!this.eZS) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.eZT * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.eZT * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.eZR) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.bxm, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.fac, this.fab, Path.Direction.CCW);
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
            path.addRect(this.fac, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.eZZ != 0) {
            this.paint.setColor(this.eZZ);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        I(canvas);
    }

    private void I(Canvas canvas) {
        if (this.eZR) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.bxm - (this.borderWidth / 2.0f));
            }
            if (this.eZT > 0) {
                a(canvas, this.eZT, this.eZU, (this.bxm - this.borderWidth) - (this.eZT / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.fad, this.faa);
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

    private void bxq() {
        if (!this.eZR) {
            this.fad.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bxr() {
        if (this.eZR) {
            this.bxm = Math.min(this.width, this.height) / 2.0f;
            this.fac.set((this.width / 2.0f) - this.bxm, (this.height / 2.0f) - this.bxm, (this.width / 2.0f) + this.bxm, (this.height / 2.0f) + this.bxm);
            return;
        }
        this.fac.set(0.0f, 0.0f, this.width, this.height);
        if (this.eZS) {
            this.fac = this.fad;
        }
    }

    private void bxs() {
        if (!this.eZR) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.faa.length; i++) {
                    this.faa[i] = this.cornerRadius;
                    this.fab[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.faa;
            float[] fArr2 = this.faa;
            float f = this.eZV;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.faa;
            float[] fArr4 = this.faa;
            float f2 = this.eZW;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.faa;
            float[] fArr6 = this.faa;
            float f3 = this.eZY;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.faa;
            float[] fArr8 = this.faa;
            float f4 = this.eZX;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.fab;
            float f5 = this.eZV - (this.borderWidth / 2.0f);
            this.fab[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.fab;
            float f6 = this.eZW - (this.borderWidth / 2.0f);
            this.fab[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.fab;
            float f7 = this.eZY - (this.borderWidth / 2.0f);
            this.fab[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.fab;
            float f8 = this.eZX - (this.borderWidth / 2.0f);
            this.fab[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void jR(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bxs();
        bxq();
        invalidate();
    }

    private void bxt() {
        if (!this.eZR) {
            this.eZT = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.eZZ = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        jR(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.eZT = i;
        bxt();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.eZU = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        jR(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.eZV = i;
        jR(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.eZW = i;
        jR(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.eZX = i;
        jR(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.eZY = i;
        jR(true);
    }
}
