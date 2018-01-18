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
    private Rect lQ = null;
    private Matrix mMatrix = null;
    private int bJb = 0;
    private int bJc = 0;

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
        this.lQ = new Rect(i, i2, i3, i4);
        this.mMatrix = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.lQ = new Rect(rect);
        this.mMatrix = null;
        super.setBounds(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.baidu.adp.widget.a.a aVar;
        if (this.mId > 0 && this.mContext != null) {
            com.baidu.tbadk.imageManager.c LP = com.baidu.tbadk.imageManager.c.LP();
            com.baidu.adp.widget.a.a gy = (LP == null || this.mKey == null) ? null : LP.gy(this.mKey);
            if (gy == null) {
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.mContext, this.mId);
                if (resBitmap != null) {
                    gy = new com.baidu.adp.widget.a.a(resBitmap, false, (String) null);
                }
                if (LP != null && gy != null && this.mKey != null) {
                    LP.c(this.mKey, gy);
                }
                aVar = gy;
            } else {
                aVar = gy;
            }
            if (aVar != null) {
                int width = aVar.getWidth();
                int height = aVar.getHeight();
                if (width > 0 && height > 0 && this.lQ != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height > 0 || width > 0 || this.bJb != 0 || this.bJc != 0) {
                        if (this.mMatrix == null) {
                            this.mMatrix = new Matrix();
                            this.mMatrix.postTranslate(this.bJb, this.bJc);
                            float f = (this.lQ.right - this.lQ.left) / width;
                            float f2 = (this.lQ.bottom - this.lQ.top) / height;
                            if (f >= f2) {
                                f = f2;
                            }
                            if (f < 1.0f) {
                                this.mMatrix.postScale(f, f);
                            }
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
