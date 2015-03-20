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
    private Paint aru;
    private Paint arv;
    private int arw;
    private int arx;
    private float ary;
    private int arz;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aru = null;
        this.arv = null;
        this.arw = 0;
        this.arx = 0;
        this.ary = 0.42857143f;
        this.arz = 0;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aru = null;
        this.arv = null;
        this.arw = 0;
        this.arx = 0;
        this.ary = 0.42857143f;
        this.arz = 0;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.aru = null;
        this.arv = null;
        this.arw = 0;
        this.arx = 0;
        this.ary = 0.42857143f;
        this.arz = 0;
        init();
    }

    private void init() {
        this.aru = new Paint();
        this.aru.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aru.setAlpha(153);
        this.arv = new Paint();
        this.arv.setStyle(Paint.Style.STROKE);
        this.arv.setColor(-1);
        this.arz = getResources().getColor(s.editimage_bg);
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
        this.arw = (int) (((i4 - i2) - (i3 - i)) * this.ary);
        this.arx = (int) (((i4 - i2) - (i3 - i)) * (1.0f - this.ary));
        setOffset(0, this.arw, 0, this.arx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.arz);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.arw, this.aru);
        canvas.drawRect(0.0f, getHeight() - this.arx, getWidth(), getHeight(), this.aru);
        canvas.drawRect(0.0f, this.arw, getWidth() - 1, getHeight() - this.arx, this.arv);
    }

    public Bitmap bg(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.arw, getWidth(), getWidth());
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
