package com.baidu.tbadk.widget.viewpager;

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
import com.baidu.tieba.R;
import d.b.i0.d3.c;
/* loaded from: classes3.dex */
public class OvalImageView extends ImageView {
    public static final int t = SkinManager.getColor(R.color.CAM_X0306);

    /* renamed from: e  reason: collision with root package name */
    public boolean f14044e;

    /* renamed from: f  reason: collision with root package name */
    public Path f14045f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f14046g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f14047h;
    public float[] i;
    public float[] j;
    public boolean k;
    public LinearGradient l;
    public int m;
    public int n;
    public int o;
    public PorterDuffXfermode p;
    public PorterDuffXfermode q;
    public Drawable r;
    public int s;

    public OvalImageView(Context context) {
        this(context, null);
    }

    public final void a(Canvas canvas) {
        this.f14046g.setXfermode(this.p);
        canvas.drawPaint(this.f14046g);
        this.f14046g.setXfermode(this.q);
    }

    public final void b() {
        c();
        Paint paint = new Paint();
        this.f14046g = paint;
        paint.setAntiAlias(true);
        this.f14046g.setColor(this.o);
        this.f14046g.setStyle(Paint.Style.FILL);
        this.f14046g.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f14047h = paint2;
        paint2.setColor(SkinManager.getColor(R.color.CAM_X0101));
        this.f14047h.setStrokeCap(Paint.Cap.ROUND);
        this.f14047h.setAntiAlias(true);
        setLayerType(1, null);
    }

    public final void c() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.s = skinType;
        if (skinType == 0) {
            this.m = c.c("#2bb8ff");
            this.n = c.c("#2b80ff");
        } else if (skinType == 1 || skinType == 4) {
            this.m = c.c("#249BD6");
            this.n = c.c("#246CD6");
        }
    }

    public final void d(Canvas canvas) {
        Drawable drawable = this.r;
        if (drawable == null) {
            this.f14047h.setAlpha(255);
            return;
        }
        if (Build.VERSION.SDK_INT < 19 || drawable.getAlpha() > 0) {
            canvas.save();
            canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            this.r.setBounds((getWidth() / 2) - (this.r.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.r.getIntrinsicHeight() / 2), (getWidth() / 2) + (this.r.getIntrinsicWidth() / 2), (getHeight() / 2) + (this.r.getIntrinsicHeight() / 2));
            this.r.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        char c2;
        if (getDrawable() != null) {
            if (getLayerType() != 2) {
                setLayerType(2, null);
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.scale(0.7f, 0.7f, canvas.getWidth() / 2, canvas.getHeight() / 2);
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
        canvas.rotate(45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
        Path path = this.f14045f;
        if (path != null) {
            path.reset();
            float width = canvas.getWidth() * 0.15f;
            float width2 = canvas.getWidth() * 0.85f;
            float f2 = (width + width2) / 2.0f;
            float height = 0.15f * canvas.getHeight();
            float height2 = canvas.getHeight() * 0.85f;
            float f3 = (height + height2) / 2.0f;
            float f4 = (((width2 - width) / 2.0f) * 51.0f) / 65.0f;
            float f5 = (((height2 - height) / 2.0f) * 51.0f) / 65.0f;
            this.f14045f.moveTo(f2, height);
            float f6 = f2 + f4;
            float f7 = f3 - f5;
            this.f14045f.cubicTo(f6, height, width2, f7, width2, f3);
            float f8 = f3 + f5;
            this.f14045f.cubicTo(width2, f8, f6, height2, f2, height2);
            float f9 = f2 - f4;
            this.f14045f.cubicTo(f9, height2, width, f8, width, f3);
            this.f14045f.cubicTo(width, f7, f9, height, f2, height);
            this.f14045f.close();
            if (this.f14044e) {
                c2 = 0;
                this.l = new LinearGradient(width, 0.0f, width2, 0.0f, new int[]{this.m, this.n}, (float[]) null, Shader.TileMode.CLAMP);
                this.f14044e = false;
            } else {
                c2 = 0;
            }
            if (this.k) {
                float width3 = canvas.getWidth() * 0.054f;
                double radians = Math.toRadians(getRotation() - 45.0f);
                double width4 = canvas.getWidth() * 0.0226f;
                this.f14046g.setShadowLayer(width3, (float) (Math.cos(radians) * width4), ((float) (width4 * Math.sin(radians))) * (-1.0f), c.a(this.l == null ? this.o : this.n, 0.83f));
            }
            LinearGradient linearGradient = this.l;
            if (linearGradient != null) {
                this.f14046g.setShader(linearGradient);
            } else {
                this.f14046g.setColor(this.o);
            }
            canvas.drawPath(this.f14045f, this.f14046g);
            float[] fArr = this.i;
            float f10 = f2 * 3.0f;
            float f11 = (width + f10) / 4.0f;
            fArr[c2] = f11;
            float f12 = f3 * 3.0f;
            float f13 = (height + f12) / 4.0f;
            fArr[1] = f13;
            float f14 = (width2 + f10) / 4.0f;
            fArr[2] = f14;
            float f15 = (height2 + f12) / 4.0f;
            fArr[3] = f15;
            float[] fArr2 = this.j;
            fArr2[c2] = f14;
            fArr2[1] = f13;
            fArr2[2] = f11;
            fArr2[3] = f15;
            d(canvas);
            this.f14047h.setStrokeWidth(canvas.getWidth() * 0.032f);
            canvas.drawLines(this.i, this.f14047h);
            canvas.drawLines(this.j, this.f14047h);
        }
        if (saveCount2 < 1 || saveCount2 > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount2);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.f14045f == null) {
            this.f14045f = new Path();
        }
    }

    public void setColor(int i) {
        this.o = i;
    }

    public void setCrossFade(float f2) {
        if (this.r == null) {
            return;
        }
        float f3 = f2 > 1.0f ? -0.5f : 0.5f - f2;
        int i = (int) (255.0f * f3 * 2.0f);
        if (f3 > 0.0f) {
            this.r.setAlpha(i);
            this.f14047h.setAlpha(0);
        } else {
            this.f14047h.setAlpha(-i);
            this.r.setAlpha(0);
        }
        invalidate();
    }

    public void setIconFade(int i) {
        if (i > 0) {
            Drawable drawable = SkinManager.getDrawable(i);
            this.r = drawable;
            if (drawable != null) {
                drawable.setAlpha(255);
            }
            this.f14047h.setAlpha(0);
        } else {
            this.r = null;
            this.f14047h.setAlpha(255);
        }
        postInvalidate();
    }

    public void setNeedShadow(boolean z) {
        this.k = z;
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        super.setRotation(f2);
        invalidate();
    }

    public void setStartAndEndColor(String str, String str2) {
        this.m = c.c(str);
        this.n = c.c(str2);
        this.f14044e = true;
        invalidate();
    }

    public void setStringColor(String str) {
        this.o = c.c(str);
    }

    public OvalImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OvalImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14044e = true;
        this.i = new float[4];
        this.j = new float[4];
        this.k = true;
        this.o = t;
        this.p = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.q = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.s = 3;
        b();
    }

    public void setStartAndEndColor(int i, int i2) {
        this.m = i;
        this.n = i2;
        this.f14044e = true;
        invalidate();
    }
}
