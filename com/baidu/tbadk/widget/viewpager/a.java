package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0400a dSI;
    private long dSJ;
    private long dSK;
    private boolean dSL;
    private boolean dSM;
    private float mDownX;
    private float mDownY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0400a {
        void aVm();

        void aVn();

        void u(float f, float f2);
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
                this.mDownY = motionEvent.getY();
                this.dSJ = System.currentTimeMillis();
                this.dSL = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dSJ < 100 && currentTimeMillis - this.dSK < 500) {
                    this.dSM = true;
                } else {
                    this.dSM = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.mDownY - motionEvent.getY()) > 50.0f) {
                    this.dSM = false;
                    this.dSL = false;
                }
                if (this.dSM) {
                    if (this.dSI != null) {
                        this.dSI.u(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.mDownY - motionEvent.getY()) && this.dSI != null) {
                    this.dSI.aVn();
                }
                if (!this.dSM && this.dSL && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.mDownY - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.dSM && a.this.dSL && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.mDownY - motionEvent.getY()) < 30.0f && a.this.dSI != null) {
                                a.this.dSI.aVm();
                            }
                        }
                    }, 300L);
                }
                this.dSK = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0400a interfaceC0400a) {
        this.dSI = interfaceC0400a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
