package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0180a bvV;
    private float bvW;
    private long bvX;
    private long bvY;
    private boolean bvZ;
    private boolean bwa;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0180a {
        void TZ();

        void Ua();

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
                this.bvW = motionEvent.getY();
                this.bvX = System.currentTimeMillis();
                this.bvZ = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.bvX < 100 && currentTimeMillis - this.bvY < 500) {
                    this.bwa = true;
                } else {
                    this.bwa = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.bvW - motionEvent.getY()) > 50.0f) {
                    this.bwa = false;
                    this.bvZ = false;
                }
                if (this.bwa) {
                    if (this.bvV != null) {
                        this.bvV.t(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.bvW - motionEvent.getY()) && this.bvV != null) {
                    this.bvV.Ua();
                }
                if (!this.bwa && this.bvZ && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.bvW - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.bwa && a.this.bvZ && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.bvW - motionEvent.getY()) < 30.0f && a.this.bvV != null) {
                                a.this.bvV.TZ();
                            }
                        }
                    }, 300L);
                }
                this.bvY = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0180a interfaceC0180a) {
        this.bvV = interfaceC0180a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
