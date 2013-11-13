package com.baidu.tieba.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class a extends View {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.guide.a.a f1373a;
    private int b;
    private int c;

    public a(Context context) {
        this(context, null, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = UtilHelper.a(context, 300.0f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c = getMeasuredWidth() >> 1;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || this.f1373a == null) {
            this.f1373a = new com.baidu.tieba.guide.a.a(getContext(), this.c, this.b);
            this.f1373a.setBounds(0, 0, getMeasuredWidth() * 3, getMeasuredHeight() + (this.b * 2));
        }
    }

    public void a(int i, float f, int i2) {
        this.f1373a.a(i, f, i2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f1373a.draw(canvas);
    }

    public void a() {
        if (this.f1373a != null) {
            this.f1373a.c();
        }
    }
}
