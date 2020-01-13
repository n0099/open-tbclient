package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes7.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float gpV;
    private float gpW;
    private float gpX;
    private float gpY;
    private boolean gpZ;
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
                this.gpV = motionEvent.getRawX();
                this.gpW = motionEvent.getRawY();
                lv(true);
                if (bEb()) {
                    this.gpZ = false;
                    break;
                }
                break;
            case 1:
                lv(false);
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
                lv(false);
                break;
            case 2:
                this.gpX = this.x - this.gpV;
                this.gpY = this.y - this.gpW;
                if (this.gpX < 0.0f && Math.abs(this.gpX) > Math.abs(this.gpY) && bEb()) {
                    requestParentInterceptTouchEvent(false);
                    if (this.gpZ) {
                        return false;
                    }
                    lw(true);
                    this.gpZ = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lv(boolean z) {
        a aVar = new a();
        aVar.lx(bEb());
        aVar.ly(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void bEa() {
        lv(false);
    }

    public void lw(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean bEb() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes7.dex */
    public static class a {
        private boolean gqa;
        private boolean gqb;

        public boolean bEc() {
            return this.gqa;
        }

        public void lx(boolean z) {
            this.gqa = z;
        }

        public boolean bEd() {
            return this.gqb;
        }

        public void ly(boolean z) {
            this.gqb = z;
        }
    }
}
