package com.baidu.tbadk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCornersImageView extends AppCompatImageView {
    private float aAe;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private int dDA;
    private int dDB;
    private int dDC;
    private float[] dDD;
    private float[] dDE;
    private RectF dDF;
    private RectF dDG;
    private Path dDH;
    private boolean dDv;
    private boolean dDw;
    private int dDx;
    private int dDy;
    private int dDz;
    private int height;
    private int maskColor;
    private Paint paint;
    private Path path;
    private int width;
    private Xfermode xfermode;

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
        this.dDy = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 7) {
                this.dDw = obtainStyledAttributes.getBoolean(index, this.dDw);
            } else if (index == 4) {
                this.dDv = obtainStyledAttributes.getBoolean(index, this.dDv);
            } else if (index == 1) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == 2) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == 6) {
                this.dDx = obtainStyledAttributes.getDimensionPixelSize(index, this.dDx);
            } else if (index == 3) {
                this.dDy = obtainStyledAttributes.getColor(index, this.dDy);
            } else if (index == 0) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == 11) {
                this.dDz = obtainStyledAttributes.getDimensionPixelSize(index, this.dDz);
            } else if (index == 10) {
                this.dDA = obtainStyledAttributes.getDimensionPixelSize(index, this.dDA);
            } else if (index == 5) {
                this.dDB = obtainStyledAttributes.getDimensionPixelSize(index, this.dDB);
            } else if (index == 8) {
                this.dDC = obtainStyledAttributes.getDimensionPixelSize(index, this.dDC);
            } else if (index == 9) {
                this.maskColor = obtainStyledAttributes.getColor(index, this.maskColor);
            }
        }
        obtainStyledAttributes.recycle();
        this.dDD = new float[8];
        this.dDE = new float[8];
        this.dDG = new RectF();
        this.dDF = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        if (Build.VERSION.SDK_INT <= 27) {
            this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.dDH = new Path();
        }
        aQc();
        aQd();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        aQa();
        aQb();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.dDF, null, 31);
        if (!this.dDw) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.dDx * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.dDx * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.dDv) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.aAe, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.dDF, this.dDE, Path.Direction.CCW);
        }
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setXfermode(this.xfermode);
        if (Build.VERSION.SDK_INT <= 27) {
            canvas.drawPath(this.path, this.paint);
        } else {
            this.dDH.addRect(this.dDF, Path.Direction.CCW);
            this.dDH.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(this.dDH, this.paint);
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
        if (this.dDv) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.aAe - (this.borderWidth / 2.0f));
            }
            if (this.dDx > 0) {
                a(canvas, this.dDx, this.dDy, (this.aAe - this.borderWidth) - (this.dDx / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.dDG, this.dDD);
        }
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        aG(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        aG(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void aG(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void aQa() {
        if (!this.dDv) {
            this.dDG.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void aQb() {
        if (this.dDv) {
            this.aAe = Math.min(this.width, this.height) / 2.0f;
            this.dDF.set((this.width / 2.0f) - this.aAe, (this.height / 2.0f) - this.aAe, (this.width / 2.0f) + this.aAe, (this.height / 2.0f) + this.aAe);
            return;
        }
        this.dDF.set(0.0f, 0.0f, this.width, this.height);
        if (this.dDw) {
            this.dDF = this.dDG;
        }
    }

    private void aQc() {
        if (!this.dDv) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.dDD.length; i++) {
                    this.dDD[i] = this.cornerRadius;
                    this.dDE[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.dDD;
            float[] fArr2 = this.dDD;
            float f = this.dDz;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.dDD;
            float[] fArr4 = this.dDD;
            float f2 = this.dDA;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.dDD;
            float[] fArr6 = this.dDD;
            float f3 = this.dDC;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.dDD;
            float[] fArr8 = this.dDD;
            float f4 = this.dDB;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.dDE;
            float f5 = this.dDz - (this.borderWidth / 2.0f);
            this.dDE[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.dDE;
            float f6 = this.dDA - (this.borderWidth / 2.0f);
            this.dDE[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.dDE;
            float f7 = this.dDC - (this.borderWidth / 2.0f);
            this.dDE[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.dDE;
            float f8 = this.dDB - (this.borderWidth / 2.0f);
            this.dDE[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void gS(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        aQc();
        aQa();
        invalidate();
    }

    private void aQd() {
        if (!this.dDv) {
            this.dDx = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.maskColor = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        gS(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.dDx = i;
        aQd();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.dDy = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        gS(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.dDz = i;
        gS(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.dDA = i;
        gS(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.dDB = i;
        gS(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.dDC = i;
        gS(true);
    }
}
