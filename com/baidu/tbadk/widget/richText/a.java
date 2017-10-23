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
    private Rect rt = null;
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
        this.rt = new Rect(i, i2, i3, i4);
        this.mMatrix = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.rt = new Rect(rect);
        this.mMatrix = null;
        super.setBounds(rect);
    }

    public void U(int i, int i2) {
        if (this.rt != null) {
            super.setBounds(this.rt.left, this.rt.top, this.rt.right + i, this.rt.bottom + i2);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.mId > 0 && this.mContext != null) {
            com.baidu.tbadk.imageManager.c DT = com.baidu.tbadk.imageManager.c.DT();
            com.baidu.adp.widget.ImageView.a gh = (DT == null || this.mKey == null) ? null : DT.gh(this.mKey);
            if (gh == null) {
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.mContext, this.mId);
                if (resBitmap != null) {
                    gh = new com.baidu.adp.widget.ImageView.a(resBitmap, false, null);
                }
                if (DT != null && gh != null && this.mKey != null) {
                    DT.c(this.mKey, gh);
                }
                aVar = gh;
            } else {
                aVar = gh;
            }
            if (aVar != null) {
                int width = aVar.getWidth();
                int height = aVar.getHeight();
                if (width > 0 && height > 0 && this.rt != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height > this.rt.bottom - this.rt.top || width > this.rt.right - this.rt.left) {
                        if (this.mMatrix == null) {
                            this.mMatrix = new Matrix();
                            this.mMatrix.postTranslate(0.0f, 0.0f);
                            float f = (this.rt.right - this.rt.left) / width;
                            float f2 = (this.rt.bottom - this.rt.top) / height;
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
