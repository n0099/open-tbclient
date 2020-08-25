package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes16.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int hSe;
    private boolean hSf;
    private a hSg;
    private boolean hSh;
    private boolean hSi;
    private Activity mActivity;
    private float x;

    /* loaded from: classes16.dex */
    public interface a {
        void clA();

        boolean clB();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSe = 0;
        this.hSi = true;
        this.mActivity = (Activity) context;
        this.hSe = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.hSe);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.pm(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.hSg != null) {
                    this.hSg.clA();
                }
                if (this.x >= getMeasuredWidth() - this.hSe && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.hSf = true;
                    this.hSi = true;
                    break;
                } else {
                    this.hSi = false;
                    break;
                }
                break;
            case 1:
                this.hSi = true;
                break;
            case 2:
                if (this.hSi) {
                    boolean clB = this.hSg != null ? this.hSg.clB() : true;
                    if (this.hSf && clB) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.hSi = clB;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hSh || this.hSf) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.hSf) {
                    this.hSf = false;
                }
                if (this.hSh) {
                    this.hSh = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.hSh = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.hSg = aVar;
    }
}
