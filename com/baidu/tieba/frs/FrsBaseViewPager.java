package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private boolean hmA;
    private boolean hmB;
    private int hmx;
    private boolean hmy;
    private a hmz;
    private Activity mActivity;
    private float x;

    /* loaded from: classes9.dex */
    public interface a {
        boolean bUA();

        void bUz();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hmx = 0;
        this.hmB = true;
        this.mActivity = (Activity) context;
        this.hmx = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.hmx);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.mq(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.hmz != null) {
                    this.hmz.bUz();
                }
                if (this.x >= getMeasuredWidth() - this.hmx && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.hmy = true;
                    this.hmB = true;
                    break;
                } else {
                    this.hmB = false;
                    break;
                }
                break;
            case 1:
                this.hmB = true;
                break;
            case 2:
                if (this.hmB) {
                    boolean bUA = this.hmz != null ? this.hmz.bUA() : true;
                    if (this.hmy && bUA) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.hmB = bUA;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hmA || this.hmy) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.hmy) {
                    this.hmy = false;
                }
                if (this.hmA) {
                    this.hmA = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.hmA = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.hmz = aVar;
    }
}
