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
    private boolean fOR;
    private boolean fOS;
    private int fOT;
    private int fOU;
    private int fOV;
    private int fOW;
    private int fOX;
    private int fOY;
    private int fOZ;
    private float[] fPa;
    private float[] fPb;
    private RectF fPc;
    private RectF fPd;
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
        this.fOU = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CornersImageView_is_cover_src) {
                this.fOS = obtainStyledAttributes.getBoolean(index, this.fOS);
            } else if (index == R.styleable.CornersImageView_is_circle) {
                this.fOR = obtainStyledAttributes.getBoolean(index, this.fOR);
            } else if (index == R.styleable.CornersImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.CornersImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.CornersImageView_inner_border_width) {
                this.fOT = obtainStyledAttributes.getDimensionPixelSize(index, this.fOT);
            } else if (index == R.styleable.CornersImageView_inner_border_color) {
                this.fOU = obtainStyledAttributes.getColor(index, this.fOU);
            } else if (index == R.styleable.CornersImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.CornersImageView_corner_top_left_radius) {
                this.fOV = obtainStyledAttributes.getDimensionPixelSize(index, this.fOV);
            } else if (index == R.styleable.CornersImageView_corner_top_right_radius) {
                this.fOW = obtainStyledAttributes.getDimensionPixelSize(index, this.fOW);
            } else if (index == R.styleable.CornersImageView_corner_bottom_left_radius) {
                this.fOX = obtainStyledAttributes.getDimensionPixelSize(index, this.fOX);
            } else if (index == R.styleable.CornersImageView_corner_bottom_right_radius) {
                this.fOY = obtainStyledAttributes.getDimensionPixelSize(index, this.fOY);
            } else if (index == R.styleable.CornersImageView_mask_color) {
                this.fOZ = obtainStyledAttributes.getColor(index, this.fOZ);
            }
        }
        obtainStyledAttributes.recycle();
        this.fPa = new float[8];
        this.fPb = new float[8];
        this.fPd = new RectF();
        this.fPc = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bGl();
        bGm();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bGj();
        bGk();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.fPc, null, 31);
        if (!this.fOS) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.fOT * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.fOT * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.fOR) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.radius, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.fPc, this.fPb, Path.Direction.CCW);
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
            path.addRect(this.fPc, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.fOZ != 0) {
            this.paint.setColor(this.fOZ);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        R(canvas);
    }

    private void R(Canvas canvas) {
        if (this.fOR) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.radius - (this.borderWidth / 2.0f));
            }
            if (this.fOT > 0) {
                a(canvas, this.fOT, this.fOU, (this.radius - this.borderWidth) - (this.fOT / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.fPd, this.fPa);
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

    private void bGj() {
        if (!this.fOR) {
            this.fPd.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bGk() {
        if (this.fOR) {
            this.radius = Math.min(this.width, this.height) / 2.0f;
            this.fPc.set((this.width / 2.0f) - this.radius, (this.height / 2.0f) - this.radius, (this.width / 2.0f) + this.radius, (this.height / 2.0f) + this.radius);
            return;
        }
        this.fPc.set(0.0f, 0.0f, this.width, this.height);
        if (this.fOS) {
            this.fPc = this.fPd;
        }
    }

    private void bGl() {
        if (!this.fOR) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.fPa.length; i++) {
                    this.fPa[i] = this.cornerRadius;
                    this.fPb[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.fPa;
            float[] fArr2 = this.fPa;
            float f = this.fOV;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.fPa;
            float[] fArr4 = this.fPa;
            float f2 = this.fOW;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.fPa;
            float[] fArr6 = this.fPa;
            float f3 = this.fOY;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.fPa;
            float[] fArr8 = this.fPa;
            float f4 = this.fOX;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.fPb;
            float f5 = this.fOV - (this.borderWidth / 2.0f);
            this.fPb[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.fPb;
            float f6 = this.fOW - (this.borderWidth / 2.0f);
            this.fPb[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.fPb;
            float f7 = this.fOY - (this.borderWidth / 2.0f);
            this.fPb[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.fPb;
            float f8 = this.fOX - (this.borderWidth / 2.0f);
            this.fPb[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void lB(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bGl();
        bGj();
        invalidate();
    }

    private void bGm() {
        if (!this.fOR) {
            this.fOT = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.fOZ = i;
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
        this.fOT = i;
        bGm();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.fOU = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        lB(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.fOV = i;
        lB(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.fOW = i;
        lB(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.fOX = i;
        lB(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.fOY = i;
        lB(true);
    }
}
