package com.baidu.tieba.ala.liveroom.livepager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class a {
    private long eHO;
    private long eHP;
    private boolean eHQ;
    private boolean eHR;
    private InterfaceC0565a fWI;
    private float mDownX;
    private float mDownY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.liveroom.livepager.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0565a {
        void bjL();

        void bjM();

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
                this.mDownY = motionEvent.getY();
                this.eHO = System.currentTimeMillis();
                this.eHQ = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.eHO < 100 && currentTimeMillis - this.eHP < 500) {
                    this.eHR = true;
                } else {
                    this.eHR = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.mDownY - motionEvent.getY()) > 50.0f) {
                    this.eHR = false;
                    this.eHQ = false;
                }
                if (this.eHR) {
                    if (this.fWI != null) {
                        this.fWI.t(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.mDownY - motionEvent.getY()) && this.fWI != null) {
                    this.fWI.bjM();
                }
                if (!this.eHR && this.eHQ && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.mDownY - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.livepager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.eHR && a.this.eHQ && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.mDownY - motionEvent.getY()) < 30.0f && a.this.fWI != null) {
                                a.this.fWI.bjL();
                            }
                        }
                    }, 300L);
                }
                this.eHP = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0565a interfaceC0565a) {
        this.fWI = interfaceC0565a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
