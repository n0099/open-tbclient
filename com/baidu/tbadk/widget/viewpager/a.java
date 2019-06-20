package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0263a cPp;
    private float cPq;
    private long cPr;
    private long cPs;
    private boolean cPt;
    private boolean cPu;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0263a {
        void azb();

        void azc();

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
                this.cPq = motionEvent.getY();
                this.cPr = System.currentTimeMillis();
                this.cPt = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cPr < 100 && currentTimeMillis - this.cPs < 500) {
                    this.cPu = true;
                } else {
                    this.cPu = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cPq - motionEvent.getY()) > 50.0f) {
                    this.cPu = false;
                    this.cPt = false;
                }
                if (this.cPu) {
                    if (this.cPp != null) {
                        this.cPp.w(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cPq - motionEvent.getY()) && this.cPp != null) {
                    this.cPp.azc();
                }
                if (!this.cPu && this.cPt && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cPq - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.cPu && a.this.cPt && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cPq - motionEvent.getY()) < 30.0f && a.this.cPp != null) {
                                a.this.cPp.azb();
                            }
                        }
                    }, 300L);
                }
                this.cPs = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0263a interfaceC0263a) {
        this.cPp = interfaceC0263a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
