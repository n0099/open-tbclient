package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.u;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> A;
    private l d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String j;
    private final int k;
    private final int l;
    private float m;
    private float n;
    private SparseArray<SoftReference<com.baidu.adp.widget.a.a>> o;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private Matrix v;
    private View.OnClickListener w;
    private boolean x;
    private String y;
    private boolean z;

    public void setEvent(l lVar) {
        this.d = lVar;
    }

    public TbImageView(Context context) {
        super(context);
        this.d = null;
        this.e = u.pic_image_h_not;
        this.f = u.pic_image_h_not_1;
        this.g = u.img_loading;
        this.h = u.img_loading_1;
        this.k = 12;
        this.l = 150;
        this.p = 2;
        this.t = true;
        this.v = new Matrix();
        this.z = true;
        this.A = new k(this);
        a(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = null;
        this.e = u.pic_image_h_not;
        this.f = u.pic_image_h_not_1;
        this.g = u.img_loading;
        this.h = u.img_loading_1;
        this.k = 12;
        this.l = 150;
        this.p = 2;
        this.t = true;
        this.v = new Matrix();
        this.z = true;
        this.A = new k(this);
        a(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        h();
        this.m = 30.0f;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != obj) {
                this.c = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.c = true;
            requestLayout();
        }
    }

    @Override // com.baidu.adp.newwidget.a.b
    protected com.baidu.adp.widget.a.a getBdImage() {
        if (TextUtils.isEmpty(this.j)) {
            Object tag = getTag();
            if (!(tag instanceof String)) {
                return null;
            }
            String str = (String) tag;
            if (!TextUtils.isEmpty(this.y)) {
                str = String.valueOf(str) + this.y;
            }
            com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(str);
            return c == null ? com.baidu.tbadk.imageManager.e.a().b(str) : c;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.resourceLoader.d.a().a(this.j, this.p, new Object[0]);
    }

    @Override // com.baidu.adp.newwidget.a.b
    protected com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (this.o == null) {
            this.o = new SparseArray<>();
        }
        if (this.o.indexOfKey(this.i) <= -1 || (softReference = this.o.get(this.i)) == null || (aVar = softReference.get()) == null) {
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(com.baidu.adp.lib.util.b.a().a(this.i), false, null);
            this.o.put(this.i, new SoftReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }

    public void a(String str, int i, boolean z) {
        a(str, i, 0, 0, z);
    }

    public void a(String str, int i, int i2, int i3, boolean z) {
        int i4;
        boolean z2 = false;
        Context context = getContext();
        if (context == null || !(context instanceof com.baidu.adp.base.g)) {
            i4 = 0;
        } else {
            com.baidu.adp.base.g gVar = (com.baidu.adp.base.g) context;
            i4 = gVar.getUniqueId();
            z2 = gVar.isScroll();
        }
        a(str, i, i2, i3, z, i4, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, int i4, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            this.j = str;
            return;
        }
        if (!(str.equals(this.j) && i == this.p && i4 == this.q)) {
            c();
            this.c = true;
            requestLayout();
        } else if (getBdImage() != null) {
            invalidate();
            return;
        }
        this.j = str;
        this.p = i;
        this.q = i4;
        this.r = i2;
        this.s = i3;
        this.c = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.resourceLoader.d.a().c(this.p) && this.z) {
            invalidate();
        } else {
            if (z) {
                d();
            }
            com.baidu.adp.lib.resourceLoader.d.a().a(this.j, this.p, this.A, i2, i3, this.q, new Object[0]);
        }
    }

    public void c() {
        if (!TextUtils.isEmpty(this.j)) {
            com.baidu.adp.lib.resourceLoader.d.a().a(this.j, this.p, this.A);
            e();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        c();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            c();
        } else {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        h();
        super.onDraw(canvas);
    }

    public void d() {
        this.u = true;
        g();
    }

    public void e() {
        this.u = false;
        removeCallbacks(this);
        this.n = 0.0f;
        this.v.reset();
        setExtraMatrix(this.v);
        invalidate();
    }

    private void g() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.n += this.m;
        if (this.n > 360.0f - this.m) {
            this.n = 0.0f;
        }
        this.v.reset();
        this.v.postRotate(this.n, getWidth() / 2, getHeight() / 2);
        setExtraMatrix(this.v);
        invalidate();
        g();
    }

    private void h() {
        int i;
        if (this.t) {
            this.a.f = TbadkApplication.m252getInst().getSkinType() == 1;
        } else {
            this.a.f = false;
        }
        int i2 = this.i;
        if (a()) {
            i = this.u ? this.h : this.f;
        } else {
            i = this.u ? this.g : this.e;
        }
        if (i != this.i) {
            this.i = i;
            this.c = true;
        }
    }

    public void setDefaultResource(int i) {
        if (this.e != i) {
            this.e = i;
            invalidate();
        }
    }

    public void setNightDefaultResource(int i) {
        if (this.f != i) {
            this.f = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.t = z;
    }

    public void setPageId(int i) {
        this.q = i;
    }

    public String getUrl() {
        return this.j;
    }

    public void setSuffix(String str) {
        this.y = str;
    }

    @Override // com.baidu.adp.newwidget.a.g
    public void b() {
        a(this.j, this.p, this.r, this.s, false);
        invalidate();
    }

    public void f() {
        setTag(null);
        this.j = null;
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.w = onClickListener;
    }

    public void setInterceptOnClick(boolean z) {
        this.x = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.x) {
            d();
            com.baidu.adp.lib.resourceLoader.d.a().a(this.j, this.p, this.A, this.r, this.s, this.q, new Object[0]);
        } else if (this.w != null) {
            this.w.onClick(view);
        }
    }

    public void setSupportNoImage(boolean z) {
        this.z = z;
    }
}
