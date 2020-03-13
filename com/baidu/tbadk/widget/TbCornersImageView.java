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
    private float aFg;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean dHY;
    private boolean dHZ;
    private int dIa;
    private int dIb;
    private int dIc;
    private int dId;
    private int dIe;
    private int dIf;
    private float[] dIg;
    private float[] dIh;
    private RectF dIi;
    private RectF dIj;
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
        this.dIb = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 7) {
                this.dHZ = obtainStyledAttributes.getBoolean(index, this.dHZ);
            } else if (index == 4) {
                this.dHY = obtainStyledAttributes.getBoolean(index, this.dHY);
            } else if (index == 1) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == 2) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == 6) {
                this.dIa = obtainStyledAttributes.getDimensionPixelSize(index, this.dIa);
            } else if (index == 3) {
                this.dIb = obtainStyledAttributes.getColor(index, this.dIb);
            } else if (index == 0) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == 11) {
                this.dIc = obtainStyledAttributes.getDimensionPixelSize(index, this.dIc);
            } else if (index == 10) {
                this.dId = obtainStyledAttributes.getDimensionPixelSize(index, this.dId);
            } else if (index == 5) {
                this.dIe = obtainStyledAttributes.getDimensionPixelSize(index, this.dIe);
            } else if (index == 8) {
                this.dIf = obtainStyledAttributes.getDimensionPixelSize(index, this.dIf);
            } else if (index == 9) {
                this.maskColor = obtainStyledAttributes.getColor(index, this.maskColor);
            }
        }
        obtainStyledAttributes.recycle();
        this.dIg = new float[8];
        this.dIh = new float[8];
        this.dIj = new RectF();
        this.dIi = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        aSP();
        aSQ();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        aSN();
        aSO();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.dIi, null, 31);
        if (!this.dHZ) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.dIa * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.dIa * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.dHY) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.aFg, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.dIi, this.dIh, Path.Direction.CCW);
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
            path.addRect(this.dIi, Path.Direction.CW);
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
        if (this.dHY) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.aFg - (this.borderWidth / 2.0f));
            }
            if (this.dIa > 0) {
                a(canvas, this.dIa, this.dIb, (this.aFg - this.borderWidth) - (this.dIa / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.dIj, this.dIg);
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

    private void aSN() {
        if (!this.dHY) {
            this.dIj.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void aSO() {
        if (this.dHY) {
            this.aFg = Math.min(this.width, this.height) / 2.0f;
            this.dIi.set((this.width / 2.0f) - this.aFg, (this.height / 2.0f) - this.aFg, (this.width / 2.0f) + this.aFg, (this.height / 2.0f) + this.aFg);
            return;
        }
        this.dIi.set(0.0f, 0.0f, this.width, this.height);
        if (this.dHZ) {
            this.dIi = this.dIj;
        }
    }

    private void aSP() {
        if (!this.dHY) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.dIg.length; i++) {
                    this.dIg[i] = this.cornerRadius;
                    this.dIh[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.dIg;
            float[] fArr2 = this.dIg;
            float f = this.dIc;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.dIg;
            float[] fArr4 = this.dIg;
            float f2 = this.dId;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.dIg;
            float[] fArr6 = this.dIg;
            float f3 = this.dIf;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.dIg;
            float[] fArr8 = this.dIg;
            float f4 = this.dIe;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.dIh;
            float f5 = this.dIc - (this.borderWidth / 2.0f);
            this.dIh[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.dIh;
            float f6 = this.dId - (this.borderWidth / 2.0f);
            this.dIh[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.dIh;
            float f7 = this.dIf - (this.borderWidth / 2.0f);
            this.dIh[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.dIh;
            float f8 = this.dIe - (this.borderWidth / 2.0f);
            this.dIh[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void he(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        aSP();
        aSN();
        invalidate();
    }

    private void aSQ() {
        if (!this.dHY) {
            this.dIa = 0;
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
        this.dIa = i;
        aSQ();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.dIb = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        he(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.dIc = i;
        he(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.dId = i;
        he(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.dIe = i;
        he(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.dIf = i;
        he(true);
    }
}
