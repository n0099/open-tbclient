package com.baidu.tieba.guide.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.baidu.location.LocationClientOption;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.guide.e {
    private boolean A;
    private int B;
    private int D;
    private Bitmap e;
    private int f;
    private int g;
    private Bitmap h;
    private int i;
    private int j;
    private Bitmap k;
    private int l;
    private int m;
    private int n;
    private int o;
    private Resources p;
    private Paint q;
    private boolean t;
    private Scroller u;
    private int w;
    private Context z;

    /* renamed from: a  reason: collision with root package name */
    private final int f1176a = 0;
    private final int b = 1;
    private final int c = 2;
    private final int d = 3;
    private Rect r = new Rect();
    private Rect s = new Rect();
    private int v = -1;
    private int x = 30;
    private int y = LocationClientOption.MIN_SCAN_SPAN;
    private int C = 10;

    public e(Context context, int i) {
        this.z = context;
        this.p = context.getResources();
        float f = this.p.getDisplayMetrics().heightPixels;
        this.n = (int) (this.p.getDisplayMetrics().widthPixels / 14.0f);
        this.o = i / 2;
        this.e = BitmapFactory.decodeResource(this.p, R.drawable.guide_me_ballon);
        this.f = this.e.getWidth();
        this.g = this.e.getHeight();
        this.h = BitmapFactory.decodeResource(this.p, R.drawable.guide_me);
        this.i = this.h.getWidth();
        this.j = this.h.getHeight();
        this.k = BitmapFactory.decodeResource(this.p, R.drawable.guide_me_smail);
        this.l = this.k.getWidth();
        this.m = this.k.getHeight();
        this.q = new Paint();
        this.q.setAntiAlias(true);
        this.q.setFilterBitmap(true);
    }

    @Override // com.baidu.tieba.guide.e
    public void a() {
        if (this.u != null && this.u.computeScrollOffset()) {
            this.w = this.u.getCurrX();
        } else if (this.D == 2 && (this.v == 1 || this.v == 3)) {
            this.t = true;
            if (this.B == this.C) {
                this.A = this.A ? false : true;
                this.B = 0;
                return;
            }
            this.B++;
        } else {
            this.t = false;
            this.v = d();
            switch (this.v) {
                case 0:
                    this.u = new Scroller(this.z, new DecelerateInterpolator());
                    this.u.startScroll(0, 0, this.x, 0, this.y);
                    return;
                case 1:
                    this.u = new Scroller(this.z, new AccelerateInterpolator());
                    this.u.startScroll(this.x, 0, 0 - this.x, 0, this.y);
                    return;
                case 2:
                    this.u = new Scroller(this.z, new DecelerateInterpolator());
                    this.u.startScroll(0, 0, -this.x, 0, this.y);
                    return;
                case 3:
                    this.u = new Scroller(this.z, new AccelerateInterpolator());
                    this.u.startScroll(-this.x, 0, this.x + 0, 0, this.y);
                    return;
                default:
                    return;
            }
        }
    }

    private int d() {
        switch (this.v) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
            default:
                return 0;
        }
    }

    @Override // com.baidu.tieba.guide.e
    public boolean b() {
        return true;
    }

    @Override // com.baidu.tieba.guide.e
    public void a(int i, float f, int i2) {
        this.D = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        int i = this.n;
        int i2 = this.o;
        int i3 = this.n + this.f;
        int i4 = this.o + this.g;
        this.r.set(0, 0, this.f, this.g);
        this.s.set(i, i2, i3, i4);
        canvas.drawBitmap(this.e, this.r, this.s, this.q);
        if (!this.t) {
            canvas.save();
            this.r.set(0, 0, this.i, this.j);
            int i5 = ((i + i3) / 2) - (this.i / 2);
            int i6 = this.i + i5;
            this.s.set(i5, i4, i6, this.j + i4);
            canvas.rotate(this.w, (i5 + i6) / 2, i4);
            canvas.drawBitmap(this.h, this.r, this.s, this.q);
            canvas.restore();
        } else if (this.A) {
            this.r.set(0, 0, this.i, this.j);
            int i7 = ((i + i3) / 2) - (this.i / 2);
            this.s.set(i7, i4, this.i + i7, this.j + i4);
            canvas.drawBitmap(this.h, this.r, this.s, this.q);
        } else {
            this.r.set(0, 0, this.l, this.m);
            int i8 = ((i + i3) / 2) - (this.l / 2);
            this.s.set(i8, i4, this.l + i8, this.m + i4);
            canvas.drawBitmap(this.k, this.r, this.s, this.q);
        }
        canvas.restore();
    }

    @Override // com.baidu.tieba.guide.e, android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // com.baidu.tieba.guide.e, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // com.baidu.tieba.guide.e, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // com.baidu.tieba.guide.e
    public void c() {
        if (this.e != null) {
            this.e.recycle();
            this.e = null;
        }
        if (this.h != null) {
            this.h.recycle();
            this.h = null;
        }
        if (this.k != null) {
            this.k.recycle();
            this.k = null;
        }
    }
}
