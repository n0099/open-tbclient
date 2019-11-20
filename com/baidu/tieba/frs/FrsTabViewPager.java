package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float fyp;
    private float fyq;
    private float fyr;
    private float fys;
    private boolean fyt;
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
                this.fyp = motionEvent.getRawX();
                this.fyq = motionEvent.getRawY();
                jY(true);
                if (blD()) {
                    this.fyt = false;
                    break;
                }
                break;
            case 1:
                jY(false);
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
                jY(false);
                break;
            case 2:
                this.fyr = this.x - this.fyp;
                this.fys = this.y - this.fyq;
                if (this.fyr < 0.0f && Math.abs(this.fyr) > Math.abs(this.fys) && blD()) {
                    requestParentInterceptTouchEvent(false);
                    if (this.fyt) {
                        return false;
                    }
                    jZ(true);
                    this.fyt = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jY(boolean z) {
        a aVar = new a();
        aVar.ka(blD());
        aVar.kb(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void blC() {
        jY(false);
    }

    public void jZ(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean blD() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes4.dex */
    public static class a {
        private boolean fyu;
        private boolean fyv;

        public boolean blE() {
            return this.fyu;
        }

        public void ka(boolean z) {
            this.fyu = z;
        }

        public boolean blF() {
            return this.fyv;
        }

        public void kb(boolean z) {
            this.fyv = z;
        }
    }
}
