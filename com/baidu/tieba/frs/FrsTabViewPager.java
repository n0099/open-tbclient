package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes6.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float dOT;
    private float dOU;
    private float dOV;
    private float dOW;
    private boolean dOX;
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
                this.dOT = motionEvent.getRawX();
                this.dOU = motionEvent.getRawY();
                gP(true);
                if (aDG()) {
                    this.dOX = false;
                    break;
                }
                break;
            case 1:
                gP(false);
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
                gP(false);
                break;
            case 2:
                this.dOV = this.x - this.dOT;
                this.dOW = this.y - this.dOU;
                if (this.dOV < 0.0f && Math.abs(this.dOV) > Math.abs(this.dOW) && aDG()) {
                    bN(false);
                    if (this.dOX) {
                        return false;
                    }
                    gQ(true);
                    this.dOX = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void gP(boolean z) {
        a aVar = new a();
        aVar.gR(aDG());
        aVar.gS(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void aDF() {
        gP(false);
    }

    public void gQ(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean aDG() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes6.dex */
    public static class a {
        private boolean dOY;
        private boolean dOZ;

        public boolean aDH() {
            return this.dOY;
        }

        public void gR(boolean z) {
            this.dOY = z;
        }

        public boolean aDI() {
            return this.dOZ;
        }

        public void gS(boolean z) {
            this.dOZ = z;
        }
    }
}
