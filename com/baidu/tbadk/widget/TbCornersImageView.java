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
    private float biG;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean ewB;
    private boolean ewC;
    private int ewD;
    private int ewE;
    private int ewF;
    private int ewG;
    private int ewH;
    private int ewI;
    private int ewJ;
    private float[] ewK;
    private float[] ewL;
    private RectF ewM;
    private RectF ewN;
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
        this.ewE = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 7) {
                this.ewC = obtainStyledAttributes.getBoolean(index, this.ewC);
            } else if (index == 4) {
                this.ewB = obtainStyledAttributes.getBoolean(index, this.ewB);
            } else if (index == 1) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == 2) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == 6) {
                this.ewD = obtainStyledAttributes.getDimensionPixelSize(index, this.ewD);
            } else if (index == 3) {
                this.ewE = obtainStyledAttributes.getColor(index, this.ewE);
            } else if (index == 0) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == 11) {
                this.ewF = obtainStyledAttributes.getDimensionPixelSize(index, this.ewF);
            } else if (index == 10) {
                this.ewG = obtainStyledAttributes.getDimensionPixelSize(index, this.ewG);
            } else if (index == 5) {
                this.ewH = obtainStyledAttributes.getDimensionPixelSize(index, this.ewH);
            } else if (index == 8) {
                this.ewI = obtainStyledAttributes.getDimensionPixelSize(index, this.ewI);
            } else if (index == 9) {
                this.ewJ = obtainStyledAttributes.getColor(index, this.ewJ);
            }
        }
        obtainStyledAttributes.recycle();
        this.ewK = new float[8];
        this.ewL = new float[8];
        this.ewN = new RectF();
        this.ewM = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bhm();
        bhn();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bhk();
        bhl();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.ewM, null, 31);
        if (!this.ewC) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.ewD * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.ewD * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.ewB) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.biG, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.ewM, this.ewL, Path.Direction.CCW);
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
            path.addRect(this.ewM, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.ewJ != 0) {
            this.paint.setColor(this.ewJ);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        C(canvas);
    }

    private void C(Canvas canvas) {
        if (this.ewB) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.biG - (this.borderWidth / 2.0f));
            }
            if (this.ewD > 0) {
                a(canvas, this.ewD, this.ewE, (this.biG - this.borderWidth) - (this.ewD / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.ewN, this.ewK);
        }
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        aT(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        aT(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void aT(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void bhk() {
        if (!this.ewB) {
            this.ewN.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bhl() {
        if (this.ewB) {
            this.biG = Math.min(this.width, this.height) / 2.0f;
            this.ewM.set((this.width / 2.0f) - this.biG, (this.height / 2.0f) - this.biG, (this.width / 2.0f) + this.biG, (this.height / 2.0f) + this.biG);
            return;
        }
        this.ewM.set(0.0f, 0.0f, this.width, this.height);
        if (this.ewC) {
            this.ewM = this.ewN;
        }
    }

    private void bhm() {
        if (!this.ewB) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.ewK.length; i++) {
                    this.ewK[i] = this.cornerRadius;
                    this.ewL[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.ewK;
            float[] fArr2 = this.ewK;
            float f = this.ewF;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.ewK;
            float[] fArr4 = this.ewK;
            float f2 = this.ewG;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.ewK;
            float[] fArr6 = this.ewK;
            float f3 = this.ewI;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.ewK;
            float[] fArr8 = this.ewK;
            float f4 = this.ewH;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.ewL;
            float f5 = this.ewF - (this.borderWidth / 2.0f);
            this.ewL[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.ewL;
            float f6 = this.ewG - (this.borderWidth / 2.0f);
            this.ewL[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.ewL;
            float f7 = this.ewI - (this.borderWidth / 2.0f);
            this.ewL[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.ewL;
            float f8 = this.ewH - (this.borderWidth / 2.0f);
            this.ewL[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void iA(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bhm();
        bhk();
        invalidate();
    }

    private void bhn() {
        if (!this.ewB) {
            this.ewD = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.ewJ = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        iA(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.ewD = i;
        bhn();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.ewE = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        iA(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.ewF = i;
        iA(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.ewG = i;
        iA(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.ewH = i;
        iA(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.ewI = i;
        iA(true);
    }
}
