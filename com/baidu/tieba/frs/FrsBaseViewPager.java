package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes22.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int iol;
    private boolean iom;
    private a ion;
    private boolean ioo;
    private boolean iop;
    private Activity mActivity;
    private float x;

    /* loaded from: classes22.dex */
    public interface a {
        void csl();

        boolean csm();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iol = 0;
        this.iop = true;
        this.mActivity = (Activity) context;
        this.iol = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.iol);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.pY(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.ion != null) {
                    this.ion.csl();
                }
                if (this.x >= getMeasuredWidth() - this.iol && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.iom = true;
                    this.iop = true;
                    break;
                } else {
                    this.iop = false;
                    break;
                }
                break;
            case 1:
                this.iop = true;
                break;
            case 2:
                if (this.iop) {
                    boolean csm = this.ion != null ? this.ion.csm() : true;
                    if (this.iom && csm) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.iop = csm;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ioo || this.iom) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.iom) {
                    this.iom = false;
                }
                if (this.ioo) {
                    this.ioo = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.ioo = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.ion = aVar;
    }
}
