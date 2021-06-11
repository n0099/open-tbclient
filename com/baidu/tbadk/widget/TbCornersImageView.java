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
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.tieba.R$styleable;
/* loaded from: classes3.dex */
public class TbCornersImageView extends AppCompatImageView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f13097e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13098f;

    /* renamed from: g  reason: collision with root package name */
    public int f13099g;

    /* renamed from: h  reason: collision with root package name */
    public int f13100h;

    /* renamed from: i  reason: collision with root package name */
    public int f13101i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public float[] t;
    public float[] u;
    public RectF v;
    public RectF w;
    public Paint x;
    public Path y;

    public TbCornersImageView(Context context) {
        this(context, null);
    }

    public final void a() {
        if (this.f13097e) {
            return;
        }
        int i2 = 0;
        if (this.k <= 0) {
            float[] fArr = this.t;
            int i3 = this.l;
            float f2 = i3;
            fArr[1] = f2;
            fArr[0] = f2;
            int i4 = this.m;
            float f3 = i4;
            fArr[3] = f3;
            fArr[2] = f3;
            int i5 = this.o;
            float f4 = i5;
            fArr[5] = f4;
            fArr[4] = f4;
            int i6 = this.n;
            float f5 = i6;
            fArr[7] = f5;
            fArr[6] = f5;
            float[] fArr2 = this.u;
            int i7 = this.f13099g;
            float f6 = i3 - (i7 / 2.0f);
            fArr2[1] = f6;
            fArr2[0] = f6;
            float f7 = i4 - (i7 / 2.0f);
            fArr2[3] = f7;
            fArr2[2] = f7;
            float f8 = i5 - (i7 / 2.0f);
            fArr2[5] = f8;
            fArr2[4] = f8;
            float f9 = i6 - (i7 / 2.0f);
            fArr2[7] = f9;
            fArr2[6] = f9;
            return;
        }
        while (true) {
            float[] fArr3 = this.t;
            if (i2 >= fArr3.length) {
                return;
            }
            int i8 = this.k;
            fArr3[i2] = i8;
            this.u[i2] = i8 - (this.f13099g / 2.0f);
            i2++;
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.k = 0;
        }
        a();
        r();
        invalidate();
    }

    public final void l() {
        if (this.f13097e) {
            return;
        }
        this.f13101i = 0;
    }

    public final void n(Canvas canvas) {
        if (this.f13097e) {
            int i2 = this.f13099g;
            if (i2 > 0) {
                o(canvas, i2, this.f13100h, this.s - (i2 / 2.0f));
            }
            int i3 = this.f13101i;
            if (i3 > 0) {
                o(canvas, i3, this.j, (this.s - this.f13099g) - (i3 / 2.0f));
                return;
            }
            return;
        }
        int i4 = this.f13099g;
        if (i4 > 0) {
            p(canvas, i4, this.f13100h, this.w, this.t);
        }
    }

    public final void o(Canvas canvas, int i2, int i3, float f2) {
        q(i2, i3);
        this.y.addCircle(this.q / 2.0f, this.r / 2.0f, f2, Path.Direction.CCW);
        canvas.drawPath(this.y, this.x);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.saveLayer(this.v, null, 31);
        if (!this.f13098f) {
            int i2 = this.q;
            int i3 = this.f13099g;
            int i4 = this.f13101i;
            int i5 = this.r;
            canvas.scale((((i2 - (i3 * 2)) - (i4 * 2)) * 1.0f) / i2, (((i5 - (i3 * 2)) - (i4 * 2)) * 1.0f) / i5, i2 / 2.0f, i5 / 2.0f);
        }
        super.onDraw(canvas);
        this.x.reset();
        this.y.reset();
        if (this.f13097e) {
            this.y.addCircle(this.q / 2.0f, this.r / 2.0f, this.s, Path.Direction.CCW);
        } else {
            this.y.addRoundRect(this.v, this.u, Path.Direction.CCW);
        }
        this.x.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.x.setAntiAlias(true);
        this.x.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.y, this.x);
        if (Build.VERSION.SDK_INT <= 27) {
            this.x.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.y, this.x);
        } else {
            this.x.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Path path = new Path();
            path.addRect(this.v, Path.Direction.CW);
            path.op(this.y, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.x);
        }
        this.x.setXfermode(null);
        int i6 = this.p;
        if (i6 != 0) {
            this.x.setColor(i6);
            canvas.drawPath(this.y, this.x);
        }
        canvas.restore();
        n(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.q = i2;
        this.r = i3;
        r();
        s();
    }

    public final void p(Canvas canvas, int i2, int i3, RectF rectF, float[] fArr) {
        q(i2, i3);
        this.y.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.y, this.x);
    }

    public final void q(int i2, int i3) {
        this.y.reset();
        this.x.setStrokeWidth(i2);
        this.x.setColor(i3);
        this.x.setStyle(Paint.Style.STROKE);
    }

    public final void r() {
        if (this.f13097e) {
            return;
        }
        RectF rectF = this.w;
        int i2 = this.f13099g;
        rectF.set(i2 / 2.0f, i2 / 2.0f, this.q - (i2 / 2.0f), this.r - (i2 / 2.0f));
    }

    public final void s() {
        if (this.f13097e) {
            float min = Math.min(this.q, this.r) / 2.0f;
            this.s = min;
            RectF rectF = this.v;
            int i2 = this.q;
            int i3 = this.r;
            rectF.set((i2 / 2.0f) - min, (i3 / 2.0f) - min, (i2 / 2.0f) + min, (i3 / 2.0f) + min);
            return;
        }
        this.v.set(0.0f, 0.0f, this.q, this.r);
        if (this.f13098f) {
            this.v = this.w;
        }
    }

    public void setBorderColor(@ColorInt int i2) {
        this.f13100h = i2;
        invalidate();
    }

    public void setBorderWidth(int i2) {
        this.f13099g = i2;
        b(false);
    }

    public void setCornerBottomLeftRadius(int i2) {
        this.n = i2;
        b(true);
    }

    public void setCornerBottomRightRadius(int i2) {
        this.o = i2;
        b(true);
    }

    public void setCornerRadius(int i2) {
        this.k = i2;
        b(false);
    }

    public void setCornerTopLeftRadius(int i2) {
        this.l = i2;
        b(true);
    }

    public void setCornerTopRightRadius(int i2) {
        this.m = i2;
        b(true);
    }

    public void setInnerBorderColor(@ColorInt int i2) {
        this.j = i2;
        invalidate();
    }

    public void setInnerBorderWidth(int i2) {
        this.f13101i = i2;
        l();
        invalidate();
    }

    public void setMaskColor(@ColorInt int i2) {
        this.p = i2;
        invalidate();
    }

    public TbCornersImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TbCornersImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13100h = -1;
        this.j = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CornersImageView, 0, 0);
        for (int i3 = 0; i3 < obtainStyledAttributes.getIndexCount(); i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.CornersImageView_is_cover_src) {
                this.f13098f = obtainStyledAttributes.getBoolean(index, this.f13098f);
            } else if (index == R$styleable.CornersImageView_is_circle) {
                this.f13097e = obtainStyledAttributes.getBoolean(index, this.f13097e);
            } else if (index == R$styleable.CornersImageView_border_width) {
                this.f13099g = obtainStyledAttributes.getDimensionPixelSize(index, this.f13099g);
            } else if (index == R$styleable.CornersImageView_border_color) {
                this.f13100h = obtainStyledAttributes.getColor(index, this.f13100h);
            } else if (index == R$styleable.CornersImageView_inner_border_width) {
                this.f13101i = obtainStyledAttributes.getDimensionPixelSize(index, this.f13101i);
            } else if (index == R$styleable.CornersImageView_inner_border_color) {
                this.j = obtainStyledAttributes.getColor(index, this.j);
            } else if (index == R$styleable.CornersImageView_corner_radius) {
                this.k = obtainStyledAttributes.getDimensionPixelSize(index, this.k);
            } else if (index == R$styleable.CornersImageView_corner_top_left_radius) {
                this.l = obtainStyledAttributes.getDimensionPixelSize(index, this.l);
            } else if (index == R$styleable.CornersImageView_corner_top_right_radius) {
                this.m = obtainStyledAttributes.getDimensionPixelSize(index, this.m);
            } else if (index == R$styleable.CornersImageView_corner_bottom_left_radius) {
                this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
            } else if (index == R$styleable.CornersImageView_corner_bottom_right_radius) {
                this.o = obtainStyledAttributes.getDimensionPixelSize(index, this.o);
            } else if (index == R$styleable.CornersImageView_mask_color) {
                this.p = obtainStyledAttributes.getColor(index, this.p);
            }
        }
        obtainStyledAttributes.recycle();
        this.t = new float[8];
        this.u = new float[8];
        this.w = new RectF();
        this.v = new RectF();
        this.x = new Paint();
        this.y = new Path();
        a();
        l();
    }
}
