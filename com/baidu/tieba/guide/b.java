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
    private final List<g> f1381a;

    public b(Context context) {
        this(context, null, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1381a = new ArrayList(9);
    }

    public void a(int i, float f, int i2) {
        for (g gVar : this.f1381a) {
            gVar.a(i, f, i2);
        }
        invalidate();
    }

    public void a(g gVar) {
        this.f1381a.add(gVar);
        gVar.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public void a() {
        for (g gVar : this.f1381a) {
            gVar.c();
        }
        this.f1381a.clear();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (g gVar : this.f1381a) {
            if (gVar != null) {
                gVar.draw(canvas);
            }
        }
    }
}
