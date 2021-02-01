package com.baidu.tieba.faceshop.packagedetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes9.dex */
public class PackageDetailListView extends BdListView {
    private boolean jaA;
    private a jaz;

    /* loaded from: classes9.dex */
    public interface a {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public PackageDetailListView(Context context) {
        super(context);
        this.jaA = false;
    }

    public PackageDetailListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jaA = false;
    }

    public PackageDetailListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jaA = false;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.jaA) {
            if (this.jaz != null) {
                this.jaz.onInterceptTouchEvent(motionEvent);
            }
            return false;
        } else if (this.jaz == null || !this.jaz.onInterceptTouchEvent(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        } else {
            return true;
        }
    }

    public void setTouchEventInterceptHandler(a aVar) {
        this.jaz = aVar;
    }

    public void setDisableListViewTouchIntercept(boolean z) {
        this.jaA = z;
    }
}
