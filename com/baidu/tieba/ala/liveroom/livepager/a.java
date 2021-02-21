package com.baidu.tieba.ala.liveroom.livepager;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes11.dex */
public class a {
    private float cEl;
    private long gbc;
    private long gbd;
    private boolean gbe;
    private boolean gbf;
    private InterfaceC0669a hFX;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.liveroom.livepager.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0669a {
        void bIS();

        void bIT();

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
                this.cEl = motionEvent.getY();
                this.gbc = System.currentTimeMillis();
                this.gbe = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gbc < 100 && currentTimeMillis - this.gbd < 500) {
                    this.gbf = true;
                } else {
                    this.gbf = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.cEl - motionEvent.getY()) > 50.0f) {
                    this.gbf = false;
                    this.gbe = false;
                }
                if (this.gbf) {
                    if (this.hFX != null) {
                        this.hFX.z(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.cEl - motionEvent.getY()) && this.hFX != null) {
                    this.hFX.bIT();
                }
                if (!this.gbf && this.gbe && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cEl - motionEvent.getY()) < 30.0f) {
                    this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.livepager.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.gbf && a.this.gbe && Math.abs(a.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(a.this.cEl - motionEvent.getY()) < 30.0f && a.this.hFX != null) {
                                a.this.hFX.bIS();
                            }
                        }
                    }, 300L);
                }
                this.gbd = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        return true;
    }

    public void setEventListener(InterfaceC0669a interfaceC0669a) {
        this.hFX = interfaceC0669a;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
}
