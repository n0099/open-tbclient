package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private float cGB;
    private InterfaceC0608a gds;
    private long gdt;
    private long gdu;
    private boolean gdv;
    private boolean gdw;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0608a {
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

    public boolean onTouchEvent(MotionEvent motionEvent) {
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
                    if (this.gds != null) {
                        this.gds.y(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cGB - motionEvent.getY()) && this.gds != null) {
                    this.gds.bMr();
                }
                if (!this.gdw && this.gdv && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cGB - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.gdw && a.this.gdv && a.this.gds != null) {
                                a.this.gds.bMq();
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

    public void setEventListener(InterfaceC0608a interfaceC0608a) {
        this.gds = interfaceC0608a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
