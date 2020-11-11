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
                pK(true);
                break;
            case 1:
                pK(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                pK(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void pK(boolean z) {
        a aVar = new a();
        aVar.pL(cAr());
        aVar.pM(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void cAq() {
        pK(false);
    }

    private boolean cAr() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes22.dex */
    public static class a {
        private boolean iLU;
        private boolean iLV;

        public boolean cAs() {
            return this.iLU;
        }

        public void pL(boolean z) {
            this.iLU = z;
        }

        public boolean cAt() {
            return this.iLV;
        }

        public void pM(boolean z) {
            this.iLV = z;
        }
    }
}
