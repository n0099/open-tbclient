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
public class b extends BitmapDrawable {
    private Context mContext;
    private int mId;
    private String mKey;
    private Rect ru = null;
    private Matrix mMatrix = null;

    public b(Context context, int i) {
        this.mId = 0;
        this.mContext = null;
        this.mKey = null;
        this.mContext = context;
        this.mId = i;
        this.mKey = String.valueOf(this.mId);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        this.ru = new Rect(i, i2, i3, i4);
        this.mMatrix = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.ru = new Rect(rect);
        this.mMatrix = null;
        super.setBounds(rect);
    }

    public void U(int i, int i2) {
        if (this.ru != null) {
            super.setBounds(this.ru.left, this.ru.top, this.ru.right + i, this.ru.bottom + i2);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.baidu.adp.widget.a.a aVar;
        if (this.mId > 0 && this.mContext != null) {
            com.baidu.tbadk.imageManager.c Es = com.baidu.tbadk.imageManager.c.Es();
            com.baidu.adp.widget.a.a gp = (Es == null || this.mKey == null) ? null : Es.gp(this.mKey);
            if (gp == null) {
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.mContext, this.mId);
                if (resBitmap != null) {
                    gp = new com.baidu.adp.widget.a.a(resBitmap, false, null);
                }
                if (Es != null && gp != null && this.mKey != null) {
                    Es.c(this.mKey, gp);
                }
                aVar = gp;
            } else {
                aVar = gp;
            }
            if (aVar != null) {
                int width = aVar.getWidth();
                int height = aVar.getHeight();
                if (width > 0 && height > 0 && this.ru != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height > this.ru.bottom - this.ru.top || width > this.ru.right - this.ru.left) {
                        if (this.mMatrix == null) {
                            this.mMatrix = new Matrix();
                            this.mMatrix.postTranslate(0.0f, 0.0f);
                            float f = (this.ru.right - this.ru.left) / width;
                            float f2 = (this.ru.bottom - this.ru.top) / height;
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
