package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes6.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int dzG;
    private boolean dzH;
    private a dzI;
    private boolean dzJ;
    private boolean dzK;
    private Activity mActivity;
    private float x;

    /* loaded from: classes6.dex */
    public interface a {
        void azm();

        boolean azn();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dzG = 16;
        this.dzK = true;
        this.mActivity = (Activity) context;
        this.dzG = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.dzG);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.ee(1000);
        aVar.b(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.dzI != null) {
                    this.dzI.azm();
                }
                if (this.x >= getMeasuredWidth() - this.dzG && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.dzH = true;
                    this.dzK = true;
                    break;
                } else {
                    this.dzK = false;
                    break;
                }
                break;
            case 1:
                this.dzK = true;
                break;
            case 2:
                if (this.dzK) {
                    boolean azn = this.dzI != null ? this.dzI.azn() : true;
                    if (this.dzH && azn) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.dzK = azn;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.dzJ || this.dzH) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.dzH) {
                    this.dzH = false;
                }
                if (this.dzJ) {
                    this.dzJ = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.dzJ = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.dzI = aVar;
    }
}
