package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class EditHeadsImageView extends a {
    private Paint b;
    private Paint c;
    private int d;
    private int e;
    private float f;
    private int g;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 0;
        this.f = 0.42857143f;
        this.g = 0;
        q();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 0;
        this.f = 0.42857143f;
        this.g = 0;
        q();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 0;
        this.f = 0.42857143f;
        this.g = 0;
        q();
    }

    private void q() {
        this.b = new Paint();
        this.b.setColor(-16777216);
        this.b.setAlpha(153);
        this.c = new Paint();
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setColor(-1);
        this.g = getResources().getColor(com.baidu.tbadk.g.editimage_bg);
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
        this.d = (int) (((i4 - i2) - (i3 - i)) * this.f);
        this.e = (int) (((i4 - i2) - (i3 - i)) * (1.0f - this.f));
        a(this.d, this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.g);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.d, this.b);
        canvas.drawRect(0.0f, getHeight() - this.e, getWidth(), getHeight(), this.b);
        canvas.drawRect(0.0f, this.d, getWidth() - 1, getHeight() - this.e, this.c);
    }

    public final Bitmap a(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.d, getWidth(), getWidth());
                bitmap = z ? Bitmap.createScaledBitmap(createBitmap, 960, 960, false) : createBitmap;
                if (bitmap != createBitmap) {
                    createBitmap.recycle();
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getVisableBitmap", e.toString());
        }
        return bitmap;
    }
}
