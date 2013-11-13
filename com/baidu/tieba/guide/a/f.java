package com.baidu.tieba.guide.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Random;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.guide.g {
    private Scroller A;
    private Scroller B;

    /* renamed from: a  reason: collision with root package name */
    private int f1379a;
    private float b;
    private float c;
    private float d;
    private float e;
    private Paint g;
    private Bitmap h;
    private Bitmap i;
    private Resources j;
    private Random k;
    private int l;
    private int m;
    private int n;
    private int o;
    private float s;
    private float t;
    private float u;
    private float v;
    private g[] w;
    private int y;
    private boolean z;
    private Rect p = new Rect();
    private Rect q = new Rect();
    private boolean r = true;
    private int x = 256;
    private Paint f = new Paint();

    public f(Context context, int i) {
        this.f1379a = i;
        this.f.setAntiAlias(true);
        this.f.setFilterBitmap(true);
        this.g = new Paint();
        this.g.setAntiAlias(true);
        this.g.setFilterBitmap(true);
        this.j = context.getResources();
        int i2 = this.j.getDisplayMetrics().widthPixels;
        float f = this.j.getDisplayMetrics().density;
        this.b = i2 - (223.0f * f);
        this.d = this.b;
        this.c = 0.0f;
        this.e = this.c;
        this.l = (int) (223.0f * f);
        this.m = (int) (f * 206.0f);
        this.s = i2 - this.b;
        this.t = this.b + this.l;
        this.u = this.c + this.m;
        this.v = this.m * 2;
        this.h = BitmapFactory.decodeResource(this.j, R.drawable.guide_sun);
        this.i = BitmapFactory.decodeResource(this.j, R.drawable.guide_sun_sparkle);
        this.n = this.i.getWidth();
        this.o = this.i.getHeight();
        this.k = new Random(System.currentTimeMillis());
        this.w = new g[i];
        for (int i3 = 0; i3 < i; i3++) {
            g gVar = new g(this);
            this.w[i3] = gVar;
            gVar.f1380a = this.k.nextInt(this.l - this.n);
            gVar.b = this.k.nextInt(this.m - this.o);
            gVar.c = this.k.nextInt(this.n) + (this.n / 2);
            gVar.d = this.k.nextInt(this.o) + (this.o / 2);
        }
        if (this.A == null) {
            this.A = new Scroller(context, new DecelerateInterpolator());
            this.A.startScroll(Util.MASK_8BIT, 0, -255, 0, 2000);
        }
        if (this.B == null) {
            this.B = new Scroller(context, new LinearInterpolator());
            this.B.startScroll(0, 0, 360, 0, 20000);
        }
    }

    @Override // com.baidu.tieba.guide.g
    public void a() {
        if (!this.r) {
            if (this.A.computeScrollOffset()) {
                this.x = this.A.getCurrX();
            } else {
                this.z = !this.z;
                if (this.z) {
                    this.A.startScroll(this.x, 0, 255 - this.x, 0, 2000);
                } else {
                    this.A.startScroll(this.x, 0, 0 - this.x, 0, 2000);
                }
            }
            if (this.B.computeScrollOffset()) {
                this.y = this.B.getCurrX();
            } else {
                this.B.startScroll(0, 0, 360, 0, 20000);
            }
            for (int i = 0; i < this.f1379a; i++) {
                g gVar = this.w[i];
                if (i % 2 == 0) {
                    gVar.e = this.x;
                } else {
                    gVar.e = 255 - this.x;
                }
            }
        }
    }

    @Override // com.baidu.tieba.guide.g
    public boolean b() {
        return true;
    }

    @Override // com.baidu.tieba.guide.g
    public void a(int i, float f, int i2) {
        float f2 = i + f;
        if (f2 > 0.0f && f2 < 2.0f) {
            this.r = false;
            if (f2 < 1.0f) {
                this.d = this.b + (this.s * (1.0f - f));
                this.e = this.c - (this.u * (1.0f - f));
                return;
            }
            this.d = this.b - (this.t * f);
            this.e = this.c + (this.v * f);
            return;
        }
        this.r = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.r) {
            canvas.save();
            int i = (int) this.d;
            int i2 = (int) this.e;
            int i3 = this.l + i;
            int i4 = this.m + i2;
            this.p.set(0, 0, this.h.getWidth(), this.h.getHeight());
            this.q.set(i, i2, i3, i4);
            canvas.save();
            canvas.rotate(this.y, (i + i3) / 2, (i2 + i4) / 2);
            canvas.drawBitmap(this.h, this.p, this.q, this.f);
            canvas.restore();
            for (int i5 = 0; i5 < this.f1379a; i5++) {
                g gVar = this.w[i5];
                this.p.set(0, 0, this.n, this.o);
                int i6 = (int) (gVar.f1380a + this.d);
                int i7 = (int) (gVar.b + this.e);
                this.q.set(i6, i7, gVar.c + i6, gVar.d + i7);
                this.g.setAlpha(gVar.e);
                canvas.drawBitmap(this.i, this.p, this.q, this.g);
            }
            canvas.restore();
        }
    }

    @Override // com.baidu.tieba.guide.g
    public void c() {
        if (this.h != null) {
            this.h.recycle();
            this.h = null;
        }
        if (this.i != null) {
            this.i.recycle();
            this.i = null;
        }
    }
}
