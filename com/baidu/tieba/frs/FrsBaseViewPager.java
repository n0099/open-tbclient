package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes7.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int glA;
    private boolean glB;
    private a glC;
    private boolean glD;
    private boolean glE;
    private Activity mActivity;
    private float x;

    /* loaded from: classes7.dex */
    public interface a {
        void bBS();

        boolean bBT();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.glA = 16;
        this.glE = true;
        this.mActivity = (Activity) context;
        this.glA = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.glA);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.li(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.glC != null) {
                    this.glC.bBS();
                }
                if (this.x >= getMeasuredWidth() - this.glA && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.glB = true;
                    this.glE = true;
                    break;
                } else {
                    this.glE = false;
                    break;
                }
                break;
            case 1:
                this.glE = true;
                break;
            case 2:
                if (this.glE) {
                    boolean bBT = this.glC != null ? this.glC.bBT() : true;
                    if (this.glB && bBT) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.glE = bBT;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.glD || this.glB) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.glB) {
                    this.glB = false;
                }
                if (this.glD) {
                    this.glD = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.glD = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.glC = aVar;
    }
}
