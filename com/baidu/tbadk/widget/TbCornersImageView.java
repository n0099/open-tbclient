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
    private float aFu;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean dIo;
    private boolean dIp;
    private int dIq;
    private int dIr;
    private int dIs;
    private int dIt;
    private int dIu;
    private int dIv;
    private float[] dIw;
    private float[] dIx;
    private RectF dIy;
    private RectF dIz;
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
        this.dIr = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 7) {
                this.dIp = obtainStyledAttributes.getBoolean(index, this.dIp);
            } else if (index == 4) {
                this.dIo = obtainStyledAttributes.getBoolean(index, this.dIo);
            } else if (index == 1) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == 2) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == 6) {
                this.dIq = obtainStyledAttributes.getDimensionPixelSize(index, this.dIq);
            } else if (index == 3) {
                this.dIr = obtainStyledAttributes.getColor(index, this.dIr);
            } else if (index == 0) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == 11) {
                this.dIs = obtainStyledAttributes.getDimensionPixelSize(index, this.dIs);
            } else if (index == 10) {
                this.dIt = obtainStyledAttributes.getDimensionPixelSize(index, this.dIt);
            } else if (index == 5) {
                this.dIu = obtainStyledAttributes.getDimensionPixelSize(index, this.dIu);
            } else if (index == 8) {
                this.dIv = obtainStyledAttributes.getDimensionPixelSize(index, this.dIv);
            } else if (index == 9) {
                this.maskColor = obtainStyledAttributes.getColor(index, this.maskColor);
            }
        }
        obtainStyledAttributes.recycle();
        this.dIw = new float[8];
        this.dIx = new float[8];
        this.dIz = new RectF();
        this.dIy = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        aST();
        aSU();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        aSR();
        aSS();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.dIy, null, 31);
        if (!this.dIp) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.dIq * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.dIq * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.dIo) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.aFu, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.dIy, this.dIx, Path.Direction.CCW);
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
            path.addRect(this.dIy, Path.Direction.CW);
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
        if (this.dIo) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.aFu - (this.borderWidth / 2.0f));
            }
            if (this.dIq > 0) {
                a(canvas, this.dIq, this.dIr, (this.aFu - this.borderWidth) - (this.dIq / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.dIz, this.dIw);
        }
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        aL(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        aL(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void aL(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void aSR() {
        if (!this.dIo) {
            this.dIz.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void aSS() {
        if (this.dIo) {
            this.aFu = Math.min(this.width, this.height) / 2.0f;
            this.dIy.set((this.width / 2.0f) - this.aFu, (this.height / 2.0f) - this.aFu, (this.width / 2.0f) + this.aFu, (this.height / 2.0f) + this.aFu);
            return;
        }
        this.dIy.set(0.0f, 0.0f, this.width, this.height);
        if (this.dIp) {
            this.dIy = this.dIz;
        }
    }

    private void aST() {
        if (!this.dIo) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.dIw.length; i++) {
                    this.dIw[i] = this.cornerRadius;
                    this.dIx[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.dIw;
            float[] fArr2 = this.dIw;
            float f = this.dIs;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.dIw;
            float[] fArr4 = this.dIw;
            float f2 = this.dIt;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.dIw;
            float[] fArr6 = this.dIw;
            float f3 = this.dIv;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.dIw;
            float[] fArr8 = this.dIw;
            float f4 = this.dIu;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.dIx;
            float f5 = this.dIs - (this.borderWidth / 2.0f);
            this.dIx[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.dIx;
            float f6 = this.dIt - (this.borderWidth / 2.0f);
            this.dIx[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.dIx;
            float f7 = this.dIv - (this.borderWidth / 2.0f);
            this.dIx[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.dIx;
            float f8 = this.dIu - (this.borderWidth / 2.0f);
            this.dIx[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void hf(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        aST();
        aSR();
        invalidate();
    }

    private void aSU() {
        if (!this.dIo) {
            this.dIq = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.maskColor = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        hf(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.dIq = i;
        aSU();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.dIr = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        hf(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.dIs = i;
        hf(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.dIt = i;
        hf(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.dIu = i;
        hf(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.dIv = i;
        hf(true);
    }
}
