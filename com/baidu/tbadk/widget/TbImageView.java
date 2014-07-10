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
    private k d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String j;
    private float k;
    private float l;
    private SparseArray<SoftReference<com.baidu.adp.widget.a.a>> m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private Matrix t;
    private View.OnClickListener u;
    private boolean v;
    private String w;
    private boolean x;
    private com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> y;

    public void setEvent(k kVar) {
        this.d = kVar;
    }

    public TbImageView(Context context) {
        super(context);
        this.d = null;
        this.e = u.pic_image_h_not;
        this.f = u.pic_image_h_not_1;
        this.g = u.img_loading;
        this.h = u.img_loading_1;
        this.n = 2;
        this.r = true;
        this.t = new Matrix();
        this.x = true;
        this.y = new j(this);
        a(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = null;
        this.e = u.pic_image_h_not;
        this.f = u.pic_image_h_not_1;
        this.g = u.img_loading;
        this.h = u.img_loading_1;
        this.n = 2;
        this.r = true;
        this.t = new Matrix();
        this.x = true;
        this.y = new j(this);
        a(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        h();
        this.k = 30.0f;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.c = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.c = true;
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getBdImage() {
        if (TextUtils.isEmpty(this.j)) {
            Object tag = getTag();
            if (!(tag instanceof String)) {
                return null;
            }
            String str = (String) tag;
            if (!TextUtils.isEmpty(this.w)) {
                str = String.valueOf(str) + this.w;
            }
            com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(str);
            return c == null ? com.baidu.tbadk.imageManager.e.a().b(str) : c;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.resourceLoader.d.a().a(this.j, this.n, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (this.m == null) {
            this.m = new SparseArray<>();
        }
        if (this.m.indexOfKey(this.i) <= -1 || (softReference = this.m.get(this.i)) == null || (aVar = softReference.get()) == null) {
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(com.baidu.tbadk.core.util.h.b(TbadkApplication.m252getInst().getApp(), this.i), false, null);
            this.m.put(this.i, new SoftReference<>(aVar2));
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
        if (context == null || !(context instanceof com.baidu.adp.base.j)) {
            i4 = 0;
        } else {
            com.baidu.adp.base.j jVar = (com.baidu.adp.base.j) context;
            i4 = jVar.getUniqueId();
            z2 = jVar.isScroll();
        }
        a(str, i, i2, i3, z, i4, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, int i4, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            this.j = str;
            return;
        }
        if (!(str.equals(this.j) && i == this.n && i4 == this.o)) {
            c();
            this.c = true;
            requestLayout();
        } else if (getBdImage() != null) {
            invalidate();
            return;
        }
        this.j = str;
        this.n = i;
        this.o = i4;
        this.p = i2;
        this.q = i3;
        this.c = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.resourceLoader.d.a().c(this.n) && this.x) {
            invalidate();
        } else {
            if (z) {
                d();
            }
            com.baidu.adp.lib.resourceLoader.d.a().a(this.j, this.n, this.y, i2, i3, this.o, new Object[0]);
        }
    }

    public void c() {
        if (!TextUtils.isEmpty(this.j)) {
            com.baidu.adp.lib.resourceLoader.d.a().a(this.j, this.n, this.y);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
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
        this.s = true;
        g();
    }

    public void e() {
        this.s = false;
        removeCallbacks(this);
        this.l = 0.0f;
        this.t.reset();
        setExtraMatrix(this.t);
        invalidate();
    }

    private void g() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.l += this.k;
        if (this.l > 360.0f - this.k) {
            this.l = 0.0f;
        }
        this.t.reset();
        this.t.postRotate(this.l, getWidth() / 2.0f, getHeight() / 2.0f);
        setExtraMatrix(this.t);
        invalidate();
        g();
    }

    private void h() {
        int i;
        if (this.r) {
            this.a.f = TbadkApplication.m252getInst().getSkinType() == 1;
        } else {
            this.a.f = false;
        }
        int i2 = this.i;
        if (a()) {
            i = this.s ? this.h : this.f;
        } else {
            i = this.s ? this.g : this.e;
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
        this.r = z;
    }

    public void setPageId(int i) {
        this.o = i;
    }

    public String getUrl() {
        return this.j;
    }

    public void setSuffix(String str) {
        this.w = str;
    }

    @Override // com.baidu.adp.newwidget.a.h
    public void b() {
        a(this.j, this.n, this.p, this.q, false);
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
        this.u = onClickListener;
    }

    public void setInterceptOnClick(boolean z) {
        this.v = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.v) {
            d();
            com.baidu.adp.lib.resourceLoader.d.a().a(this.j, this.n, this.y, this.p, this.q, this.o, new Object[0]);
        } else if (this.u != null) {
            this.u.onClick(view);
        }
    }

    public void setSupportNoImage(boolean z) {
        this.x = z;
    }
}
