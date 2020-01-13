package com.baidu.tieba.frs.gamesubpb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes7.dex */
public class BlankView extends View {
    private a gBE;
    private Scroller mScroller;

    /* loaded from: classes7.dex */
    public interface a {
        void bGA();
    }

    public void setScrollCallBack(a aVar) {
        this.gBE = aVar;
    }

    public BlankView(Context context) {
        super(context);
    }

    public BlankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BlankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void bGE() {
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
            } else if (this.gBE != null) {
                this.gBE.bGA();
            }
        }
    }
}
