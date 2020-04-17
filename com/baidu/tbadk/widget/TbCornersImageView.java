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
    private float bbb;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean eie;
    private boolean eif;
    private int eig;
    private int eih;
    private int eii;
    private int eij;
    private int eik;
    private int eil;
    private int eim;
    private float[] ein;
    private float[] eio;
    private RectF eip;
    private RectF eiq;
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
        this.eih = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 7) {
                this.eif = obtainStyledAttributes.getBoolean(index, this.eif);
            } else if (index == 4) {
                this.eie = obtainStyledAttributes.getBoolean(index, this.eie);
            } else if (index == 1) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == 2) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == 6) {
                this.eig = obtainStyledAttributes.getDimensionPixelSize(index, this.eig);
            } else if (index == 3) {
                this.eih = obtainStyledAttributes.getColor(index, this.eih);
            } else if (index == 0) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == 11) {
                this.eii = obtainStyledAttributes.getDimensionPixelSize(index, this.eii);
            } else if (index == 10) {
                this.eij = obtainStyledAttributes.getDimensionPixelSize(index, this.eij);
            } else if (index == 5) {
                this.eik = obtainStyledAttributes.getDimensionPixelSize(index, this.eik);
            } else if (index == 8) {
                this.eil = obtainStyledAttributes.getDimensionPixelSize(index, this.eil);
            } else if (index == 9) {
                this.eim = obtainStyledAttributes.getColor(index, this.eim);
            }
        }
        obtainStyledAttributes.recycle();
        this.ein = new float[8];
        this.eio = new float[8];
        this.eiq = new RectF();
        this.eip = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bbd();
        bbe();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bbb();
        bbc();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.eip, null, 31);
        if (!this.eif) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.eig * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.eig * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.eie) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.bbb, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.eip, this.eio, Path.Direction.CCW);
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
            path.addRect(this.eip, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.eim != 0) {
            this.paint.setColor(this.eim);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        B(canvas);
    }

    private void B(Canvas canvas) {
        if (this.eie) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.bbb - (this.borderWidth / 2.0f));
            }
            if (this.eig > 0) {
                a(canvas, this.eig, this.eih, (this.bbb - this.borderWidth) - (this.eig / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.eiq, this.ein);
        }
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        aP(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        aP(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void aP(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void bbb() {
        if (!this.eie) {
            this.eiq.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bbc() {
        if (this.eie) {
            this.bbb = Math.min(this.width, this.height) / 2.0f;
            this.eip.set((this.width / 2.0f) - this.bbb, (this.height / 2.0f) - this.bbb, (this.width / 2.0f) + this.bbb, (this.height / 2.0f) + this.bbb);
            return;
        }
        this.eip.set(0.0f, 0.0f, this.width, this.height);
        if (this.eif) {
            this.eip = this.eiq;
        }
    }

    private void bbd() {
        if (!this.eie) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.ein.length; i++) {
                    this.ein[i] = this.cornerRadius;
                    this.eio[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.ein;
            float[] fArr2 = this.ein;
            float f = this.eii;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.ein;
            float[] fArr4 = this.ein;
            float f2 = this.eij;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.ein;
            float[] fArr6 = this.ein;
            float f3 = this.eil;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.ein;
            float[] fArr8 = this.ein;
            float f4 = this.eik;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.eio;
            float f5 = this.eii - (this.borderWidth / 2.0f);
            this.eio[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.eio;
            float f6 = this.eij - (this.borderWidth / 2.0f);
            this.eio[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.eio;
            float f7 = this.eil - (this.borderWidth / 2.0f);
            this.eio[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.eio;
            float f8 = this.eik - (this.borderWidth / 2.0f);
            this.eio[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void id(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bbd();
        bbb();
        invalidate();
    }

    private void bbe() {
        if (!this.eie) {
            this.eig = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.eim = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        id(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.eig = i;
        bbe();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.eih = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        id(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.eii = i;
        id(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.eij = i;
        id(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.eik = i;
        id(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.eil = i;
        id(true);
    }
}
