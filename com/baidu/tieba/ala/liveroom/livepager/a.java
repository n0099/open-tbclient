package com.baidu.tieba.ala.liveroom.livepager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class a {
    private float cqF;
    private long fGL;
    private long fGM;
    private boolean fGN;
    private boolean fGO;
    private InterfaceC0664a hfh;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.liveroom.livepager.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0664a {
        void bEG();

        void bEH();

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
                this.cqF = motionEvent.getY();
                this.fGL = System.currentTimeMillis();
                this.fGN = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fGL < 100 && currentTimeMillis - this.fGM < 500) {
                    this.fGO = true;
                } else {
                    this.fGO = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cqF - motionEvent.getY()) > 50.0f) {
                    this.fGO = false;
                    this.fGN = false;
                }
                if (this.fGO) {
                    if (this.hfh != null) {
                        this.hfh.y(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cqF - motionEvent.getY()) && this.hfh != null) {
                    this.hfh.bEH();
                }
                if (!this.fGO && this.fGN && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cqF - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.livepager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.fGO && a.this.fGN && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cqF - motionEvent.getY()) < 30.0f && a.this.hfh != null) {
                                a.this.hfh.bEG();
                            }
                        }
                    }, 300L);
                }
                this.fGM = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0664a interfaceC0664a) {
        this.hfh = interfaceC0664a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
