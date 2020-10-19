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
                pj(true);
                break;
            case 1:
                pj(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                pj(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void pj(boolean z) {
        a aVar = new a();
        aVar.pk(cuJ());
        aVar.pl(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void cuI() {
        pj(false);
    }

    private boolean cuJ() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes22.dex */
    public static class a {
        private boolean itB;
        private boolean itC;

        public boolean cuK() {
            return this.itB;
        }

        public void pk(boolean z) {
            this.itB = z;
        }

        public boolean cuL() {
            return this.itC;
        }

        public void pl(boolean z) {
            this.itC = z;
        }
    }
}
