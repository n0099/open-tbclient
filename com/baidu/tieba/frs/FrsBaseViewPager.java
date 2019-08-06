package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int ftI;
    private boolean ftJ;
    private a ftK;
    private boolean ftL;
    private boolean ftM;
    private Activity mActivity;
    private float x;

    /* loaded from: classes4.dex */
    public interface a {
        void blI();

        boolean blJ();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftI = 16;
        this.ftM = true;
        this.mActivity = (Activity) context;
        this.ftI = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.ftI);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.jh(1000);
        aVar.b(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.ftK != null) {
                    this.ftK.blI();
                }
                if (this.x >= getMeasuredWidth() - this.ftI && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.ftJ = true;
                    this.ftM = true;
                    break;
                } else {
                    this.ftM = false;
                    break;
                }
                break;
            case 1:
                this.ftM = true;
                break;
            case 2:
                if (this.ftM) {
                    boolean blJ = this.ftK != null ? this.ftK.blJ() : true;
                    if (this.ftJ && blJ) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.ftM = blJ;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ftL || this.ftJ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.ftJ) {
                    this.ftJ = false;
                }
                if (this.ftL) {
                    this.ftL = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.ftL = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.ftK = aVar;
    }
}
