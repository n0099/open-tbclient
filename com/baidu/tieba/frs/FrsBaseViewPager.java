package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes16.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int hSk;
    private boolean hSl;
    private a hSm;
    private boolean hSn;
    private boolean hSo;
    private Activity mActivity;
    private float x;

    /* loaded from: classes16.dex */
    public interface a {
        void clB();

        boolean clC();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSk = 0;
        this.hSo = true;
        this.mActivity = (Activity) context;
        this.hSk = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.hSk);
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
                if (this.hSm != null) {
                    this.hSm.clB();
                }
                if (this.x >= getMeasuredWidth() - this.hSk && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.hSl = true;
                    this.hSo = true;
                    break;
                } else {
                    this.hSo = false;
                    break;
                }
                break;
            case 1:
                this.hSo = true;
                break;
            case 2:
                if (this.hSo) {
                    boolean clC = this.hSm != null ? this.hSm.clC() : true;
                    if (this.hSl && clC) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.hSo = clC;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hSn || this.hSl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.hSl) {
                    this.hSl = false;
                }
                if (this.hSn) {
                    this.hSn = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.hSn = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.hSm = aVar;
    }
}
