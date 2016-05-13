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
    private Rect hJ = null;
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
        this.hJ = new Rect(i, i2, i3, i4);
        this.mMatrix = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.hJ = new Rect(rect);
        this.mMatrix = null;
        super.setBounds(rect);
    }

    public void I(int i, int i2) {
        if (this.hJ != null) {
            super.setBounds(this.hJ.left, this.hJ.top, this.hJ.right + i, this.hJ.bottom + i2);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.baidu.adp.widget.a.a aVar;
        if (this.mId > 0 && this.mContext != null) {
            com.baidu.tbadk.imageManager.c CI = com.baidu.tbadk.imageManager.c.CI();
            com.baidu.adp.widget.a.a fM = (CI == null || this.mKey == null) ? null : CI.fM(this.mKey);
            if (fM == null) {
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.mContext, this.mId);
                if (resBitmap != null) {
                    fM = new com.baidu.adp.widget.a.a(resBitmap, false, null);
                }
                if (CI != null && fM != null && this.mKey != null) {
                    CI.c(this.mKey, fM);
                }
                aVar = fM;
            } else {
                aVar = fM;
            }
            if (aVar != null) {
                int width = aVar.getWidth();
                int height = aVar.getHeight();
                if (width > 0 && height > 0 && this.hJ != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height > this.hJ.bottom - this.hJ.top || width > this.hJ.right - this.hJ.left) {
                        if (this.mMatrix == null) {
                            this.mMatrix = new Matrix();
                            this.mMatrix.postTranslate(0.0f, 0.0f);
                            float f = (this.hJ.right - this.hJ.left) / width;
                            float f2 = (this.hJ.bottom - this.hJ.top) / height;
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
