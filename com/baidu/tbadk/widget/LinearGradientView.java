package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.i0.i1.o.k.b;
import java.util.ArrayList;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class LinearGradientView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f14066e;

    /* renamed from: f  reason: collision with root package name */
    public int f14067f;

    /* renamed from: g  reason: collision with root package name */
    public int f14068g;

    /* renamed from: h  reason: collision with root package name */
    public int f14069h;
    public int i;
    public int j;
    public int k;
    public LinearGradient l;
    public final Paint m;
    public Path n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;

    public LinearGradientView(Context context) {
        super(context);
        this.f14066e = 3;
        this.m = new Paint();
        this.o = 0;
        this.s = 0;
        d();
    }

    public void a(int i) {
        if (this.f14066e != i) {
            this.l = c();
            invalidate();
        }
        this.f14066e = i;
    }

    public final void b() {
        if ((getWidth() == this.p && getHeight() == this.q && this.r == this.o) || this.s == 0) {
            return;
        }
        this.p = getWidth();
        this.q = getHeight();
        this.r = this.o;
        this.n.reset();
        int i = this.s;
        if (i == 1) {
            Path path = this.n;
            RectF rectF = new RectF(0.0f, 0.0f, this.p, this.q);
            int i2 = this.o;
            path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
        } else if (i == 2) {
            Path path2 = this.n;
            RectF rectF2 = new RectF(0.0f, 0.0f, this.p, this.q);
            int i3 = this.o;
            path2.addRoundRect(rectF2, new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, i3, i3}, Path.Direction.CW);
        } else if (i == 3) {
            Path path3 = this.n;
            RectF rectF3 = new RectF(0.0f, 0.0f, this.p, this.q);
            int i4 = this.o;
            path3.addRoundRect(rectF3, new float[]{i4, i4, i4, i4, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        } else if (i == 4) {
            Path path4 = this.n;
            RectF rectF4 = new RectF(0.0f, 0.0f, this.p, this.q);
            int i5 = this.o;
            path4.addRoundRect(rectF4, new float[]{0.0f, 0.0f, i5, i5, i5, i5, 0.0f, 0.0f}, Path.Direction.CW);
        } else if (i != 5) {
        } else {
            Path path5 = this.n;
            RectF rectF5 = new RectF(0.0f, 0.0f, this.p, this.q);
            int i6 = this.o;
            path5.addRoundRect(rectF5, new float[]{0.0f, 0.0f, 0.0f, 0.0f, i6, i6, i6, i6}, Path.Direction.CW);
        }
    }

    public final LinearGradient c() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i = this.f14067f;
        int i2 = this.f14068g;
        if (skinType == 4) {
            i = this.j;
            i2 = this.k;
        } else if (skinType == 1) {
            i = this.f14069h;
            i2 = this.i;
        }
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.l = linearGradient;
        this.m.setShader(linearGradient);
        this.f14066e = skinType;
        return this.l;
    }

    public final void d() {
        this.n = new Path();
        e();
    }

    public final void e() {
        this.f14067f = b.b("#2BB8FF");
        this.f14068g = b.b("#2BB8FF");
        this.f14069h = b.b("#249BD6");
        this.i = b.b("#246CD6");
        this.j = b.b("#249BD6");
        this.k = b.b("#246CD6");
        this.l = c();
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.f14067f));
        arrayList.add(Integer.valueOf(this.f14068g));
        arrayList.add(Integer.valueOf(this.f14069h));
        arrayList.add(Integer.valueOf(this.i));
        arrayList.add(Integer.valueOf(this.j));
        arrayList.add(Integer.valueOf(this.k));
        return arrayList;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        b();
        if (this.s == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.m);
        } else {
            canvas.drawPath(this.n, this.m);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.l = c();
    }

    public void setCornerRadius(int i) {
        this.o = i;
    }

    public void setDefaultGradientColor() {
        e();
        invalidate();
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f14067f = i;
        this.f14068g = i2;
        this.f14069h = i3;
        this.i = i4;
        this.j = i5;
        this.k = i6;
        this.l = c();
        invalidate();
    }

    public void setRoundMode(int i) {
        this.s = i;
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14066e = 3;
        this.m = new Paint();
        this.o = 0;
        this.s = 0;
        d();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            if (this.f14067f == b.b(str) && this.f14068g == b.b(str2) && this.f14069h == b.b(str3) && this.i == b.b(str4) && this.j == b.b(str5) && this.k == b.b(str6)) {
                return;
            }
            this.f14067f = b.b(str);
            this.f14068g = b.b(str2);
            this.f14069h = b.b(str3);
            this.i = b.b(str4);
            this.j = b.b(str5);
            this.k = b.b(str6);
            this.l = c();
            invalidate();
            return;
        }
        setDefaultGradientColor();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14066e = 3;
        this.m = new Paint();
        this.o = 0;
        this.s = 0;
        d();
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int b2;
        int b3;
        int b4;
        int i;
        int b5;
        int i2;
        if (themeElement == null) {
            b2 = b.b("#2BB8FF");
            b3 = b.b("#2BB8FF");
        } else {
            b2 = b.b(themeElement.common_color);
            b3 = b.b(themeElement.common_color);
        }
        if (themeElement2 == null) {
            i = b.b("#249BD6");
            b4 = b.b("#246CD6");
        } else {
            int b6 = b.b(themeElement2.common_color);
            b4 = b.b(themeElement2.common_color);
            i = b6;
        }
        if (themeElement3 == null) {
            i2 = b.b("#249BD6");
            b5 = b.b("#246CD6");
        } else {
            int b7 = b.b(themeElement3.common_color);
            b5 = b.b(themeElement3.common_color);
            i2 = b7;
        }
        this.f14067f = b2;
        this.f14068g = b3;
        this.f14069h = i;
        this.i = b4;
        this.j = i2;
        this.k = b5;
        this.l = c();
        invalidate();
    }
}
