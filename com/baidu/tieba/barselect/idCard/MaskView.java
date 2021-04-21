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
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class MaskView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f14853e;

    /* renamed from: f  reason: collision with root package name */
    public int f14854f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f14855g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f14856h;
    public Rect i;
    public Drawable j;
    public Path k;

    public MaskView(Context context) {
        super(context);
        this.f14853e = 1;
        this.f14854f = Color.argb(100, 0, 0, 0);
        this.f14855g = new Paint(1);
        this.f14856h = new Paint(1);
        this.i = new Rect();
        this.k = new Path();
        setLayerType(1, null);
        this.f14856h.setColor(-1);
        this.f14856h.setStyle(Paint.Style.STROKE);
        this.f14856h.setStrokeWidth(6.0f);
        this.f14855g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        b();
    }

    public final Path a(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        this.k.reset();
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        float f8 = f4 - f2;
        float f9 = f5 - f3;
        float f10 = f8 / 2.0f;
        if (f6 > f10) {
            f6 = f10;
        }
        float f11 = f9 / 2.0f;
        if (f7 > f11) {
            f7 = f11;
        }
        float f12 = f8 - (f6 * 2.0f);
        float f13 = f9 - (2.0f * f7);
        this.k.moveTo(f4, f3 + f7);
        float f14 = -f7;
        float f15 = -f6;
        this.k.rQuadTo(0.0f, f14, f15, f14);
        this.k.rLineTo(-f12, 0.0f);
        this.k.rQuadTo(f15, 0.0f, f15, f7);
        this.k.rLineTo(0.0f, f13);
        if (z) {
            this.k.rLineTo(0.0f, f7);
            this.k.rLineTo(f8, 0.0f);
            this.k.rLineTo(0.0f, f14);
        } else {
            this.k.rQuadTo(0.0f, f7, f6, f7);
            this.k.rLineTo(f12, 0.0f);
            this.k.rQuadTo(f6, 0.0f, f6, f14);
        }
        this.k.rLineTo(0.0f, -f13);
        this.k.close();
        return this.k;
    }

    public final void b() {
        this.j = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_front, null);
    }

    public Rect getFrameRect() {
        if (this.f14853e == 0) {
            return new Rect(0, 0, getWidth(), getHeight());
        }
        return new Rect(this.i);
    }

    public Rect getFrameRectExtend() {
        Rect rect = new Rect(this.i);
        Rect rect2 = this.i;
        int i = (int) ((rect2.right - rect2.left) * 0.02f);
        int i2 = (int) ((rect2.bottom - rect2.top) * 0.02f);
        rect.left -= i;
        rect.right += i;
        rect.top -= i2;
        rect.bottom += i2;
        return rect;
    }

    public int getMaskType() {
        return this.f14853e;
    }

    @Override // android.view.View
    @RequiresApi(api = 21)
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.i;
        int width = rect.width();
        int height = rect.height();
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        canvas.drawColor(this.f14854f);
        float f2 = i;
        float f3 = i2;
        a(f2, f3, i3, i4, 30.0f, 30.0f, false);
        canvas.drawPath(this.k, this.f14856h);
        canvas.drawPath(this.k, this.f14855g);
        int i5 = this.f14853e;
        if (i5 == 1) {
            float f4 = width;
            float f5 = height;
            this.j.setBounds((int) ((0.5974155f * f4) + f2), (int) ((0.17405063f * f5) + f3), (int) (f2 + (f4 * 0.95725644f)), (int) (f3 + (f5 * 0.7531645f)));
        } else if (i5 == 2) {
            float f6 = width;
            float f7 = height;
            this.j.setBounds((int) ((0.050695825f * f6) + f2), (int) ((0.07594936f * f7) + f3), (int) (f2 + (f6 * 0.24850895f)), (int) (f3 + (f7 * 0.41455695f)));
        }
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int i5 = (int) (i * (i2 > i ? 0.9f : 0.72f));
        int i6 = (i5 * 400) / 620;
        int i7 = (i - i5) / 2;
        int i8 = (i2 - i6) / 2;
        Rect rect = this.i;
        rect.left = i7;
        rect.top = i8;
        rect.right = i5 + i7;
        rect.bottom = i6 + i8;
    }

    public void setLineColor(int i) {
    }

    public void setMaskColor(int i) {
        this.f14854f = i;
    }

    public void setMaskType(int i) {
        this.f14853e = i;
        if (i == 1) {
            this.j = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_front, null);
        } else if (i == 2) {
            this.j = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_back, null);
        }
        invalidate();
    }

    public void setOrientation(int i) {
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14853e = 1;
        this.f14854f = Color.argb(100, 0, 0, 0);
        this.f14855g = new Paint(1);
        this.f14856h = new Paint(1);
        this.i = new Rect();
        this.k = new Path();
        setLayerType(1, null);
        this.f14856h.setColor(-1);
        this.f14856h.setStyle(Paint.Style.STROKE);
        this.f14856h.setStrokeWidth(6.0f);
        this.f14855g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        b();
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14853e = 1;
        this.f14854f = Color.argb(100, 0, 0, 0);
        this.f14855g = new Paint(1);
        this.f14856h = new Paint(1);
        this.i = new Rect();
        this.k = new Path();
        setLayerType(1, null);
        this.f14856h.setColor(-1);
        this.f14856h.setStyle(Paint.Style.STROKE);
        this.f14856h.setStrokeWidth(6.0f);
        this.f14855g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        b();
    }
}
