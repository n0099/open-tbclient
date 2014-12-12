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
    private Paint ais;
    private Paint ait;
    private int aiu;
    private int aiv;
    private float aiw;
    private int aix;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ais = null;
        this.ait = null;
        this.aiu = 0;
        this.aiv = 0;
        this.aiw = 0.42857143f;
        this.aix = 0;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ais = null;
        this.ait = null;
        this.aiu = 0;
        this.aiv = 0;
        this.aiw = 0.42857143f;
        this.aix = 0;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.ais = null;
        this.ait = null;
        this.aiu = 0;
        this.aiv = 0;
        this.aiw = 0.42857143f;
        this.aix = 0;
        init();
    }

    private void init() {
        this.ais = new Paint();
        this.ais.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.ais.setAlpha(153);
        this.ait = new Paint();
        this.ait.setStyle(Paint.Style.STROKE);
        this.ait.setColor(-1);
        this.aix = getResources().getColor(t.editimage_bg);
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
        this.aiu = (int) (((i4 - i2) - (i3 - i)) * this.aiw);
        this.aiv = (int) (((i4 - i2) - (i3 - i)) * (1.0f - this.aiw));
        setOffset(0, this.aiu, 0, this.aiv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.aix);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aiu, this.ais);
        canvas.drawRect(0.0f, getHeight() - this.aiv, getWidth(), getHeight(), this.ais);
        canvas.drawRect(0.0f, this.aiu, getWidth() - 1, getHeight() - this.aiv, this.ait);
    }

    public Bitmap aZ(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.aiu, getWidth(), getWidth());
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
