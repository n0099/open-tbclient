package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class f extends BitmapDrawable {
    private int a;
    private Context b;
    private String d;
    private Rect c = null;
    private Matrix e = null;

    public f(Context context, int i) {
        this.a = 0;
        this.b = null;
        this.d = null;
        this.b = context;
        this.a = i;
        this.d = String.valueOf(this.a);
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
        com.baidu.adp.widget.ImageView.b bVar;
        if (this.a > 0 && this.b != null) {
            com.baidu.tbadk.imageManager.e a = com.baidu.tbadk.imageManager.e.a();
            com.baidu.adp.widget.ImageView.b c = (a == null || this.d == null) ? null : a.c(this.d);
            if (c == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.b.getResources(), this.a);
                if (decodeResource != null) {
                    c = new com.baidu.adp.widget.ImageView.b(decodeResource, false, null);
                }
                if (a != null && c != null && this.d != null) {
                    a.b(this.d, c);
                }
                bVar = c;
            } else {
                bVar = c;
            }
            if (bVar != null) {
                int c2 = bVar.c();
                int d = bVar.d();
                if (c2 > 0 && d > 0 && this.c != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (d > this.c.bottom - this.c.top || c2 > this.c.right - this.c.left) {
                        if (this.e == null) {
                            this.e = new Matrix();
                            this.e.postTranslate(0.0f, 0.0f);
                            float f = (this.c.right - this.c.left) / c2;
                            float f2 = (this.c.bottom - this.c.top) / d;
                            if (f >= f2) {
                                f = f2;
                            }
                            this.e.postScale(f, f);
                        }
                        bVar.a(canvas, this.e, null);
                    } else {
                        bVar.a(canvas, 0.0f, 0.0f, null);
                    }
                    canvas.restore();
                }
            }
        }
    }
}
