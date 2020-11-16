package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes21.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int iHs;
    private boolean iHt;
    private a iHu;
    private boolean iHv;
    private boolean iHw;
    private Activity mActivity;
    private float x;

    /* loaded from: classes21.dex */
    public interface a {
        void cxw();

        boolean cxx();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iHs = 0;
        this.iHw = true;
        this.mActivity = (Activity) context;
        this.iHs = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.iHs);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.qR(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.iHu != null) {
                    this.iHu.cxw();
                }
                if (this.x >= getMeasuredWidth() - this.iHs && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.iHt = true;
                    this.iHw = true;
                    break;
                } else {
                    this.iHw = false;
                    break;
                }
                break;
            case 1:
                this.iHw = true;
                break;
            case 2:
                if (this.iHw) {
                    boolean cxx = this.iHu != null ? this.iHu.cxx() : true;
                    if (this.iHt && cxx) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.iHw = cxx;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.iHv || this.iHt) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.iHt) {
                    this.iHt = false;
                }
                if (this.iHv) {
                    this.iHv = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.iHv = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.iHu = aVar;
    }
}
