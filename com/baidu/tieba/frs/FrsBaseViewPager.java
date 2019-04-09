package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int eXZ;
    private boolean eYa;
    private a eYb;
    private boolean eYc;
    private boolean eYd;
    private Activity mActivity;
    private float x;

    /* loaded from: classes4.dex */
    public interface a {
        void bcc();

        boolean bcd();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eXZ = 16;
        this.eYd = true;
        this.mActivity = (Activity) context;
        this.eXZ = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.eXZ);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.im(1000);
        aVar.b(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.eYb != null) {
                    this.eYb.bcc();
                }
                if (this.x >= getMeasuredWidth() - this.eXZ && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.eYa = true;
                    this.eYd = true;
                    break;
                } else {
                    this.eYd = false;
                    break;
                }
                break;
            case 1:
                this.eYd = true;
                break;
            case 2:
                if (this.eYd) {
                    boolean bcd = this.eYb != null ? this.eYb.bcd() : true;
                    if (this.eYa && bcd) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.eYd = bcd;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.eYc || this.eYa) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.eYa) {
                    this.eYa = false;
                }
                if (this.eYc) {
                    this.eYc = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.eYc = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.eYb = aVar;
    }
}
