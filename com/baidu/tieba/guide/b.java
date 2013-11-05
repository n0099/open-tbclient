package com.baidu.tieba.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends View {

    /* renamed from: a  reason: collision with root package name */
    private final List<f> f1314a;

    public b(Context context) {
        this(context, null, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1314a = new ArrayList(9);
    }

    public void a(int i, float f, int i2) {
        for (f fVar : this.f1314a) {
            fVar.a(i, f, i2);
        }
        invalidate();
    }

    public void a(f fVar) {
        this.f1314a.add(fVar);
        fVar.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public void a() {
        for (f fVar : this.f1314a) {
            fVar.c();
        }
        this.f1314a.clear();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (f fVar : this.f1314a) {
            if (fVar != null) {
                fVar.draw(canvas);
            }
        }
    }
}
