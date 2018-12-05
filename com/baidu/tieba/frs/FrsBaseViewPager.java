package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes6.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private boolean dHA;
    private int dHw;
    private boolean dHx;
    private a dHy;
    private boolean dHz;
    private Activity mActivity;
    private float x;

    /* loaded from: classes6.dex */
    public interface a {
        void aAt();

        boolean aAu();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dHw = 16;
        this.dHA = true;
        this.mActivity = (Activity) context;
        this.dHw = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.dHw);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.eG(1000);
        aVar.b(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.dHy != null) {
                    this.dHy.aAt();
                }
                if (this.x >= getMeasuredWidth() - this.dHw && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.dHx = true;
                    this.dHA = true;
                    break;
                } else {
                    this.dHA = false;
                    break;
                }
                break;
            case 1:
                this.dHA = true;
                break;
            case 2:
                if (this.dHA) {
                    boolean aAu = this.dHy != null ? this.dHy.aAu() : true;
                    if (this.dHx && aAu) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.dHA = aAu;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.dHz || this.dHx) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.dHx) {
                    this.dHx = false;
                }
                if (this.dHz) {
                    this.dHz = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.dHz = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.dHy = aVar;
    }
}
