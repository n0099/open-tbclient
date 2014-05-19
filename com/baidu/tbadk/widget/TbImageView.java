package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.q;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private String i;
    private final int j;
    private final int k;
    private float l;
    private float m;
    private SparseArray<SoftReference<com.baidu.adp.widget.a.a>> n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private Matrix u;
    private View.OnClickListener v;
    private boolean w;
    private String x;
    private boolean y;
    private com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> z;

    public TbImageView(Context context) {
        super(context);
        this.d = q.pic_image_h_not;
        this.e = q.pic_image_h_not_1;
        this.f = q.img_loading;
        this.g = q.img_loading_1;
        this.j = 12;
        this.k = 150;
        this.o = 2;
        this.s = true;
        this.u = new Matrix();
        this.y = true;
        this.z = new k(this);
        a(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = q.pic_image_h_not;
        this.e = q.pic_image_h_not_1;
        this.f = q.img_loading;
        this.g = q.img_loading_1;
        this.j = 12;
        this.k = 150;
        this.o = 2;
        this.s = true;
        this.u = new Matrix();
        this.y = true;
        this.z = new k(this);
        a(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        h();
        this.l = 30.0f;
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
        if (TextUtils.isEmpty(this.i)) {
            Object tag = getTag();
            if (!(tag instanceof String)) {
                return null;
            }
            String str = (String) tag;
            if (!TextUtils.isEmpty(this.x)) {
                str = String.valueOf(str) + this.x;
            }
            com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(str);
            return c == null ? com.baidu.tbadk.imageManager.e.a().b(str) : c;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.resourceLoader.d.a().a(this.i, this.o, new Object[0]);
    }

    @Override // com.baidu.adp.newwidget.a.b
    protected com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (this.n == null) {
            this.n = new SparseArray<>();
        }
        if (this.n.indexOfKey(this.h) <= -1 || (softReference = this.n.get(this.h)) == null || (aVar = softReference.get()) == null) {
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(com.baidu.adp.lib.util.b.a().a(this.h), false, null);
            this.n.put(this.h, new SoftReference<>(aVar2));
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
        if (context == null || !(context instanceof com.baidu.adp.base.i)) {
            i4 = 0;
        } else {
            com.baidu.adp.base.i iVar = (com.baidu.adp.base.i) context;
            i4 = iVar.getUniqueId();
            z2 = iVar.isScroll();
        }
        a(str, i, i2, i3, z, i4, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, int i4, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            this.i = str;
            return;
        }
        if (!(str.equals(this.i) && i == this.o && i4 == this.p)) {
            c();
            this.c = true;
            requestLayout();
        } else if (getBdImage() != null) {
            invalidate();
            return;
        }
        this.i = str;
        this.o = i;
        this.p = i4;
        this.q = i2;
        this.r = i3;
        this.c = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.resourceLoader.d.a().c(this.o) && this.y) {
            invalidate();
        } else {
            if (z) {
                d();
            }
            com.baidu.adp.lib.resourceLoader.d.a().a(this.i, this.o, this.z, i2, i3, this.p, new Object[0]);
        }
    }

    public void c() {
        if (!TextUtils.isEmpty(this.i)) {
            com.baidu.adp.lib.resourceLoader.d.a().a(this.i, this.o, this.z);
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
        this.t = true;
        g();
    }

    public void e() {
        this.t = false;
        removeCallbacks(this);
        this.m = 0.0f;
        this.u.reset();
        setExtraMatrix(this.u);
        invalidate();
    }

    private void g() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.m += this.l;
        if (this.m > 360.0f - this.l) {
            this.m = 0.0f;
        }
        this.u.reset();
        this.u.postRotate(this.m, getWidth() / 2, getHeight() / 2);
        setExtraMatrix(this.u);
        invalidate();
        g();
    }

    private void h() {
        int i;
        if (this.s) {
            this.a.f = TbadkApplication.m252getInst().getSkinType() == 1;
        } else {
            this.a.f = false;
        }
        int i2 = this.h;
        if (a()) {
            i = this.t ? this.g : this.e;
        } else {
            i = this.t ? this.f : this.d;
        }
        if (i != this.h) {
            this.h = i;
            this.c = true;
        }
    }

    public void setDefaultResource(int i) {
        if (this.d != i) {
            this.d = i;
            invalidate();
        }
    }

    public void setNightDefaultResource(int i) {
        if (this.e != i) {
            this.e = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.s = z;
    }

    public void setPageId(int i) {
        this.p = i;
    }

    public String getUrl() {
        return this.i;
    }

    public void setSuffix(String str) {
        this.x = str;
    }

    @Override // com.baidu.adp.newwidget.a.g
    public void b() {
        a(this.i, this.o, this.q, this.r, false);
        invalidate();
    }

    public void f() {
        setTag(null);
        this.i = null;
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.v = onClickListener;
    }

    public void setInterceptOnClick(boolean z) {
        this.w = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.w) {
            d();
            com.baidu.adp.lib.resourceLoader.d.a().a(this.i, this.o, this.z, this.q, this.r, this.p, new Object[0]);
        } else if (this.v != null) {
            this.v.onClick(view);
        }
    }

    public void setSupportNoImage(boolean z) {
        this.y = z;
    }
}
