package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class MaskView extends View {
    private int bZk;
    private int cPU;
    private Paint esN;
    private Paint etk;
    private Rect etl;
    private Drawable etm;
    private Path lS;
    private int maskType;

    public void setLineColor(int i) {
        this.bZk = i;
    }

    public void setMaskColor(int i) {
        this.cPU = i;
    }

    public Rect getFrameRect() {
        return this.maskType == 0 ? new Rect(0, 0, getWidth(), getHeight()) : new Rect(this.etl);
    }

    public Rect getFrameRectExtend() {
        Rect rect = new Rect(this.etl);
        int i = (int) ((this.etl.right - this.etl.left) * 0.02f);
        int i2 = (int) ((this.etl.bottom - this.etl.top) * 0.02f);
        rect.left -= i;
        rect.right = i + rect.right;
        rect.top -= i2;
        rect.bottom += i2;
        return rect;
    }

    public void setMaskType(@MaskType int i) {
        this.maskType = i;
        switch (i) {
            case 1:
                this.etm = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_front, null);
                break;
            case 2:
                this.etm = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_back, null);
                break;
        }
        invalidate();
    }

    public int getMaskType() {
        return this.maskType;
    }

    public void setOrientation(int i) {
    }

    public MaskView(Context context) {
        super(context);
        this.bZk = -1;
        this.maskType = 1;
        this.cPU = Color.argb(100, 0, 0, 0);
        this.esN = new Paint(1);
        this.etk = new Paint(1);
        this.etl = new Rect();
        this.lS = new Path();
        setLayerType(1, null);
        this.etk.setColor(-1);
        this.etk.setStyle(Paint.Style.STROKE);
        this.etk.setStrokeWidth(6.0f);
        this.esN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        init();
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZk = -1;
        this.maskType = 1;
        this.cPU = Color.argb(100, 0, 0, 0);
        this.esN = new Paint(1);
        this.etk = new Paint(1);
        this.etl = new Rect();
        this.lS = new Path();
        setLayerType(1, null);
        this.etk.setColor(-1);
        this.etk.setStyle(Paint.Style.STROKE);
        this.etk.setStrokeWidth(6.0f);
        this.esN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        init();
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZk = -1;
        this.maskType = 1;
        this.cPU = Color.argb(100, 0, 0, 0);
        this.esN = new Paint(1);
        this.etk = new Paint(1);
        this.etl = new Rect();
        this.lS = new Path();
        setLayerType(1, null);
        this.etk.setColor(-1);
        this.etk.setStyle(Paint.Style.STROKE);
        this.etk.setStrokeWidth(6.0f);
        this.esN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        init();
    }

    private void init() {
        this.etm = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_front, null);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            int i5 = (int) ((i2 > i ? 0.9f : 0.72f) * i);
            int i6 = (i5 * 400) / 620;
            int i7 = (i - i5) / 2;
            int i8 = (i2 - i6) / 2;
            this.etl.left = i7;
            this.etl.top = i8;
            this.etl.right = i5 + i7;
            this.etl.bottom = i6 + i8;
        }
    }

    @Override // android.view.View
    @RequiresApi(api = 21)
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.etl;
        int width = rect.width();
        int height = rect.height();
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        canvas.drawColor(this.cPU);
        a(i, i2, i3, i4, 30.0f, 30.0f, false);
        canvas.drawPath(this.lS, this.etk);
        canvas.drawPath(this.lS, this.esN);
        if (this.maskType == 1) {
            this.etm.setBounds((int) (i + (0.5974155f * width)), (int) (i2 + (0.17405063f * height)), (int) (i + (0.95725644f * width)), (int) (i2 + (0.7531645f * height)));
        } else if (this.maskType == 2) {
            this.etm.setBounds((int) (i + (0.050695825f * width)), (int) (i2 + (0.07594936f * height)), (int) (i + (0.24850895f * width)), (int) (i2 + (0.41455695f * height)));
        }
        if (this.etm != null) {
            this.etm.draw(canvas);
        }
    }

    private Path a(float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        this.lS.reset();
        float f7 = f5 < 0.0f ? 0.0f : f5;
        float f8 = f6 < 0.0f ? 0.0f : f6;
        float f9 = f3 - f;
        float f10 = f4 - f2;
        if (f7 > f9 / 2.0f) {
            f7 = f9 / 2.0f;
        }
        if (f8 > f10 / 2.0f) {
            f8 = f10 / 2.0f;
        }
        float f11 = f9 - (2.0f * f7);
        float f12 = f10 - (2.0f * f8);
        this.lS.moveTo(f3, f2 + f8);
        this.lS.rQuadTo(0.0f, -f8, -f7, -f8);
        this.lS.rLineTo(-f11, 0.0f);
        this.lS.rQuadTo(-f7, 0.0f, -f7, f8);
        this.lS.rLineTo(0.0f, f12);
        if (z) {
            this.lS.rLineTo(0.0f, f8);
            this.lS.rLineTo(f9, 0.0f);
            this.lS.rLineTo(0.0f, -f8);
        } else {
            this.lS.rQuadTo(0.0f, f8, f7, f8);
            this.lS.rLineTo(f11, 0.0f);
            this.lS.rQuadTo(f7, 0.0f, f7, -f8);
        }
        this.lS.rLineTo(0.0f, -f12);
        this.lS.close();
        return this.lS;
    }
}
