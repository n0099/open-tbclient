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
    private Paint aAo;
    private Paint aAp;
    private int aAq;
    private int aAr;
    private float aAs;
    private int aAt;
    private float aAu;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aAo = null;
        this.aAp = null;
        this.aAq = 0;
        this.aAr = 0;
        this.aAs = 0.42857143f;
        this.aAt = 0;
        this.aAu = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAo = null;
        this.aAp = null;
        this.aAq = 0;
        this.aAr = 0;
        this.aAs = 0.42857143f;
        this.aAt = 0;
        this.aAu = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.aAo = null;
        this.aAp = null;
        this.aAq = 0;
        this.aAr = 0;
        this.aAs = 0.42857143f;
        this.aAt = 0;
        this.aAu = 1.0f;
        init();
    }

    private void init() {
        this.aAo = new Paint();
        this.aAo.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aAo.setAlpha(153);
        this.aAp = new Paint();
        this.aAp.setStyle(Paint.Style.STROKE);
        this.aAp.setColor(-1);
        this.aAt = getResources().getColor(i.c.editimage_bg);
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
        float width = this.aAu * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aAq = (int) (((i4 - i2) - width) * this.aAs);
        this.aAr = (int) (((i4 - i2) - width) * (1.0f - this.aAs));
        setOffset(0, this.aAq, 0, this.aAr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.aAt);
        super.onDraw(canvas);
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        canvas.drawRect(scrollX, scrollY, getWidth() + scrollX, this.aAq + scrollY, this.aAo);
        canvas.drawRect(scrollX, (getHeight() + scrollY) - this.aAr, getWidth() + scrollX, getHeight() + scrollY, this.aAo);
        canvas.drawRect(scrollX, this.aAq + scrollY, (getWidth() + scrollX) - 1, (getHeight() + scrollY) - this.aAr, this.aAp);
    }

    public Bitmap bo(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.aAq, getWidth(), (getHeight() - this.aAr) - this.aAq);
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
        this.aAu = f;
        invalidate();
    }
}
