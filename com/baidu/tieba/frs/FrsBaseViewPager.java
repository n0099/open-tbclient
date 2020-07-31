package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes16.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int hEO;
    private boolean hEP;
    private a hEQ;
    private boolean hER;
    private boolean hES;
    private Activity mActivity;
    private float x;

    /* loaded from: classes16.dex */
    public interface a {
        void cbe();

        boolean cbf();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hEO = 0;
        this.hES = true;
        this.mActivity = (Activity) context;
        this.hEO = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.hEO);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.ne(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.hEQ != null) {
                    this.hEQ.cbe();
                }
                if (this.x >= getMeasuredWidth() - this.hEO && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.hEP = true;
                    this.hES = true;
                    break;
                } else {
                    this.hES = false;
                    break;
                }
                break;
            case 1:
                this.hES = true;
                break;
            case 2:
                if (this.hES) {
                    boolean cbf = this.hEQ != null ? this.hEQ.cbf() : true;
                    if (this.hEP && cbf) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.hES = cbf;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hER || this.hEP) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.hEP) {
                    this.hEP = false;
                }
                if (this.hER) {
                    this.hER = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.hER = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.hEQ = aVar;
    }
}
