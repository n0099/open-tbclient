package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int hyZ;
    private boolean hza;
    private a hzb;
    private boolean hzc;
    private boolean hzd;
    private Activity mActivity;
    private float x;

    /* loaded from: classes9.dex */
    public interface a {
        void bXH();

        boolean bXI();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hyZ = 0;
        this.hzd = true;
        this.mActivity = (Activity) context;
        this.hyZ = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.hyZ);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.mM(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.hzb != null) {
                    this.hzb.bXH();
                }
                if (this.x >= getMeasuredWidth() - this.hyZ && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.hza = true;
                    this.hzd = true;
                    break;
                } else {
                    this.hzd = false;
                    break;
                }
                break;
            case 1:
                this.hzd = true;
                break;
            case 2:
                if (this.hzd) {
                    boolean bXI = this.hzb != null ? this.hzb.bXI() : true;
                    if (this.hza && bXI) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.hzd = bXI;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hzc || this.hza) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.hza) {
                    this.hza = false;
                }
                if (this.hzc) {
                    this.hzc = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.hzc = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.hzb = aVar;
    }
}
