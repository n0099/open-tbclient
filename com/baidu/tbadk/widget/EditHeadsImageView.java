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
/* loaded from: classes.dex */
public class EditHeadsImageView extends a {
    private Paint atf;
    private Paint atg;
    private int ath;
    private int ati;
    private float atj;
    private int atk;
    private float atl;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.atf = null;
        this.atg = null;
        this.ath = 0;
        this.ati = 0;
        this.atj = 0.42857143f;
        this.atk = 0;
        this.atl = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atf = null;
        this.atg = null;
        this.ath = 0;
        this.ati = 0;
        this.atj = 0.42857143f;
        this.atk = 0;
        this.atl = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.atf = null;
        this.atg = null;
        this.ath = 0;
        this.ati = 0;
        this.atj = 0.42857143f;
        this.atk = 0;
        this.atl = 1.0f;
        init();
    }

    private void init() {
        this.atf = new Paint();
        this.atf.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.atf.setAlpha(153);
        this.atg = new Paint();
        this.atg.setStyle(Paint.Style.STROKE);
        this.atg.setColor(-1);
        this.atk = getResources().getColor(com.baidu.tieba.n.editimage_bg);
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
        float width = this.atl * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.ath = (int) (((i4 - i2) - width) * this.atj);
        this.ati = (int) (((i4 - i2) - width) * (1.0f - this.atj));
        setOffset(0, this.ath, 0, this.ati);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.atk);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.ath, this.atf);
        canvas.drawRect(0.0f, getHeight() - this.ati, getWidth(), getHeight(), this.atf);
        canvas.drawRect(0.0f, this.ath, getWidth() - 1, getHeight() - this.ati, this.atg);
    }

    public Bitmap bn(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.ath, getWidth(), (getHeight() - this.ati) - this.ath);
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
        this.atl = f;
        invalidate();
    }
}
