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
import com.baidu.tieba.s;
/* loaded from: classes.dex */
public class EditHeadsImageView extends a {
    private Paint arC;
    private Paint arD;
    private int arE;
    private int arF;
    private float arG;
    private int arH;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arC = null;
        this.arD = null;
        this.arE = 0;
        this.arF = 0;
        this.arG = 0.42857143f;
        this.arH = 0;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arC = null;
        this.arD = null;
        this.arE = 0;
        this.arF = 0;
        this.arG = 0.42857143f;
        this.arH = 0;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.arC = null;
        this.arD = null;
        this.arE = 0;
        this.arF = 0;
        this.arG = 0.42857143f;
        this.arH = 0;
        init();
    }

    private void init() {
        this.arC = new Paint();
        this.arC.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.arC.setAlpha(153);
        this.arD = new Paint();
        this.arD.setStyle(Paint.Style.STROKE);
        this.arD.setColor(-1);
        this.arH = getResources().getColor(s.editimage_bg);
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
        this.arE = (int) (((i4 - i2) - (i3 - i)) * this.arG);
        this.arF = (int) (((i4 - i2) - (i3 - i)) * (1.0f - this.arG));
        setOffset(0, this.arE, 0, this.arF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.arH);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.arE, this.arC);
        canvas.drawRect(0.0f, getHeight() - this.arF, getWidth(), getHeight(), this.arC);
        canvas.drawRect(0.0f, this.arE, getWidth() - 1, getHeight() - this.arF, this.arD);
    }

    public Bitmap bg(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.arE, getWidth(), getWidth());
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
