package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes21.dex */
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
                pN(true);
                break;
            case 1:
                pN(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                pN(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void pN(boolean z) {
        a aVar = new a();
        aVar.pO(czU());
        aVar.pP(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void czT() {
        pN(false);
    }

    private boolean czU() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes21.dex */
    public static class a {
        private boolean iMH;
        private boolean iMI;

        public boolean czV() {
            return this.iMH;
        }

        public void pO(boolean z) {
            this.iMH = z;
        }

        public boolean czW() {
            return this.iMI;
        }

        public void pP(boolean z) {
            this.iMI = z;
        }
    }
}
