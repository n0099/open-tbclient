package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int fvv;
    private boolean fvw;
    private a fvx;
    private boolean fvy;
    private boolean fvz;
    private Activity mActivity;
    private float x;

    /* loaded from: classes4.dex */
    public interface a {
        void bmt();

        boolean bmu();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fvv = 16;
        this.fvz = true;
        this.mActivity = (Activity) context;
        this.fvv = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.fvv);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.jk(1000);
        aVar.b(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.fvx != null) {
                    this.fvx.bmt();
                }
                if (this.x >= getMeasuredWidth() - this.fvv && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.fvw = true;
                    this.fvz = true;
                    break;
                } else {
                    this.fvz = false;
                    break;
                }
                break;
            case 1:
                this.fvz = true;
                break;
            case 2:
                if (this.fvz) {
                    boolean bmu = this.fvx != null ? this.fvx.bmu() : true;
                    if (this.fvw && bmu) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.fvz = bmu;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.fvy || this.fvw) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.fvw) {
                    this.fvw = false;
                }
                if (this.fvy) {
                    this.fvy = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.fvy = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.fvx = aVar;
    }
}
