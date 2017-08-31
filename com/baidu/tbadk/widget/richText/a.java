package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class a extends BitmapDrawable {
    private Context mContext;
    private int mId;
    private String mKey;
    private Rect rr = null;
    private Matrix mMatrix = null;

    public a(Context context, int i) {
        this.mId = 0;
        this.mContext = null;
        this.mKey = null;
        this.mContext = context;
        this.mId = i;
        this.mKey = String.valueOf(this.mId);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        this.rr = new Rect(i, i2, i3, i4);
        this.mMatrix = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.rr = new Rect(rect);
        this.mMatrix = null;
        super.setBounds(rect);
    }

    public void Q(int i, int i2) {
        if (this.rr != null) {
            super.setBounds(this.rr.left, this.rr.top, this.rr.right + i, this.rr.bottom + i2);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.baidu.adp.widget.a.a aVar;
        if (this.mId > 0 && this.mContext != null) {
            com.baidu.tbadk.imageManager.c Ev = com.baidu.tbadk.imageManager.c.Ev();
            com.baidu.adp.widget.a.a go = (Ev == null || this.mKey == null) ? null : Ev.go(this.mKey);
            if (go == null) {
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.mContext, this.mId);
                if (resBitmap != null) {
                    go = new com.baidu.adp.widget.a.a(resBitmap, false, null);
                }
                if (Ev != null && go != null && this.mKey != null) {
                    Ev.c(this.mKey, go);
                }
                aVar = go;
            } else {
                aVar = go;
            }
            if (aVar != null) {
                int width = aVar.getWidth();
                int height = aVar.getHeight();
                if (width > 0 && height > 0 && this.rr != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height > this.rr.bottom - this.rr.top || width > this.rr.right - this.rr.left) {
                        if (this.mMatrix == null) {
                            this.mMatrix = new Matrix();
                            this.mMatrix.postTranslate(0.0f, 0.0f);
                            float f = (this.rr.right - this.rr.left) / width;
                            float f2 = (this.rr.bottom - this.rr.top) / height;
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
