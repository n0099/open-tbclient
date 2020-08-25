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
/* loaded from: classes2.dex */
public class TbCornersImageView extends AppCompatImageView {
    private int borderColor;
    private int borderWidth;
    private float btQ;
    private int cornerRadius;
    private boolean eWW;
    private boolean eWX;
    private int eWY;
    private int eWZ;
    private int eXa;
    private int eXb;
    private int eXc;
    private int eXd;
    private int eXe;
    private float[] eXf;
    private float[] eXg;
    private RectF eXh;
    private RectF eXi;
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
        this.eWZ = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CornersImageView_is_cover_src) {
                this.eWX = obtainStyledAttributes.getBoolean(index, this.eWX);
            } else if (index == R.styleable.CornersImageView_is_circle) {
                this.eWW = obtainStyledAttributes.getBoolean(index, this.eWW);
            } else if (index == R.styleable.CornersImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.CornersImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.CornersImageView_inner_border_width) {
                this.eWY = obtainStyledAttributes.getDimensionPixelSize(index, this.eWY);
            } else if (index == R.styleable.CornersImageView_inner_border_color) {
                this.eWZ = obtainStyledAttributes.getColor(index, this.eWZ);
            } else if (index == R.styleable.CornersImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.CornersImageView_corner_top_left_radius) {
                this.eXa = obtainStyledAttributes.getDimensionPixelSize(index, this.eXa);
            } else if (index == R.styleable.CornersImageView_corner_top_right_radius) {
                this.eXb = obtainStyledAttributes.getDimensionPixelSize(index, this.eXb);
            } else if (index == R.styleable.CornersImageView_corner_bottom_left_radius) {
                this.eXc = obtainStyledAttributes.getDimensionPixelSize(index, this.eXc);
            } else if (index == R.styleable.CornersImageView_corner_bottom_right_radius) {
                this.eXd = obtainStyledAttributes.getDimensionPixelSize(index, this.eXd);
            } else if (index == R.styleable.CornersImageView_mask_color) {
                this.eXe = obtainStyledAttributes.getColor(index, this.eXe);
            }
        }
        obtainStyledAttributes.recycle();
        this.eXf = new float[8];
        this.eXg = new float[8];
        this.eXi = new RectF();
        this.eXh = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bwi();
        bwj();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bwg();
        bwh();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.eXh, null, 31);
        if (!this.eWX) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.eWY * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.eWY * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.eWW) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.btQ, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.eXh, this.eXg, Path.Direction.CCW);
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
            path.addRect(this.eXh, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.eXe != 0) {
            this.paint.setColor(this.eXe);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        I(canvas);
    }

    private void I(Canvas canvas) {
        if (this.eWW) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.btQ - (this.borderWidth / 2.0f));
            }
            if (this.eWY > 0) {
                a(canvas, this.eWY, this.eWZ, (this.btQ - this.borderWidth) - (this.eWY / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.eXi, this.eXf);
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

    private void bwg() {
        if (!this.eWW) {
            this.eXi.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bwh() {
        if (this.eWW) {
            this.btQ = Math.min(this.width, this.height) / 2.0f;
            this.eXh.set((this.width / 2.0f) - this.btQ, (this.height / 2.0f) - this.btQ, (this.width / 2.0f) + this.btQ, (this.height / 2.0f) + this.btQ);
            return;
        }
        this.eXh.set(0.0f, 0.0f, this.width, this.height);
        if (this.eWX) {
            this.eXh = this.eXi;
        }
    }

    private void bwi() {
        if (!this.eWW) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.eXf.length; i++) {
                    this.eXf[i] = this.cornerRadius;
                    this.eXg[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.eXf;
            float[] fArr2 = this.eXf;
            float f = this.eXa;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.eXf;
            float[] fArr4 = this.eXf;
            float f2 = this.eXb;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.eXf;
            float[] fArr6 = this.eXf;
            float f3 = this.eXd;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.eXf;
            float[] fArr8 = this.eXf;
            float f4 = this.eXc;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.eXg;
            float f5 = this.eXa - (this.borderWidth / 2.0f);
            this.eXg[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.eXg;
            float f6 = this.eXb - (this.borderWidth / 2.0f);
            this.eXg[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.eXg;
            float f7 = this.eXd - (this.borderWidth / 2.0f);
            this.eXg[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.eXg;
            float f8 = this.eXc - (this.borderWidth / 2.0f);
            this.eXg[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void jO(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bwi();
        bwg();
        invalidate();
    }

    private void bwj() {
        if (!this.eWW) {
            this.eWY = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.eXe = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        jO(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.eWY = i;
        bwj();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.eWZ = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        jO(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.eXa = i;
        jO(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.eXb = i;
        jO(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.eXc = i;
        jO(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.eXd = i;
        jO(true);
    }
}
