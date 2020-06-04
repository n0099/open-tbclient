package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int hmI;
    private boolean hmJ;
    private a hmK;
    private boolean hmL;
    private boolean hmM;
    private Activity mActivity;
    private float x;

    /* loaded from: classes9.dex */
    public interface a {
        void bUB();

        boolean bUC();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hmI = 0;
        this.hmM = true;
        this.mActivity = (Activity) context;
        this.hmI = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.hmI);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.ms(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.hmK != null) {
                    this.hmK.bUB();
                }
                if (this.x >= getMeasuredWidth() - this.hmI && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.hmJ = true;
                    this.hmM = true;
                    break;
                } else {
                    this.hmM = false;
                    break;
                }
                break;
            case 1:
                this.hmM = true;
                break;
            case 2:
                if (this.hmM) {
                    boolean bUC = this.hmK != null ? this.hmK.bUC() : true;
                    if (this.hmJ && bUC) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.hmM = bUC;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hmL || this.hmJ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.hmJ) {
                    this.hmJ = false;
                }
                if (this.hmL) {
                    this.hmL = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.hmL = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.hmK = aVar;
    }
}
