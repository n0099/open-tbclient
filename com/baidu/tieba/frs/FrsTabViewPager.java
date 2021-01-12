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
                qE(true);
                break;
            case 1:
                qE(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                qE(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void qE(boolean z) {
        a aVar = new a();
        aVar.qF(cDp());
        aVar.qG(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void cDo() {
        qE(false);
    }

    private boolean cDp() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean jff;
        private boolean jfg;

        public boolean cDq() {
            return this.jff;
        }

        public void qF(boolean z) {
            this.jff = z;
        }

        public boolean cDr() {
            return this.jfg;
        }

        public void qG(boolean z) {
            this.jfg = z;
        }
    }
}
