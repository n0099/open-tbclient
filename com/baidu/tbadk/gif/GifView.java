package com.baidu.tbadk.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.adp.gif.IGifPlay;
import com.baidu.adp.gif.c;
import com.baidu.adp.widget.ImageView.d;
import com.baidu.tbadk.widget.richText.e;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements IGifPlay, Runnable {
    public static Bitmap a;
    private WeakReference<c> b;
    private Bitmap c;
    private int d;
    private BitmapDrawable e;
    private boolean f;
    private boolean g;
    private boolean h;
    private Drawable i;
    private e j;
    private float k;
    private final int l;
    private final int m;
    private float n;
    private Rect o;
    private Rect p;
    private Handler q;
    private boolean r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(GifView gifView, int i) {
        int i2 = gifView.d + i;
        gifView.d = i2;
        return i2;
    }

    public GifView(Context context) {
        this(context, null, 0);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = false;
        this.l = 12;
        this.m = 150;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new a(this);
        this.e = (BitmapDrawable) getResources().getDrawable(com.baidu.tbadk.c.icon_content_animation);
        this.e.setBounds(0, 0, this.e.getIntrinsicWidth(), this.e.getIntrinsicHeight());
        this.n = 30.0f;
        a = BitmapFactory.decodeResource(getResources(), com.baidu.tbadk.c.loading);
        this.p.set(0, 0, a.getWidth(), a.getHeight());
        this.i = getResources().getDrawable(com.baidu.tbadk.c.image_group_load_f);
        a(this.i);
    }

    private void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setFilterBitmap(true);
            if (drawable instanceof BitmapDrawable) {
                ((BitmapDrawable) drawable).setAntiAlias(true);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            int i5 = i / 4;
            int i6 = (i - i5) / 2;
            int i7 = (i2 - i5) / 2;
            com.baidu.adp.lib.h.e.e("GifView", "onSizeChanged", "w:" + i + "h:" + i2 + "dw:" + i5 + "dh:" + i5);
            this.o.set(i6, i7, i6 + i5, i7 + i5);
            int intrinsicWidth = this.i.getIntrinsicWidth();
            int intrinsicHeight = this.i.getIntrinsicHeight();
            int i8 = (i - intrinsicWidth) / 2;
            int i9 = (i2 - intrinsicHeight) / 2;
            this.i.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
        }
    }

    public void setGif(d dVar) {
        com.baidu.adp.lib.h.e.e("GifView", "setGif", "" + dVar);
        this.h = false;
        this.g = false;
        if (dVar == null) {
            this.h = true;
            this.f = false;
            setImageBitmap(null);
            if (this.b != null) {
                this.b.clear();
            }
        } else if (dVar.b() == null) {
            if (!dVar.a()) {
                com.baidu.adp.lib.h.e.e("GifView", "setGif", "static");
                this.f = true;
                dVar.a(this);
                this.g = false;
            }
            if (this.b != null) {
                this.b.clear();
            }
        } else if (this.b == null || !dVar.b().equals(this.b.get())) {
            this.f = false;
            if (this.c == null || (this.c.getWidth() != dVar.b().c() && this.c.getHeight() != dVar.b().d())) {
                this.c = Bitmap.createBitmap(dVar.b().c(), dVar.b().d(), Bitmap.Config.ARGB_8888);
            }
            this.b = new WeakReference<>(dVar.b());
            dVar.b().a(0);
            dVar.b().a(this.c, null);
            setImageBitmap(this.c);
            c();
        } else {
            dVar.b().a(this.d);
            dVar.b().a(this.c, null);
            setImageBitmap(this.c);
            a();
        }
    }

    public void a() {
        c cVar;
        if (this.b != null && (cVar = this.b.get()) != null) {
            this.q.removeMessages(1);
            this.q.sendEmptyMessageDelayed(1, cVar.b(this.d));
            com.baidu.adp.lib.h.e.e("GifView", "resume", "resumed");
        }
    }

    public void b() {
        c cVar;
        if (this.b != null && (cVar = this.b.get()) != null) {
            this.q.removeMessages(1);
            cVar.a(0);
            com.baidu.adp.lib.h.e.e("GifView", "stop", "stopped");
        }
    }

    public void c() {
        c cVar;
        if (this.b != null && (cVar = this.b.get()) != null) {
            if (this.d != 0) {
                this.d = 0;
            }
            cVar.a(0);
            this.q.removeMessages(1);
            this.q.sendEmptyMessageDelayed(1, cVar.b(this.d));
            com.baidu.adp.lib.h.e.e("GifView", "play", "played");
        }
    }

    public void d() {
        this.b = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.baidu.adp.lib.h.e.e("GifView", "onWindowVisibilityChanged", "changed = " + i);
        if (!this.f) {
            if (i == 4 || i == 8) {
                b();
            } else if (i == 0) {
                c();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        c cVar;
        if (!this.g) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.b != null && !this.g && (cVar = this.b.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.f) {
            canvas.save();
            this.e.draw(canvas);
            canvas.restore();
        }
        if (this.h) {
            canvas.save();
            this.i.draw(canvas);
            canvas.restore();
        }
        if (this.g && a != null) {
            canvas.save();
            canvas.rotate(this.k, getWidth() * 0.5f, getHeight() * 0.5f);
            canvas.drawBitmap(a, this.p, this.o, (Paint) null);
            canvas.restore();
            if (!this.r) {
                e();
            }
        } else if (a != null && this.r) {
            f();
        }
    }

    public void setIsLoading(boolean z) {
        this.g = z;
        if (z) {
            this.h = false;
        }
        invalidate();
    }

    public c getGif() {
        if (this.b == null) {
            return null;
        }
        return this.b.get();
    }

    public void setTbRichTextEmotionInfo(e eVar) {
        this.j = eVar;
    }

    public e getTbRichTextEmotionINfo() {
        return this.j;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        com.baidu.adp.lib.h.e.e("GifView", "onLayout", "" + this + ": onLayout");
        com.baidu.adp.lib.h.e.e("GifView", "onLayout", "width=" + i3 + " height=" + i4);
    }

    public void e() {
        if (!this.r) {
            this.r = true;
            g();
        }
    }

    public void f() {
        this.r = false;
        removeCallbacks(this);
    }

    private void g() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.k += this.n;
        if (this.k > 360.0f - this.n) {
            this.k = 0.0f;
        }
        invalidate();
        g();
    }
}
