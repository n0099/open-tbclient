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
    private final List<e> f1179a;

    public b(Context context) {
        this(context, null, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1179a = new ArrayList(9);
    }

    public void a(int i, float f, int i2) {
        for (e eVar : this.f1179a) {
            eVar.a(i, f, i2);
        }
        invalidate();
    }

    public void a(e eVar) {
        this.f1179a.add(eVar);
        eVar.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public void a() {
        for (e eVar : this.f1179a) {
            eVar.c();
        }
        this.f1179a.clear();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (e eVar : this.f1179a) {
            if (eVar != null) {
                eVar.draw(canvas);
            }
        }
    }
}
