package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0263a cPo;
    private float cPp;
    private long cPq;
    private long cPr;
    private boolean cPs;
    private boolean cPt;
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
                this.cPp = motionEvent.getY();
                this.cPq = System.currentTimeMillis();
                this.cPs = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cPq < 100 && currentTimeMillis - this.cPr < 500) {
                    this.cPt = true;
                } else {
                    this.cPt = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cPp - motionEvent.getY()) > 50.0f) {
                    this.cPt = false;
                    this.cPs = false;
                }
                if (this.cPt) {
                    if (this.cPo != null) {
                        this.cPo.w(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cPp - motionEvent.getY()) && this.cPo != null) {
                    this.cPo.azc();
                }
                if (!this.cPt && this.cPs && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cPp - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.cPt && a.this.cPs && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cPp - motionEvent.getY()) < 30.0f && a.this.cPo != null) {
                                a.this.cPo.azb();
                            }
                        }
                    }, 300L);
                }
                this.cPr = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0263a interfaceC0263a) {
        this.cPo = interfaceC0263a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
