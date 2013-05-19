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
    private int a;
    private Context b;
    private String d;
    private Rect c = null;
    private Matrix e = null;

    public d(Context context, int i) {
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
        if (this.a > 0 && this.b != null) {
            com.baidu.tbadk.a.d a = com.baidu.tbadk.a.d.a();
            Bitmap c = (a == null || this.d == null) ? null : a.c(this.d);
            if (c == null) {
                c = BitmapFactory.decodeResource(this.b.getResources(), this.a);
                if (a != null && c != null && this.d != null) {
                    a.b(this.d, c);
                }
            }
            Bitmap bitmap = c;
            if (bitmap != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width > 0 && height > 0 && this.c != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height > this.c.bottom - this.c.top || width > this.c.right - this.c.left) {
                        if (this.e == null) {
                            this.e = new Matrix();
                            this.e.postTranslate(0.0f, 0.0f);
                            float f = (this.c.right - this.c.left) / width;
                            float f2 = (this.c.bottom - this.c.top) / height;
                            if (f >= f2) {
                                f = f2;
                            }
                            this.e.postScale(f, f);
                        }
                        canvas.drawBitmap(bitmap, this.e, null);
                    } else {
                        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    }
                    canvas.restore();
                }
            }
        }
    }
}
