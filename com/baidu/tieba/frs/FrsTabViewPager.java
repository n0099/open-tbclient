package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes16.dex */
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
                ow(true);
                break;
            case 1:
                ow(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                ow(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ow(boolean z) {
        a aVar = new a();
        aVar.ox(cnX());
        aVar.oy(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void cnW() {
        ow(false);
    }

    private boolean cnX() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes16.dex */
    public static class a {
        private boolean hXu;
        private boolean hXv;

        public boolean cnY() {
            return this.hXu;
        }

        public void ox(boolean z) {
            this.hXu = z;
        }

        public boolean cnZ() {
            return this.hXv;
        }

        public void oy(boolean z) {
            this.hXv = z;
        }
    }
}
