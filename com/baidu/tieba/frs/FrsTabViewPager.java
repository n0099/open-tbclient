package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes6.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float dOk;
    private float dOl;
    private float dOm;
    private float dOn;
    private boolean dOo;
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
                this.dOk = motionEvent.getRawX();
                this.dOl = motionEvent.getRawY();
                gM(true);
                if (aDj()) {
                    this.dOo = false;
                    break;
                }
                break;
            case 1:
                gM(false);
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
                gM(false);
                break;
            case 2:
                this.dOm = this.x - this.dOk;
                this.dOn = this.y - this.dOl;
                if (this.dOm < 0.0f && Math.abs(this.dOm) > Math.abs(this.dOn) && aDj()) {
                    bM(false);
                    if (this.dOo) {
                        return false;
                    }
                    gN(true);
                    this.dOo = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void gM(boolean z) {
        a aVar = new a();
        aVar.gO(aDj());
        aVar.gP(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void aDi() {
        gM(false);
    }

    public void gN(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean aDj() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes6.dex */
    public static class a {
        private boolean dOp;
        private boolean dOq;

        public boolean aDk() {
            return this.dOp;
        }

        public void gO(boolean z) {
            this.dOp = z;
        }

        public boolean aDl() {
            return this.dOq;
        }

        public void gP(boolean z) {
            this.dOq = z;
        }
    }
}
