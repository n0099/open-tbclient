package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0265a cQS;
    private float cQT;
    private long cQU;
    private long cQV;
    private boolean cQW;
    private boolean cQX;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0265a {
        void aAr();

        void aAs();

        void x(float f, float f2);
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
                this.cQT = motionEvent.getY();
                this.cQU = System.currentTimeMillis();
                this.cQW = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cQU < 100 && currentTimeMillis - this.cQV < 500) {
                    this.cQX = true;
                } else {
                    this.cQX = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cQT - motionEvent.getY()) > 50.0f) {
                    this.cQX = false;
                    this.cQW = false;
                }
                if (this.cQX) {
                    if (this.cQS != null) {
                        this.cQS.x(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cQT - motionEvent.getY()) && this.cQS != null) {
                    this.cQS.aAs();
                }
                if (!this.cQX && this.cQW && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cQT - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.cQX && a.this.cQW && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cQT - motionEvent.getY()) < 30.0f && a.this.cQS != null) {
                                a.this.cQS.aAr();
                            }
                        }
                    }, 300L);
                }
                this.cQV = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0265a interfaceC0265a) {
        this.cQS = interfaceC0265a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
