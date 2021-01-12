package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes2.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int iZR;
    private boolean iZS;
    private a iZT;
    private boolean iZU;
    private boolean iZV;
    private Activity mActivity;
    private float x;

    /* loaded from: classes2.dex */
    public interface a {
        void cAP();

        boolean cAQ();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iZR = 0;
        this.iZV = true;
        this.mActivity = (Activity) context;
        this.iZR = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.iZR);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.pY(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.iZT != null) {
                    this.iZT.cAP();
                }
                if (this.x >= getMeasuredWidth() - this.iZR && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.iZS = true;
                    this.iZV = true;
                    break;
                } else {
                    this.iZV = false;
                    break;
                }
                break;
            case 1:
                this.iZV = true;
                break;
            case 2:
                if (this.iZV) {
                    boolean cAQ = this.iZT != null ? this.iZT.cAQ() : true;
                    if (this.iZS && cAQ) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.iZV = cAQ;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.iZU || this.iZS) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.iZS) {
                    this.iZS = false;
                }
                if (this.iZU) {
                    this.iZU = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.iZU = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.iZT = aVar;
    }
}
