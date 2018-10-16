package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes6.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float dDH;
    private float dDI;
    private float dDJ;
    private float dDK;
    private boolean dDL;
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
                this.dDH = motionEvent.getRawX();
                this.dDI = motionEvent.getRawY();
                gy(true);
                if (aBm()) {
                    this.dDL = false;
                    break;
                }
                break;
            case 1:
                gy(false);
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
                gy(false);
                break;
            case 2:
                this.dDJ = this.x - this.dDH;
                this.dDK = this.y - this.dDI;
                if (this.dDJ < 0.0f && Math.abs(this.dDJ) > Math.abs(this.dDK) && aBm()) {
                    bu(false);
                    if (this.dDL) {
                        return false;
                    }
                    gz(true);
                    this.dDL = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void gy(boolean z) {
        a aVar = new a();
        aVar.gA(aBm());
        aVar.gB(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void aBl() {
        gy(false);
    }

    public void gz(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean aBm() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes6.dex */
    public static class a {
        private boolean dDM;
        private boolean dDN;

        public boolean aBn() {
            return this.dDM;
        }

        public void gA(boolean z) {
            this.dDM = z;
        }

        public boolean aBo() {
            return this.dDN;
        }

        public void gB(boolean z) {
            this.dDN = z;
        }
    }
}
