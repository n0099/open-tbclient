package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int eYn;
    private boolean eYo;
    private a eYp;
    private boolean eYq;
    private boolean eYr;
    private Activity mActivity;
    private float x;

    /* loaded from: classes4.dex */
    public interface a {
        void bce();

        boolean bcf();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eYn = 16;
        this.eYr = true;
        this.mActivity = (Activity) context;
        this.eYn = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.eYn);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.in(1000);
        aVar.b(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.eYp != null) {
                    this.eYp.bce();
                }
                if (this.x >= getMeasuredWidth() - this.eYn && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.eYo = true;
                    this.eYr = true;
                    break;
                } else {
                    this.eYr = false;
                    break;
                }
                break;
            case 1:
                this.eYr = true;
                break;
            case 2:
                if (this.eYr) {
                    boolean bcf = this.eYp != null ? this.eYp.bcf() : true;
                    if (this.eYo && bcf) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.eYr = bcf;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.eYq || this.eYo) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.eYo) {
                    this.eYo = false;
                }
                if (this.eYq) {
                    this.eYq = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.eYq = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.eYp = aVar;
    }
}
