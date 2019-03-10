package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float fcI;
    private float fcJ;
    private float fcK;
    private float fcL;
    private boolean fcM;
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
                this.fcI = motionEvent.getRawX();
                this.fcJ = motionEvent.getRawY();
                jn(true);
                if (ben()) {
                    this.fcM = false;
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
                this.fcK = this.x - this.fcI;
                this.fcL = this.y - this.fcJ;
                if (this.fcK < 0.0f && Math.abs(this.fcK) > Math.abs(this.fcL) && ben()) {
                    dW(false);
                    if (this.fcM) {
                        return false;
                    }
                    jo(true);
                    this.fcM = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jn(boolean z) {
        a aVar = new a();
        aVar.jp(ben());
        aVar.jq(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void bem() {
        jn(false);
    }

    public void jo(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean ben() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes4.dex */
    public static class a {
        private boolean fcN;
        private boolean fcO;

        public boolean beo() {
            return this.fcN;
        }

        public void jp(boolean z) {
            this.fcN = z;
        }

        public boolean bep() {
            return this.fcO;
        }

        public void jq(boolean z) {
            this.fcO = z;
        }
    }
}
