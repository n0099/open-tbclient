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
    private Rect hI = null;
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
        this.hI = new Rect(i, i2, i3, i4);
        this.mMatrix = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.hI = new Rect(rect);
        this.mMatrix = null;
        super.setBounds(rect);
    }

    public void I(int i, int i2) {
        if (this.hI != null) {
            super.setBounds(this.hI.left, this.hI.top, this.hI.right + i, this.hI.bottom + i2);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.baidu.adp.widget.a.a aVar;
        if (this.mId > 0 && this.mContext != null) {
            com.baidu.tbadk.imageManager.c CQ = com.baidu.tbadk.imageManager.c.CQ();
            com.baidu.adp.widget.a.a fS = (CQ == null || this.mKey == null) ? null : CQ.fS(this.mKey);
            if (fS == null) {
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.mContext, this.mId);
                if (resBitmap != null) {
                    fS = new com.baidu.adp.widget.a.a(resBitmap, false, null);
                }
                if (CQ != null && fS != null && this.mKey != null) {
                    CQ.c(this.mKey, fS);
                }
                aVar = fS;
            } else {
                aVar = fS;
            }
            if (aVar != null) {
                int width = aVar.getWidth();
                int height = aVar.getHeight();
                if (width > 0 && height > 0 && this.hI != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height > this.hI.bottom - this.hI.top || width > this.hI.right - this.hI.left) {
                        if (this.mMatrix == null) {
                            this.mMatrix = new Matrix();
                            this.mMatrix.postTranslate(0.0f, 0.0f);
                            float f = (this.hI.right - this.hI.left) / width;
                            float f2 = (this.hI.bottom - this.hI.top) / height;
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
