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
    private float aAO;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean dDF;
    private boolean dDG;
    private int dDH;
    private int dDI;
    private int dDJ;
    private int dDK;
    private int dDL;
    private int dDM;
    private float[] dDN;
    private float[] dDO;
    private RectF dDP;
    private RectF dDQ;
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
        this.dDI = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 7) {
                this.dDG = obtainStyledAttributes.getBoolean(index, this.dDG);
            } else if (index == 4) {
                this.dDF = obtainStyledAttributes.getBoolean(index, this.dDF);
            } else if (index == 1) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == 2) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == 6) {
                this.dDH = obtainStyledAttributes.getDimensionPixelSize(index, this.dDH);
            } else if (index == 3) {
                this.dDI = obtainStyledAttributes.getColor(index, this.dDI);
            } else if (index == 0) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == 11) {
                this.dDJ = obtainStyledAttributes.getDimensionPixelSize(index, this.dDJ);
            } else if (index == 10) {
                this.dDK = obtainStyledAttributes.getDimensionPixelSize(index, this.dDK);
            } else if (index == 5) {
                this.dDL = obtainStyledAttributes.getDimensionPixelSize(index, this.dDL);
            } else if (index == 8) {
                this.dDM = obtainStyledAttributes.getDimensionPixelSize(index, this.dDM);
            } else if (index == 9) {
                this.maskColor = obtainStyledAttributes.getColor(index, this.maskColor);
            }
        }
        obtainStyledAttributes.recycle();
        this.dDN = new float[8];
        this.dDO = new float[8];
        this.dDQ = new RectF();
        this.dDP = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        aQv();
        aQw();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        aQt();
        aQu();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.dDP, null, 31);
        if (!this.dDG) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.dDH * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.dDH * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.dDF) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.aAO, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.dDP, this.dDO, Path.Direction.CCW);
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
            path.addRect(this.dDP, Path.Direction.CW);
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
        if (this.dDF) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.aAO - (this.borderWidth / 2.0f));
            }
            if (this.dDH > 0) {
                a(canvas, this.dDH, this.dDI, (this.aAO - this.borderWidth) - (this.dDH / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.dDQ, this.dDN);
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

    private void aQt() {
        if (!this.dDF) {
            this.dDQ.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void aQu() {
        if (this.dDF) {
            this.aAO = Math.min(this.width, this.height) / 2.0f;
            this.dDP.set((this.width / 2.0f) - this.aAO, (this.height / 2.0f) - this.aAO, (this.width / 2.0f) + this.aAO, (this.height / 2.0f) + this.aAO);
            return;
        }
        this.dDP.set(0.0f, 0.0f, this.width, this.height);
        if (this.dDG) {
            this.dDP = this.dDQ;
        }
    }

    private void aQv() {
        if (!this.dDF) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.dDN.length; i++) {
                    this.dDN[i] = this.cornerRadius;
                    this.dDO[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.dDN;
            float[] fArr2 = this.dDN;
            float f = this.dDJ;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.dDN;
            float[] fArr4 = this.dDN;
            float f2 = this.dDK;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.dDN;
            float[] fArr6 = this.dDN;
            float f3 = this.dDM;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.dDN;
            float[] fArr8 = this.dDN;
            float f4 = this.dDL;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.dDO;
            float f5 = this.dDJ - (this.borderWidth / 2.0f);
            this.dDO[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.dDO;
            float f6 = this.dDK - (this.borderWidth / 2.0f);
            this.dDO[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.dDO;
            float f7 = this.dDM - (this.borderWidth / 2.0f);
            this.dDO[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.dDO;
            float f8 = this.dDL - (this.borderWidth / 2.0f);
            this.dDO[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void gX(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        aQv();
        aQt();
        invalidate();
    }

    private void aQw() {
        if (!this.dDF) {
            this.dDH = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.maskColor = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        gX(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.dDH = i;
        aQw();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.dDI = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        gX(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.dDJ = i;
        gX(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.dDK = i;
        gX(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.dDL = i;
        gX(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.dDM = i;
        gX(true);
    }
}
