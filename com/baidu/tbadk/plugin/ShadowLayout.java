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
    public Paint f13666e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f13667f;

    /* renamed from: g  reason: collision with root package name */
    public int f13668g;

    /* renamed from: h  reason: collision with root package name */
    public int f13669h;
    public int i;
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
        this.f13668g = dimensionPixelSize;
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.l = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.f13669h = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.i = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.j = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.k = SkinManager.getColor(R.color.plugin_button_shadow_blue);
        Paint paint = new Paint();
        this.f13666e = paint;
        paint.setColor(0);
        this.f13666e.setShadowLayer(this.f13669h, this.i, this.j, this.k);
        this.f13667f = new RectF();
    }

    public final void b() {
        this.f13666e.setShadowLayer(this.f13669h, this.i, this.j, this.k);
        postInvalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f13667f.left = getPaddingLeft();
        this.f13667f.right = getWidth() - getPaddingRight();
        this.f13667f.bottom = getHeight() - getPaddingBottom();
        this.f13667f.top = getPaddingTop();
        RectF rectF = this.f13667f;
        int i = this.l;
        canvas.drawRoundRect(rectF, i, i, this.f13666e);
    }

    public void setShadowColor(int i) {
        this.k = SkinManager.getColor(i);
        b();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
