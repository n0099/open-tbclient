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
                mH(true);
                break;
            case 1:
                mH(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                mH(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void mH(boolean z) {
        a aVar = new a();
        aVar.mI(bQr());
        aVar.mJ(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void bQq() {
        mH(false);
    }

    private boolean bQr() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes9.dex */
    public static class a {
        private boolean hcm;
        private boolean hcn;

        public boolean bQs() {
            return this.hcm;
        }

        public void mI(boolean z) {
            this.hcm = z;
        }

        public boolean bQt() {
            return this.hcn;
        }

        public void mJ(boolean z) {
            this.hcn = z;
        }
    }
}
