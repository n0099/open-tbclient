package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes22.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int iGE;
    private boolean iGF;
    private a iGG;
    private boolean iGH;
    private boolean iGI;
    private Activity mActivity;
    private float x;

    /* loaded from: classes22.dex */
    public interface a {
        void cxT();

        boolean cxU();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iGE = 0;
        this.iGI = true;
        this.mActivity = (Activity) context;
        this.iGE = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.iGE);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.qt(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.iGG != null) {
                    this.iGG.cxT();
                }
                if (this.x >= getMeasuredWidth() - this.iGE && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.iGF = true;
                    this.iGI = true;
                    break;
                } else {
                    this.iGI = false;
                    break;
                }
                break;
            case 1:
                this.iGI = true;
                break;
            case 2:
                if (this.iGI) {
                    boolean cxU = this.iGG != null ? this.iGG.cxU() : true;
                    if (this.iGF && cxU) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.iGI = cxU;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.iGH || this.iGF) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.iGF) {
                    this.iGF = false;
                }
                if (this.iGH) {
                    this.iGH = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.iGH = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.iGG = aVar;
    }
}
