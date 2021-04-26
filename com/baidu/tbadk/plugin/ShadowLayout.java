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
    public Paint f13667e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f13668f;

    /* renamed from: g  reason: collision with root package name */
    public int f13669g;

    /* renamed from: h  reason: collision with root package name */
    public int f13670h;

    /* renamed from: i  reason: collision with root package name */
    public int f13671i;
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
        this.f13669g = dimensionPixelSize;
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.l = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.f13670h = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.f13671i = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.j = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.k = SkinManager.getColor(R.color.plugin_button_shadow_blue);
        Paint paint = new Paint();
        this.f13667e = paint;
        paint.setColor(0);
        this.f13667e.setShadowLayer(this.f13670h, this.f13671i, this.j, this.k);
        this.f13668f = new RectF();
    }

    public final void b() {
        this.f13667e.setShadowLayer(this.f13670h, this.f13671i, this.j, this.k);
        postInvalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f13668f.left = getPaddingLeft();
        this.f13668f.right = getWidth() - getPaddingRight();
        this.f13668f.bottom = getHeight() - getPaddingBottom();
        this.f13668f.top = getPaddingTop();
        RectF rectF = this.f13668f;
        int i2 = this.l;
        canvas.drawRoundRect(rectF, i2, i2, this.f13667e);
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
