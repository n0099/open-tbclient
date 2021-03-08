package com.baidu.tieba.ala.liveroom.livepager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes10.dex */
public class a {
    private float cFL;
    private long gcD;
    private long gcE;
    private boolean gcF;
    private boolean gcG;
    private InterfaceC0675a hHG;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.liveroom.livepager.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0675a {
        void bIW();

        void bIX();

        void z(float f, float f2);
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
                this.cFL = motionEvent.getY();
                this.gcD = System.currentTimeMillis();
                this.gcF = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gcD < 100 && currentTimeMillis - this.gcE < 500) {
                    this.gcG = true;
                } else {
                    this.gcG = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cFL - motionEvent.getY()) > 50.0f) {
                    this.gcG = false;
                    this.gcF = false;
                }
                if (this.gcG) {
                    if (this.hHG != null) {
                        this.hHG.z(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cFL - motionEvent.getY()) && this.hHG != null) {
                    this.hHG.bIX();
                }
                if (!this.gcG && this.gcF && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cFL - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.livepager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.gcG && a.this.gcF && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cFL - motionEvent.getY()) < 30.0f && a.this.hHG != null) {
                                a.this.hHG.bIW();
                            }
                        }
                    }, 300L);
                }
                this.gcE = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0675a interfaceC0675a) {
        this.hHG = interfaceC0675a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
