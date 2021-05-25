package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ShadowLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Paint f12911e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f12912f;

    /* renamed from: g  reason: collision with root package name */
    public int f12913g;

    /* renamed from: h  reason: collision with root package name */
    public int f12914h;

    /* renamed from: i  reason: collision with root package name */
    public int f12915i;
    public int j;
    public int k;
    public int l;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        a();
    }

    public final void a() {
        setWillNotDraw(false);
        setLayerType(1, null);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.f12913g = dimensionPixelSize;
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.l = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.f12914h = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.f12915i = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.j = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.k = SkinManager.getColor(R.color.plugin_button_shadow_blue);
        Paint paint = new Paint();
        this.f12911e = paint;
        paint.setColor(0);
        this.f12911e.setShadowLayer(this.f12914h, this.f12915i, this.j, this.k);
        this.f12912f = new RectF();
    }

    public final void b() {
        this.f12911e.setShadowLayer(this.f12914h, this.f12915i, this.j, this.k);
        postInvalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f12912f.left = getPaddingLeft();
        this.f12912f.right = getWidth() - getPaddingRight();
        this.f12912f.bottom = getHeight() - getPaddingBottom();
        this.f12912f.top = getPaddingTop();
        RectF rectF = this.f12912f;
        int i2 = this.l;
        canvas.drawRoundRect(rectF, i2, i2, this.f12911e);
    }

    public void setShadowColor(int i2) {
        this.k = SkinManager.getColor(i2);
        b();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
