package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes22.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    public FrsTabViewPager(Context context) {
        this(context, null);
    }

    public FrsTabViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                qk(true);
                break;
            case 1:
                qk(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                qk(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void qk(boolean z) {
        a aVar = new a();
        aVar.ql(cEk());
        aVar.qm(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void cEj() {
        qk(false);
    }

    private boolean cEk() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes22.dex */
    public static class a {
        private boolean iXy;
        private boolean iXz;

        public boolean cEl() {
            return this.iXy;
        }

        public void ql(boolean z) {
            this.iXy = z;
        }

        public boolean cEm() {
            return this.iXz;
        }

        public void qm(boolean z) {
            this.iXz = z;
        }
    }
}
