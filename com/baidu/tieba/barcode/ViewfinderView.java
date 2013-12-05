package com.baidu.tieba.barcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.zeus.bouncycastle.DERTags;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class ViewfinderView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1133a = {0, 64, DERTags.TAGGED, 192, Util.MASK_8BIT, 192, DERTags.TAGGED, 64};
    private com.baidu.tieba.barcode.a.f b;
    private final Paint c;
    private Bitmap d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private int j;
    private List<com.google.zxing.i> k;
    private List<com.google.zxing.i> l;
    private Bitmap m;
    private Rect n;
    private Bitmap o;
    private int p;
    private int q;
    private Handler r;
    private String s;
    private String t;
    private int u;
    private boolean v;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = 0;
        this.q = 0;
        this.r = new t(this);
        this.v = false;
        this.c = new Paint(1);
        Resources resources = getResources();
        this.e = resources.getColor(R.color.viewfinder_mask);
        this.f = resources.getColor(R.color.result_view);
        this.g = resources.getColor(R.color.viewfinder_laser);
        this.h = resources.getColor(R.color.possible_result_points);
        this.i = resources.getColor(R.color.viewfinder_tip_text);
        this.t = resources.getString(R.string.bar_code_tip_text1);
        this.s = resources.getString(R.string.bar_code_tip_text2);
        this.j = 0;
        this.k = new ArrayList(5);
        this.l = null;
        this.m = BitmapFactory.decodeResource(resources, R.drawable.bg_scanning_code);
        this.o = BitmapFactory.decodeResource(resources, R.drawable.cursor_scanning_code);
        this.n = new Rect(0, 0, this.m.getWidth(), this.m.getHeight());
        this.u = resources.getDimensionPixelSize(R.dimen.bar_code_tip_text_margin_top);
        this.q = resources.getDimensionPixelSize(R.dimen.bar_code_tip_text);
    }

    public void setCameraManager(com.baidu.tieba.barcode.a.f fVar) {
        this.b = fVar;
        this.r.removeMessages(1);
        this.r.sendMessage(this.r.obtainMessage(1));
    }

    public void a() {
        this.p = 0;
        this.v = true;
        this.r.removeMessages(1);
    }

    public void b() {
        this.v = false;
        this.r.removeMessages(1);
        this.r.sendMessage(this.r.obtainMessage(1));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect e;
        if (this.b != null && (e = this.b.e()) != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.c.setColor(this.d != null ? this.f : this.e);
            canvas.drawRect(0.0f, 0.0f, width, e.top, this.c);
            canvas.drawRect(0.0f, e.top, e.left, e.bottom, this.c);
            canvas.drawRect(e.right, e.top, width, e.bottom, this.c);
            canvas.drawRect(0.0f, e.bottom, width, height, this.c);
            this.c.setColor(this.i);
            this.c.setTextSize(this.q);
            this.c.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.t, width / 2, e.bottom + this.u, this.c);
            canvas.drawText(this.s, width / 2, e.bottom + this.u + this.q, this.c);
            canvas.drawBitmap(this.m, this.n, e, (Paint) null);
            if (this.d != null) {
                this.c.setAlpha(160);
                canvas.drawBitmap(this.d, (Rect) null, e, this.c);
                return;
            }
            this.c.setColor(this.g);
            this.c.setAlpha(f1133a[this.j]);
            this.j = (this.j + 1) % f1133a.length;
            if (!this.v) {
                if (this.p < e.top) {
                    this.p = e.top;
                }
                if (this.p > e.bottom - this.o.getHeight()) {
                    this.p = e.top;
                }
                canvas.drawBitmap(this.o, e.left + ((e.width() - this.o.getWidth()) / 2), this.p, (Paint) null);
                this.p += 3;
            }
            Rect f = this.b.f();
            float width2 = e.width() / f.width();
            float height2 = e.height() / f.height();
            List<com.google.zxing.i> list = this.k;
            List<com.google.zxing.i> list2 = this.l;
            int i = e.left;
            int i2 = e.top;
            if (list.isEmpty()) {
                this.l = null;
            } else {
                this.k = new ArrayList(5);
                this.l = list;
                this.c.setAlpha(160);
                this.c.setColor(this.h);
                synchronized (list) {
                    for (com.google.zxing.i iVar : list) {
                        canvas.drawCircle(((int) (iVar.a() * width2)) + i, ((int) (iVar.b() * height2)) + i2, 6.0f, this.c);
                    }
                }
            }
            if (list2 != null) {
                this.c.setAlpha(80);
                this.c.setColor(this.h);
                synchronized (list2) {
                    for (com.google.zxing.i iVar2 : list2) {
                        canvas.drawCircle(((int) (iVar2.a() * width2)) + i, ((int) (iVar2.b() * height2)) + i2, 3.0f, this.c);
                    }
                }
            }
            postInvalidateDelayed(80L, e.left - 6, e.top - 6, e.right + 6, e.bottom + 6);
        }
    }

    public void c() {
        Bitmap bitmap = this.d;
        this.d = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    public void a(com.google.zxing.i iVar) {
        List<com.google.zxing.i> list = this.k;
        synchronized (list) {
            list.add(iVar);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }

    public void d() {
        this.r.removeMessages(1);
    }

    public void e() {
        if (this.m != null && !this.m.isRecycled()) {
            this.m.recycle();
            this.m = null;
        }
        if (this.o != null && !this.o.isRecycled()) {
            this.o.recycle();
            this.o = null;
        }
        if (this.d != null && !this.d.isRecycled()) {
            this.d.recycle();
        }
    }
}
