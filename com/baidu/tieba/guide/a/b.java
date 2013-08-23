package com.baidu.tieba.guide.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Random;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.guide.e {
    private Context i;

    /* renamed from: a  reason: collision with root package name */
    private int f1126a = 12;
    private int b = 10;
    private float c = 1.0f;
    private float d = -20.0f;
    private float e = 20.0f;
    private int f = 0;
    private int g = Util.MASK_8BIT;
    private float h = 0.0f;
    private Bitmap j = null;
    private Bitmap k = null;
    private Bitmap l = null;
    private Bitmap m = null;
    private Bitmap n = null;
    private Bitmap o = null;
    private Bitmap p = null;
    private Matrix q = null;
    private Matrix r = null;
    private Matrix s = null;
    private Matrix t = null;
    private Matrix u = null;
    private Matrix v = null;
    private int w = 0;
    private int x = 0;
    private int y = 0;
    private Paint z = null;
    private Paint A = null;
    private Paint B = null;
    private int C = 0;
    private float D = 0.0f;
    private int E = 0;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private int J = 0;
    private int K = 0;
    private int L = 0;
    private int M = 0;
    private int[] N = null;
    private float[] O = null;
    private boolean P = false;

    public b(Context context) {
        this.i = null;
        this.i = context;
        e();
    }

    private void e() {
        this.k = com.baidu.tieba.util.e.b(this.i, (int) R.drawable.rachel);
        this.l = com.baidu.tieba.util.e.b(this.i, (int) R.drawable.chandler);
        this.m = com.baidu.tieba.util.e.b(this.i, (int) R.drawable.ross);
        this.j = com.baidu.tieba.util.e.b(this.i, (int) R.drawable.ballons);
        this.n = com.baidu.tieba.util.e.b(this.i, (int) R.drawable.guide_sun_sparkle);
        this.o = com.baidu.tieba.util.e.b(this.i, (int) R.drawable.ballons_sparkle1);
        this.p = com.baidu.tieba.util.e.b(this.i, (int) R.drawable.ballons_sparkle2);
        this.B = new Paint();
        this.A = new Paint();
        this.z = new Paint();
        this.r = new Matrix();
        this.s = new Matrix();
        this.q = new Matrix();
        this.t = new Matrix();
        this.u = new Matrix();
        this.v = new Matrix();
        this.B.setFilterBitmap(true);
        this.w = UtilHelper.a(this.i);
        this.x = (this.w * 3) / 4;
        float width = this.x / this.j.getWidth();
        this.y = (int) (this.j.getHeight() * width);
        this.s.setScale(width, width);
        this.L = this.w / 8;
        this.M = this.w / 15;
        float width2 = (1.1f * this.x) / this.o.getWidth();
        this.r.setScale(width2, width2);
        this.r.postTranslate((-this.x) * 0.05f, (-this.y) * 0.05f);
        this.F = ((this.y * 5) / 6) - (this.k.getHeight() >> 1);
        this.G = this.y - (this.l.getHeight() >> 1);
        this.H = ((this.y * 5) / 6) - (this.l.getHeight() >> 1);
        this.I = (((this.x * 2) / 3) - this.k.getWidth()) >> 1;
        this.J = (this.x - this.l.getWidth()) >> 1;
        this.K = (((this.x * 4) / 3) - this.m.getWidth()) >> 1;
        this.N = new int[50];
        this.O = new float[25];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 25; i++) {
            int abs = Math.abs(random.nextInt());
            this.N[i << 1] = abs % this.x;
            this.N[(i << 1) + 1] = (abs / this.x) % this.y;
            this.O[i] = ((((abs / this.y) / this.x) % 100) / 100.0f) + 0.7f;
        }
    }

    public int d() {
        return this.y;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.C != 0 && !this.P) {
            canvas.save();
            if (this.C == 1) {
                canvas.translate((this.L + this.w) - this.E, ((this.M + this.y) * this.D) - this.y);
            } else if (this.C == 2) {
                canvas.translate(this.L, this.M);
            }
            a(canvas);
            canvas.drawBitmap(this.j, this.s, this.B);
            b(canvas);
            c(canvas);
            canvas.restore();
        }
    }

    private void a(Canvas canvas) {
        this.A.setAlpha(this.g);
        canvas.drawBitmap(this.o, this.r, this.A);
        this.A.setAlpha(255 - this.g);
        canvas.drawBitmap(this.p, this.r, this.A);
    }

    private void b(Canvas canvas) {
        this.z.setAlpha(this.f);
        for (int i = 0; i < 25; i++) {
            this.q.setScale(this.O[i], this.O[i]);
            this.q.postTranslate(this.N[i << 1], this.N[(i << 1) + 1]);
            canvas.drawBitmap(this.n, this.q, this.z);
        }
    }

    private void c(Canvas canvas) {
        canvas.drawBitmap(this.k, this.t, null);
        canvas.drawBitmap(this.l, this.u, null);
        canvas.drawBitmap(this.m, this.v, null);
    }

    @Override // com.baidu.tieba.guide.e, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.z.setAlpha(i);
    }

    @Override // com.baidu.tieba.guide.e, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // com.baidu.tieba.guide.e, android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // com.baidu.tieba.guide.e
    public void a() {
        int i = Util.MASK_8BIT;
        if (this.C != 0) {
            this.h = (float) (this.h + (this.c * (1.0d - (0.5d * Math.abs(this.h / this.e)))));
            if (this.h < this.d || this.h > this.e) {
                this.h = this.h < this.d ? this.d : this.h;
                this.h = this.h > this.e ? this.e : this.h;
                this.c = -this.c;
            }
            this.t.setRotate(this.h, this.k.getWidth() >> 1, this.k.getHeight() >> 1);
            this.u.setRotate(this.h, this.l.getWidth() >> 1, this.l.getHeight() >> 1);
            this.v.setRotate(this.h, this.m.getWidth() >> 1, this.m.getHeight() >> 1);
            this.t.postTranslate(this.I, this.F);
            this.u.postTranslate(this.J, this.G);
            this.v.postTranslate(this.K, this.H);
            this.f += this.f1126a;
            if (this.f > 255 || this.f < 0) {
                this.f = this.f > 255 ? 255 : this.f;
                this.f = this.f < 0 ? 0 : this.f;
                this.f1126a = -this.f1126a;
            }
            this.g += this.b;
            if (this.g > 255 || this.g < 0) {
                if (this.g <= 255) {
                    i = this.g;
                }
                this.g = i;
                this.g = this.g >= 0 ? this.g : 0;
                this.b = -this.b;
            }
        }
    }

    @Override // com.baidu.tieba.guide.e
    public boolean b() {
        return this.C != 0;
    }

    @Override // com.baidu.tieba.guide.e
    public void a(int i, float f, int i2) {
        this.C = i;
        this.D = f;
        this.E = i2;
    }

    @Override // com.baidu.tieba.guide.e
    public void c() {
        this.P = true;
        try {
            this.j.recycle();
            this.k.recycle();
            this.l.recycle();
            this.m.recycle();
            this.n.recycle();
            this.o.recycle();
            this.p.recycle();
        } catch (Exception e) {
            aq.b(getClass().getName(), "releaseResource", e.toString());
        }
    }
}
