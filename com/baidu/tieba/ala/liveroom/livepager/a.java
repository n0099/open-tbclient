package com.baidu.tieba.ala.liveroom.livepager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes6.dex */
public class a {
    private float dak;
    private long dal;
    private long dam;
    private boolean dan;
    private boolean dao;
    private InterfaceC0359a ehD;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.liveroom.livepager.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0359a {
        void aAK();

        void aAL();

        void s(float f, float f2);
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
                this.dak = motionEvent.getY();
                this.dal = System.currentTimeMillis();
                this.dan = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dal < 100 && currentTimeMillis - this.dam < 500) {
                    this.dao = true;
                } else {
                    this.dao = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.dak - motionEvent.getY()) > 50.0f) {
                    this.dao = false;
                    this.dan = false;
                }
                if (this.dao) {
                    if (this.ehD != null) {
                        this.ehD.s(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.dak - motionEvent.getY()) && this.ehD != null) {
                    this.ehD.aAL();
                }
                if (!this.dao && this.dan && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.dak - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.livepager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.dao && a.this.dan && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.dak - motionEvent.getY()) < 30.0f && a.this.ehD != null) {
                                a.this.ehD.aAK();
                            }
                        }
                    }, 300L);
                }
                this.dam = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0359a interfaceC0359a) {
        this.ehD = interfaceC0359a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
