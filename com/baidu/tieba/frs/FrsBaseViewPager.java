package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int ftR;
    private boolean ftS;
    private a ftT;
    private boolean ftU;
    private boolean ftV;
    private Activity mActivity;
    private float x;

    /* loaded from: classes4.dex */
    public interface a {
        void bjx();

        boolean bjy();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftR = 16;
        this.ftV = true;
        this.mActivity = (Activity) context;
        this.ftR = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.ftR);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.iV(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.ftT != null) {
                    this.ftT.bjx();
                }
                if (this.x >= getMeasuredWidth() - this.ftR && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.ftS = true;
                    this.ftV = true;
                    break;
                } else {
                    this.ftV = false;
                    break;
                }
                break;
            case 1:
                this.ftV = true;
                break;
            case 2:
                if (this.ftV) {
                    boolean bjy = this.ftT != null ? this.ftT.bjy() : true;
                    if (this.ftS && bjy) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.ftV = bjy;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ftU || this.ftS) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.ftS) {
                    this.ftS = false;
                }
                if (this.ftU) {
                    this.ftU = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.ftU = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.ftT = aVar;
    }
}
