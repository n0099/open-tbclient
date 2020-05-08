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
    private float bbg;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean eij;
    private boolean eik;
    private int eil;
    private int eim;
    private int ein;
    private int eio;
    private int eip;
    private int eiq;
    private int eir;
    private float[] eis;
    private float[] eit;
    private RectF eiu;
    private RectF eiv;
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
        this.eim = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 7) {
                this.eik = obtainStyledAttributes.getBoolean(index, this.eik);
            } else if (index == 4) {
                this.eij = obtainStyledAttributes.getBoolean(index, this.eij);
            } else if (index == 1) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == 2) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == 6) {
                this.eil = obtainStyledAttributes.getDimensionPixelSize(index, this.eil);
            } else if (index == 3) {
                this.eim = obtainStyledAttributes.getColor(index, this.eim);
            } else if (index == 0) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == 11) {
                this.ein = obtainStyledAttributes.getDimensionPixelSize(index, this.ein);
            } else if (index == 10) {
                this.eio = obtainStyledAttributes.getDimensionPixelSize(index, this.eio);
            } else if (index == 5) {
                this.eip = obtainStyledAttributes.getDimensionPixelSize(index, this.eip);
            } else if (index == 8) {
                this.eiq = obtainStyledAttributes.getDimensionPixelSize(index, this.eiq);
            } else if (index == 9) {
                this.eir = obtainStyledAttributes.getColor(index, this.eir);
            }
        }
        obtainStyledAttributes.recycle();
        this.eis = new float[8];
        this.eit = new float[8];
        this.eiv = new RectF();
        this.eiu = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bbb();
        bbc();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        baZ();
        bba();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.eiu, null, 31);
        if (!this.eik) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.eil * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.eil * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.eij) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.bbg, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.eiu, this.eit, Path.Direction.CCW);
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
            path.addRect(this.eiu, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.eir != 0) {
            this.paint.setColor(this.eir);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        B(canvas);
    }

    private void B(Canvas canvas) {
        if (this.eij) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.bbg - (this.borderWidth / 2.0f));
            }
            if (this.eil > 0) {
                a(canvas, this.eil, this.eim, (this.bbg - this.borderWidth) - (this.eil / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.eiv, this.eis);
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

    private void baZ() {
        if (!this.eij) {
            this.eiv.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bba() {
        if (this.eij) {
            this.bbg = Math.min(this.width, this.height) / 2.0f;
            this.eiu.set((this.width / 2.0f) - this.bbg, (this.height / 2.0f) - this.bbg, (this.width / 2.0f) + this.bbg, (this.height / 2.0f) + this.bbg);
            return;
        }
        this.eiu.set(0.0f, 0.0f, this.width, this.height);
        if (this.eik) {
            this.eiu = this.eiv;
        }
    }

    private void bbb() {
        if (!this.eij) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.eis.length; i++) {
                    this.eis[i] = this.cornerRadius;
                    this.eit[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.eis;
            float[] fArr2 = this.eis;
            float f = this.ein;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.eis;
            float[] fArr4 = this.eis;
            float f2 = this.eio;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.eis;
            float[] fArr6 = this.eis;
            float f3 = this.eiq;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.eis;
            float[] fArr8 = this.eis;
            float f4 = this.eip;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.eit;
            float f5 = this.ein - (this.borderWidth / 2.0f);
            this.eit[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.eit;
            float f6 = this.eio - (this.borderWidth / 2.0f);
            this.eit[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.eit;
            float f7 = this.eiq - (this.borderWidth / 2.0f);
            this.eit[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.eit;
            float f8 = this.eip - (this.borderWidth / 2.0f);
            this.eit[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void id(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bbb();
        baZ();
        invalidate();
    }

    private void bbc() {
        if (!this.eij) {
            this.eil = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.eir = i;
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
        this.eil = i;
        bbc();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.eim = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        id(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.ein = i;
        id(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.eio = i;
        id(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.eip = i;
        id(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.eiq = i;
        id(true);
    }
}
