package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes6.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int dAX;
    private boolean dAY;
    private a dAZ;
    private boolean dBa;
    private boolean dBb;
    private Activity mActivity;
    private float x;

    /* loaded from: classes6.dex */
    public interface a {
        void ayJ();

        boolean ayK();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dAX = 16;
        this.dBb = true;
        this.mActivity = (Activity) context;
        this.dAX = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.dAX);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.es(1000);
        aVar.b(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.dAZ != null) {
                    this.dAZ.ayJ();
                }
                if (this.x >= getMeasuredWidth() - this.dAX && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.dAY = true;
                    this.dBb = true;
                    break;
                } else {
                    this.dBb = false;
                    break;
                }
                break;
            case 1:
                this.dBb = true;
                break;
            case 2:
                if (this.dBb) {
                    boolean ayK = this.dAZ != null ? this.dAZ.ayK() : true;
                    if (this.dAY && ayK) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.dBb = ayK;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.dBa || this.dAY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.dAY) {
                    this.dAY = false;
                }
                if (this.dBa) {
                    this.dBa = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.dBa = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.dAZ = aVar;
    }
}
