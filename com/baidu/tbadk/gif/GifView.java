package com.baidu.tbadk.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.newwidget.a.i;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.t;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap a;
    private BdUniqueId A;
    private final com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> B;
    private final int b;
    private final int c;
    private WeakReference<com.baidu.adp.gif.c> d;
    private Bitmap e;
    private int f;
    private d g;
    private boolean h;
    private BitmapDrawable i;
    private boolean j;
    private Drawable k;
    private boolean l;
    private float m;
    private float n;
    private boolean o;
    private Drawable p;
    private int q;
    private final Rect r;
    private final Rect s;
    private boolean t;
    private View.OnClickListener u;
    private final Handler v;
    private boolean w;
    private a x;
    private final int y;
    private boolean z;

    public GifView(Context context) {
        this(context, null, 0);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = t.pic_expression_upload_selector;
        this.c = t.pic_expression_upload_selector_1;
        this.h = false;
        this.r = new Rect();
        this.s = new Rect();
        this.t = true;
        this.v = new b(this, Looper.getMainLooper());
        this.y = 20;
        this.z = true;
        this.B = new c(this);
        this.i = (BitmapDrawable) getResources().getDrawable(t.icon_content_animation);
        this.i.setBounds(0, 0, this.i.getIntrinsicWidth(), this.i.getIntrinsicHeight());
        this.n = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(t.loading);
        if (bitmapDrawable != null) {
            a = bitmapDrawable.getBitmap();
            this.s.set(0, 0, a.getWidth(), a.getHeight());
        }
        this.k = getResources().getDrawable(t.image_group_load_f);
        a(this.k);
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
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = i2 - (getPaddingBottom() + paddingTop);
            int i5 = i - (paddingRight + paddingLeft);
            if (a != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.r.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.k.getIntrinsicWidth();
            int intrinsicHeight = this.k.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.k.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.p != null) {
                int intrinsicWidth2 = this.p.getIntrinsicWidth();
                int intrinsicHeight2 = this.p.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.p.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.j = false;
        this.l = false;
        this.o = false;
        if (this.x != null) {
            this.x.a = false;
        }
        if (aVar == null) {
            this.j = true;
            this.h = false;
            if (this.x != null) {
                this.x.a = true;
            }
            setImageDrawable(null);
            if (this.d != null) {
                this.d.clear();
            }
        } else if (aVar.b() == null) {
            if (!aVar.a()) {
                this.h = true;
                aVar.a(this);
                this.l = false;
            }
            if (this.d != null) {
                this.d.clear();
            }
        } else if (this.d == null || !aVar.b().equals(this.d.get())) {
            this.h = false;
            if (this.e == null || (this.e.getWidth() != aVar.b().b() && this.e.getHeight() != aVar.b().c())) {
                this.e = Bitmap.createBitmap(aVar.b().b(), aVar.b().c(), Bitmap.Config.ARGB_8888);
            }
            this.d = new WeakReference<>(aVar.b());
            aVar.b().a(0);
            aVar.b().a(this.e, null);
            setImageBitmap(this.e);
            if (this.t) {
                d();
            }
        } else {
            aVar.b().a(this.f);
            aVar.b().a(this.e, null);
            setImageBitmap(this.e);
            if (this.t) {
                a();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.t;
    }

    public void setAutoPlay(boolean z) {
        this.t = z;
    }

    public void a() {
        com.baidu.adp.gif.c cVar;
        if (this.d != null && (cVar = this.d.get()) != null) {
            this.v.removeMessages(1);
            this.v.sendEmptyMessageDelayed(1, cVar.b(this.f));
        }
    }

    public void c() {
        com.baidu.adp.gif.c cVar;
        if (this.d != null && (cVar = this.d.get()) != null) {
            this.v.removeMessages(1);
            cVar.a(0);
            cVar.a(this.e, null);
            invalidate();
        }
    }

    public void d() {
        com.baidu.adp.gif.c cVar;
        if (this.d != null && (cVar = this.d.get()) != null) {
            if (this.f != 0) {
                this.f = 0;
            }
            cVar.a(0);
            this.v.removeMessages(1);
            this.v.sendEmptyMessageDelayed(1, cVar.b(this.f));
        }
    }

    public void e() {
        this.d = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.v.removeMessages(1);
        h();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.v.removeMessages(1);
        h();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.h) {
            if (i == 4 || i == 8) {
                c();
            } else if (i == 0) {
                d();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.c cVar;
        if (!this.l && !this.j && !this.o) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.d != null && !this.l && !this.j && !this.o && (cVar = this.d.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.h) {
            canvas.save();
            this.i.draw(canvas);
            canvas.restore();
        }
        if (this.l && a != null) {
            canvas.save();
            canvas.rotate(this.m, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a, this.s, this.r, (Paint) null);
            canvas.restore();
        } else if (this.j || (this.x != null && this.x.a)) {
            canvas.save();
            this.k.draw(canvas);
            canvas.restore();
        } else if (this.o) {
            canvas.save();
            this.p.draw(canvas);
            canvas.restore();
        }
    }

    public void setIsLoading(boolean z) {
        if (z) {
            f();
        } else {
            g();
        }
    }

    public void f() {
        if (!this.l) {
            this.l = true;
            i();
        }
    }

    public void a(boolean z, int i) {
        this.o = z;
        if (z) {
            this.l = false;
            this.j = false;
            if (this.p == null || this.q != i) {
                this.q = i;
                this.p = getResources().getDrawable(i);
                int intrinsicWidth = this.p.getIntrinsicWidth();
                int intrinsicHeight = this.p.getIntrinsicHeight();
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
                this.p.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public com.baidu.adp.gif.c getGif() {
        if (this.d == null) {
            return null;
        }
        return this.d.get();
    }

    public void g() {
        this.l = false;
        removeCallbacks(this);
        invalidate();
    }

    private void i() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.m += this.n;
        if (this.m > 360.0f - this.n) {
            this.m = 0.0f;
        }
        invalidate();
        i();
    }

    public void setPlayCallback(d dVar) {
        this.g = dVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.p != null && this.p.isStateful()) {
            this.p.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.x = null;
            return;
        }
        boolean b = com.baidu.tbadk.b.c.b();
        Context context = getContext();
        if (context == null || !(context instanceof com.baidu.adp.base.i)) {
            bdUniqueId = null;
            z = false;
        } else {
            com.baidu.adp.base.i iVar = (com.baidu.adp.base.i) context;
            BdUniqueId uniqueId = iVar.getUniqueId();
            z = iVar.isScroll();
            bdUniqueId = uniqueId;
        }
        if (!(aVar == this.x && this.A == bdUniqueId)) {
            h();
        }
        this.x = aVar;
        this.A = bdUniqueId;
        String str = b ? this.x.d : this.x.c;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.resourceLoader.d.a().a(this.x.b, 20, this.x.e, this.x.b, Boolean.valueOf(b), str);
        if (aVar2 != null) {
            g();
            setGif(aVar2);
        } else if (this.x.a) {
            setGif(null);
        } else if (!com.baidu.adp.lib.resourceLoader.d.a().a(20) && this.z) {
            a(true, TbadkApplication.m252getInst().getSkinType() == 1 ? this.c : this.b);
        } else {
            f();
            if (!z) {
                com.baidu.adp.lib.resourceLoader.d.a().a(this.x.b, 20, this.B, 0, 0, this.A, this.x.e, this.x.b, Boolean.valueOf(b), str);
            }
        }
    }

    public void h() {
        g();
        this.j = false;
        this.o = false;
        if (this.x != null) {
            com.baidu.adp.lib.resourceLoader.d.a().a(this.x.b, 20, this.B);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void b() {
        a(this.x);
    }

    public void setSupportNoImage(boolean z) {
        this.z = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.u = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.x != null) {
            boolean b = com.baidu.tbadk.b.c.b();
            String str = b ? this.x.d : this.x.c;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.resourceLoader.d.a().a(this.x.b, 20, this.x.e, this.x.b, Boolean.valueOf(b), str);
            if (aVar != null) {
                this.x.a = false;
                setGif(aVar);
            } else {
                f();
                com.baidu.adp.lib.resourceLoader.d.a().a(this.x.b, 20, this.B, 0, 0, this.A, this.x.e, this.x.b, Boolean.valueOf(b), str);
                return;
            }
        }
        if (this.u != null) {
            this.u.onClick(view);
        }
    }
}
