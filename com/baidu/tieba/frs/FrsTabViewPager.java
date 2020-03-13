package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float gsl;
    private float gsm;
    private float gsn;
    private float gso;
    private boolean gsp;
    private float x;
    private float y;

    public FrsTabViewPager(Context context) {
        this(context, null);
    }

    public FrsTabViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        this.y = motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 0:
                this.gsl = motionEvent.getRawX();
                this.gsm = motionEvent.getRawY();
                ly(true);
                if (bFH()) {
                    this.gsp = false;
                    break;
                }
                break;
            case 1:
                ly(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        this.y = motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 1:
                ly(false);
                break;
            case 2:
                this.gsn = this.x - this.gsl;
                this.gso = this.y - this.gsm;
                if (this.gsn < 0.0f && Math.abs(this.gsn) > Math.abs(this.gso) && bFH()) {
                    requestParentInterceptTouchEvent(false);
                    if (this.gsp) {
                        return false;
                    }
                    lz(true);
                    this.gsp = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ly(boolean z) {
        a aVar = new a();
        aVar.lA(bFH());
        aVar.lB(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void bFG() {
        ly(false);
    }

    public void lz(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean bFH() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes9.dex */
    public static class a {
        private boolean gsq;
        private boolean gsr;

        public boolean bFI() {
            return this.gsq;
        }

        public void lA(boolean z) {
            this.gsq = z;
        }

        public boolean bFJ() {
            return this.gsr;
        }

        public void lB(boolean z) {
            this.gsr = z;
        }
    }
}
