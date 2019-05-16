package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int foj;
    private boolean fok;
    private a fol;
    private boolean fom;
    private boolean fon;
    private Activity mActivity;
    private float x;

    /* loaded from: classes4.dex */
    public interface a {
        void bjw();

        boolean bjx();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foj = 16;
        this.fon = true;
        this.mActivity = (Activity) context;
        this.foj = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.foj);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.mActivity);
        aVar.ja(1000);
        aVar.b(this);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.fol != null) {
                    this.fol.bjw();
                }
                if (this.x >= getMeasuredWidth() - this.foj && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.fok = true;
                    this.fon = true;
                    break;
                } else {
                    this.fon = false;
                    break;
                }
                break;
            case 1:
                this.fon = true;
                break;
            case 2:
                if (this.fon) {
                    boolean bjx = this.fol != null ? this.fol.bjx() : true;
                    if (this.fok && bjx) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.fon = bjx;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.fom || this.fok) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.fok) {
                    this.fok = false;
                }
                if (this.fom) {
                    this.fom = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.fom = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.fol = aVar;
    }
}
