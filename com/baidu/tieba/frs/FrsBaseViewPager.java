package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int gnQ;
    private boolean gnR;
    private a gnS;
    private boolean gnT;
    private boolean gnU;
    private Activity mActivity;
    private float x;

    /* loaded from: classes9.dex */
    public interface a {
        void bDy();

        boolean bDz();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnQ = 16;
        this.gnU = true;
        this.mActivity = (Activity) context;
        this.gnQ = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.gnQ);
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
                if (this.gnS != null) {
                    this.gnS.bDy();
                }
                if (this.x >= getMeasuredWidth() - this.gnQ && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.gnR = true;
                    this.gnU = true;
                    break;
                } else {
                    this.gnU = false;
                    break;
                }
                break;
            case 1:
                this.gnU = true;
                break;
            case 2:
                if (this.gnU) {
                    boolean bDz = this.gnS != null ? this.gnS.bDz() : true;
                    if (this.gnR && bDz) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.gnU = bDz;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gnT || this.gnR) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.gnR) {
                    this.gnR = false;
                }
                if (this.gnT) {
                    this.gnT = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.gnT = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.gnS = aVar;
    }
}
