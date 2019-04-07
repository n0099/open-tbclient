package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int eXY;
    private boolean eXZ;
    private a eYa;
    private boolean eYb;
    private boolean eYc;
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
        this.eXY = 16;
        this.eYc = true;
        this.mActivity = (Activity) context;
        this.eXY = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.eXY);
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
                if (this.eYa != null) {
                    this.eYa.bcc();
                }
                if (this.x >= getMeasuredWidth() - this.eXY && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.eXZ = true;
                    this.eYc = true;
                    break;
                } else {
                    this.eYc = false;
                    break;
                }
                break;
            case 1:
                this.eYc = true;
                break;
            case 2:
                if (this.eYc) {
                    boolean bcd = this.eYa != null ? this.eYa.bcd() : true;
                    if (this.eXZ && bcd) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.eYc = bcd;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.eYb || this.eXZ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.eXZ) {
                    this.eXZ = false;
                }
                if (this.eYb) {
                    this.eYb = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.eYb = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.eYa = aVar;
    }
}
