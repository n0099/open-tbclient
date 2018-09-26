package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes2.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float dvG;
    private float dvH;
    private float dvI;
    private float dvJ;
    private boolean dvK;
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
                this.dvG = motionEvent.getRawX();
                this.dvH = motionEvent.getRawY();
                gg(true);
                if (axR()) {
                    this.dvK = false;
                    break;
                }
                break;
            case 1:
                gg(false);
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
                gg(false);
                break;
            case 2:
                this.dvI = this.x - this.dvG;
                this.dvJ = this.y - this.dvH;
                if (this.dvI < 0.0f && Math.abs(this.dvI) > Math.abs(this.dvJ) && axR()) {
                    bk(false);
                    if (this.dvK) {
                        return false;
                    }
                    gh(true);
                    this.dvK = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void gg(boolean z) {
        a aVar = new a();
        aVar.gi(axR());
        aVar.gj(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921361, aVar));
    }

    public void axQ() {
        gg(false);
    }

    public void gh(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Boolean.valueOf(z)));
    }

    private boolean axR() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private boolean dvL;
        private boolean dvM;

        public boolean axS() {
            return this.dvL;
        }

        public void gi(boolean z) {
            this.dvL = z;
        }

        public boolean axT() {
            return this.dvM;
        }

        public void gj(boolean z) {
            this.dvM = z;
        }
    }
}
