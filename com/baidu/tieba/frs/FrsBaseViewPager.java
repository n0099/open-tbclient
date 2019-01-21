package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes6.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int dKU;
    private boolean dKV;
    private a dKW;
    private boolean dKX;
    private boolean dKY;
    private Activity mActivity;
    private float x;

    /* loaded from: classes6.dex */
    public interface a {
        void aBF();

        boolean aBG();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKU = 16;
        this.dKY = true;
        this.mActivity = (Activity) context;
        this.dKU = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.dKU);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.eH(1000);
        aVar.b(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.dKW != null) {
                    this.dKW.aBF();
                }
                if (this.x >= getMeasuredWidth() - this.dKU && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.dKV = true;
                    this.dKY = true;
                    break;
                } else {
                    this.dKY = false;
                    break;
                }
                break;
            case 1:
                this.dKY = true;
                break;
            case 2:
                if (this.dKY) {
                    boolean aBG = this.dKW != null ? this.dKW.aBG() : true;
                    if (this.dKV && aBG) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.dKY = aBG;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.dKX || this.dKV) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.dKV) {
                    this.dKV = false;
                }
                if (this.dKX) {
                    this.dKX = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.dKX = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.dKW = aVar;
    }
}
