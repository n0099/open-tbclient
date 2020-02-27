package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float grW;
    private float grX;
    private float grY;
    private float grZ;
    private boolean gsa;
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
                this.grW = motionEvent.getRawX();
                this.grX = motionEvent.getRawY();
                ly(true);
                if (bFE()) {
                    this.gsa = false;
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
                this.grY = this.x - this.grW;
                this.grZ = this.y - this.grX;
                if (this.grY < 0.0f && Math.abs(this.grY) > Math.abs(this.grZ) && bFE()) {
                    requestParentInterceptTouchEvent(false);
                    if (this.gsa) {
                        return false;
                    }
                    lz(true);
                    this.gsa = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ly(boolean z) {
        a aVar = new a();
        aVar.lA(bFE());
        aVar.lB(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void bFD() {
        ly(false);
    }

    public void lz(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean bFE() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes9.dex */
    public static class a {
        private boolean gsb;
        private boolean gsc;

        public boolean bFF() {
            return this.gsb;
        }

        public void lA(boolean z) {
            this.gsb = z;
        }

        public boolean bFG() {
            return this.gsc;
        }

        public void lB(boolean z) {
            this.gsc = z;
        }
    }
}
