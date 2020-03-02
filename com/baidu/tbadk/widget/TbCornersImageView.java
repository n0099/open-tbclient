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
    private float aFf;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean dHL;
    private boolean dHM;
    private int dHN;
    private int dHO;
    private int dHP;
    private int dHQ;
    private int dHR;
    private int dHS;
    private float[] dHT;
    private float[] dHU;
    private RectF dHV;
    private RectF dHW;
    private int height;
    private int maskColor;
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
        this.dHO = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 7) {
                this.dHM = obtainStyledAttributes.getBoolean(index, this.dHM);
            } else if (index == 4) {
                this.dHL = obtainStyledAttributes.getBoolean(index, this.dHL);
            } else if (index == 1) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == 2) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == 6) {
                this.dHN = obtainStyledAttributes.getDimensionPixelSize(index, this.dHN);
            } else if (index == 3) {
                this.dHO = obtainStyledAttributes.getColor(index, this.dHO);
            } else if (index == 0) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == 11) {
                this.dHP = obtainStyledAttributes.getDimensionPixelSize(index, this.dHP);
            } else if (index == 10) {
                this.dHQ = obtainStyledAttributes.getDimensionPixelSize(index, this.dHQ);
            } else if (index == 5) {
                this.dHR = obtainStyledAttributes.getDimensionPixelSize(index, this.dHR);
            } else if (index == 8) {
                this.dHS = obtainStyledAttributes.getDimensionPixelSize(index, this.dHS);
            } else if (index == 9) {
                this.maskColor = obtainStyledAttributes.getColor(index, this.maskColor);
            }
        }
        obtainStyledAttributes.recycle();
        this.dHT = new float[8];
        this.dHU = new float[8];
        this.dHW = new RectF();
        this.dHV = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        aSO();
        aSP();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        aSM();
        aSN();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.dHV, null, 31);
        if (!this.dHM) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.dHN * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.dHN * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.dHL) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.aFf, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.dHV, this.dHU, Path.Direction.CCW);
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
            path.addRect(this.dHV, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.maskColor != 0) {
            this.paint.setColor(this.maskColor);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        A(canvas);
    }

    private void A(Canvas canvas) {
        if (this.dHL) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.aFf - (this.borderWidth / 2.0f));
            }
            if (this.dHN > 0) {
                a(canvas, this.dHN, this.dHO, (this.aFf - this.borderWidth) - (this.dHN / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.dHW, this.dHT);
        }
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        aK(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        aK(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void aK(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void aSM() {
        if (!this.dHL) {
            this.dHW.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void aSN() {
        if (this.dHL) {
            this.aFf = Math.min(this.width, this.height) / 2.0f;
            this.dHV.set((this.width / 2.0f) - this.aFf, (this.height / 2.0f) - this.aFf, (this.width / 2.0f) + this.aFf, (this.height / 2.0f) + this.aFf);
            return;
        }
        this.dHV.set(0.0f, 0.0f, this.width, this.height);
        if (this.dHM) {
            this.dHV = this.dHW;
        }
    }

    private void aSO() {
        if (!this.dHL) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.dHT.length; i++) {
                    this.dHT[i] = this.cornerRadius;
                    this.dHU[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.dHT;
            float[] fArr2 = this.dHT;
            float f = this.dHP;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.dHT;
            float[] fArr4 = this.dHT;
            float f2 = this.dHQ;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.dHT;
            float[] fArr6 = this.dHT;
            float f3 = this.dHS;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.dHT;
            float[] fArr8 = this.dHT;
            float f4 = this.dHR;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.dHU;
            float f5 = this.dHP - (this.borderWidth / 2.0f);
            this.dHU[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.dHU;
            float f6 = this.dHQ - (this.borderWidth / 2.0f);
            this.dHU[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.dHU;
            float f7 = this.dHS - (this.borderWidth / 2.0f);
            this.dHU[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.dHU;
            float f8 = this.dHR - (this.borderWidth / 2.0f);
            this.dHU[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void he(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        aSO();
        aSM();
        invalidate();
    }

    private void aSP() {
        if (!this.dHL) {
            this.dHN = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.maskColor = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        he(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.dHN = i;
        aSP();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.dHO = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        he(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.dHP = i;
        he(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.dHQ = i;
        he(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.dHR = i;
        he(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.dHS = i;
        he(true);
    }
}
