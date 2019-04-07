package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0248a cHe;
    private float cHf;
    private long cHg;
    private long cHh;
    private boolean cHi;
    private boolean cHj;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0248a {
        void atV();

        void atW();

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
                this.cHf = motionEvent.getY();
                this.cHg = System.currentTimeMillis();
                this.cHi = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cHg < 100 && currentTimeMillis - this.cHh < 500) {
                    this.cHj = true;
                } else {
                    this.cHj = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cHf - motionEvent.getY()) > 50.0f) {
                    this.cHj = false;
                    this.cHi = false;
                }
                if (this.cHj) {
                    if (this.cHe != null) {
                        this.cHe.w(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cHf - motionEvent.getY()) && this.cHe != null) {
                    this.cHe.atW();
                }
                if (!this.cHj && this.cHi && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cHf - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.cHj && a.this.cHi && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cHf - motionEvent.getY()) < 30.0f && a.this.cHe != null) {
                                a.this.cHe.atV();
                            }
                        }
                    }, 300L);
                }
                this.cHh = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0248a interfaceC0248a) {
        this.cHe = interfaceC0248a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
