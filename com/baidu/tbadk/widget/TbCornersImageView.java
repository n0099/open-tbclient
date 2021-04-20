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
    public boolean f13767e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13768f;

    /* renamed from: g  reason: collision with root package name */
    public int f13769g;

    /* renamed from: h  reason: collision with root package name */
    public int f13770h;
    public int i;
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
        if (this.f13767e) {
            return;
        }
        int i = 0;
        if (this.k <= 0) {
            float[] fArr = this.t;
            int i2 = this.l;
            float f2 = i2;
            fArr[1] = f2;
            fArr[0] = f2;
            int i3 = this.m;
            float f3 = i3;
            fArr[3] = f3;
            fArr[2] = f3;
            int i4 = this.o;
            float f4 = i4;
            fArr[5] = f4;
            fArr[4] = f4;
            int i5 = this.n;
            float f5 = i5;
            fArr[7] = f5;
            fArr[6] = f5;
            float[] fArr2 = this.u;
            int i6 = this.f13769g;
            float f6 = i2 - (i6 / 2.0f);
            fArr2[1] = f6;
            fArr2[0] = f6;
            float f7 = i3 - (i6 / 2.0f);
            fArr2[3] = f7;
            fArr2[2] = f7;
            float f8 = i4 - (i6 / 2.0f);
            fArr2[5] = f8;
            fArr2[4] = f8;
            float f9 = i5 - (i6 / 2.0f);
            fArr2[7] = f9;
            fArr2[6] = f9;
            return;
        }
        while (true) {
            float[] fArr3 = this.t;
            if (i >= fArr3.length) {
                return;
            }
            int i7 = this.k;
            fArr3[i] = i7;
            this.u[i] = i7 - (this.f13769g / 2.0f);
            i++;
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.k = 0;
        }
        a();
        q();
        invalidate();
    }

    public final void c() {
        if (this.f13767e) {
            return;
        }
        this.i = 0;
    }

    public final void g(Canvas canvas) {
        if (this.f13767e) {
            int i = this.f13769g;
            if (i > 0) {
                n(canvas, i, this.f13770h, this.s - (i / 2.0f));
            }
            int i2 = this.i;
            if (i2 > 0) {
                n(canvas, i2, this.j, (this.s - this.f13769g) - (i2 / 2.0f));
                return;
            }
            return;
        }
        int i3 = this.f13769g;
        if (i3 > 0) {
            o(canvas, i3, this.f13770h, this.w, this.t);
        }
    }

    public final void n(Canvas canvas, int i, int i2, float f2) {
        p(i, i2);
        this.y.addCircle(this.q / 2.0f, this.r / 2.0f, f2, Path.Direction.CCW);
        canvas.drawPath(this.y, this.x);
    }

    public final void o(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        p(i, i2);
        this.y.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.y, this.x);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.saveLayer(this.v, null, 31);
        if (!this.f13768f) {
            int i = this.q;
            int i2 = this.f13769g;
            int i3 = this.i;
            int i4 = this.r;
            canvas.scale((((i - (i2 * 2)) - (i3 * 2)) * 1.0f) / i, (((i4 - (i2 * 2)) - (i3 * 2)) * 1.0f) / i4, i / 2.0f, i4 / 2.0f);
        }
        super.onDraw(canvas);
        this.x.reset();
        this.y.reset();
        if (this.f13767e) {
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
        int i5 = this.p;
        if (i5 != 0) {
            this.x.setColor(i5);
            canvas.drawPath(this.y, this.x);
        }
        canvas.restore();
        g(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.q = i;
        this.r = i2;
        q();
        r();
    }

    public final void p(int i, int i2) {
        this.y.reset();
        this.x.setStrokeWidth(i);
        this.x.setColor(i2);
        this.x.setStyle(Paint.Style.STROKE);
    }

    public final void q() {
        if (this.f13767e) {
            return;
        }
        RectF rectF = this.w;
        int i = this.f13769g;
        rectF.set(i / 2.0f, i / 2.0f, this.q - (i / 2.0f), this.r - (i / 2.0f));
    }

    public final void r() {
        if (this.f13767e) {
            float min = Math.min(this.q, this.r) / 2.0f;
            this.s = min;
            RectF rectF = this.v;
            int i = this.q;
            int i2 = this.r;
            rectF.set((i / 2.0f) - min, (i2 / 2.0f) - min, (i / 2.0f) + min, (i2 / 2.0f) + min);
            return;
        }
        this.v.set(0.0f, 0.0f, this.q, this.r);
        if (this.f13768f) {
            this.v = this.w;
        }
    }

    public void setBorderColor(@ColorInt int i) {
        this.f13770h = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.f13769g = i;
        b(false);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.n = i;
        b(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.o = i;
        b(true);
    }

    public void setCornerRadius(int i) {
        this.k = i;
        b(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.l = i;
        b(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.m = i;
        b(true);
    }

    public void setInnerBorderColor(@ColorInt int i) {
        this.j = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.i = i;
        c();
        invalidate();
    }

    public void setMaskColor(@ColorInt int i) {
        this.p = i;
        invalidate();
    }

    public TbCornersImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TbCornersImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13770h = -1;
        this.j = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CornersImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R$styleable.CornersImageView_is_cover_src) {
                this.f13768f = obtainStyledAttributes.getBoolean(index, this.f13768f);
            } else if (index == R$styleable.CornersImageView_is_circle) {
                this.f13767e = obtainStyledAttributes.getBoolean(index, this.f13767e);
            } else if (index == R$styleable.CornersImageView_border_width) {
                this.f13769g = obtainStyledAttributes.getDimensionPixelSize(index, this.f13769g);
            } else if (index == R$styleable.CornersImageView_border_color) {
                this.f13770h = obtainStyledAttributes.getColor(index, this.f13770h);
            } else if (index == R$styleable.CornersImageView_inner_border_width) {
                this.i = obtainStyledAttributes.getDimensionPixelSize(index, this.i);
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
        c();
    }
}
