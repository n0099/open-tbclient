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
    private Paint aaC;
    private Paint aaD;
    private int aaE;
    private int aaF;
    private float aaG;
    private int aaH;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaC = null;
        this.aaD = null;
        this.aaE = 0;
        this.aaF = 0;
        this.aaG = 0.42857143f;
        this.aaH = 0;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaC = null;
        this.aaD = null;
        this.aaE = 0;
        this.aaF = 0;
        this.aaG = 0.42857143f;
        this.aaH = 0;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.aaC = null;
        this.aaD = null;
        this.aaE = 0;
        this.aaF = 0;
        this.aaG = 0.42857143f;
        this.aaH = 0;
        init();
    }

    private void init() {
        this.aaC = new Paint();
        this.aaC.setColor(-16777216);
        this.aaC.setAlpha(153);
        this.aaD = new Paint();
        this.aaD.setStyle(Paint.Style.STROKE);
        this.aaD.setColor(-1);
        this.aaH = getResources().getColor(s.editimage_bg);
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
        this.aaE = (int) (((i4 - i2) - (i3 - i)) * this.aaG);
        this.aaF = (int) (((i4 - i2) - (i3 - i)) * (1.0f - this.aaG));
        c(0, this.aaE, 0, this.aaF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.aaH);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aaE, this.aaC);
        canvas.drawRect(0.0f, getHeight() - this.aaF, getWidth(), getHeight(), this.aaC);
        canvas.drawRect(0.0f, this.aaE, getWidth() - 1, getHeight() - this.aaF, this.aaD);
    }

    public Bitmap aK(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.aaE, getWidth(), getWidth());
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
