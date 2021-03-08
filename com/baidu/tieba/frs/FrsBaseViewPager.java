package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes2.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int jhu;
    private boolean jhv;
    private a jhw;
    private boolean jhx;
    private boolean jhy;
    private Activity mActivity;
    private float x;

    /* loaded from: classes2.dex */
    public interface a {
        void cCn();

        boolean cCo();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jhu = 0;
        this.jhy = true;
        this.mActivity = (Activity) context;
        this.jhu = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.jhu);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.qe(1000);
        aVar.initViewPagerScroll(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jhw != null) {
                    this.jhw.cCn();
                }
                if (this.x >= getMeasuredWidth() - this.jhu && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.jhv = true;
                    this.jhy = true;
                    break;
                } else {
                    this.jhy = false;
                    break;
                }
                break;
            case 1:
                this.jhy = true;
                break;
            case 2:
                if (this.jhy) {
                    boolean cCo = this.jhw != null ? this.jhw.cCo() : true;
                    if (this.jhv && cCo) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.jhy = cCo;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.jhx || this.jhv) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.jhv) {
                    this.jhv = false;
                }
                if (this.jhx) {
                    this.jhx = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.jhx = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.jhw = aVar;
    }
}
