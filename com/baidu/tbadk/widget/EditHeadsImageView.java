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
    private Paint aiS;
    private Paint aiT;
    private int aiU;
    private int aiV;
    private float aiW;
    private int aiX;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiS = null;
        this.aiT = null;
        this.aiU = 0;
        this.aiV = 0;
        this.aiW = 0.42857143f;
        this.aiX = 0;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiS = null;
        this.aiT = null;
        this.aiU = 0;
        this.aiV = 0;
        this.aiW = 0.42857143f;
        this.aiX = 0;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.aiS = null;
        this.aiT = null;
        this.aiU = 0;
        this.aiV = 0;
        this.aiW = 0.42857143f;
        this.aiX = 0;
        init();
    }

    private void init() {
        this.aiS = new Paint();
        this.aiS.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aiS.setAlpha(153);
        this.aiT = new Paint();
        this.aiT.setStyle(Paint.Style.STROKE);
        this.aiT.setColor(-1);
        this.aiX = getResources().getColor(t.editimage_bg);
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
        this.aiU = (int) (((i4 - i2) - (i3 - i)) * this.aiW);
        this.aiV = (int) (((i4 - i2) - (i3 - i)) * (1.0f - this.aiW));
        setOffset(0, this.aiU, 0, this.aiV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.aiX);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aiU, this.aiS);
        canvas.drawRect(0.0f, getHeight() - this.aiV, getWidth(), getHeight(), this.aiS);
        canvas.drawRect(0.0f, this.aiU, getWidth() - 1, getHeight() - this.aiV, this.aiT);
    }

    public Bitmap bb(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.aiU, getWidth(), getWidth());
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
