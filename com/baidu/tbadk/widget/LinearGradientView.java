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
import d.a.n0.k1.o.k.b;
import java.util.ArrayList;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class LinearGradientView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f13052e;

    /* renamed from: f  reason: collision with root package name */
    public int f13053f;

    /* renamed from: g  reason: collision with root package name */
    public int f13054g;

    /* renamed from: h  reason: collision with root package name */
    public int f13055h;

    /* renamed from: i  reason: collision with root package name */
    public int f13056i;
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
        this.f13052e = 3;
        this.m = new Paint();
        this.o = 0;
        this.s = 0;
        d();
    }

    public void a(int i2) {
        if (this.f13052e != i2) {
            this.l = c();
            invalidate();
        }
        this.f13052e = i2;
    }

    public final void b() {
        if ((getWidth() == this.p && getHeight() == this.q && this.r == this.o) || this.s == 0) {
            return;
        }
        this.p = getWidth();
        this.q = getHeight();
        this.r = this.o;
        this.n.reset();
        int i2 = this.s;
        if (i2 == 1) {
            Path path = this.n;
            RectF rectF = new RectF(0.0f, 0.0f, this.p, this.q);
            int i3 = this.o;
            path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
        } else if (i2 == 2) {
            Path path2 = this.n;
            RectF rectF2 = new RectF(0.0f, 0.0f, this.p, this.q);
            int i4 = this.o;
            path2.addRoundRect(rectF2, new float[]{i4, i4, 0.0f, 0.0f, 0.0f, 0.0f, i4, i4}, Path.Direction.CW);
        } else if (i2 == 3) {
            Path path3 = this.n;
            RectF rectF3 = new RectF(0.0f, 0.0f, this.p, this.q);
            int i5 = this.o;
            path3.addRoundRect(rectF3, new float[]{i5, i5, i5, i5, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        } else if (i2 == 4) {
            Path path4 = this.n;
            RectF rectF4 = new RectF(0.0f, 0.0f, this.p, this.q);
            int i6 = this.o;
            path4.addRoundRect(rectF4, new float[]{0.0f, 0.0f, i6, i6, i6, i6, 0.0f, 0.0f}, Path.Direction.CW);
        } else if (i2 != 5) {
        } else {
            Path path5 = this.n;
            RectF rectF5 = new RectF(0.0f, 0.0f, this.p, this.q);
            int i7 = this.o;
            path5.addRoundRect(rectF5, new float[]{0.0f, 0.0f, 0.0f, 0.0f, i7, i7, i7, i7}, Path.Direction.CW);
        }
    }

    public final LinearGradient c() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i2 = this.f13053f;
        int i3 = this.f13054g;
        if (skinType == 4) {
            i2 = this.j;
            i3 = this.k;
        } else if (skinType == 1) {
            i2 = this.f13055h;
            i3 = this.f13056i;
        }
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i2, i3}, (float[]) null, Shader.TileMode.CLAMP);
        this.l = linearGradient;
        this.m.setShader(linearGradient);
        this.f13052e = skinType;
        return this.l;
    }

    public final void d() {
        this.n = new Path();
        e();
    }

    public final void e() {
        this.f13053f = b.b("#2BB8FF");
        this.f13054g = b.b("#2BB8FF");
        this.f13055h = b.b("#249BD6");
        this.f13056i = b.b("#246CD6");
        this.j = b.b("#249BD6");
        this.k = b.b("#246CD6");
        this.l = c();
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.f13053f));
        arrayList.add(Integer.valueOf(this.f13054g));
        arrayList.add(Integer.valueOf(this.f13055h));
        arrayList.add(Integer.valueOf(this.f13056i));
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
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.l = c();
    }

    public void setCornerRadius(int i2) {
        this.o = i2;
    }

    public void setDefaultGradientColor() {
        e();
        invalidate();
    }

    public void setGradientColor(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f13053f = i2;
        this.f13054g = i3;
        this.f13055h = i4;
        this.f13056i = i5;
        this.j = i6;
        this.k = i7;
        this.l = c();
        invalidate();
    }

    public void setRoundMode(int i2) {
        this.s = i2;
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13052e = 3;
        this.m = new Paint();
        this.o = 0;
        this.s = 0;
        d();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            if (this.f13053f == b.b(str) && this.f13054g == b.b(str2) && this.f13055h == b.b(str3) && this.f13056i == b.b(str4) && this.j == b.b(str5) && this.k == b.b(str6)) {
                return;
            }
            this.f13053f = b.b(str);
            this.f13054g = b.b(str2);
            this.f13055h = b.b(str3);
            this.f13056i = b.b(str4);
            this.j = b.b(str5);
            this.k = b.b(str6);
            this.l = c();
            invalidate();
            return;
        }
        setDefaultGradientColor();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13052e = 3;
        this.m = new Paint();
        this.o = 0;
        this.s = 0;
        d();
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int b2;
        int b3;
        int b4;
        int i2;
        int b5;
        int i3;
        if (themeElement == null) {
            b2 = b.b("#2BB8FF");
            b3 = b.b("#2BB8FF");
        } else {
            b2 = b.b(themeElement.common_color);
            b3 = b.b(themeElement.common_color);
        }
        if (themeElement2 == null) {
            i2 = b.b("#249BD6");
            b4 = b.b("#246CD6");
        } else {
            int b6 = b.b(themeElement2.common_color);
            b4 = b.b(themeElement2.common_color);
            i2 = b6;
        }
        if (themeElement3 == null) {
            i3 = b.b("#249BD6");
            b5 = b.b("#246CD6");
        } else {
            int b7 = b.b(themeElement3.common_color);
            b5 = b.b(themeElement3.common_color);
            i3 = b7;
        }
        this.f13053f = b2;
        this.f13054g = b3;
        this.f13055h = i2;
        this.f13056i = b4;
        this.j = i3;
        this.k = b5;
        this.l = c();
        invalidate();
    }
}
