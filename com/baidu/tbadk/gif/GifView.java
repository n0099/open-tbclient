package com.baidu.tbadk.gif;

import android.content.Context;
import android.graphics.Bitmap;
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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.widget.richText.e;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements IGifPlay, Runnable {
    public static Bitmap a;
    private WeakReference<c> b;
    private Bitmap c;
    private int d;
    private b e;
    private BitmapDrawable f;
    private boolean g;
    private boolean h;
    private boolean i;
    private Drawable j;
    private e k;
    private float l;
    private final int m;
    private final int n;
    private float o;
    private Rect p;
    private Rect q;
    private boolean r;
    private Handler s;
    private boolean t;
    private boolean u;

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
        this.g = false;
        this.m = 12;
        this.n = SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED;
        this.p = new Rect();
        this.q = new Rect();
        this.r = true;
        this.s = new a(this);
        this.f = (BitmapDrawable) getResources().getDrawable(com.baidu.tbadk.c.icon_content_animation);
        this.f.setBounds(0, 0, this.f.getIntrinsicWidth(), this.f.getIntrinsicHeight());
        this.o = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(com.baidu.tbadk.c.loading);
        if (bitmapDrawable != null) {
            a = bitmapDrawable.getBitmap();
            this.q.set(0, 0, a.getWidth(), a.getHeight());
        }
        this.j = getResources().getDrawable(com.baidu.tbadk.c.image_group_load_f);
        a(this.j);
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
            com.baidu.adp.lib.g.e.e("GifView", "onSizeChanged", "w:" + i + "h:" + i2 + "dw:" + i5 + "dh:" + i5);
            this.p.set(i6, i7, i6 + i5, i7 + i5);
            int intrinsicWidth = this.j.getIntrinsicWidth();
            int intrinsicHeight = this.j.getIntrinsicHeight();
            int i8 = (i - intrinsicWidth) / 2;
            int i9 = (i2 - intrinsicHeight) / 2;
            this.j.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
        }
    }

    public void setGif(d dVar) {
        com.baidu.adp.lib.g.e.e("GifView", "setGif", "" + dVar);
        this.i = false;
        this.h = false;
        if (dVar == null) {
            this.i = true;
            this.g = false;
            setImageBitmap(null);
            if (this.b != null) {
                this.b.clear();
            }
        } else if (dVar.b() == null) {
            if (!dVar.a()) {
                com.baidu.adp.lib.g.e.e("GifView", "setGif", "static");
                this.g = true;
                dVar.a(this);
                this.h = false;
            }
            if (this.b != null) {
                this.b.clear();
            }
        } else if (this.b == null || !dVar.b().equals(this.b.get())) {
            this.g = false;
            if (this.c == null || (this.c.getWidth() != dVar.b().c() && this.c.getHeight() != dVar.b().d())) {
                this.c = Bitmap.createBitmap(dVar.b().c(), dVar.b().d(), Bitmap.Config.ARGB_8888);
            }
            this.b = new WeakReference<>(dVar.b());
            dVar.b().a(0);
            dVar.b().a(this.c, null);
            setImageBitmap(this.c);
            if (this.r) {
                c();
            }
        } else {
            dVar.b().a(this.d);
            dVar.b().a(this.c, null);
            setImageBitmap(this.c);
            if (this.r) {
                a();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.r;
    }

    public void setAutoPlay(boolean z) {
        this.r = z;
    }

    public void a() {
        c cVar;
        if (this.b != null && (cVar = this.b.get()) != null) {
            this.s.removeMessages(1);
            this.s.sendEmptyMessageDelayed(1, cVar.b(this.d));
            com.baidu.adp.lib.g.e.e("GifView", "resume", "resumed");
        }
    }

    public void b() {
        c cVar;
        if (this.b != null && (cVar = this.b.get()) != null) {
            this.s.removeMessages(1);
            cVar.a(0);
            cVar.a(this.c, null);
            invalidate();
            com.baidu.adp.lib.g.e.e("GifView", "stop", "stopped");
        }
    }

    public void c() {
        c cVar;
        if (this.b != null && (cVar = this.b.get()) != null) {
            if (this.d != 0) {
                this.d = 0;
            }
            cVar.a(0);
            this.s.removeMessages(1);
            this.s.sendEmptyMessageDelayed(1, cVar.b(this.d));
            com.baidu.adp.lib.g.e.e("GifView", "play", "played");
        }
    }

    public void d() {
        this.u = true;
        c();
    }

    public void e() {
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
        com.baidu.adp.lib.g.e.e("GifView", "onWindowVisibilityChanged", "changed = " + i);
        if (!this.g) {
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
        if (!this.h) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.b != null && !this.h && (cVar = this.b.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.g) {
            canvas.save();
            this.f.draw(canvas);
            canvas.restore();
        }
        if (this.i) {
            canvas.save();
            this.j.draw(canvas);
            canvas.restore();
        }
        if (this.h && a != null) {
            canvas.save();
            canvas.rotate(this.l, getWidth() * 0.5f, getHeight() * 0.5f);
            canvas.drawBitmap(a, this.q, this.p, (Paint) null);
            canvas.restore();
            if (!this.t) {
                f();
            }
        } else if (a != null && this.t) {
            g();
        }
    }

    public void setIsLoading(boolean z) {
        this.h = z;
        if (z) {
            this.i = false;
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
        this.k = eVar;
    }

    public e getTbRichTextEmotionINfo() {
        return this.k;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        com.baidu.adp.lib.g.e.e("GifView", "onLayout", "" + this + ": onLayout");
        com.baidu.adp.lib.g.e.e("GifView", "onLayout", "width=" + i3 + " height=" + i4);
    }

    public void f() {
        if (!this.t) {
            this.t = true;
            h();
        }
    }

    public void g() {
        this.t = false;
        removeCallbacks(this);
    }

    private void h() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.l += this.o;
        if (this.l > 360.0f - this.o) {
            this.l = 0.0f;
        }
        invalidate();
        h();
    }

    public void setPlayCallback(b bVar) {
        this.e = bVar;
    }
}
