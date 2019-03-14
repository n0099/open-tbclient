package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float fcH;
    private float fcI;
    private float fcJ;
    private float fcK;
    private boolean fcL;
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
                this.fcH = motionEvent.getRawX();
                this.fcI = motionEvent.getRawY();
                jn(true);
                if (bem()) {
                    this.fcL = false;
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
                this.fcJ = this.x - this.fcH;
                this.fcK = this.y - this.fcI;
                if (this.fcJ < 0.0f && Math.abs(this.fcJ) > Math.abs(this.fcK) && bem()) {
                    dW(false);
                    if (this.fcL) {
                        return false;
                    }
                    jo(true);
                    this.fcL = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jn(boolean z) {
        a aVar = new a();
        aVar.jp(bem());
        aVar.jq(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void bel() {
        jn(false);
    }

    public void jo(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean bem() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes4.dex */
    public static class a {
        private boolean fcM;
        private boolean fcN;

        public boolean ben() {
            return this.fcM;
        }

        public void jp(boolean z) {
            this.fcM = z;
        }

        public boolean beo() {
            return this.fcN;
        }

        public void jq(boolean z) {
            this.fcN = z;
        }
    }
}
