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
    private Rect rs = null;
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
        this.rs = new Rect(i, i2, i3, i4);
        this.mMatrix = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.rs = new Rect(rect);
        this.mMatrix = null;
        super.setBounds(rect);
    }

    public void U(int i, int i2) {
        if (this.rs != null) {
            super.setBounds(this.rs.left, this.rs.top, this.rs.right + i, this.rs.bottom + i2);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.mId > 0 && this.mContext != null) {
            com.baidu.tbadk.imageManager.c DZ = com.baidu.tbadk.imageManager.c.DZ();
            com.baidu.adp.widget.ImageView.a gi = (DZ == null || this.mKey == null) ? null : DZ.gi(this.mKey);
            if (gi == null) {
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.mContext, this.mId);
                if (resBitmap != null) {
                    gi = new com.baidu.adp.widget.ImageView.a(resBitmap, false, null);
                }
                if (DZ != null && gi != null && this.mKey != null) {
                    DZ.c(this.mKey, gi);
                }
                aVar = gi;
            } else {
                aVar = gi;
            }
            if (aVar != null) {
                int width = aVar.getWidth();
                int height = aVar.getHeight();
                if (width > 0 && height > 0 && this.rs != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height > this.rs.bottom - this.rs.top || width > this.rs.right - this.rs.left) {
                        if (this.mMatrix == null) {
                            this.mMatrix = new Matrix();
                            this.mMatrix.postTranslate(0.0f, 0.0f);
                            float f = (this.rs.right - this.rs.left) / width;
                            float f2 = (this.rs.bottom - this.rs.top) / height;
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
