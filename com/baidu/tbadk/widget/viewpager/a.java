package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0248a cHc;
    private float cHd;
    private long cHe;
    private long cHf;
    private boolean cHg;
    private boolean cHh;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0248a {
        void atY();

        void atZ();

        void w(float f, float f2);
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
                this.cHd = motionEvent.getY();
                this.cHe = System.currentTimeMillis();
                this.cHg = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cHe < 100 && currentTimeMillis - this.cHf < 500) {
                    this.cHh = true;
                } else {
                    this.cHh = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cHd - motionEvent.getY()) > 50.0f) {
                    this.cHh = false;
                    this.cHg = false;
                }
                if (this.cHh) {
                    if (this.cHc != null) {
                        this.cHc.w(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cHd - motionEvent.getY()) && this.cHc != null) {
                    this.cHc.atZ();
                }
                if (!this.cHh && this.cHg && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cHd - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.cHh && a.this.cHg && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cHd - motionEvent.getY()) < 30.0f && a.this.cHc != null) {
                                a.this.cHc.atY();
                            }
                        }
                    }, 300L);
                }
                this.cHf = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0248a interfaceC0248a) {
        this.cHc = interfaceC0248a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
