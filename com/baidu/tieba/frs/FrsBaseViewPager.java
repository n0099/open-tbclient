package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int gnD;
    private boolean gnE;
    private a gnF;
    private boolean gnG;
    private boolean gnH;
    private Activity mActivity;
    private float x;

    /* loaded from: classes9.dex */
    public interface a {
        void bDx();

        boolean bDy();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnD = 16;
        this.gnH = true;
        this.mActivity = (Activity) context;
        this.gnD = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.gnD);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.lz(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gnF != null) {
                    this.gnF.bDx();
                }
                if (this.x >= getMeasuredWidth() - this.gnD && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.gnE = true;
                    this.gnH = true;
                    break;
                } else {
                    this.gnH = false;
                    break;
                }
                break;
            case 1:
                this.gnH = true;
                break;
            case 2:
                if (this.gnH) {
                    boolean bDy = this.gnF != null ? this.gnF.bDy() : true;
                    if (this.gnE && bDy) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.gnH = bDy;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gnG || this.gnE) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.gnE) {
                    this.gnE = false;
                }
                if (this.gnG) {
                    this.gnG = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.gnG = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.gnF = aVar;
    }
}
