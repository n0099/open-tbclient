package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes2.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private a jeA;
    private boolean jeB;
    private boolean jeC;
    private int jey;
    private boolean jez;
    private Activity mActivity;
    private float x;

    /* loaded from: classes2.dex */
    public interface a {
        void cEH();

        boolean cEI();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jey = 0;
        this.jeC = true;
        this.mActivity = (Activity) context;
        this.jey = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.jey);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.rE(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jeA != null) {
                    this.jeA.cEH();
                }
                if (this.x >= getMeasuredWidth() - this.jey && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.jez = true;
                    this.jeC = true;
                    break;
                } else {
                    this.jeC = false;
                    break;
                }
                break;
            case 1:
                this.jeC = true;
                break;
            case 2:
                if (this.jeC) {
                    boolean cEI = this.jeA != null ? this.jeA.cEI() : true;
                    if (this.jez && cEI) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.jeC = cEI;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.jeB || this.jez) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.jez) {
                    this.jez = false;
                }
                if (this.jeB) {
                    this.jeB = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.jeB = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.jeA = aVar;
    }
}
