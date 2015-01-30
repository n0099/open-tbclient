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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class EditHeadsImageView extends a {
    private Paint aiV;
    private Paint aiW;
    private int aiX;
    private int aiY;
    private float aiZ;
    private int aja;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiV = null;
        this.aiW = null;
        this.aiX = 0;
        this.aiY = 0;
        this.aiZ = 0.42857143f;
        this.aja = 0;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiV = null;
        this.aiW = null;
        this.aiX = 0;
        this.aiY = 0;
        this.aiZ = 0.42857143f;
        this.aja = 0;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.aiV = null;
        this.aiW = null;
        this.aiX = 0;
        this.aiY = 0;
        this.aiZ = 0.42857143f;
        this.aja = 0;
        init();
    }

    private void init() {
        this.aiV = new Paint();
        this.aiV.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aiV.setAlpha(153);
        this.aiW = new Paint();
        this.aiW.setStyle(Paint.Style.STROKE);
        this.aiW.setColor(-1);
        this.aja = getResources().getColor(t.editimage_bg);
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
        this.aiX = (int) (((i4 - i2) - (i3 - i)) * this.aiZ);
        this.aiY = (int) (((i4 - i2) - (i3 - i)) * (1.0f - this.aiZ));
        setOffset(0, this.aiX, 0, this.aiY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.aja);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aiX, this.aiV);
        canvas.drawRect(0.0f, getHeight() - this.aiY, getWidth(), getHeight(), this.aiV);
        canvas.drawRect(0.0f, this.aiX, getWidth() - 1, getHeight() - this.aiY, this.aiW);
    }

    public Bitmap bb(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.aiX, getWidth(), getWidth());
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
