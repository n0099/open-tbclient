package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int fuI;
    private boolean fuJ;
    private a fuK;
    private boolean fuL;
    private boolean fuM;
    private Activity mActivity;
    private float x;

    /* loaded from: classes4.dex */
    public interface a {
        boolean bjA();

        void bjz();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fuI = 16;
        this.fuM = true;
        this.mActivity = (Activity) context;
        this.fuI = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.fuI);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.iW(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.fuK != null) {
                    this.fuK.bjz();
                }
                if (this.x >= getMeasuredWidth() - this.fuI && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.fuJ = true;
                    this.fuM = true;
                    break;
                } else {
                    this.fuM = false;
                    break;
                }
                break;
            case 1:
                this.fuM = true;
                break;
            case 2:
                if (this.fuM) {
                    boolean bjA = this.fuK != null ? this.fuK.bjA() : true;
                    if (this.fuJ && bjA) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.fuM = bjA;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.fuL || this.fuJ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.fuJ) {
                    this.fuJ = false;
                }
                if (this.fuL) {
                    this.fuL = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.fuL = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.fuK = aVar;
    }
}
