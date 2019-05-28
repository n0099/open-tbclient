package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float fsJ;
    private float fsK;
    private float fsL;
    private float fsM;
    private boolean fsN;
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
                this.fsJ = motionEvent.getRawX();
                this.fsK = motionEvent.getRawY();
                jX(true);
                if (blF()) {
                    this.fsN = false;
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
                this.fsL = this.x - this.fsJ;
                this.fsM = this.y - this.fsK;
                if (this.fsL < 0.0f && Math.abs(this.fsL) > Math.abs(this.fsM) && blF()) {
                    et(false);
                    if (this.fsN) {
                        return false;
                    }
                    jY(true);
                    this.fsN = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jX(boolean z) {
        a aVar = new a();
        aVar.jZ(blF());
        aVar.ka(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void blE() {
        jX(false);
    }

    public void jY(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean blF() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes4.dex */
    public static class a {
        private boolean fsO;
        private boolean fsP;

        public boolean blG() {
            return this.fsO;
        }

        public void jZ(boolean z) {
            this.fsO = z;
        }

        public boolean blH() {
            return this.fsP;
        }

        public void ka(boolean z) {
            this.fsP = z;
        }
    }
}
