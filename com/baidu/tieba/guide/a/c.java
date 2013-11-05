package com.baidu.tieba.guide.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.guide.f {
    private Paint b;
    private float f;
    private int g;
    private int h;

    /* renamed from: a  reason: collision with root package name */
    private int f1309a = 4;
    private Rect d = new Rect();
    private Rect e = new Rect();
    private d[] c = new d[this.f1309a];

    public c(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.g = displayMetrics.widthPixels;
        this.h = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        this.f = (this.g / 10.0f) / 60.0f;
        this.f = -(this.f >= 1.0f ? this.f : 1.0f);
        d dVar = new d(this);
        this.c[0] = dVar;
        dVar.f1310a = BitmapFactory.decodeResource(resources, R.drawable.guide_cloud1);
        dVar.b = dVar.f1310a.getWidth();
        dVar.c = dVar.f1310a.getHeight();
        dVar.e = this.h / 3;
        dVar.h = dVar.e;
        dVar.d = this.g - dVar.b;
        dVar.f = dVar.d;
        dVar.g = dVar.d;
        dVar.i = false;
        dVar.j = true;
        dVar.k = this.g;
        dVar.n = this.g;
        d dVar2 = new d(this);
        this.c[1] = dVar2;
        dVar2.f1310a = BitmapFactory.decodeResource(resources, R.drawable.guide_cloud2);
        dVar2.b = dVar2.f1310a.getWidth();
        dVar2.c = dVar2.f1310a.getHeight();
        dVar2.e = (int) (f * 206.0f);
        dVar2.h = dVar2.e;
        dVar2.d = this.g - dVar2.b;
        dVar2.f = dVar2.d;
        dVar2.g = dVar2.d;
        dVar2.m = this.h / 2;
        dVar2.l = this.g;
        dVar2.k = this.g;
        dVar2.n = this.h;
        dVar2.i = true;
        dVar2.j = false;
        d dVar3 = new d(this);
        this.c[2] = dVar3;
        dVar3.f1310a = BitmapFactory.decodeResource(resources, R.drawable.guide_cloud3);
        dVar3.b = dVar3.f1310a.getWidth();
        dVar3.c = dVar3.f1310a.getHeight();
        dVar3.e = 0;
        dVar3.h = dVar3.e;
        dVar3.d = (-dVar3.b) / 2;
        dVar3.f = dVar3.d;
        dVar3.g = dVar3.d;
        dVar3.m = this.h / 2;
        dVar3.l = this.g;
        dVar3.k = this.g;
        dVar3.n = this.h;
        dVar3.i = true;
        dVar3.j = false;
        d dVar4 = new d(this);
        this.c[3] = dVar4;
        dVar4.f1310a = BitmapFactory.decodeResource(resources, R.drawable.guide_cloud3);
        dVar4.b = dVar4.f1310a.getWidth();
        dVar4.c = dVar4.f1310a.getHeight();
        dVar4.e = (this.h * 2) / 3;
        dVar4.h = dVar4.e;
        dVar4.d = this.g - dVar4.b;
        dVar4.f = dVar4.d;
        dVar4.g = dVar4.d;
        dVar4.i = true;
        dVar4.j = false;
        dVar4.m = this.h / 2;
        dVar4.l = this.g;
        this.b = new Paint();
        this.b.setAntiAlias(true);
    }

    @Override // com.baidu.tieba.guide.f
    public void a() {
        for (int i = 0; i < this.f1309a; i++) {
            d dVar = this.c[i];
            if (dVar.j) {
                dVar.f = (int) (dVar.f + this.f);
                if (dVar.f < (-dVar.b)) {
                    dVar.f = this.g;
                }
                dVar.g = dVar.f;
            }
        }
    }

    @Override // com.baidu.tieba.guide.f
    public boolean b() {
        return true;
    }

    @Override // com.baidu.tieba.guide.f
    public void a(int i, float f, int i2) {
        float f2 = i + f;
        if (f2 >= 0.0f && f2 < 1.0f) {
            if (f2 == 0.0f) {
                this.c[0].j = true;
                this.c[0].i = false;
                this.c[1].i = true;
                this.c[1].j = false;
                d dVar = this.c[1];
                d dVar2 = this.c[1];
                int i3 = this.c[1].d;
                dVar2.g = i3;
                dVar.f = i3;
                this.c[1].h = this.c[1].e;
                this.c[2].i = true;
                this.c[2].j = false;
                d dVar3 = this.c[2];
                d dVar4 = this.c[2];
                int i4 = this.c[2].d;
                dVar4.g = i4;
                dVar3.f = i4;
                this.c[2].h = this.c[2].e;
                this.c[3].i = true;
                this.c[3].j = false;
                d dVar5 = this.c[3];
                d dVar6 = this.c[3];
                int i5 = this.c[3].d;
                dVar6.g = i5;
                dVar5.f = i5;
                this.c[3].h = this.c[3].e;
                return;
            }
            this.c[0].j = false;
            this.c[0].i = false;
            this.c[1].j = false;
            this.c[1].i = false;
            this.c[2].j = false;
            this.c[2].i = false;
            this.c[0].f = (int) (this.c[0].g - (this.c[0].k * f));
            this.c[0].h = (int) (this.c[0].e + (this.c[0].n * f));
            this.c[1].f = (int) (this.c[1].g + ((1.0f - f) * this.c[1].l));
            this.c[1].h = (int) (this.c[1].e - ((1.0f - f) * this.c[1].m));
            this.c[2].f = (int) (this.c[2].g + ((1.0f - f) * this.c[2].l));
            this.c[2].h = (int) (this.c[2].e - ((1.0f - f) * this.c[2].m));
        } else if (f2 >= 1.0f && f2 < 2.0f) {
            if (f2 == 1.0f) {
                this.c[0].i = true;
                this.c[0].j = false;
                d dVar7 = this.c[0];
                d dVar8 = this.c[0];
                int i6 = this.c[0].d;
                dVar8.g = i6;
                dVar7.f = i6;
                this.c[0].h = this.c[0].e;
                this.c[1].j = true;
                this.c[1].i = false;
                this.c[2].i = false;
                this.c[2].j = true;
                this.c[3].i = true;
                this.c[3].j = false;
                d dVar9 = this.c[3];
                d dVar10 = this.c[3];
                int i7 = this.c[3].d;
                dVar10.g = i7;
                dVar9.f = i7;
                this.c[3].h = this.c[3].e;
                return;
            }
            this.c[1].j = false;
            this.c[1].i = false;
            this.c[2].j = false;
            this.c[2].i = false;
            this.c[1].f = (int) (this.c[1].g - (this.c[1].k * f));
            this.c[1].h = (int) (this.c[1].e + (this.c[1].n * f));
            this.c[2].f = (int) (this.c[2].g - (this.c[2].k * f));
            this.c[2].h = (int) (this.c[2].e + (this.c[2].n * f));
            this.c[3].i = false;
            this.c[3].j = false;
            this.c[3].f = (int) (this.c[3].g + ((1.0f - f) * this.c[3].l));
            this.c[3].h = (int) (this.c[3].e - ((1.0f - f) * this.c[3].m));
        } else if (f2 == 2.0f) {
            this.c[0].i = true;
            this.c[0].j = false;
            d dVar11 = this.c[0];
            d dVar12 = this.c[0];
            int i8 = this.c[0].d;
            dVar12.g = i8;
            dVar11.f = i8;
            this.c[0].h = this.c[0].e;
            this.c[1].j = false;
            this.c[1].i = true;
            d dVar13 = this.c[1];
            d dVar14 = this.c[1];
            int i9 = this.c[1].d;
            dVar14.g = i9;
            dVar13.f = i9;
            this.c[1].h = this.c[1].e;
            this.c[2].j = false;
            this.c[2].i = true;
            d dVar15 = this.c[2];
            d dVar16 = this.c[2];
            int i10 = this.c[2].d;
            dVar16.g = i10;
            dVar15.f = i10;
            this.c[2].h = this.c[2].e;
            this.c[3].i = false;
            this.c[3].j = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        for (int i = 0; i < this.f1309a; i++) {
            d dVar = this.c[i];
            if (!dVar.i) {
                this.d.set(0, 0, dVar.b, dVar.c);
                this.e.set(dVar.f, dVar.h, dVar.f + dVar.b, dVar.h + dVar.c);
                canvas.drawBitmap(dVar.f1310a, this.d, this.e, this.b);
            }
        }
        canvas.restore();
    }

    @Override // com.baidu.tieba.guide.f
    public void c() {
        for (int i = 0; i < this.f1309a; i++) {
            d dVar = this.c[i];
            dVar.f1310a.recycle();
            dVar.f1310a = null;
        }
    }
}
