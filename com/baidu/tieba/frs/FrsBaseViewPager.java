package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes6.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int dKk;
    private boolean dKl;
    private a dKm;
    private boolean dKn;
    private boolean dKo;
    private Activity mActivity;
    private float x;

    /* loaded from: classes6.dex */
    public interface a {
        void aBi();

        boolean aBj();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKk = 16;
        this.dKo = true;
        this.mActivity = (Activity) context;
        this.dKk = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.dKk);
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
                if (this.dKm != null) {
                    this.dKm.aBi();
                }
                if (this.x >= getMeasuredWidth() - this.dKk && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.dKl = true;
                    this.dKo = true;
                    break;
                } else {
                    this.dKo = false;
                    break;
                }
                break;
            case 1:
                this.dKo = true;
                break;
            case 2:
                if (this.dKo) {
                    boolean aBj = this.dKm != null ? this.dKm.aBj() : true;
                    if (this.dKl && aBj) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.dKo = aBj;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.dKn || this.dKl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.dKl) {
                    this.dKl = false;
                }
                if (this.dKn) {
                    this.dKn = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.dKn = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.dKm = aVar;
    }
}
