package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0180a bvg;
    private float bvh;
    private long bvi;
    private long bvj;
    private boolean bvk;
    private boolean bvl;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0180a {
        void TD();

        void TE();

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
                this.bvh = motionEvent.getY();
                this.bvi = System.currentTimeMillis();
                this.bvk = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.bvi < 100 && currentTimeMillis - this.bvj < 500) {
                    this.bvl = true;
                } else {
                    this.bvl = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.bvh - motionEvent.getY()) > 50.0f) {
                    this.bvl = false;
                    this.bvk = false;
                }
                if (this.bvl) {
                    if (this.bvg != null) {
                        this.bvg.t(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.bvh - motionEvent.getY()) && this.bvg != null) {
                    this.bvg.TE();
                }
                if (!this.bvl && this.bvk && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.bvh - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.bvl && a.this.bvk && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.bvh - motionEvent.getY()) < 30.0f && a.this.bvg != null) {
                                a.this.bvg.TD();
                            }
                        }
                    }, 300L);
                }
                this.bvj = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0180a interfaceC0180a) {
        this.bvg = interfaceC0180a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
