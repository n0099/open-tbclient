package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes2.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int drF;
    private boolean drG;
    private a drH;
    private boolean drI;
    private Activity mActivity;
    private float x;

    /* loaded from: classes2.dex */
    public interface a {
        void avP();

        void avQ();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drF = 16;
        this.mActivity = (Activity) context;
        this.drF = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.drF);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.dU(1000);
        aVar.b(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.drH != null) {
                    this.drH.avP();
                }
                if (this.x >= getMeasuredWidth() - this.drF && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.drG = true;
                    break;
                }
                break;
            case 2:
                if (this.drH != null) {
                    this.drH.avQ();
                }
                if (this.drG) {
                    setmDisallowSlip(false);
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.drI || this.drG) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.drG) {
                    this.drG = false;
                }
                if (this.drI) {
                    this.drI = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.drI = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.drH = aVar;
    }
}
