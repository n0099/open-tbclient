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
    private int cornerRadius;
    private boolean fHJ;
    private boolean fHK;
    private int fHL;
    private int fHM;
    private int fHN;
    private int fHO;
    private int fHP;
    private int fHQ;
    private int fHR;
    private float[] fHS;
    private float[] fHT;
    private RectF fHU;
    private RectF fHV;
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
        this.fHM = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CornersImageView_is_cover_src) {
                this.fHK = obtainStyledAttributes.getBoolean(index, this.fHK);
            } else if (index == R.styleable.CornersImageView_is_circle) {
                this.fHJ = obtainStyledAttributes.getBoolean(index, this.fHJ);
            } else if (index == R.styleable.CornersImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.CornersImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.CornersImageView_inner_border_width) {
                this.fHL = obtainStyledAttributes.getDimensionPixelSize(index, this.fHL);
            } else if (index == R.styleable.CornersImageView_inner_border_color) {
                this.fHM = obtainStyledAttributes.getColor(index, this.fHM);
            } else if (index == R.styleable.CornersImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.CornersImageView_corner_top_left_radius) {
                this.fHN = obtainStyledAttributes.getDimensionPixelSize(index, this.fHN);
            } else if (index == R.styleable.CornersImageView_corner_top_right_radius) {
                this.fHO = obtainStyledAttributes.getDimensionPixelSize(index, this.fHO);
            } else if (index == R.styleable.CornersImageView_corner_bottom_left_radius) {
                this.fHP = obtainStyledAttributes.getDimensionPixelSize(index, this.fHP);
            } else if (index == R.styleable.CornersImageView_corner_bottom_right_radius) {
                this.fHQ = obtainStyledAttributes.getDimensionPixelSize(index, this.fHQ);
            } else if (index == R.styleable.CornersImageView_mask_color) {
                this.fHR = obtainStyledAttributes.getColor(index, this.fHR);
            }
        }
        obtainStyledAttributes.recycle();
        this.fHS = new float[8];
        this.fHT = new float[8];
        this.fHV = new RectF();
        this.fHU = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bHp();
        bHq();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bHn();
        bHo();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.fHU, null, 31);
        if (!this.fHK) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.fHL * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.fHL * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.fHJ) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.radius, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.fHU, this.fHT, Path.Direction.CCW);
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
            path.addRect(this.fHU, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.fHR != 0) {
            this.paint.setColor(this.fHR);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        L(canvas);
    }

    private void L(Canvas canvas) {
        if (this.fHJ) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.radius - (this.borderWidth / 2.0f));
            }
            if (this.fHL > 0) {
                a(canvas, this.fHL, this.fHM, (this.radius - this.borderWidth) - (this.fHL / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.fHV, this.fHS);
        }
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        bl(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        bl(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void bl(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void bHn() {
        if (!this.fHJ) {
            this.fHV.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bHo() {
        if (this.fHJ) {
            this.radius = Math.min(this.width, this.height) / 2.0f;
            this.fHU.set((this.width / 2.0f) - this.radius, (this.height / 2.0f) - this.radius, (this.width / 2.0f) + this.radius, (this.height / 2.0f) + this.radius);
            return;
        }
        this.fHU.set(0.0f, 0.0f, this.width, this.height);
        if (this.fHK) {
            this.fHU = this.fHV;
        }
    }

    private void bHp() {
        if (!this.fHJ) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.fHS.length; i++) {
                    this.fHS[i] = this.cornerRadius;
                    this.fHT[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.fHS;
            float[] fArr2 = this.fHS;
            float f = this.fHN;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.fHS;
            float[] fArr4 = this.fHS;
            float f2 = this.fHO;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.fHS;
            float[] fArr6 = this.fHS;
            float f3 = this.fHQ;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.fHS;
            float[] fArr8 = this.fHS;
            float f4 = this.fHP;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.fHT;
            float f5 = this.fHN - (this.borderWidth / 2.0f);
            this.fHT[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.fHT;
            float f6 = this.fHO - (this.borderWidth / 2.0f);
            this.fHT[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.fHT;
            float f7 = this.fHQ - (this.borderWidth / 2.0f);
            this.fHT[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.fHT;
            float f8 = this.fHP - (this.borderWidth / 2.0f);
            this.fHT[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void lg(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bHp();
        bHn();
        invalidate();
    }

    private void bHq() {
        if (!this.fHJ) {
            this.fHL = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.fHR = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        lg(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.fHL = i;
        bHq();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.fHM = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        lg(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.fHN = i;
        lg(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.fHO = i;
        lg(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.fHP = i;
        lg(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.fHQ = i;
        lg(true);
    }
}
