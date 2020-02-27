package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int gnB;
    private boolean gnC;
    private a gnD;
    private boolean gnE;
    private boolean gnF;
    private Activity mActivity;
    private float x;

    /* loaded from: classes9.dex */
    public interface a {
        void bDv();

        boolean bDw();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnB = 16;
        this.gnF = true;
        this.mActivity = (Activity) context;
        this.gnB = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.gnB);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.lz(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gnD != null) {
                    this.gnD.bDv();
                }
                if (this.x >= getMeasuredWidth() - this.gnB && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.gnC = true;
                    this.gnF = true;
                    break;
                } else {
                    this.gnF = false;
                    break;
                }
                break;
            case 1:
                this.gnF = true;
                break;
            case 2:
                if (this.gnF) {
                    boolean bDw = this.gnD != null ? this.gnD.bDw() : true;
                    if (this.gnC && bDw) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.gnF = bDw;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gnE || this.gnC) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.gnC) {
                    this.gnC = false;
                }
                if (this.gnE) {
                    this.gnE = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.gnE = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.gnD = aVar;
    }
}
