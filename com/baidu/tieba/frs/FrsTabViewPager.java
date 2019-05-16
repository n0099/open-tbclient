package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float fsI;
    private float fsJ;
    private float fsK;
    private float fsL;
    private boolean fsM;
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
                this.fsI = motionEvent.getRawX();
                this.fsJ = motionEvent.getRawY();
                jX(true);
                if (blC()) {
                    this.fsM = false;
                    break;
                }
                break;
            case 1:
                jX(false);
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
                jX(false);
                break;
            case 2:
                this.fsK = this.x - this.fsI;
                this.fsL = this.y - this.fsJ;
                if (this.fsK < 0.0f && Math.abs(this.fsK) > Math.abs(this.fsL) && blC()) {
                    et(false);
                    if (this.fsM) {
                        return false;
                    }
                    jY(true);
                    this.fsM = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jX(boolean z) {
        a aVar = new a();
        aVar.jZ(blC());
        aVar.ka(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void blB() {
        jX(false);
    }

    public void jY(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean blC() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes4.dex */
    public static class a {
        private boolean fsN;
        private boolean fsO;

        public boolean blD() {
            return this.fsN;
        }

        public void jZ(boolean z) {
            this.fsN = z;
        }

        public boolean blE() {
            return this.fsO;
        }

        public void ka(boolean z) {
            this.fsO = z;
        }
    }
}
