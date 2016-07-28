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
public class e extends BitmapDrawable {
    private Context mContext;
    private int mId;
    private String mKey;
    private Rect il = null;
    private Matrix mMatrix = null;

    public e(Context context, int i) {
        this.mId = 0;
        this.mContext = null;
        this.mKey = null;
        this.mContext = context;
        this.mId = i;
        this.mKey = String.valueOf(this.mId);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        this.il = new Rect(i, i2, i3, i4);
        this.mMatrix = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.il = new Rect(rect);
        this.mMatrix = null;
        super.setBounds(rect);
    }

    public void I(int i, int i2) {
        if (this.il != null) {
            super.setBounds(this.il.left, this.il.top, this.il.right + i, this.il.bottom + i2);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.baidu.adp.widget.a.a aVar;
        if (this.mId > 0 && this.mContext != null) {
            com.baidu.tbadk.imageManager.c CP = com.baidu.tbadk.imageManager.c.CP();
            com.baidu.adp.widget.a.a fQ = (CP == null || this.mKey == null) ? null : CP.fQ(this.mKey);
            if (fQ == null) {
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.mContext, this.mId);
                if (resBitmap != null) {
                    fQ = new com.baidu.adp.widget.a.a(resBitmap, false, null);
                }
                if (CP != null && fQ != null && this.mKey != null) {
                    CP.c(this.mKey, fQ);
                }
                aVar = fQ;
            } else {
                aVar = fQ;
            }
            if (aVar != null) {
                int width = aVar.getWidth();
                int height = aVar.getHeight();
                if (width > 0 && height > 0 && this.il != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height > this.il.bottom - this.il.top || width > this.il.right - this.il.left) {
                        if (this.mMatrix == null) {
                            this.mMatrix = new Matrix();
                            this.mMatrix.postTranslate(0.0f, 0.0f);
                            float f = (this.il.right - this.il.left) / width;
                            float f2 = (this.il.bottom - this.il.top) / height;
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
