package com.baidu.tieba.ala.liveroom.livepager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes11.dex */
public class a {
    private float cGB;
    private long gdt;
    private long gdu;
    private boolean gdv;
    private boolean gdw;
    private InterfaceC0684a hGf;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.liveroom.livepager.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0684a {
        void bMq();

        void bMr();

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
                this.cGB = motionEvent.getY();
                this.gdt = System.currentTimeMillis();
                this.gdv = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gdt < 100 && currentTimeMillis - this.gdu < 500) {
                    this.gdw = true;
                } else {
                    this.gdw = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cGB - motionEvent.getY()) > 50.0f) {
                    this.gdw = false;
                    this.gdv = false;
                }
                if (this.gdw) {
                    if (this.hGf != null) {
                        this.hGf.y(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cGB - motionEvent.getY()) && this.hGf != null) {
                    this.hGf.bMr();
                }
                if (!this.gdw && this.gdv && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cGB - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.livepager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.gdw && a.this.gdv && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cGB - motionEvent.getY()) < 30.0f && a.this.hGf != null) {
                                a.this.hGf.bMq();
                            }
                        }
                    }, 300L);
                }
                this.gdu = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0684a interfaceC0684a) {
        this.hGf = interfaceC0684a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
