package com.baidu.tieba.frs.gamesubpb.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes3.dex */
public class a extends View {
    private InterfaceC0157a dQo;
    private Scroller mScroller;

    /* renamed from: com.baidu.tieba.frs.gamesubpb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0157a {
        void aym();
    }

    public void setScrollCallBack(InterfaceC0157a interfaceC0157a) {
        this.dQo = interfaceC0157a;
    }

    public a(Context context) {
        super(context);
    }

    public void ayq() {
        if (this.mScroller == null) {
            this.mScroller = new Scroller(getContext());
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            this.mScroller.startScroll(0, layoutParams.height, 0, 0 - layoutParams.height);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller != null) {
            if (this.mScroller.computeScrollOffset()) {
                int currY = this.mScroller.getCurrY();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = currY;
                    setLayoutParams(layoutParams);
                }
            } else if (this.dQo != null) {
                this.dQo.aym();
            }
        }
    }
}
