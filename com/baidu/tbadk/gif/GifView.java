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
import com.baidu.adp.gif.c;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.widget.richText.e;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements Runnable {
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
    private boolean s;
    private Drawable t;
    private int u;
    private Handler v;
    private boolean w;
    private boolean x;

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
        this.v = new a(this);
        this.f = (BitmapDrawable) getResources().getDrawable(com.baidu.tbadk.c.icon_content_animation);
        this.f.setBounds(0, 0, this.f.getIntrinsicWidth(), this.f.getIntrinsicHeight());
        this.o = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(com.baidu.tbadk.c.loading);
        if (bitmapDrawable != null) {
            a = bitmapDrawable.getBitmap();
            this.q.set(0, 0, a.getWidth(), a.getHeight());
        }
        this.j = getResources().getDrawable(com.baidu.tbadk.c.image_group_load_f);
        Drawable drawable = this.j;
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
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = i2 - (getPaddingBottom() + paddingTop);
            int i5 = i - (paddingRight + paddingLeft);
            if (a != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.p.set(i7, i8, i7 + i6, i8 + i6);
                com.baidu.adp.lib.util.e.e("GifView", "onSizeChanged", "w:" + i5 + "h:" + paddingBottom + "dw:" + i6 + "dh:" + i6);
            }
            int intrinsicWidth = this.j.getIntrinsicWidth();
            int intrinsicHeight = this.j.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.j.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.t != null) {
                int intrinsicWidth2 = this.t.getIntrinsicWidth();
                int intrinsicHeight2 = this.t.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.t.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 com.baidu.adp.widget.ImageView.b)] */
    public void setGif(com.baidu.adp.widget.ImageView.b bVar) {
        c cVar;
        com.baidu.adp.lib.util.e.e("GifView", "setGif", new StringBuilder().append(bVar).toString());
        this.i = false;
        this.h = false;
        this.s = false;
        if (bVar == null) {
            this.i = true;
            this.g = false;
            setImageBitmap(null);
            if (this.b != null) {
                this.b.clear();
            }
        } else if (bVar.b() == null) {
            if (!bVar.a()) {
                com.baidu.adp.lib.util.e.e("GifView", "setGif", "static");
                this.g = true;
                bVar.a(this);
                this.h = false;
            }
            if (this.b != null) {
                this.b.clear();
            }
        } else if (this.b == null || !bVar.b().equals(this.b.get())) {
            this.g = false;
            if (this.c == null || (this.c.getWidth() != bVar.b().b() && this.c.getHeight() != bVar.b().c())) {
                this.c = Bitmap.createBitmap(bVar.b().b(), bVar.b().c(), Bitmap.Config.ARGB_8888);
            }
            this.b = new WeakReference<>(bVar.b());
            bVar.b().a(0);
            bVar.b().a(this.c, null);
            setImageBitmap(this.c);
            if (this.r) {
                d();
            }
        } else {
            bVar.b().a(this.d);
            bVar.b().a(this.c, null);
            setImageBitmap(this.c);
            if (!this.r || this.b == null || (cVar = this.b.get()) == null) {
                return;
            }
            this.v.removeMessages(1);
            this.v.sendEmptyMessageDelayed(1, cVar.b(this.d));
            com.baidu.adp.lib.util.e.e("GifView", "resume", "resumed");
        }
    }

    public boolean getAutoPlay() {
        return this.r;
    }

    public void setAutoPlay(boolean z) {
        this.r = z;
    }

    public final void a() {
        c cVar;
        if (this.b != null && (cVar = this.b.get()) != null) {
            this.v.removeMessages(1);
            cVar.a(0);
            cVar.a(this.c, null);
            invalidate();
            com.baidu.adp.lib.util.e.e("GifView", "stop", "stopped");
        }
    }

    private void d() {
        c cVar;
        if (this.b != null && (cVar = this.b.get()) != null) {
            if (this.d != 0) {
                this.d = 0;
            }
            cVar.a(0);
            this.v.removeMessages(1);
            this.v.sendEmptyMessageDelayed(1, cVar.b(this.d));
            com.baidu.adp.lib.util.e.e("GifView", "play", "played");
        }
    }

    public final void b() {
        this.x = true;
        d();
    }

    public final void c() {
        this.b = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.baidu.adp.lib.util.e.e("GifView", "onWindowVisibilityChanged", "changed = " + i);
        if (!this.g) {
            if (i == 4 || i == 8) {
                a();
            } else if (i == 0) {
                d();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        c cVar;
        if (!this.h && !this.i && !this.s) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.b != null && !this.h && !this.i && !this.s && (cVar = this.b.get()) != null) {
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
        if (this.s) {
            canvas.save();
            this.t.draw(canvas);
            canvas.restore();
        }
        if (this.h && a != null) {
            canvas.save();
            canvas.rotate(this.l, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a, this.q, this.p, (Paint) null);
            canvas.restore();
            if (this.w || this.w) {
                return;
            }
            this.w = true;
            e();
        } else if (a != null && this.w) {
            this.w = false;
            removeCallbacks(this);
        }
    }

    public void setIsLoading(boolean z) {
        this.h = z;
        if (z) {
            this.i = false;
            this.s = false;
        }
        invalidate();
    }

    public final void a(boolean z, int i) {
        this.s = z;
        if (z) {
            this.h = false;
            this.i = false;
            if (this.t == null || this.u != i) {
                this.u = i;
                this.t = getResources().getDrawable(i);
                int intrinsicWidth = this.t.getIntrinsicWidth();
                int intrinsicHeight = this.t.getIntrinsicHeight();
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                if (intrinsicWidth > measuredWidth) {
                    intrinsicWidth = measuredWidth;
                }
                if (intrinsicHeight > measuredHeight) {
                    intrinsicHeight = measuredHeight;
                }
                int paddingLeft = ((measuredWidth - intrinsicWidth) / 2) + getPaddingLeft();
                int paddingTop = ((measuredHeight - intrinsicHeight) / 2) + getPaddingTop();
                this.t.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
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
        com.baidu.adp.lib.util.e.e("GifView", "onLayout", this + ": onLayout");
        com.baidu.adp.lib.util.e.e("GifView", "onLayout", "width=" + i3 + " height=" + i4);
    }

    private void e() {
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
        e();
    }

    public void setPlayCallback(b bVar) {
        this.e = bVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.t != null && this.t.isStateful()) {
            this.t.setState(getDrawableState());
            invalidate();
        }
    }
}
