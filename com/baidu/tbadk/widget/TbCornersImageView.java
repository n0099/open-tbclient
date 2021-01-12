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
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCornersImageView extends AppCompatImageView {
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean fME;
    private boolean fMF;
    private int fMG;
    private int fMH;
    private int fMI;
    private int fMJ;
    private int fMK;
    private int fML;
    private int fMM;
    private float[] fMN;
    private float[] fMO;
    private RectF fMP;
    private RectF fMQ;
    private int height;
    private Paint paint;
    private Path path;
    private float radius;
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
        this.fMH = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CornersImageView_is_cover_src) {
                this.fMF = obtainStyledAttributes.getBoolean(index, this.fMF);
            } else if (index == R.styleable.CornersImageView_is_circle) {
                this.fME = obtainStyledAttributes.getBoolean(index, this.fME);
            } else if (index == R.styleable.CornersImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.CornersImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.CornersImageView_inner_border_width) {
                this.fMG = obtainStyledAttributes.getDimensionPixelSize(index, this.fMG);
            } else if (index == R.styleable.CornersImageView_inner_border_color) {
                this.fMH = obtainStyledAttributes.getColor(index, this.fMH);
            } else if (index == R.styleable.CornersImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.CornersImageView_corner_top_left_radius) {
                this.fMI = obtainStyledAttributes.getDimensionPixelSize(index, this.fMI);
            } else if (index == R.styleable.CornersImageView_corner_top_right_radius) {
                this.fMJ = obtainStyledAttributes.getDimensionPixelSize(index, this.fMJ);
            } else if (index == R.styleable.CornersImageView_corner_bottom_left_radius) {
                this.fMK = obtainStyledAttributes.getDimensionPixelSize(index, this.fMK);
            } else if (index == R.styleable.CornersImageView_corner_bottom_right_radius) {
                this.fML = obtainStyledAttributes.getDimensionPixelSize(index, this.fML);
            } else if (index == R.styleable.CornersImageView_mask_color) {
                this.fMM = obtainStyledAttributes.getColor(index, this.fMM);
            }
        }
        obtainStyledAttributes.recycle();
        this.fMN = new float[8];
        this.fMO = new float[8];
        this.fMQ = new RectF();
        this.fMP = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bFR();
        bFS();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bFP();
        bFQ();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.fMP, null, 31);
        if (!this.fMF) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.fMG * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.fMG * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.fME) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.radius, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.fMP, this.fMO, Path.Direction.CCW);
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
            path.addRect(this.fMP, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.fMM != 0) {
            this.paint.setColor(this.fMM);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        R(canvas);
    }

    private void R(Canvas canvas) {
        if (this.fME) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.radius - (this.borderWidth / 2.0f));
            }
            if (this.fMG > 0) {
                a(canvas, this.fMG, this.fMH, (this.radius - this.borderWidth) - (this.fMG / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.fMQ, this.fMN);
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

    private void bFP() {
        if (!this.fME) {
            this.fMQ.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bFQ() {
        if (this.fME) {
            this.radius = Math.min(this.width, this.height) / 2.0f;
            this.fMP.set((this.width / 2.0f) - this.radius, (this.height / 2.0f) - this.radius, (this.width / 2.0f) + this.radius, (this.height / 2.0f) + this.radius);
            return;
        }
        this.fMP.set(0.0f, 0.0f, this.width, this.height);
        if (this.fMF) {
            this.fMP = this.fMQ;
        }
    }

    private void bFR() {
        if (!this.fME) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.fMN.length; i++) {
                    this.fMN[i] = this.cornerRadius;
                    this.fMO[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.fMN;
            float[] fArr2 = this.fMN;
            float f = this.fMI;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.fMN;
            float[] fArr4 = this.fMN;
            float f2 = this.fMJ;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.fMN;
            float[] fArr6 = this.fMN;
            float f3 = this.fML;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.fMN;
            float[] fArr8 = this.fMN;
            float f4 = this.fMK;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.fMO;
            float f5 = this.fMI - (this.borderWidth / 2.0f);
            this.fMO[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.fMO;
            float f6 = this.fMJ - (this.borderWidth / 2.0f);
            this.fMO[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.fMO;
            float f7 = this.fML - (this.borderWidth / 2.0f);
            this.fMO[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.fMO;
            float f8 = this.fMK - (this.borderWidth / 2.0f);
            this.fMO[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void ly(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bFR();
        bFP();
        invalidate();
    }

    private void bFS() {
        if (!this.fME) {
            this.fMG = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.fMM = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        ly(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.fMG = i;
        bFS();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.fMH = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        ly(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.fMI = i;
        ly(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.fMJ = i;
        ly(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.fMK = i;
        ly(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.fML = i;
        ly(true);
    }
}
