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
                oE(true);
                break;
            case 1:
                oE(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                oE(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oE(boolean z) {
        a aVar = new a();
        aVar.oF(crl());
        aVar.oG(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void crk() {
        oE(false);
    }

    private boolean crl() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes21.dex */
    public static class a {
        private boolean ieE;
        private boolean ieF;

        public boolean crm() {
            return this.ieE;
        }

        public void oF(boolean z) {
            this.ieE = z;
        }

        public boolean crn() {
            return this.ieF;
        }

        public void oG(boolean z) {
            this.ieF = z;
        }
    }
}
