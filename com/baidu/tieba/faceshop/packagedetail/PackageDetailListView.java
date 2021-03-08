package com.baidu.tieba.faceshop.packagedetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes8.dex */
public class PackageDetailListView extends BdListView {
    private a jcw;
    private boolean jcx;

    /* loaded from: classes8.dex */
    public interface a {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public PackageDetailListView(Context context) {
        super(context);
        this.jcx = false;
    }

    public PackageDetailListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jcx = false;
    }

    public PackageDetailListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jcx = false;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.jcx) {
            if (this.jcw != null) {
                this.jcw.onInterceptTouchEvent(motionEvent);
            }
            return false;
        } else if (this.jcw == null || !this.jcw.onInterceptTouchEvent(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        } else {
            return true;
        }
    }

    public void setTouchEventInterceptHandler(a aVar) {
        this.jcw = aVar;
    }

    public void setDisableListViewTouchIntercept(boolean z) {
        this.jcx = z;
    }
}
