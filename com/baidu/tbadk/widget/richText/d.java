package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d extends BitmapDrawable {

    /* renamed from: a  reason: collision with root package name */
    private int f806a;
    private Context b;
    private String d;
    private Rect c = null;
    private Matrix e = null;

    public d(Context context, int i) {
        this.f806a = 0;
        this.b = null;
        this.d = null;
        this.b = context;
        this.f806a = i;
        this.d = String.valueOf(this.f806a);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        this.c = new Rect(i, i2, i3, i4);
        this.e = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.c = new Rect(rect);
        this.e = null;
        super.setBounds(rect);
    }

    public void a(int i, int i2) {
        if (this.c != null) {
            super.setBounds(this.c.left, this.c.top, this.c.right + i, this.c.bottom + i2);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.baidu.adp.widget.a.b bVar;
        if (this.f806a > 0 && this.b != null) {
            com.baidu.tbadk.a.e a2 = com.baidu.tbadk.a.e.a();
            com.baidu.adp.widget.a.b c = (a2 == null || this.d == null) ? null : a2.c(this.d);
            if (c == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.b.getResources(), this.f806a);
                if (decodeResource != null) {
                    c = new com.baidu.adp.widget.a.b(decodeResource, false, null);
                }
                if (a2 != null && c != null && this.d != null) {
                    a2.b(this.d, c);
                }
                bVar = c;
            } else {
                bVar = c;
            }
            if (bVar != null) {
                int a3 = bVar.a();
                int b = bVar.b();
                if (a3 > 0 && b > 0 && this.c != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (b > this.c.bottom - this.c.top || a3 > this.c.right - this.c.left) {
                        if (this.e == null) {
                            this.e = new Matrix();
                            this.e.postTranslate(0.0f, 0.0f);
                            float f = (this.c.right - this.c.left) / a3;
                            float f2 = (this.c.bottom - this.c.top) / b;
                            if (f >= f2) {
                                f = f2;
                            }
                            this.e.postScale(f, f);
                        }
                        bVar.a(canvas, this.e, null);
                    } else {
                        bVar.a(canvas, 0.0f, 0.0f, (Paint) null);
                    }
                    canvas.restore();
                }
            }
        }
    }
}
