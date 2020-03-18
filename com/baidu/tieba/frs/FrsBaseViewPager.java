package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes9.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int goA;
    private boolean goB;
    private a goC;
    private boolean goD;
    private boolean goE;
    private Activity mActivity;
    private float x;

    /* loaded from: classes9.dex */
    public interface a {
        void bDG();

        boolean bDH();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.goA = 16;
        this.goE = true;
        this.mActivity = (Activity) context;
        this.goA = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.goA);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.lB(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.goC != null) {
                    this.goC.bDG();
                }
                if (this.x >= getMeasuredWidth() - this.goA && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.goB = true;
                    this.goE = true;
                    break;
                } else {
                    this.goE = false;
                    break;
                }
                break;
            case 1:
                this.goE = true;
                break;
            case 2:
                if (this.goE) {
                    boolean bDH = this.goC != null ? this.goC.bDH() : true;
                    if (this.goB && bDH) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.goE = bDH;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.goD || this.goB) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.goB) {
                    this.goB = false;
                }
                if (this.goD) {
                    this.goD = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.goD = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.goC = aVar;
    }
}
