package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0180a bvd;
    private float bve;
    private long bvf;
    private long bvg;
    private boolean bvh;
    private boolean bvi;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0180a {
        void TB();

        void TC();

        void t(float f, float f2);
    }

    public a(View view) {
        this.mView = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        if (viewConfiguration != null) {
            this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownX = motionEvent.getX();
                this.bve = motionEvent.getY();
                this.bvf = System.currentTimeMillis();
                this.bvh = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.bvf < 100 && currentTimeMillis - this.bvg < 500) {
                    this.bvi = true;
                } else {
                    this.bvi = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.bve - motionEvent.getY()) > 50.0f) {
                    this.bvi = false;
                    this.bvh = false;
                }
                if (this.bvi) {
                    if (this.bvd != null) {
                        this.bvd.t(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.bve - motionEvent.getY()) && this.bvd != null) {
                    this.bvd.TC();
                }
                if (!this.bvi && this.bvh && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.bve - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.bvi && a.this.bvh && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.bve - motionEvent.getY()) < 30.0f && a.this.bvd != null) {
                                a.this.bvd.TB();
                            }
                        }
                    }, 300L);
                }
                this.bvg = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0180a interfaceC0180a) {
        this.bvd = interfaceC0180a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
