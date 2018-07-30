package com.baidu.tbadk.widget.viewpager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0122a bgX;
    private float bgY;
    private long bgZ;
    private long bha;
    private boolean bhb;
    private boolean bhc;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tbadk.widget.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0122a {
        void OA();

        void Oz();

        void q(float f, float f2);
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
                this.bgY = motionEvent.getY();
                this.bgZ = System.currentTimeMillis();
                this.bhb = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.bgZ < 100 && currentTimeMillis - this.bha < 500) {
                    this.bhc = true;
                } else {
                    this.bhc = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.bgY - motionEvent.getY()) > 50.0f) {
                    this.bhc = false;
                    this.bhb = false;
                }
                if (this.bhc) {
                    if (this.bgX != null) {
                        this.bgX.q(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.bgY - motionEvent.getY()) && this.bgX != null) {
                    this.bgX.OA();
                }
                if (!this.bhc && this.bhb && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.bgY - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.bhc && a.this.bhb && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.bgY - motionEvent.getY()) < 30.0f && a.this.bgX != null) {
                                a.this.bgX.Oz();
                            }
                        }
                    }, 300L);
                }
                this.bha = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0122a interfaceC0122a) {
        this.bgX = interfaceC0122a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
