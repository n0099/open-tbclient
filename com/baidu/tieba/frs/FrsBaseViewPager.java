package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes22.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int iSm;
    private boolean iSn;
    private a iSo;
    private boolean iSp;
    private boolean iSq;
    private Activity mActivity;
    private float x;

    /* loaded from: classes22.dex */
    public interface a {
        void cBN();

        boolean cBO();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iSm = 0;
        this.iSq = true;
        this.mActivity = (Activity) context;
        this.iSm = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.iSm);
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
                if (this.iSo != null) {
                    this.iSo.cBN();
                }
                if (this.x >= getMeasuredWidth() - this.iSm && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.iSn = true;
                    this.iSq = true;
                    break;
                } else {
                    this.iSq = false;
                    break;
                }
                break;
            case 1:
                this.iSq = true;
                break;
            case 2:
                if (this.iSq) {
                    boolean cBO = this.iSo != null ? this.iSo.cBO() : true;
                    if (this.iSn && cBO) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.iSq = cBO;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.iSp || this.iSn) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.iSn) {
                    this.iSn = false;
                }
                if (this.iSp) {
                    this.iSp = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.iSp = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.iSo = aVar;
    }
}
