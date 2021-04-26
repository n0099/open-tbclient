package com.baidu.tieba.faceshop.packagedetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes4.dex */
public class PackageDetailListView extends BdListView {
    public a K;
    public boolean L;

    /* loaded from: classes4.dex */
    public interface a {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public PackageDetailListView(Context context) {
        super(context);
        this.L = false;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.L) {
            a aVar = this.K;
            if (aVar != null) {
                aVar.onInterceptTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
        a aVar2 = this.K;
        if (aVar2 == null || !aVar2.onInterceptTouchEvent(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public void setDisableListViewTouchIntercept(boolean z) {
        this.L = z;
    }

    public void setTouchEventInterceptHandler(a aVar) {
        this.K = aVar;
    }

    public PackageDetailListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = false;
    }

    public PackageDetailListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.L = false;
    }
}
