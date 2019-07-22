package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float fxF;
    private float fxG;
    private float fxH;
    private float fxI;
    private boolean fxJ;
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
                this.fxF = motionEvent.getRawX();
                this.fxG = motionEvent.getRawY();
                kh(true);
                if (bnG()) {
                    this.fxJ = false;
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
                this.fxH = this.x - this.fxF;
                this.fxI = this.y - this.fxG;
                if (this.fxH < 0.0f && Math.abs(this.fxH) > Math.abs(this.fxI) && bnG()) {
                    ex(false);
                    if (this.fxJ) {
                        return false;
                    }
                    ki(true);
                    this.fxJ = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kh(boolean z) {
        a aVar = new a();
        aVar.kj(bnG());
        aVar.kk(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void bnF() {
        kh(false);
    }

    public void ki(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean bnG() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes4.dex */
    public static class a {
        private boolean fxK;
        private boolean fxL;

        public boolean bnH() {
            return this.fxK;
        }

        public void kj(boolean z) {
            this.fxK = z;
        }

        public boolean bnI() {
            return this.fxL;
        }

        public void kk(boolean z) {
            this.fxL = z;
        }
    }
}
