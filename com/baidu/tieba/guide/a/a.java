package com.baidu.tieba.guide.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.guide.e {
    private final int c;
    private final int d;
    private final Bitmap e;
    private int f;
    private int g;
    private final Rect b = new Rect();

    /* renamed from: a  reason: collision with root package name */
    private final Paint f1172a = new Paint();

    public a(Context context, int i, int i2) {
        this.c = i2;
        this.d = i;
        this.f1172a.setDither(true);
        this.f1172a.setAntiAlias(true);
        this.f = 0;
        this.g = this.c * 2;
        this.e = com.baidu.tieba.util.e.b(context, (int) R.drawable.intro);
    }

    @Override // com.baidu.tieba.guide.e
    public void a() {
    }

    @Override // com.baidu.tieba.guide.e
    public boolean b() {
        return true;
    }

    @Override // com.baidu.tieba.guide.e
    public void a(int i, float f, int i2) {
        this.g = (int) ((this.c * 2) - ((i + f) * this.c));
        this.f = (int) (this.d * (i + f));
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        this.b.left = i;
        this.b.top = i2;
        this.b.right = i3;
        this.b.bottom = i4;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.e != null) {
            canvas.save();
            canvas.translate(-this.f, -this.g);
            canvas.drawBitmap(this.e, (Rect) null, this.b, this.f1172a);
            canvas.restore();
        }
    }

    @Override // com.baidu.tieba.guide.e
    public void c() {
        if (this.e != null) {
            this.e.recycle();
        }
    }
}
