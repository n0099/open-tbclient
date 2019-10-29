package com.baidu.tieba.ala.liveroom.livepager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes6.dex */
public class a {
    private float dbc;
    private long dbd;
    private long dbe;
    private boolean dbf;
    private boolean dbg;
    private InterfaceC0364a eiu;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.liveroom.livepager.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0364a {
        void aAM();

        void aAN();

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
                this.dbc = motionEvent.getY();
                this.dbd = System.currentTimeMillis();
                this.dbf = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dbd < 100 && currentTimeMillis - this.dbe < 500) {
                    this.dbg = true;
                } else {
                    this.dbg = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.dbc - motionEvent.getY()) > 50.0f) {
                    this.dbg = false;
                    this.dbf = false;
                }
                if (this.dbg) {
                    if (this.eiu != null) {
                        this.eiu.s(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.dbc - motionEvent.getY()) && this.eiu != null) {
                    this.eiu.aAN();
                }
                if (!this.dbg && this.dbf && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.dbc - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.livepager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.dbg && a.this.dbf && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.dbc - motionEvent.getY()) < 30.0f && a.this.eiu != null) {
                                a.this.eiu.aAM();
                            }
                        }
                    }, 300L);
                }
                this.dbe = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0364a interfaceC0364a) {
        this.eiu = interfaceC0364a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
