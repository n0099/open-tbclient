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
    private float boe;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private float[] eMA;
    private RectF eMB;
    private RectF eMC;
    private boolean eMq;
    private boolean eMr;
    private int eMs;
    private int eMt;
    private int eMu;
    private int eMv;
    private int eMw;
    private int eMx;
    private int eMy;
    private float[] eMz;
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
        this.eMt = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CornersImageView_is_cover_src) {
                this.eMr = obtainStyledAttributes.getBoolean(index, this.eMr);
            } else if (index == R.styleable.CornersImageView_is_circle) {
                this.eMq = obtainStyledAttributes.getBoolean(index, this.eMq);
            } else if (index == R.styleable.CornersImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.CornersImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.CornersImageView_inner_border_width) {
                this.eMs = obtainStyledAttributes.getDimensionPixelSize(index, this.eMs);
            } else if (index == R.styleable.CornersImageView_inner_border_color) {
                this.eMt = obtainStyledAttributes.getColor(index, this.eMt);
            } else if (index == R.styleable.CornersImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.CornersImageView_corner_top_left_radius) {
                this.eMu = obtainStyledAttributes.getDimensionPixelSize(index, this.eMu);
            } else if (index == R.styleable.CornersImageView_corner_top_right_radius) {
                this.eMv = obtainStyledAttributes.getDimensionPixelSize(index, this.eMv);
            } else if (index == R.styleable.CornersImageView_corner_bottom_left_radius) {
                this.eMw = obtainStyledAttributes.getDimensionPixelSize(index, this.eMw);
            } else if (index == R.styleable.CornersImageView_corner_bottom_right_radius) {
                this.eMx = obtainStyledAttributes.getDimensionPixelSize(index, this.eMx);
            } else if (index == R.styleable.CornersImageView_mask_color) {
                this.eMy = obtainStyledAttributes.getColor(index, this.eMy);
            }
        }
        obtainStyledAttributes.recycle();
        this.eMz = new float[8];
        this.eMA = new float[8];
        this.eMC = new RectF();
        this.eMB = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        bnu();
        bnv();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        bns();
        bnt();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.eMB, null, 31);
        if (!this.eMr) {
            canvas.scale((((this.width - (this.borderWidth * 2)) - (this.eMs * 2)) * 1.0f) / this.width, (((this.height - (this.borderWidth * 2)) - (this.eMs * 2)) * 1.0f) / this.height, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.eMq) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.boe, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.eMB, this.eMA, Path.Direction.CCW);
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
            path.addRect(this.eMB, Path.Direction.CW);
            path.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.paint);
        }
        this.paint.setXfermode(null);
        if (this.eMy != 0) {
            this.paint.setColor(this.eMy);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        D(canvas);
    }

    private void D(Canvas canvas) {
        if (this.eMq) {
            if (this.borderWidth > 0) {
                a(canvas, this.borderWidth, this.borderColor, this.boe - (this.borderWidth / 2.0f));
            }
            if (this.eMs > 0) {
                a(canvas, this.eMs, this.eMt, (this.boe - this.borderWidth) - (this.eMs / 2.0f));
            }
        } else if (this.borderWidth > 0) {
            a(canvas, this.borderWidth, this.borderColor, this.eMC, this.eMz);
        }
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        ba(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        ba(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void ba(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void bns() {
        if (!this.eMq) {
            this.eMC.set(this.borderWidth / 2.0f, this.borderWidth / 2.0f, this.width - (this.borderWidth / 2.0f), this.height - (this.borderWidth / 2.0f));
        }
    }

    private void bnt() {
        if (this.eMq) {
            this.boe = Math.min(this.width, this.height) / 2.0f;
            this.eMB.set((this.width / 2.0f) - this.boe, (this.height / 2.0f) - this.boe, (this.width / 2.0f) + this.boe, (this.height / 2.0f) + this.boe);
            return;
        }
        this.eMB.set(0.0f, 0.0f, this.width, this.height);
        if (this.eMr) {
            this.eMB = this.eMC;
        }
    }

    private void bnu() {
        if (!this.eMq) {
            if (this.cornerRadius > 0) {
                for (int i = 0; i < this.eMz.length; i++) {
                    this.eMz[i] = this.cornerRadius;
                    this.eMA[i] = this.cornerRadius - (this.borderWidth / 2.0f);
                }
                return;
            }
            float[] fArr = this.eMz;
            float[] fArr2 = this.eMz;
            float f = this.eMu;
            fArr2[1] = f;
            fArr[0] = f;
            float[] fArr3 = this.eMz;
            float[] fArr4 = this.eMz;
            float f2 = this.eMv;
            fArr4[3] = f2;
            fArr3[2] = f2;
            float[] fArr5 = this.eMz;
            float[] fArr6 = this.eMz;
            float f3 = this.eMx;
            fArr6[5] = f3;
            fArr5[4] = f3;
            float[] fArr7 = this.eMz;
            float[] fArr8 = this.eMz;
            float f4 = this.eMw;
            fArr8[7] = f4;
            fArr7[6] = f4;
            float[] fArr9 = this.eMA;
            float f5 = this.eMu - (this.borderWidth / 2.0f);
            this.eMA[1] = f5;
            fArr9[0] = f5;
            float[] fArr10 = this.eMA;
            float f6 = this.eMv - (this.borderWidth / 2.0f);
            this.eMA[3] = f6;
            fArr10[2] = f6;
            float[] fArr11 = this.eMA;
            float f7 = this.eMx - (this.borderWidth / 2.0f);
            this.eMA[5] = f7;
            fArr11[4] = f7;
            float[] fArr12 = this.eMA;
            float f8 = this.eMw - (this.borderWidth / 2.0f);
            this.eMA[7] = f8;
            fArr12[6] = f8;
        }
    }

    private void jq(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        bnu();
        bns();
        invalidate();
    }

    private void bnv() {
        if (!this.eMq) {
            this.eMs = 0;
        }
    }

    public void setMaskColor(@ColorInt int i) {
        this.eMy = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        jq(false);
    }

    public void setBorderColor(@ColorInt int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.eMs = i;
        bnv();
        invalidate();
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.eMt = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
        jq(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.eMu = i;
        jq(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.eMv = i;
        jq(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.eMw = i;
        jq(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.eMx = i;
        jq(true);
    }
}
