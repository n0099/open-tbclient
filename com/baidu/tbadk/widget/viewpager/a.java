package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0122a bmQ;
    private float bmR;
    private long bmS;
    private long bmT;
    private boolean bmU;
    private boolean bmV;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0122a {
        void Qs();

        void Qt();

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
                this.bmR = motionEvent.getY();
                this.bmS = System.currentTimeMillis();
                this.bmU = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.bmS < 100 && currentTimeMillis - this.bmT < 500) {
                    this.bmV = true;
                } else {
                    this.bmV = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.bmR - motionEvent.getY()) > 50.0f) {
                    this.bmV = false;
                    this.bmU = false;
                }
                if (this.bmV) {
                    if (this.bmQ != null) {
                        this.bmQ.q(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.bmR - motionEvent.getY()) && this.bmQ != null) {
                    this.bmQ.Qt();
                }
                if (!this.bmV && this.bmU && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.bmR - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.bmV && a.this.bmU && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.bmR - motionEvent.getY()) < 30.0f && a.this.bmQ != null) {
                                a.this.bmQ.Qs();
                            }
                        }
                    }, 300L);
                }
                this.bmT = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0122a interfaceC0122a) {
        this.bmQ = interfaceC0122a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
