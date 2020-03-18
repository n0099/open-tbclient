package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
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
                lE(true);
                break;
            case 1:
                lE(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                lE(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lE(boolean z) {
        a aVar = new a();
        aVar.lF(bFR());
        aVar.lG(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void bFQ() {
        lE(false);
    }

    private boolean bFR() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes9.dex */
    public static class a {
        private boolean gsV;
        private boolean gsW;

        public boolean bFS() {
            return this.gsV;
        }

        public void lF(boolean z) {
            this.gsV = z;
        }

        public boolean bFT() {
            return this.gsW;
        }

        public void lG(boolean z) {
            this.gsW = z;
        }
    }
}
