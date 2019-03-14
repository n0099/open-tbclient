package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int eYm;
    private boolean eYn;
    private a eYo;
    private boolean eYp;
    private boolean eYq;
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
        this.eYm = 16;
        this.eYq = true;
        this.mActivity = (Activity) context;
        this.eYm = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.eYm);
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
                if (this.eYo != null) {
                    this.eYo.bce();
                }
                if (this.x >= getMeasuredWidth() - this.eYm && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.eYn = true;
                    this.eYq = true;
                    break;
                } else {
                    this.eYq = false;
                    break;
                }
                break;
            case 1:
                this.eYq = true;
                break;
            case 2:
                if (this.eYq) {
                    boolean bcf = this.eYo != null ? this.eYo.bcf() : true;
                    if (this.eYn && bcf) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.eYq = bcf;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.eYp || this.eYn) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.eYn) {
                    this.eYn = false;
                }
                if (this.eYp) {
                    this.eYp = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.eYp = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.eYo = aVar;
    }
}
