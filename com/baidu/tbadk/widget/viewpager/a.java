package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0214a cHf;
    private float cHg;
    private long cHh;
    private long cHi;
    private boolean cHj;
    private boolean cHk;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0214a {
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
                this.cHg = motionEvent.getY();
                this.cHh = System.currentTimeMillis();
                this.cHj = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cHh < 100 && currentTimeMillis - this.cHi < 500) {
                    this.cHk = true;
                } else {
                    this.cHk = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cHg - motionEvent.getY()) > 50.0f) {
                    this.cHk = false;
                    this.cHj = false;
                }
                if (this.cHk) {
                    if (this.cHf != null) {
                        this.cHf.w(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cHg - motionEvent.getY()) && this.cHf != null) {
                    this.cHf.atZ();
                }
                if (!this.cHk && this.cHj && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cHg - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.cHk && a.this.cHj && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cHg - motionEvent.getY()) < 30.0f && a.this.cHf != null) {
                                a.this.cHf.atY();
                            }
                        }
                    }, 300L);
                }
                this.cHi = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0214a interfaceC0214a) {
        this.cHf = interfaceC0214a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
