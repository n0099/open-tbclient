package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class EditHeadsImageView extends a {
    private Paint aBW;
    private Paint aBX;
    private int aBY;
    private int aBZ;
    private float aCa;
    private int aCb;
    private float aCc;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBW = null;
        this.aBX = null;
        this.aBY = 0;
        this.aBZ = 0;
        this.aCa = 0.42857143f;
        this.aCb = 0;
        this.aCc = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBW = null;
        this.aBX = null;
        this.aBY = 0;
        this.aBZ = 0;
        this.aCa = 0.42857143f;
        this.aCb = 0;
        this.aCc = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.aBW = null;
        this.aBX = null;
        this.aBY = 0;
        this.aBZ = 0;
        this.aCa = 0.42857143f;
        this.aCb = 0;
        this.aCc = 1.0f;
        init();
    }

    private void init() {
        this.aBW = new Paint();
        this.aBW.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aBW.setAlpha(153);
        this.aBX = new Paint();
        this.aBX.setStyle(Paint.Style.STROKE);
        this.aBX.setColor(-1);
        this.aCb = getResources().getColor(i.c.editimage_bg);
        setDrawingCacheEnabled(true);
        setImageMode(1);
        CompatibleUtile.getInstance().noneViewGpu(this);
    }

    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.aCc * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aBY = (int) (((i4 - i2) - width) * this.aCa);
        this.aBZ = (int) (((i4 - i2) - width) * (1.0f - this.aCa));
        setOffset(0, this.aBY, 0, this.aBZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.aCb);
        super.onDraw(canvas);
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        canvas.drawRect(scrollX, scrollY, getWidth() + scrollX, this.aBY + scrollY, this.aBW);
        canvas.drawRect(scrollX, (getHeight() + scrollY) - this.aBZ, getWidth() + scrollX, getHeight() + scrollY, this.aBW);
        canvas.drawRect(scrollX, this.aBY + scrollY, (getWidth() + scrollX) - 1, (getHeight() + scrollY) - this.aBZ, this.aBX);
    }

    public Bitmap bv(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.aBY, getWidth(), (getHeight() - this.aBZ) - this.aBY);
                bitmap = z ? Bitmap.createScaledBitmap(createBitmap, TbConfig.HEAD_IMG_SIZE, TbConfig.HEAD_IMG_SIZE, false) : createBitmap;
                if (bitmap != createBitmap) {
                    createBitmap.recycle();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return bitmap;
    }

    public void setCutImageHeightScale(float f) {
        this.aCc = f;
        invalidate();
    }
}
