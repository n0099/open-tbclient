package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes21.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int hZk;
    private boolean hZl;
    private a hZm;
    private boolean hZn;
    private boolean hZo;
    private Activity mActivity;
    private float x;

    /* loaded from: classes21.dex */
    public interface a {
        void coN();

        boolean coO();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hZk = 0;
        this.hZo = true;
        this.mActivity = (Activity) context;
        this.hZk = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.hZk);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.pA(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.hZm != null) {
                    this.hZm.coN();
                }
                if (this.x >= getMeasuredWidth() - this.hZk && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.hZl = true;
                    this.hZo = true;
                    break;
                } else {
                    this.hZo = false;
                    break;
                }
                break;
            case 1:
                this.hZo = true;
                break;
            case 2:
                if (this.hZo) {
                    boolean coO = this.hZm != null ? this.hZm.coO() : true;
                    if (this.hZl && coO) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.hZo = coO;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hZn || this.hZl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.hZl) {
                    this.hZl = false;
                }
                if (this.hZn) {
                    this.hZn = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.hZn = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.hZm = aVar;
    }
}
