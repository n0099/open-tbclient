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
    public int f14162e;

    /* renamed from: f  reason: collision with root package name */
    public int f14163f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f14164g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f14165h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f14166i;
    public Drawable j;
    public Path k;

    public MaskView(Context context) {
        super(context);
        this.f14162e = 1;
        this.f14163f = Color.argb(100, 0, 0, 0);
        this.f14164g = new Paint(1);
        this.f14165h = new Paint(1);
        this.f14166i = new Rect();
        this.k = new Path();
        setLayerType(1, null);
        this.f14165h.setColor(-1);
        this.f14165h.setStyle(Paint.Style.STROKE);
        this.f14165h.setStrokeWidth(6.0f);
        this.f14164g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
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
        if (this.f14162e == 0) {
            return new Rect(0, 0, getWidth(), getHeight());
        }
        return new Rect(this.f14166i);
    }

    public Rect getFrameRectExtend() {
        Rect rect = new Rect(this.f14166i);
        Rect rect2 = this.f14166i;
        int i2 = (int) ((rect2.right - rect2.left) * 0.02f);
        int i3 = (int) ((rect2.bottom - rect2.top) * 0.02f);
        rect.left -= i2;
        rect.right += i2;
        rect.top -= i3;
        rect.bottom += i3;
        return rect;
    }

    public int getMaskType() {
        return this.f14162e;
    }

    @Override // android.view.View
    @RequiresApi(api = 21)
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.f14166i;
        int width = rect.width();
        int height = rect.height();
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        canvas.drawColor(this.f14163f);
        float f2 = i2;
        float f3 = i3;
        a(f2, f3, i4, i5, 30.0f, 30.0f, false);
        canvas.drawPath(this.k, this.f14165h);
        canvas.drawPath(this.k, this.f14164g);
        int i6 = this.f14162e;
        if (i6 == 1) {
            float f4 = width;
            float f5 = height;
            this.j.setBounds((int) ((0.5974155f * f4) + f2), (int) ((0.17405063f * f5) + f3), (int) (f2 + (f4 * 0.95725644f)), (int) (f3 + (f5 * 0.7531645f)));
        } else if (i6 == 2) {
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
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        int i6 = (int) (i2 * (i3 > i2 ? 0.9f : 0.72f));
        int i7 = (i6 * 400) / 620;
        int i8 = (i2 - i6) / 2;
        int i9 = (i3 - i7) / 2;
        Rect rect = this.f14166i;
        rect.left = i8;
        rect.top = i9;
        rect.right = i6 + i8;
        rect.bottom = i7 + i9;
    }

    public void setLineColor(int i2) {
    }

    public void setMaskColor(int i2) {
        this.f14163f = i2;
    }

    public void setMaskType(int i2) {
        this.f14162e = i2;
        if (i2 == 1) {
            this.j = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_front, null);
        } else if (i2 == 2) {
            this.j = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_back, null);
        }
        invalidate();
    }

    public void setOrientation(int i2) {
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14162e = 1;
        this.f14163f = Color.argb(100, 0, 0, 0);
        this.f14164g = new Paint(1);
        this.f14165h = new Paint(1);
        this.f14166i = new Rect();
        this.k = new Path();
        setLayerType(1, null);
        this.f14165h.setColor(-1);
        this.f14165h.setStyle(Paint.Style.STROKE);
        this.f14165h.setStrokeWidth(6.0f);
        this.f14164g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        b();
    }

    public MaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14162e = 1;
        this.f14163f = Color.argb(100, 0, 0, 0);
        this.f14164g = new Paint(1);
        this.f14165h = new Paint(1);
        this.f14166i = new Rect();
        this.k = new Path();
        setLayerType(1, null);
        this.f14165h.setColor(-1);
        this.f14165h.setStyle(Paint.Style.STROKE);
        this.f14165h.setStrokeWidth(6.0f);
        this.f14164g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        b();
    }
}
