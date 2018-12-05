package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes6.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private boolean dLA;
    private float dLw;
    private float dLx;
    private float dLy;
    private float dLz;
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
                this.dLw = motionEvent.getRawX();
                this.dLx = motionEvent.getRawY();
                gJ(true);
                if (aCu()) {
                    this.dLA = false;
                    break;
                }
                break;
            case 1:
                gJ(false);
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
                gJ(false);
                break;
            case 2:
                this.dLy = this.x - this.dLw;
                this.dLz = this.y - this.dLx;
                if (this.dLy < 0.0f && Math.abs(this.dLy) > Math.abs(this.dLz) && aCu()) {
                    bM(false);
                    if (this.dLA) {
                        return false;
                    }
                    gK(true);
                    this.dLA = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void gJ(boolean z) {
        a aVar = new a();
        aVar.gL(aCu());
        aVar.gM(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void aCt() {
        gJ(false);
    }

    public void gK(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean aCu() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes6.dex */
    public static class a {
        private boolean dLB;
        private boolean dLC;

        public boolean aCv() {
            return this.dLB;
        }

        public void gL(boolean z) {
            this.dLB = z;
        }

        public boolean aCw() {
            return this.dLC;
        }

        public void gM(boolean z) {
            this.dLC = z;
        }
    }
}
