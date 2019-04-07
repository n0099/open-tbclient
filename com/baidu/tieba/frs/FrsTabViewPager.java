package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float fcu;
    private float fcv;
    private float fcw;
    private float fcx;
    private boolean fcy;
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
                this.fcu = motionEvent.getRawX();
                this.fcv = motionEvent.getRawY();
                jn(true);
                if (bek()) {
                    this.fcy = false;
                    break;
                }
                break;
            case 1:
                jn(false);
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
                jn(false);
                break;
            case 2:
                this.fcw = this.x - this.fcu;
                this.fcx = this.y - this.fcv;
                if (this.fcw < 0.0f && Math.abs(this.fcw) > Math.abs(this.fcx) && bek()) {
                    dW(false);
                    if (this.fcy) {
                        return false;
                    }
                    jo(true);
                    this.fcy = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jn(boolean z) {
        a aVar = new a();
        aVar.jp(bek());
        aVar.jq(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void bej() {
        jn(false);
    }

    public void jo(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean bek() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes4.dex */
    public static class a {
        private boolean fcA;
        private boolean fcz;

        public boolean bel() {
            return this.fcz;
        }

        public void jp(boolean z) {
            this.fcz = z;
        }

        public boolean bem() {
            return this.fcA;
        }

        public void jq(boolean z) {
            this.fcA = z;
        }
    }
}
