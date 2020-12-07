package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes22.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int iSk;
    private boolean iSl;
    private a iSm;
    private boolean iSn;
    private boolean iSo;
    private Activity mActivity;
    private float x;

    /* loaded from: classes22.dex */
    public interface a {
        void cBM();

        boolean cBN();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iSk = 0;
        this.iSo = true;
        this.mActivity = (Activity) context;
        this.iSk = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.iSk);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.rs(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.iSm != null) {
                    this.iSm.cBM();
                }
                if (this.x >= getMeasuredWidth() - this.iSk && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.iSl = true;
                    this.iSo = true;
                    break;
                } else {
                    this.iSo = false;
                    break;
                }
                break;
            case 1:
                this.iSo = true;
                break;
            case 2:
                if (this.iSo) {
                    boolean cBN = this.iSm != null ? this.iSm.cBN() : true;
                    if (this.iSl && cBN) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.iSo = cBN;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.iSn || this.iSl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.iSl) {
                    this.iSl = false;
                }
                if (this.iSn) {
                    this.iSn = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.iSn = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.iSm = aVar;
    }
}
