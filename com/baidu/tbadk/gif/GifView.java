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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.newwidget.a.g;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.u;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, g, Runnable {
    public static Bitmap a;
    private int A;
    private boolean B;
    private int C;
    private com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> D;
    private int b;
    private int c;
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
    private final int n;
    private final int o;
    private float p;
    private boolean q;
    private Drawable r;
    private int s;
    private Rect t;
    private Rect u;
    private boolean v;
    private View.OnClickListener w;
    private Handler x;
    private boolean y;
    private a z;

    public GifView(Context context) {
        this(context, null, 0);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = u.pic_expression_upload_selector;
        this.c = u.pic_expression_upload_selector_1;
        this.h = false;
        this.n = 12;
        this.o = 150;
        this.t = new Rect();
        this.u = new Rect();
        this.v = true;
        this.x = new b(this, Looper.getMainLooper());
        this.A = 20;
        this.B = true;
        this.D = new c(this);
        this.i = (BitmapDrawable) getResources().getDrawable(u.icon_content_animation);
        this.i.setBounds(0, 0, this.i.getIntrinsicWidth(), this.i.getIntrinsicHeight());
        this.p = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(u.loading);
        if (bitmapDrawable != null) {
            a = bitmapDrawable.getBitmap();
            this.u.set(0, 0, a.getWidth(), a.getHeight());
        }
        this.k = getResources().getDrawable(u.image_group_load_f);
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
                this.t.set(i7, i8, i7 + i6, i8 + i6);
                BdLog.d("GifView", "onSizeChanged", "w:" + i5 + "h:" + paddingBottom + "dw:" + i6 + "dh:" + i6);
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
            if (this.r != null) {
                int intrinsicWidth2 = this.r.getIntrinsicWidth();
                int intrinsicHeight2 = this.r.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.r.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 com.baidu.adp.widget.a.a)] */
    public void setGif(com.baidu.adp.widget.a.a aVar) {
        BdLog.d("GifView", "setGif", new StringBuilder().append(aVar).toString());
        this.j = false;
        this.l = false;
        this.q = false;
        if (this.z != null) {
            this.z.a = false;
        }
        if (aVar == null) {
            this.j = true;
            this.h = false;
            if (this.z != null) {
                this.z.a = true;
            }
            setImageBitmap(null);
            if (this.d != null) {
                this.d.clear();
            }
        } else if (aVar.b() == null) {
            if (!aVar.a()) {
                BdLog.d("GifView", "setGif", "static");
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
            if (this.v) {
                d();
            }
        } else {
            aVar.b().a(this.f);
            aVar.b().a(this.e, null);
            setImageBitmap(this.e);
            if (this.v) {
                a();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.v;
    }

    public void setAutoPlay(boolean z) {
        this.v = z;
    }

    public void a() {
        com.baidu.adp.gif.c cVar;
        if (this.d != null && (cVar = this.d.get()) != null) {
            this.x.removeMessages(1);
            this.x.sendEmptyMessageDelayed(1, cVar.b(this.f));
            BdLog.d("GifView", "resume", "resumed");
        }
    }

    public void c() {
        com.baidu.adp.gif.c cVar;
        if (this.d != null && (cVar = this.d.get()) != null) {
            this.x.removeMessages(1);
            cVar.a(0);
            cVar.a(this.e, null);
            invalidate();
            BdLog.d("GifView", com.baidu.tbadk.core.frameworkData.a.STOP, "stopped");
        }
    }

    public void d() {
        com.baidu.adp.gif.c cVar;
        if (this.d != null && (cVar = this.d.get()) != null) {
            if (this.f != 0) {
                this.f = 0;
            }
            cVar.a(0);
            this.x.removeMessages(1);
            this.x.sendEmptyMessageDelayed(1, cVar.b(this.f));
            BdLog.d("GifView", "play", "played");
        }
    }

    public void e() {
        this.d = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.x.removeMessages(1);
        h();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.x.removeMessages(1);
        h();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        BdLog.d("GifView", "onWindowVisibilityChanged", "changed = " + i);
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
        if (!this.l && !this.j && !this.q) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.d != null && !this.l && !this.j && !this.q && (cVar = this.d.get()) != null) {
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
            canvas.drawBitmap(a, this.u, this.t, (Paint) null);
            canvas.restore();
        } else if (this.j || (this.z != null && this.z.a)) {
            canvas.save();
            this.k.draw(canvas);
            canvas.restore();
        } else if (this.q) {
            canvas.save();
            this.r.draw(canvas);
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
        this.q = z;
        if (z) {
            this.l = false;
            this.j = false;
            if (this.r == null || this.s != i) {
                this.s = i;
                this.r = getResources().getDrawable(i);
                int intrinsicWidth = this.r.getIntrinsicWidth();
                int intrinsicHeight = this.r.getIntrinsicHeight();
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
                this.r.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
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

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        BdLog.d("GifView", "onLayout", this + ": onLayout");
        BdLog.d("GifView", "onLayout", "width=" + i3 + " height=" + i4);
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
        this.m += this.p;
        if (this.m > 360.0f - this.p) {
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
        if (this.r != null && this.r.isStateful()) {
            this.r.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(a aVar) {
        int i;
        boolean z;
        if (aVar == null) {
            this.z = null;
            return;
        }
        boolean c = ab.c();
        Context context = getContext();
        if (context == null || !(context instanceof com.baidu.adp.base.g)) {
            i = 0;
            z = false;
        } else {
            com.baidu.adp.base.g gVar = (com.baidu.adp.base.g) context;
            int uniqueId = gVar.getUniqueId();
            z = gVar.isScroll();
            i = uniqueId;
        }
        if (!(aVar == this.z && this.C == i)) {
            h();
        }
        this.z = aVar;
        this.C = i;
        String str = c ? this.z.d : this.z.c;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.resourceLoader.d.a().a(this.z.b, this.A, this.z.e, this.z.b, Boolean.valueOf(c), str);
        if (aVar2 != null) {
            g();
            setGif(aVar2);
        } else if (this.z.a) {
            setGif(null);
        } else if (!com.baidu.adp.lib.resourceLoader.d.a().c(this.A) && this.B) {
            a(true, TbadkApplication.m252getInst().getSkinType() == 1 ? this.c : this.b);
        } else {
            f();
            if (!z) {
                com.baidu.adp.lib.resourceLoader.d.a().a(this.z.b, this.A, this.D, 0, 0, this.C, this.z.e, this.z.b, Boolean.valueOf(c), str);
            }
        }
    }

    public void h() {
        g();
        this.j = false;
        this.q = false;
        if (this.z != null) {
            com.baidu.adp.lib.resourceLoader.d.a().a(this.z.b, this.A, this.D);
        }
    }

    @Override // com.baidu.adp.newwidget.a.g
    public void b() {
        a(this.z);
    }

    public void setSupportNoImage(boolean z) {
        this.B = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.w = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.z != null) {
            boolean c = ab.c();
            String str = c ? this.z.d : this.z.c;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.resourceLoader.d.a().a(this.z.b, this.A, this.z.e, this.z.b, Boolean.valueOf(c), str);
            if (aVar != null) {
                this.z.a = false;
                setGif(aVar);
            } else {
                f();
                com.baidu.adp.lib.resourceLoader.d.a().a(this.z.b, this.A, this.D, 0, 0, this.C, this.z.e, this.z.b, Boolean.valueOf(c), str);
                return;
            }
        }
        if (this.w != null) {
            this.w.onClick(view);
        }
    }
}
