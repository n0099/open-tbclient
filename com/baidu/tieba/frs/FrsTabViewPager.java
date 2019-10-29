package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsTabViewPager extends BdBaseViewPager {
    private float fzg;
    private float fzh;
    private float fzi;
    private float fzj;
    private boolean fzk;
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
                this.fzg = motionEvent.getRawX();
                this.fzh = motionEvent.getRawY();
                jY(true);
                if (blF()) {
                    this.fzk = false;
                    break;
                }
                break;
            case 1:
                jY(false);
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
                jY(false);
                break;
            case 2:
                this.fzi = this.x - this.fzg;
                this.fzj = this.y - this.fzh;
                if (this.fzi < 0.0f && Math.abs(this.fzi) > Math.abs(this.fzj) && blF()) {
                    requestParentInterceptTouchEvent(false);
                    if (this.fzk) {
                        return false;
                    }
                    jZ(true);
                    this.fzk = true;
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jY(boolean z) {
        a aVar = new a();
        aVar.ka(blF());
        aVar.kb(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    public void blE() {
        jY(false);
    }

    public void jZ(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921370, Boolean.valueOf(z)));
    }

    private boolean blF() {
        return getCurrentItem() == getAdapter().getCount() + (-1);
    }

    /* loaded from: classes4.dex */
    public static class a {
        private boolean fzl;
        private boolean fzm;

        public boolean blG() {
            return this.fzl;
        }

        public void ka(boolean z) {
            this.fzl = z;
        }

        public boolean blH() {
            return this.fzm;
        }

        public void kb(boolean z) {
            this.fzm = z;
        }
    }
}
