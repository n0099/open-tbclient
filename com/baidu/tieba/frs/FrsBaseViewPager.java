package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int gXF;
    private boolean gXG;
    private a gXH;
    private boolean gXI;
    private boolean gXJ;
    private Activity mActivity;
    private float x;

    /* loaded from: classes9.dex */
    public interface a {
        void bOf();

        boolean bOg();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gXF = 0;
        this.gXJ = true;
        this.mActivity = (Activity) context;
        this.gXF = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.gXF);
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
                if (this.gXH != null) {
                    this.gXH.bOf();
                }
                if (this.x >= getMeasuredWidth() - this.gXF && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.gXG = true;
                    this.gXJ = true;
                    break;
                } else {
                    this.gXJ = false;
                    break;
                }
                break;
            case 1:
                this.gXJ = true;
                break;
            case 2:
                if (this.gXJ) {
                    boolean bOg = this.gXH != null ? this.gXH.bOg() : true;
                    if (this.gXG && bOg) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.gXJ = bOg;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gXI || this.gXG) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.gXG) {
                    this.gXG = false;
                }
                if (this.gXI) {
                    this.gXI = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.gXI = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.gXH = aVar;
    }
}
