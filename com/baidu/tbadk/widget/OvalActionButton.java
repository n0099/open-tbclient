package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.a.n0.e3.c;
/* loaded from: classes3.dex */
public class OvalActionButton extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f12992e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12993f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12994g;

    /* renamed from: h  reason: collision with root package name */
    public int f12995h;

    /* renamed from: i  reason: collision with root package name */
    public int f12996i;
    public Path j;
    public Paint k;
    public Paint l;
    public float[] m;
    public float[] n;
    public LinearGradient o;
    public int p;
    public int q;
    public int r;
    public PorterDuffXfermode s;
    public PorterDuffXfermode t;
    public Drawable u;
    public Drawable v;
    public int w;
    public int x;

    public OvalActionButton(Context context) {
        this(context, null);
    }

    public final void a(Canvas canvas) {
        this.k.setXfermode(this.s);
        canvas.drawPaint(this.k);
        this.k.setXfermode(this.t);
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton == null) {
            return;
        }
        ovalActionButton.setStartAndEndColor(this.p, this.q);
        ovalActionButton.setColor(this.r);
    }

    public final void c() {
        d();
        Paint paint = new Paint();
        this.k = paint;
        paint.setAntiAlias(true);
        this.k.setColor(this.r);
        this.k.setStyle(Paint.Style.FILL);
        this.k.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.l = paint2;
        paint2.setColor(SkinManager.getColor(R.color.CAM_X0101));
        this.l.setStrokeCap(Paint.Cap.ROUND);
        this.l.setAntiAlias(true);
        setLayerType(1, null);
    }

    public final void d() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.x = skinType;
        if (skinType == 0) {
            this.p = c.c("#00E1FF");
            this.q = c.c("#00A2FF");
        } else if (skinType == 1) {
            this.p = c.c("#00BBD4");
            this.q = c.c("#0086D4");
        } else if (skinType == 4) {
            this.p = c.c("#2BE6FF");
            this.q = c.c("#2BB1FF");
        }
    }

    public void e(int i2) {
        if (this.x != i2) {
            d();
            this.r = SkinManager.getColor(this.x, R.color.CAM_X0306);
            this.l.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.f12992e = true;
            invalidate();
        }
    }

    public final void f(Canvas canvas) {
        Drawable drawable = this.v;
        if (drawable == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19 || drawable.getAlpha() > 0) {
            canvas.save();
            canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            this.v.setBounds(((getWidth() / 2) - (this.v.getIntrinsicWidth() / 2)) + this.w, ((getHeight() / 2) - (this.v.getIntrinsicHeight() / 2)) + this.w, ((getWidth() / 2) + (this.v.getIntrinsicWidth() / 2)) - this.w, ((getHeight() / 2) + (this.v.getIntrinsicHeight() / 2)) - this.w);
            this.v.draw(canvas);
            canvas.restore();
        }
    }

    public final void g(Canvas canvas) {
        Drawable drawable = this.u;
        if (drawable == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19 || drawable.getAlpha() > 0) {
            canvas.save();
            canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            this.u.setBounds((getWidth() / 2) - (this.u.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.u.getIntrinsicHeight() / 2), (getWidth() / 2) + (this.u.getIntrinsicWidth() / 2), (getHeight() / 2) + (this.u.getIntrinsicHeight() / 2));
            this.u.draw(canvas);
            canvas.restore();
        }
    }

    public void h() {
        Drawable drawable = this.u;
        if (drawable != null) {
            drawable.setAlpha(255);
            postInvalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        char c2;
        int i2;
        float f2;
        float f3;
        if (this.f12995h <= 0 || this.f12996i <= 0) {
            return;
        }
        if (getDrawable() != null) {
            if (getLayerType() != 2) {
                setLayerType(2, null);
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.scale(0.7f, 0.7f, this.f12995h / 2, this.f12996i / 2);
            super.onDraw(canvas);
            if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(saveCount);
            return;
        }
        if (getLayerType() != 1) {
            setLayerType(1, null);
        }
        int saveCount2 = canvas.getSaveCount();
        canvas.save();
        a(canvas);
        canvas.rotate(45.0f, this.f12995h / 2, this.f12996i / 2);
        Path path = this.j;
        if (path != null) {
            path.reset();
            int i3 = this.f12995h;
            float f4 = i3 * 0.15f;
            float f5 = i3 * 0.85f;
            float f6 = (f4 + f5) / 2.0f;
            int i4 = this.f12996i;
            float f7 = 0.15f * i4;
            float f8 = i4 * 0.85f;
            float f9 = (f7 + f8) / 2.0f;
            float f10 = (((f5 - f4) / 2.0f) * 51.0f) / 65.0f;
            float f11 = (((f8 - f7) / 2.0f) * 51.0f) / 65.0f;
            this.j.moveTo(f6, f7);
            float f12 = f6 + f10;
            float f13 = f9 - f11;
            this.j.cubicTo(f12, f7, f5, f13, f5, f9);
            float f14 = f9 + f11;
            this.j.cubicTo(f5, f14, f12, f8, f6, f8);
            float f15 = f6 - f10;
            this.j.cubicTo(f15, f8, f4, f14, f4, f9);
            this.j.cubicTo(f4, f13, f15, f7, f6, f7);
            this.j.close();
            if (this.f12992e) {
                c2 = 0;
                this.o = new LinearGradient(f4, 0.0f, f5, 0.0f, new int[]{this.p, this.q}, (float[]) null, Shader.TileMode.CLAMP);
                this.f12992e = false;
            } else {
                c2 = 0;
            }
            if (this.f12994g) {
                if (this.f12993f) {
                    this.k.setShadowLayer(16.0f, 5.0f, 5.0f, c.a(this.o == null ? this.r : this.q, 0.5f));
                } else {
                    int i5 = this.f12995h;
                    float f16 = i5 * 0.054f;
                    double radians = Math.toRadians(getRotation() - 45.0f);
                    double d2 = i5 * 0.0226f;
                    this.k.setShadowLayer(f16, (float) (Math.cos(radians) * d2), ((float) (d2 * Math.sin(radians))) * (-1.0f), c.a(this.o == null ? this.r : this.q, 0.83f));
                }
            }
            LinearGradient linearGradient = this.o;
            if (linearGradient != null) {
                this.k.setShader(linearGradient);
            } else {
                this.k.setColor(this.r);
            }
            float f17 = this.f12995h * 0.032f;
            if (this.f12993f) {
                f2 = f9;
                f3 = f6;
                canvas.drawCircle(f3, f2, (i2 / 2) - 20, this.k);
            } else {
                f2 = f9;
                f3 = f6;
                canvas.drawPath(this.j, this.k);
            }
            float[] fArr = this.m;
            float f18 = f3 * 3.0f;
            float f19 = (f4 + f18) / 4.0f;
            fArr[c2] = f19;
            float f20 = 3.0f * f2;
            float f21 = (f7 + f20) / 4.0f;
            fArr[1] = f21;
            float f22 = (f5 + f18) / 4.0f;
            fArr[2] = f22;
            float f23 = (f8 + f20) / 4.0f;
            fArr[3] = f23;
            float[] fArr2 = this.n;
            fArr2[c2] = f22;
            fArr2[1] = f21;
            fArr2[2] = f19;
            fArr2[3] = f23;
            g(canvas);
            f(canvas);
            this.l.setStrokeWidth(f17);
            canvas.drawLines(this.m, this.l);
            canvas.drawLines(this.n, this.l);
        }
        if (saveCount2 < 1 || saveCount2 > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount2);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z && this.j == null) {
            this.j = new Path();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f12995h = getMeasuredWidth();
        this.f12996i = getMeasuredHeight();
    }

    public void setColor(int i2) {
        this.r = i2;
    }

    public void setCrossFade(float f2, boolean z) {
        float f3;
        if (this.v == null) {
            return;
        }
        float f4 = 1.0f;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if ((!z && f2 > 0.3d) || (z && f2 > 0.5d)) {
            if (z) {
                f3 = f2 * 2.0f;
            } else {
                f3 = (f2 * 10.0f) / 7.0f;
                f4 = 0.42857143f;
            }
            int i2 = (int) ((f3 - f4) * 255.0f);
            if (z) {
                i2 = 255 - i2;
            }
            this.v.setAlpha(i2);
            int i3 = 255 - i2;
            this.k.setAlpha(i3);
            Drawable drawable = this.u;
            if (drawable != null) {
                drawable.setAlpha(i3);
                this.l.setAlpha(0);
            } else {
                this.l.setAlpha(i3);
            }
        }
        invalidate();
    }

    public void setEndIcon(int i2, int i3, String str) {
        if (i2 > 0) {
            if ("webp".equals(str)) {
                this.v = WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0107), null);
            } else {
                this.v = SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            }
        } else {
            this.v = null;
        }
        this.w = i3;
    }

    public void setHasShadow(boolean z) {
        this.f12994g = z;
    }

    public void setIconFade(int i2) {
        if (i2 > 0) {
            Drawable drawable = SkinManager.getDrawable(i2);
            this.u = drawable;
            if (drawable != null) {
                drawable.setAlpha(255);
            }
            this.l.setAlpha(0);
        } else {
            this.u = null;
            this.l.setAlpha(255);
        }
        postInvalidate();
    }

    public void setIsCircle(boolean z) {
        this.f12993f = z;
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        super.setRotation(f2);
        invalidate();
    }

    public void setStartAndEndColor(String str, String str2) {
        this.p = c.c(str);
        this.q = c.c(str2);
        this.f12992e = true;
        invalidate();
    }

    public OvalActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OvalActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12992e = true;
        this.f12994g = true;
        this.m = new float[4];
        this.n = new float[4];
        this.r = SkinManager.getColor(R.color.CAM_X0306);
        this.s = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.t = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.x = 3;
        c();
    }

    public void setStartAndEndColor(int i2, int i3) {
        this.p = i2;
        this.q = i3;
        this.f12992e = true;
        invalidate();
    }
}
