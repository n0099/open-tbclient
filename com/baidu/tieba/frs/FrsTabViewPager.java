package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes2.dex */
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
                qO(true);
                break;
            case 1:
                qO(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                qO(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void qO(boolean z) {
        a aVar = new a();
        aVar.qP(cEI());
        aVar.qQ(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void cEH() {
        qO(false);
    }

    private boolean cEI() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean jla;
        private boolean jlb;

        public boolean cEJ() {
            return this.jla;
        }

        public void qP(boolean z) {
            this.jla = z;
        }

        public boolean cEK() {
            return this.jlb;
        }

        public void qQ(boolean z) {
            this.jlb = z;
        }
    }
}
