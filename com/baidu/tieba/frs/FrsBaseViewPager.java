package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes2.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int jfL;
    private boolean jfM;
    private a jfN;
    private boolean jfO;
    private boolean jfP;
    private Activity mActivity;
    private float x;

    /* loaded from: classes2.dex */
    public interface a {
        void cCh();

        boolean cCi();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jfL = 0;
        this.jfP = true;
        this.mActivity = (Activity) context;
        this.jfL = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.jfL);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.qd(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jfN != null) {
                    this.jfN.cCh();
                }
                if (this.x >= getMeasuredWidth() - this.jfL && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.jfM = true;
                    this.jfP = true;
                    break;
                } else {
                    this.jfP = false;
                    break;
                }
                break;
            case 1:
                this.jfP = true;
                break;
            case 2:
                if (this.jfP) {
                    boolean cCi = this.jfN != null ? this.jfN.cCi() : true;
                    if (this.jfM && cCi) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.jfP = cCi;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.jfO || this.jfM) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.jfM) {
                    this.jfM = false;
                }
                if (this.jfO) {
                    this.jfO = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.jfO = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.jfN = aVar;
    }
}
