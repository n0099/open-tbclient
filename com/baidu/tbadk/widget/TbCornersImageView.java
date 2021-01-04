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
    private boolean fRl;
    private boolean fRm;
    private int fRn;
    private int fRo;
    private int fRp;
    private int fRq;
    private int fRr;
    private int fRs;
    private int fRt;
    private float[] fRu;
    private float[] fRv;
    private RectF fRw;
    private RectF fRx;
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
        this.fRo = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CornersImageView_is_cover_src) {
                this.fRm = obtainStyledAttributes.getBoolean(index, this.fRm);
            } else if (index == R.styleable.CornersImageView_is_circle) {
                this.fRl = obtainStyledAttributes.getBoolean(index, this.fRl);
            } else if (index == R.styleable.CornersImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.CornersImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.CornersImageView_inner_border_width) {
                this.fRn = obtainStyledAttributes.getDimensionPixelSize(index, this.fRn);
            } else if (index == R.styleable.CornersImageView_inner_border_color) {
                this.fRo = obtainStyledAttributes.getColor(index, this.fRo);
            } else if (index == R.styleable.CornersImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.CornersImageView_corner_top_left_radius) {
                this.fRp = obtainStyledAttributes.getDimensionPixelSize(index, this.fRp);
            } else if (index == R.styleable.CornersImageView_corner_top_right_radius) {
                this.fRq = obtainStyledAttributes.getDimensionPixelSize(index, this.fRq);
            } else if (index == R.styleable.CornersImageView_corner_bottom_left_radius) {
                this.fRr = obtainStyledAttributes.getDimensionPixelSize(index, this.fRr);
            } else if (index == R.styleable.CornersImageView_corner_bottom_right_radius) {
                this.fRs = obtainStyledAttributes.getDimensionPixelSize(index, this.fRs);
            } else if (index == R.styleable.CornersImageView_mask_color) {
                this.fRt = obtainStyledAttributes.getColor(index, this.fRt);
            }
        }
        obtainStyledAttributes.recycle();
        this.fRu = new float[8];
        this.fRv = new float[8];
        this.fRx = new RectF();
        this.fRw = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bJI();
        bJJ();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bJG();
        bJH();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.fRw, null, 31);
        if (!this.fRm) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.fRn * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.fRn * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.fRl) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.radius, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.fRw, this.fRv, Path.Direction.CCW);
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
            path.addRect(this.fRw, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.fRt != 0) {
            this.paint.setColor(this.fRt);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        R(canvas);
    }

    private void R(Canvas canvas) {
        if (this.fRl) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.radius - (this.borderWidth / 2.0f));
            }
            if (this.fRn > 0) {
                a(canvas, this.fRn, this.fRo, (this.radius - this.borderWidth) - (this.fRn / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.fRx, this.fRu);
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

    private void bJG() {
        if (!this.fRl) {
            this.fRx.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bJH() {
        if (this.fRl) {
            this.radius = Math.min(this.width, this.height) / 2.0f;
            this.fRw.set((this.width / 2.0f) - this.radius, (this.height / 2.0f) - this.radius, (this.width / 2.0f) + this.radius, (this.height / 2.0f) + this.radius);
            return;
        }
        this.fRw.set(0.0f, 0.0f, this.width, this.height);
        if (this.fRm) {
            this.fRw = this.fRx;
        }
    }

    private void bJI() {
        if (!this.fRl) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.fRu.length; i++) {
                    this.fRu[i] = this.cornerRadius;
                    this.fRv[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.fRu;
            float[] fArr2 = this.fRu;
            float f = this.fRp;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.fRu;
            float[] fArr4 = this.fRu;
            float f2 = this.fRq;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.fRu;
            float[] fArr6 = this.fRu;
            float f3 = this.fRs;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.fRu;
            float[] fArr8 = this.fRu;
            float f4 = this.fRr;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.fRv;
            float f5 = this.fRp - (this.borderWidth / 2.0f);
            this.fRv[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.fRv;
            float f6 = this.fRq - (this.borderWidth / 2.0f);
            this.fRv[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.fRv;
            float f7 = this.fRs - (this.borderWidth / 2.0f);
            this.fRv[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.fRv;
            float f8 = this.fRr - (this.borderWidth / 2.0f);
            this.fRv[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void lC(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bJI();
        bJG();
        invalidate();
    }

    private void bJJ() {
        if (!this.fRl) {
            this.fRn = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.fRt = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        lC(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.fRn = i;
        bJJ();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.fRo = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        lC(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.fRp = i;
        lC(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.fRq = i;
        lC(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.fRr = i;
        lC(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.fRs = i;
        lC(true);
    }
}
