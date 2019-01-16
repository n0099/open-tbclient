package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes6.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int dKT;
    private boolean dKU;
    private a dKV;
    private boolean dKW;
    private boolean dKX;
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
        this.dKT = 16;
        this.dKX = true;
        this.mActivity = (Activity) context;
        this.dKT = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.dKT);
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
                if (this.dKV != null) {
                    this.dKV.aBF();
                }
                if (this.x >= getMeasuredWidth() - this.dKT && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.dKU = true;
                    this.dKX = true;
                    break;
                } else {
                    this.dKX = false;
                    break;
                }
                break;
            case 1:
                this.dKX = true;
                break;
            case 2:
                if (this.dKX) {
                    boolean aBG = this.dKV != null ? this.dKV.aBG() : true;
                    if (this.dKU && aBG) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.dKX = aBG;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.dKW || this.dKU) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.dKU) {
                    this.dKU = false;
                }
                if (this.dKW) {
                    this.dKW = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.dKW = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.dKV = aVar;
    }
}
