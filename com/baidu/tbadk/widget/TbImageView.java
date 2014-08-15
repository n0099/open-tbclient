package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static SparseArray<SoftReference<com.baidu.adp.widget.a.a>> p;
    private final com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> A;
    private l d;
    private int e;
    private int f;
    private final int g;
    private final int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private String m;
    private float n;
    private float o;
    private int q;
    private BdUniqueId r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private final Matrix w;
    private View.OnClickListener x;
    private boolean y;
    private boolean z;

    public void setEvent(l lVar) {
        this.d = lVar;
    }

    public TbImageView(Context context) {
        super(context);
        this.d = null;
        this.e = t.img_default_100;
        this.f = t.img_default_100_1;
        this.g = t.img_loading;
        this.h = t.img_loading_1;
        this.i = r.cp_bg_line_c;
        this.j = r.cp_bg_line_c_1;
        this.q = 10;
        this.u = true;
        this.w = new Matrix();
        this.z = true;
        this.A = new k(this);
        a(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = null;
        this.e = t.img_default_100;
        this.f = t.img_default_100_1;
        this.g = t.img_loading;
        this.h = t.img_loading_1;
        this.i = r.cp_bg_line_c;
        this.j = r.cp_bg_line_c_1;
        this.q = 10;
        this.u = true;
        this.w = new Matrix();
        this.z = true;
        this.A = new k(this);
        a(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        h();
        this.n = 30.0f;
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
        if (TextUtils.isEmpty(this.m)) {
            Object tag = getTag();
            if (!(tag instanceof String)) {
                return null;
            }
            String str = (String) tag;
            com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(str);
            return c == null ? com.baidu.tbadk.imageManager.e.a().b(str) : c;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.resourceLoader.d.a().a(this.m, this.q, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (p == null) {
            p = new SparseArray<>();
        }
        if (p.indexOfKey(this.k) <= -1 || (softReference = p.get(this.k)) == null || (aVar = softReference.get()) == null) {
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(com.baidu.tbadk.core.util.d.b(TbadkApplication.m252getInst().getApp(), this.k), false, String.valueOf(this.k));
            p.put(this.k, new SoftReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }

    public void a(String str, int i, boolean z) {
        a(str, i, 0, 0, z);
    }

    public void a(String str, int i, int i2, int i3, boolean z) {
        Context context = getContext();
        BdUniqueId bdUniqueId = null;
        boolean z2 = false;
        if (context != null && (context instanceof com.baidu.adp.base.i)) {
            com.baidu.adp.base.i iVar = (com.baidu.adp.base.i) context;
            bdUniqueId = iVar.getUniqueId();
            z2 = iVar.isScroll();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        BdLog.i("startLoad:url-" + str);
        if (TextUtils.isEmpty(str)) {
            this.m = str;
            return;
        }
        if (!(str.equals(this.m) && i == this.q && bdUniqueId == this.r)) {
            c();
            this.c = true;
            requestLayout();
        } else if (getBdImage() != null) {
            invalidate();
            return;
        }
        this.m = str;
        this.q = i;
        this.r = bdUniqueId;
        this.s = i2;
        this.t = i3;
        this.c = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.resourceLoader.d.a().a(this.q) && this.z) {
            invalidate();
        } else {
            if (z) {
                d();
            }
            com.baidu.adp.lib.resourceLoader.d.a().a(this.m, this.q, this.A, i2, i3, this.r, new Object[0]);
        }
    }

    public void c() {
        if (!TextUtils.isEmpty(this.m)) {
            com.baidu.adp.lib.resourceLoader.d.a().a(this.m, this.q, this.A);
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
        this.v = true;
        g();
    }

    public void e() {
        this.v = false;
        removeCallbacks(this);
        this.o = 0.0f;
        this.w.reset();
        setExtraMatrix(this.w);
        invalidate();
    }

    private void g() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.o += this.n;
        if (this.o > 360.0f - this.n) {
            this.o = 0.0f;
        }
        this.w.reset();
        this.w.postRotate(this.o, getWidth() / 2.0f, getHeight() / 2.0f);
        setExtraMatrix(this.w);
        invalidate();
        g();
    }

    private void h() {
        int i;
        int i2;
        if (this.u) {
            this.a.f = TbadkApplication.m252getInst().getSkinType() == 1;
        } else {
            this.a.f = false;
        }
        int i3 = this.k;
        if (a()) {
            i = this.v ? this.h : this.f;
        } else {
            i = this.v ? this.g : this.e;
        }
        if (i != this.k) {
            this.k = i;
            this.c = true;
        }
        int i4 = this.l;
        if (a()) {
            i2 = this.j;
        } else {
            i2 = this.i;
        }
        this.l = i2;
        if (this.l > 0) {
            setDefaultBg(getResources().getDrawable(this.l));
        } else {
            setDefaultBg(null);
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

    public void setDefaultBgResource(int i) {
        if (this.i != i) {
            this.i = i;
            invalidate();
        }
    }

    public void setNightDefaultBgResource(int i) {
        if (this.j != i) {
            this.j = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.u = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.r = bdUniqueId;
    }

    public String getUrl() {
        return this.m;
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void b() {
        a(this.m, this.q, this.s, this.t, false);
        invalidate();
    }

    public void f() {
        setTag(null);
        this.m = null;
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.x = onClickListener;
    }

    public void setInterceptOnClick(boolean z) {
        this.y = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.y) {
            d();
            com.baidu.adp.lib.resourceLoader.d.a().a(this.m, this.q, this.A, this.s, this.t, this.r, new Object[0]);
        } else if (this.x != null) {
            this.x.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.a.i != null) {
            return this.a.i.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.a.i != null) {
            return this.a.i.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.z = z;
    }
}
