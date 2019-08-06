package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float fye;
    private float fyf;
    private float fyg;
    private float fyh;
    private boolean fyi;
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
                this.fye = motionEvent.getRawX();
                this.fyf = motionEvent.getRawY();
                kh(true);
                if (bnQ()) {
                    this.fyi = false;
                    break;
                }
                break;
            case 1:
                kh(false);
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
                kh(false);
                break;
            case 2:
                this.fyg = this.x - this.fye;
                this.fyh = this.y - this.fyf;
                if (this.fyg < 0.0f && Math.abs(this.fyg) > Math.abs(this.fyh) && bnQ()) {
                    ex(false);
                    if (this.fyi) {
                        return false;
                    }
                    ki(true);
                    this.fyi = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kh(boolean z) {
        a aVar = new a();
        aVar.kj(bnQ());
        aVar.kk(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void bnP() {
        kh(false);
    }

    public void ki(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean bnQ() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes4.dex */
    public static class a {
        private boolean fyj;
        private boolean fyk;

        public boolean bnR() {
            return this.fyj;
        }

        public void kj(boolean z) {
            this.fyj = z;
        }

        public boolean bnS() {
            return this.fyk;
        }

        public void kk(boolean z) {
            this.fyk = z;
        }
    }
}
