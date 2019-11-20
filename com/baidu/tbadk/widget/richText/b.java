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
    private Rect mRect = null;
    private Matrix mMatrix = null;
    private int cVR = 0;
    private int cVS = 0;

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
        this.mRect = new Rect(i, i2, i3, i4);
        this.mMatrix = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.mRect = new Rect(rect);
        this.mMatrix = null;
        super.setBounds(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.mId > 0 && this.mContext != null) {
            com.baidu.tbadk.imageManager.c avs = com.baidu.tbadk.imageManager.c.avs();
            com.baidu.adp.widget.ImageView.a pY = (avs == null || this.mKey == null) ? null : avs.pY(this.mKey);
            if (pY == null) {
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.mContext, this.mId);
                if (resBitmap != null) {
                    pY = new com.baidu.adp.widget.ImageView.a(resBitmap, false, (String) null);
                }
                if (avs != null && pY != null && this.mKey != null) {
                    avs.c(this.mKey, pY);
                }
                aVar = pY;
            } else {
                aVar = pY;
            }
            if (aVar != null) {
                int width = aVar.getWidth();
                int height = aVar.getHeight();
                if (width > 0 && height > 0 && this.mRect != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height > 0 || width > 0 || this.cVR != 0 || this.cVS != 0) {
                        if (this.mMatrix == null) {
                            this.mMatrix = new Matrix();
                            this.mMatrix.postTranslate(this.cVR, this.cVS);
                            float f = (this.mRect.right - this.mRect.left) / width;
                            float f2 = (this.mRect.bottom - this.mRect.top) / height;
                            if (f >= f2) {
                                f = f2;
                            }
                            if (f < 1.0f) {
                                this.mMatrix.postScale(f, f);
                            }
                        }
                        aVar.drawImageTo(canvas, this.mMatrix, null);
                    } else {
                        aVar.drawImageTo(canvas, 0.0f, 0.0f, (Paint) null);
                    }
                    canvas.restore();
                }
            }
        }
    }
}
