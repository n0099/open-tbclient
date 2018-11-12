package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes6.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float dEX;
    private float dEY;
    private float dEZ;
    private float dFa;
    private boolean dFb;
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
                this.dEX = motionEvent.getRawX();
                this.dEY = motionEvent.getRawY();
                gI(true);
                if (aAK()) {
                    this.dFb = false;
                    break;
                }
                break;
            case 1:
                gI(false);
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
                gI(false);
                break;
            case 2:
                this.dEZ = this.x - this.dEX;
                this.dFa = this.y - this.dEY;
                if (this.dEZ < 0.0f && Math.abs(this.dEZ) > Math.abs(this.dFa) && aAK()) {
                    bL(false);
                    if (this.dFb) {
                        return false;
                    }
                    gJ(true);
                    this.dFb = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void gI(boolean z) {
        a aVar = new a();
        aVar.gK(aAK());
        aVar.gL(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void aAJ() {
        gI(false);
    }

    public void gJ(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean aAK() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes6.dex */
    public static class a {
        private boolean dFc;
        private boolean dFd;

        public boolean aAL() {
            return this.dFc;
        }

        public void gK(boolean z) {
            this.dFc = z;
        }

        public boolean aAM() {
            return this.dFd;
        }

        public void gL(boolean z) {
            this.dFd = z;
        }
    }
}
