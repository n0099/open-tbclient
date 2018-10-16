package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0146a bqS;
    private float bqT;
    private long bqU;
    private long bqV;
    private boolean bqW;
    private boolean bqX;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0146a {
        void Sm();

        void Sn();

        void q(float f, float f2);
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
                this.bqT = motionEvent.getY();
                this.bqU = System.currentTimeMillis();
                this.bqW = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.bqU < 100 && currentTimeMillis - this.bqV < 500) {
                    this.bqX = true;
                } else {
                    this.bqX = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.bqT - motionEvent.getY()) > 50.0f) {
                    this.bqX = false;
                    this.bqW = false;
                }
                if (this.bqX) {
                    if (this.bqS != null) {
                        this.bqS.q(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.bqT - motionEvent.getY()) && this.bqS != null) {
                    this.bqS.Sn();
                }
                if (!this.bqX && this.bqW && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.bqT - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.bqX && a.this.bqW && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.bqT - motionEvent.getY()) < 30.0f && a.this.bqS != null) {
                                a.this.bqS.Sm();
                            }
                        }
                    }, 300L);
                }
                this.bqV = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0146a interfaceC0146a) {
        this.bqS = interfaceC0146a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
