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
    private Rect kF = null;
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
        this.kF = new Rect(i, i2, i3, i4);
        this.mMatrix = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.kF = new Rect(rect);
        this.mMatrix = null;
        super.setBounds(rect);
    }

    public void L(int i, int i2) {
        if (this.kF != null) {
            super.setBounds(this.kF.left, this.kF.top, this.kF.right + i, this.kF.bottom + i2);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.baidu.adp.widget.a.a aVar;
        if (this.mId > 0 && this.mContext != null) {
            com.baidu.tbadk.imageManager.c Ek = com.baidu.tbadk.imageManager.c.Ek();
            com.baidu.adp.widget.a.a fT = (Ek == null || this.mKey == null) ? null : Ek.fT(this.mKey);
            if (fT == null) {
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.mContext, this.mId);
                if (resBitmap != null) {
                    fT = new com.baidu.adp.widget.a.a(resBitmap, false, null);
                }
                if (Ek != null && fT != null && this.mKey != null) {
                    Ek.c(this.mKey, fT);
                }
                aVar = fT;
            } else {
                aVar = fT;
            }
            if (aVar != null) {
                int width = aVar.getWidth();
                int height = aVar.getHeight();
                if (width > 0 && height > 0 && this.kF != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height > this.kF.bottom - this.kF.top || width > this.kF.right - this.kF.left) {
                        if (this.mMatrix == null) {
                            this.mMatrix = new Matrix();
                            this.mMatrix.postTranslate(0.0f, 0.0f);
                            float f = (this.kF.right - this.kF.left) / width;
                            float f2 = (this.kF.bottom - this.kF.top) / height;
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
