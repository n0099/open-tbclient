package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class f extends BitmapDrawable {
    private Context mContext;
    private int mId;
    private String mKey;
    private Rect dZ = null;
    private Matrix mMatrix = null;

    public f(Context context, int i) {
        this.mId = 0;
        this.mContext = null;
        this.mKey = null;
        this.mContext = context;
        this.mId = i;
        this.mKey = String.valueOf(this.mId);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        this.dZ = new Rect(i, i2, i3, i4);
        this.mMatrix = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.dZ = new Rect(rect);
        this.mMatrix = null;
        super.setBounds(rect);
    }

    public void C(int i, int i2) {
        if (this.dZ != null) {
            super.setBounds(this.dZ.left, this.dZ.top, this.dZ.right + i, this.dZ.bottom + i2);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.baidu.adp.widget.a.a aVar;
        if (this.mId > 0 && this.mContext != null) {
            com.baidu.tbadk.imageManager.e si = com.baidu.tbadk.imageManager.e.si();
            com.baidu.adp.widget.a.a dt = (si == null || this.mKey == null) ? null : si.dt(this.mKey);
            if (dt == null) {
                Bitmap a = com.baidu.tbadk.core.util.d.a(this.mContext, this.mId);
                if (a != null) {
                    dt = new com.baidu.adp.widget.a.a(a, false, null);
                }
                if (si != null && dt != null && this.mKey != null) {
                    si.c(this.mKey, dt);
                }
                aVar = dt;
            } else {
                aVar = dt;
            }
            if (aVar != null) {
                int width = aVar.getWidth();
                int height = aVar.getHeight();
                if (width > 0 && height > 0 && this.dZ != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height > this.dZ.bottom - this.dZ.top || width > this.dZ.right - this.dZ.left) {
                        if (this.mMatrix == null) {
                            this.mMatrix = new Matrix();
                            this.mMatrix.postTranslate(0.0f, 0.0f);
                            float f = (this.dZ.right - this.dZ.left) / width;
                            float f2 = (this.dZ.bottom - this.dZ.top) / height;
                            if (f >= f2) {
                                f = f2;
                            }
                            this.mMatrix.postScale(f, f);
                        }
                        aVar.a(canvas, this.mMatrix, null);
                    } else {
                        aVar.a(canvas, 0.0f, 0.0f, (Paint) null);
                    }
                    canvas.restore();
                }
            }
        }
    }
}
