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
    private float btT;
    private int cornerRadius;
    private boolean eXa;
    private boolean eXb;
    private int eXc;
    private int eXd;
    private int eXe;
    private int eXf;
    private int eXg;
    private int eXh;
    private int eXi;
    private float[] eXj;
    private float[] eXk;
    private RectF eXl;
    private RectF eXm;
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
        this.eXd = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CornersImageView_is_cover_src) {
                this.eXb = obtainStyledAttributes.getBoolean(index, this.eXb);
            } else if (index == R.styleable.CornersImageView_is_circle) {
                this.eXa = obtainStyledAttributes.getBoolean(index, this.eXa);
            } else if (index == R.styleable.CornersImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.CornersImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.CornersImageView_inner_border_width) {
                this.eXc = obtainStyledAttributes.getDimensionPixelSize(index, this.eXc);
            } else if (index == R.styleable.CornersImageView_inner_border_color) {
                this.eXd = obtainStyledAttributes.getColor(index, this.eXd);
            } else if (index == R.styleable.CornersImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.CornersImageView_corner_top_left_radius) {
                this.eXe = obtainStyledAttributes.getDimensionPixelSize(index, this.eXe);
            } else if (index == R.styleable.CornersImageView_corner_top_right_radius) {
                this.eXf = obtainStyledAttributes.getDimensionPixelSize(index, this.eXf);
            } else if (index == R.styleable.CornersImageView_corner_bottom_left_radius) {
                this.eXg = obtainStyledAttributes.getDimensionPixelSize(index, this.eXg);
            } else if (index == R.styleable.CornersImageView_corner_bottom_right_radius) {
                this.eXh = obtainStyledAttributes.getDimensionPixelSize(index, this.eXh);
            } else if (index == R.styleable.CornersImageView_mask_color) {
                this.eXi = obtainStyledAttributes.getColor(index, this.eXi);
            }
        }
        obtainStyledAttributes.recycle();
        this.eXj = new float[8];
        this.eXk = new float[8];
        this.eXm = new RectF();
        this.eXl = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bwj();
        bwk();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bwh();
        bwi();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.eXl, null, 31);
        if (!this.eXb) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.eXc * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.eXc * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.eXa) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.btT, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.eXl, this.eXk, Path.Direction.CCW);
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
            path.addRect(this.eXl, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.eXi != 0) {
            this.paint.setColor(this.eXi);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        I(canvas);
    }

    private void I(Canvas canvas) {
        if (this.eXa) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.btT - (this.borderWidth / 2.0f));
            }
            if (this.eXc > 0) {
                a(canvas, this.eXc, this.eXd, (this.btT - this.borderWidth) - (this.eXc / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.eXm, this.eXj);
        }
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        bj(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        bj(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void bj(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void bwh() {
        if (!this.eXa) {
            this.eXm.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bwi() {
        if (this.eXa) {
            this.btT = Math.min(this.width, this.height) / 2.0f;
            this.eXl.set((this.width / 2.0f) - this.btT, (this.height / 2.0f) - this.btT, (this.width / 2.0f) + this.btT, (this.height / 2.0f) + this.btT);
            return;
        }
        this.eXl.set(0.0f, 0.0f, this.width, this.height);
        if (this.eXb) {
            this.eXl = this.eXm;
        }
    }

    private void bwj() {
        if (!this.eXa) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.eXj.length; i++) {
                    this.eXj[i] = this.cornerRadius;
                    this.eXk[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.eXj;
            float[] fArr2 = this.eXj;
            float f = this.eXe;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.eXj;
            float[] fArr4 = this.eXj;
            float f2 = this.eXf;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.eXj;
            float[] fArr6 = this.eXj;
            float f3 = this.eXh;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.eXj;
            float[] fArr8 = this.eXj;
            float f4 = this.eXg;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.eXk;
            float f5 = this.eXe - (this.borderWidth / 2.0f);
            this.eXk[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.eXk;
            float f6 = this.eXf - (this.borderWidth / 2.0f);
            this.eXk[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.eXk;
            float f7 = this.eXh - (this.borderWidth / 2.0f);
            this.eXk[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.eXk;
            float f8 = this.eXg - (this.borderWidth / 2.0f);
            this.eXk[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void jQ(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bwj();
        bwh();
        invalidate();
    }

    private void bwk() {
        if (!this.eXa) {
            this.eXc = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.eXi = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        jQ(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.eXc = i;
        bwk();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.eXd = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        jQ(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.eXe = i;
        jQ(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.eXf = i;
        jQ(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.eXg = i;
        jQ(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.eXh = i;
        jQ(true);
    }
}
