package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes22.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int iAH;
    private boolean iAI;
    private a iAJ;
    private boolean iAK;
    private boolean iAL;
    private Activity mActivity;
    private float x;

    /* loaded from: classes22.dex */
    public interface a {
        void cvs();

        boolean cvt();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iAH = 0;
        this.iAL = true;
        this.mActivity = (Activity) context;
        this.iAH = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.iAH);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.qj(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.iAJ != null) {
                    this.iAJ.cvs();
                }
                if (this.x >= getMeasuredWidth() - this.iAH && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.iAI = true;
                    this.iAL = true;
                    break;
                } else {
                    this.iAL = false;
                    break;
                }
                break;
            case 1:
                this.iAL = true;
                break;
            case 2:
                if (this.iAL) {
                    boolean cvt = this.iAJ != null ? this.iAJ.cvt() : true;
                    if (this.iAI && cvt) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.iAL = cvt;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.iAK || this.iAI) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.iAI) {
                    this.iAI = false;
                }
                if (this.iAK) {
                    this.iAK = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.iAK = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.iAJ = aVar;
    }
}
