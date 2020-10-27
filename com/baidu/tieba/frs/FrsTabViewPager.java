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
                pB(true);
                break;
            case 1:
                pB(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                pB(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void pB(boolean z) {
        a aVar = new a();
        aVar.pC(cxQ());
        aVar.pD(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void cxP() {
        pB(false);
    }

    private boolean cxQ() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes22.dex */
    public static class a {
        private boolean iFX;
        private boolean iFY;

        public boolean cxR() {
            return this.iFX;
        }

        public void pC(boolean z) {
            this.iFX = z;
        }

        public boolean cxS() {
            return this.iFY;
        }

        public void pD(boolean z) {
            this.iFY = z;
        }
    }
}
