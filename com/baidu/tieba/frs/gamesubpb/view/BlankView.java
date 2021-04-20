package com.baidu.tieba.frs.gamesubpb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes4.dex */
public class BlankView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Scroller f16084e;

    /* renamed from: f  reason: collision with root package name */
    public a f16085f;

    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    public BlankView(Context context) {
        super(context);
    }

    public void a() {
        if (this.f16084e == null) {
            this.f16084e = new Scroller(getContext());
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            Scroller scroller = this.f16084e;
            int i = layoutParams.height;
            scroller.startScroll(0, i, 0, 0 - i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.f16084e;
        if (scroller == null) {
            return;
        }
        if (scroller.computeScrollOffset()) {
            int currY = this.f16084e.getCurrY();
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = currY;
                setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        a aVar = this.f16085f;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setScrollCallBack(a aVar) {
        this.f16085f = aVar;
    }

    public BlankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BlankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
