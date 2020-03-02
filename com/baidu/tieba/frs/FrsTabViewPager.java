package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float grY;
    private float grZ;
    private float gsa;
    private float gsb;
    private boolean gsc;
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
                this.grY = motionEvent.getRawX();
                this.grZ = motionEvent.getRawY();
                ly(true);
                if (bFG()) {
                    this.gsc = false;
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
                this.gsa = this.x - this.grY;
                this.gsb = this.y - this.grZ;
                if (this.gsa < 0.0f && Math.abs(this.gsa) > Math.abs(this.gsb) && bFG()) {
                    requestParentInterceptTouchEvent(false);
                    if (this.gsc) {
                        return false;
                    }
                    lz(true);
                    this.gsc = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ly(boolean z) {
        a aVar = new a();
        aVar.lA(bFG());
        aVar.lB(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void bFF() {
        ly(false);
    }

    public void lz(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean bFG() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes9.dex */
    public static class a {
        private boolean gsd;
        private boolean gse;

        public boolean bFH() {
            return this.gsd;
        }

        public void lA(boolean z) {
            this.gsd = z;
        }

        public boolean bFI() {
            return this.gse;
        }

        public void lB(boolean z) {
            this.gse = z;
        }
    }
}
