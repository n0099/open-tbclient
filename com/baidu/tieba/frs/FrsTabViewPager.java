package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float fzR;
    private float fzS;
    private float fzT;
    private float fzU;
    private boolean fzV;
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
                this.fzR = motionEvent.getRawX();
                this.fzS = motionEvent.getRawY();
                kk(true);
                if (boB()) {
                    this.fzV = false;
                    break;
                }
                break;
            case 1:
                kk(false);
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
                kk(false);
                break;
            case 2:
                this.fzT = this.x - this.fzR;
                this.fzU = this.y - this.fzS;
                if (this.fzT < 0.0f && Math.abs(this.fzT) > Math.abs(this.fzU) && boB()) {
                    eA(false);
                    if (this.fzV) {
                        return false;
                    }
                    kl(true);
                    this.fzV = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kk(boolean z) {
        a aVar = new a();
        aVar.km(boB());
        aVar.kn(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void boA() {
        kk(false);
    }

    public void kl(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean boB() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes4.dex */
    public static class a {
        private boolean fzW;
        private boolean fzX;

        public boolean boC() {
            return this.fzW;
        }

        public void km(boolean z) {
            this.fzW = z;
        }

        public boolean boD() {
            return this.fzX;
        }

        public void kn(boolean z) {
            this.fzX = z;
        }
    }
}
