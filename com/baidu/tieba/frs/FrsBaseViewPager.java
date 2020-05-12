package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int gXL;
    private boolean gXM;
    private a gXN;
    private boolean gXO;
    private boolean gXP;
    private Activity mActivity;
    private float x;

    /* loaded from: classes9.dex */
    public interface a {
        void bOe();

        boolean bOf();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gXL = 0;
        this.gXP = true;
        this.mActivity = (Activity) context;
        this.gXL = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.gXL);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.lN(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gXN != null) {
                    this.gXN.bOe();
                }
                if (this.x >= getMeasuredWidth() - this.gXL && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.gXM = true;
                    this.gXP = true;
                    break;
                } else {
                    this.gXP = false;
                    break;
                }
                break;
            case 1:
                this.gXP = true;
                break;
            case 2:
                if (this.gXP) {
                    boolean bOf = this.gXN != null ? this.gXN.bOf() : true;
                    if (this.gXM && bOf) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.gXP = bOf;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gXO || this.gXM) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.gXM) {
                    this.gXM = false;
                }
                if (this.gXO) {
                    this.gXO = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.gXO = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.gXN = aVar;
    }
}
