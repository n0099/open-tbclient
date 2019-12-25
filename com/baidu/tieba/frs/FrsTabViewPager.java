package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes6.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float gmM;
    private float gmN;
    private float gmO;
    private float gmP;
    private boolean gmQ;
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
                this.gmM = motionEvent.getRawX();
                this.gmN = motionEvent.getRawY();
                lk(true);
                if (bCZ()) {
                    this.gmQ = false;
                    break;
                }
                break;
            case 1:
                lk(false);
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
                lk(false);
                break;
            case 2:
                this.gmO = this.x - this.gmM;
                this.gmP = this.y - this.gmN;
                if (this.gmO < 0.0f && Math.abs(this.gmO) > Math.abs(this.gmP) && bCZ()) {
                    requestParentInterceptTouchEvent(false);
                    if (this.gmQ) {
                        return false;
                    }
                    ll(true);
                    this.gmQ = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lk(boolean z) {
        a aVar = new a();
        aVar.lm(bCZ());
        aVar.ln(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void bCY() {
        lk(false);
    }

    public void ll(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean bCZ() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes6.dex */
    public static class a {
        private boolean gmR;
        private boolean gmS;

        public boolean bDa() {
            return this.gmR;
        }

        public void lm(boolean z) {
            this.gmR = z;
        }

        public boolean bDb() {
            return this.gmS;
        }

        public void ln(boolean z) {
            this.gmS = z;
        }
    }
}
