package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    private int fok;
    private boolean fol;
    private a fom;
    private boolean fon;
    private boolean foo;
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
        this.fok = 16;
        this.foo = true;
        this.mActivity = (Activity) context;
        this.fok = com.baidu.adp.lib.util.l.dip2px(this.mActivity, this.fok);
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
                if (this.fom != null) {
                    this.fom.bjz();
                }
                if (this.x >= getMeasuredWidth() - this.fok && this.x <= getMeasuredWidth()) {
                    setmDisallowSlip(false);
                    this.fol = true;
                    this.foo = true;
                    break;
                } else {
                    this.foo = false;
                    break;
                }
                break;
            case 1:
                this.foo = true;
                break;
            case 2:
                if (this.foo) {
                    boolean bjA = this.fom != null ? this.fom.bjA() : true;
                    if (this.fol && bjA) {
                        z = false;
                    }
                    setmDisallowSlip(z);
                    this.foo = bjA;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.fon || this.fol) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.fol) {
                    this.fol = false;
                }
                if (this.fon) {
                    this.fon = false;
                }
                setmDisallowSlip(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.fon = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.fom = aVar;
    }
}
