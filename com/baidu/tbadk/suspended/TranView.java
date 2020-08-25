package com.baidu.tbadk.suspended;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes2.dex */
public class TranView extends View {
    private a eUk;
    private Scroller mScroller;

    /* loaded from: classes2.dex */
    public interface a {
        void buR();
    }

    public void setScrollCallBack(a aVar) {
        this.eUk = aVar;
    }

    public TranView(Context context) {
        super(context);
    }

    public TranView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TranView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(0);
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
            } else if (this.eUk != null) {
                this.eUk.buR();
            }
        }
    }
}
