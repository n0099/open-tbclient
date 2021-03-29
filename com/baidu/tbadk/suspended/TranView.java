package com.baidu.tbadk.suspended;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes3.dex */
public class TranView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Scroller f14015e;

    /* renamed from: f  reason: collision with root package name */
    public a f14016f;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public TranView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.f14015e;
        if (scroller == null) {
            return;
        }
        if (scroller.computeScrollOffset()) {
            int currY = this.f14015e.getCurrY();
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = currY;
                setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        a aVar = this.f14016f;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(0);
    }

    public void setScrollCallBack(a aVar) {
        this.f14016f = aVar;
    }

    public TranView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TranView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
