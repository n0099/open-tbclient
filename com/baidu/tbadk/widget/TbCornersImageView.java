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
    private float[] fQA;
    private float[] fQB;
    private RectF fQC;
    private RectF fQD;
    private boolean fQr;
    private boolean fQs;
    private int fQt;
    private int fQu;
    private int fQv;
    private int fQw;
    private int fQx;
    private int fQy;
    private int fQz;
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
        this.fQu = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CornersImageView_is_cover_src) {
                this.fQs = obtainStyledAttributes.getBoolean(index, this.fQs);
            } else if (index == R.styleable.CornersImageView_is_circle) {
                this.fQr = obtainStyledAttributes.getBoolean(index, this.fQr);
            } else if (index == R.styleable.CornersImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.CornersImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.CornersImageView_inner_border_width) {
                this.fQt = obtainStyledAttributes.getDimensionPixelSize(index, this.fQt);
            } else if (index == R.styleable.CornersImageView_inner_border_color) {
                this.fQu = obtainStyledAttributes.getColor(index, this.fQu);
            } else if (index == R.styleable.CornersImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.CornersImageView_corner_top_left_radius) {
                this.fQv = obtainStyledAttributes.getDimensionPixelSize(index, this.fQv);
            } else if (index == R.styleable.CornersImageView_corner_top_right_radius) {
                this.fQw = obtainStyledAttributes.getDimensionPixelSize(index, this.fQw);
            } else if (index == R.styleable.CornersImageView_corner_bottom_left_radius) {
                this.fQx = obtainStyledAttributes.getDimensionPixelSize(index, this.fQx);
            } else if (index == R.styleable.CornersImageView_corner_bottom_right_radius) {
                this.fQy = obtainStyledAttributes.getDimensionPixelSize(index, this.fQy);
            } else if (index == R.styleable.CornersImageView_mask_color) {
                this.fQz = obtainStyledAttributes.getColor(index, this.fQz);
            }
        }
        obtainStyledAttributes.recycle();
        this.fQA = new float[8];
        this.fQB = new float[8];
        this.fQD = new RectF();
        this.fQC = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bGp();
        bGq();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bGn();
        bGo();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.fQC, null, 31);
        if (!this.fQs) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.fQt * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.fQt * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.fQr) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.radius, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.fQC, this.fQB, Path.Direction.CCW);
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
            path.addRect(this.fQC, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.fQz != 0) {
            this.paint.setColor(this.fQz);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        R(canvas);
    }

    private void R(Canvas canvas) {
        if (this.fQr) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.radius - (this.borderWidth / 2.0f));
            }
            if (this.fQt > 0) {
                a(canvas, this.fQt, this.fQu, (this.radius - this.borderWidth) - (this.fQt / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.fQD, this.fQA);
        }
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        bg(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        bg(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void bg(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void bGn() {
        if (!this.fQr) {
            this.fQD.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bGo() {
        if (this.fQr) {
            this.radius = Math.min(this.width, this.height) / 2.0f;
            this.fQC.set((this.width / 2.0f) - this.radius, (this.height / 2.0f) - this.radius, (this.width / 2.0f) + this.radius, (this.height / 2.0f) + this.radius);
            return;
        }
        this.fQC.set(0.0f, 0.0f, this.width, this.height);
        if (this.fQs) {
            this.fQC = this.fQD;
        }
    }

    private void bGp() {
        if (!this.fQr) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.fQA.length; i++) {
                    this.fQA[i] = this.cornerRadius;
                    this.fQB[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.fQA;
            float[] fArr2 = this.fQA;
            float f = this.fQv;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.fQA;
            float[] fArr4 = this.fQA;
            float f2 = this.fQw;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.fQA;
            float[] fArr6 = this.fQA;
            float f3 = this.fQy;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.fQA;
            float[] fArr8 = this.fQA;
            float f4 = this.fQx;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.fQB;
            float f5 = this.fQv - (this.borderWidth / 2.0f);
            this.fQB[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.fQB;
            float f6 = this.fQw - (this.borderWidth / 2.0f);
            this.fQB[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.fQB;
            float f7 = this.fQy - (this.borderWidth / 2.0f);
            this.fQB[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.fQB;
            float f8 = this.fQx - (this.borderWidth / 2.0f);
            this.fQB[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void lB(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bGp();
        bGn();
        invalidate();
    }

    private void bGq() {
        if (!this.fQr) {
            this.fQt = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.fQz = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        lB(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.fQt = i;
        bGq();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.fQu = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        lB(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.fQv = i;
        lB(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.fQw = i;
        lB(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.fQx = i;
        lB(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.fQy = i;
        lB(true);
    }
}
