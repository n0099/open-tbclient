package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
public class EditHeadsImageView extends a {
    private int aaA;
    private int aaB;
    private float aaC;
    private int aaD;
    private Paint aay;
    private Paint aaz;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aay = null;
        this.aaz = null;
        this.aaA = 0;
        this.aaB = 0;
        this.aaC = 0.42857143f;
        this.aaD = 0;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aay = null;
        this.aaz = null;
        this.aaA = 0;
        this.aaB = 0;
        this.aaC = 0.42857143f;
        this.aaD = 0;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.aay = null;
        this.aaz = null;
        this.aaA = 0;
        this.aaB = 0;
        this.aaC = 0.42857143f;
        this.aaD = 0;
        init();
    }

    private void init() {
        this.aay = new Paint();
        this.aay.setColor(-16777216);
        this.aay.setAlpha(153);
        this.aaz = new Paint();
        this.aaz.setStyle(Paint.Style.STROKE);
        this.aaz.setColor(-1);
        this.aaD = getResources().getColor(s.editimage_bg);
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
        this.aaA = (int) (((i4 - i2) - (i3 - i)) * this.aaC);
        this.aaB = (int) (((i4 - i2) - (i3 - i)) * (1.0f - this.aaC));
        c(0, this.aaA, 0, this.aaB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.aaD);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aaA, this.aay);
        canvas.drawRect(0.0f, getHeight() - this.aaB, getWidth(), getHeight(), this.aay);
        canvas.drawRect(0.0f, this.aaA, getWidth() - 1, getHeight() - this.aaB, this.aaz);
    }

    public Bitmap aK(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.aaA, getWidth(), getWidth());
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
}
