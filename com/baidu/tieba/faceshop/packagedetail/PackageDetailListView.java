package com.baidu.tieba.faceshop.packagedetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes9.dex */
public class PackageDetailListView extends BdListView {
    private boolean iZA;
    private a iZz;

    /* loaded from: classes9.dex */
    public interface a {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public PackageDetailListView(Context context) {
        super(context);
        this.iZA = false;
    }

    public PackageDetailListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iZA = false;
    }

    public PackageDetailListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iZA = false;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.iZA) {
            if (this.iZz != null) {
                this.iZz.onInterceptTouchEvent(motionEvent);
            }
            return false;
        } else if (this.iZz == null || !this.iZz.onInterceptTouchEvent(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        } else {
            return true;
        }
    }

    public void setTouchEventInterceptHandler(a aVar) {
        this.iZz = aVar;
    }

    public void setDisableListViewTouchIntercept(boolean z) {
        this.iZA = z;
    }
}
