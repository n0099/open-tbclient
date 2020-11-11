package com.baidu.tieba.ala.liveroom.livepager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class a {
    private float cwD;
    private long fMB;
    private long fMC;
    private boolean fMD;
    private boolean fME;
    private InterfaceC0678a hld;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.liveroom.livepager.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0678a {
        void bHf();

        void bHg();

        void y(float f, float f2);
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
                this.cwD = motionEvent.getY();
                this.fMB = System.currentTimeMillis();
                this.fMD = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fMB < 100 && currentTimeMillis - this.fMC < 500) {
                    this.fME = true;
                } else {
                    this.fME = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cwD - motionEvent.getY()) > 50.0f) {
                    this.fME = false;
                    this.fMD = false;
                }
                if (this.fME) {
                    if (this.hld != null) {
                        this.hld.y(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cwD - motionEvent.getY()) && this.hld != null) {
                    this.hld.bHg();
                }
                if (!this.fME && this.fMD && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cwD - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.livepager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.fME && a.this.fMD && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cwD - motionEvent.getY()) < 30.0f && a.this.hld != null) {
                                a.this.hld.bHf();
                            }
                        }
                    }, 300L);
                }
                this.fMC = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0678a interfaceC0678a) {
        this.hld = interfaceC0678a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
