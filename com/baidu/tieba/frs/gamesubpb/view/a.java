package com.baidu.tieba.frs.gamesubpb.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes3.dex */
public class a extends View {
    private InterfaceC0158a dQh;
    private Scroller mScroller;

    /* renamed from: com.baidu.tieba.frs.gamesubpb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0158a {
        void ayn();
    }

    public void setScrollCallBack(InterfaceC0158a interfaceC0158a) {
        this.dQh = interfaceC0158a;
    }

    public a(Context context) {
        super(context);
    }

    public void ayr() {
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
            } else if (this.dQh != null) {
                this.dQh.ayn();
            }
        }
    }
}
