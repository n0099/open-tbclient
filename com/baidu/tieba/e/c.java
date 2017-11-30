package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class c {
    private float EP;
    private View.OnLongClickListener avA;
    private float bKr;
    private b cra;
    private InterfaceC0085c crb;
    private MotionEvent crd;
    private a cre;
    private MotionEvent mCurrentDownEvent;
    private int mDoubleTapSlopSquare;
    private boolean mInLongPress;
    private boolean mIsDoubleTapping;
    private float mLastMotionX;
    private float mLastMotionY;
    private View.OnClickListener mOnClickListener;
    private MotionEvent mPreviousUpEvent;
    private boolean mStillDown;
    private VelocityTracker mVelocityTracker;
    private final View mView;
    private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    private int mActivePointerId = -1;
    private boolean cqZ = false;

    /* loaded from: classes.dex */
    public interface b {
        void ak(View view);
    }

    /* renamed from: com.baidu.tieba.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0085c {
        void al(View view);

        void am(View view);

        void an(View view);

        void ao(View view);
    }

    public MotionEvent agh() {
        return this.crd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    return;
                case 2:
                    c.this.dispatchLongPress();
                    if (!c.this.cqZ) {
                        c.this.performLongClick();
                        return;
                    }
                    return;
                case 3:
                    if (!c.this.mStillDown && !c.this.cqZ) {
                        c.this.performClick();
                        return;
                    }
                    return;
                default:
                    throw new RuntimeException("Unknown message " + message);
            }
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(InterfaceC0085c interfaceC0085c) {
        this.crb = interfaceC0085c;
    }

    public c(View view) {
        if (view == null) {
            throw new NullPointerException("view is null");
        }
        this.mView = view;
        this.mView.setOnClickListener(null);
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
        this.cre = new a();
        this.mDoubleTapSlopSquare = 10000;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getPointerCount() > 1) {
            cancel();
        } else {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.crd = MotionEvent.obtain(motionEvent);
                    this.cqZ = false;
                    x(motionEvent);
                    boolean hasMessages = this.cre.hasMessages(3);
                    if (hasMessages) {
                        this.cre.removeMessages(3);
                    }
                    if (this.cra != null && this.mCurrentDownEvent != null && this.mPreviousUpEvent != null && hasMessages && isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, motionEvent)) {
                        this.mIsDoubleTapping = true;
                    } else {
                        this.cre.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
                    }
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mLastMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.EP = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.bKr = MotionEventCompat.getY(motionEvent, actionIndex);
                    if (this.mCurrentDownEvent != null) {
                        this.mCurrentDownEvent.recycle();
                    }
                    this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                    this.mStillDown = true;
                    this.mInLongPress = false;
                    if (this.avA != null) {
                        this.cre.removeMessages(2);
                        this.cre.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
                    }
                    this.cre.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
                    break;
                case 1:
                    this.mStillDown = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.mIsDoubleTapping) {
                        if (!this.cqZ) {
                            agj();
                        }
                    } else if (this.mInLongPress) {
                        this.cre.removeMessages(3);
                        this.mInLongPress = false;
                    }
                    if (this.mPreviousUpEvent != null) {
                        this.mPreviousUpEvent.recycle();
                    }
                    this.mPreviousUpEvent = obtain;
                    this.mIsDoubleTapping = false;
                    this.cre.removeMessages(1);
                    this.cre.removeMessages(2);
                    endDrag();
                    break;
                case 2:
                    if (!a(motionEvent, b(motionEvent, this.mActivePointerId), this.mActivePointerId)) {
                        x(motionEvent);
                        g(motionEvent);
                        break;
                    }
                    break;
                case 3:
                    cancel();
                    break;
            }
        }
        return false;
    }

    private void cancel() {
        agi();
        lj();
        this.mIsDoubleTapping = false;
        this.mStillDown = false;
        this.cqZ = false;
        this.mActivePointerId = -1;
        if (this.mInLongPress) {
            this.mInLongPress = false;
        }
    }

    private void agi() {
        this.cre.removeMessages(1);
        this.cre.removeMessages(2);
        this.cre.removeMessages(3);
    }

    private void Lg() {
        this.mIsDoubleTapping = false;
        this.mStillDown = false;
        this.mInLongPress = false;
        agi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLongPress() {
        this.cre.removeMessages(3);
        this.mInLongPress = true;
    }

    public boolean performLongClick() {
        if (this.avA != null) {
            this.avA.onLongClick(this.mView);
            this.crd = null;
            return true;
        }
        return false;
    }

    public boolean performClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mView);
            this.crd = null;
            return true;
        }
        return false;
    }

    public boolean agj() {
        if (this.cra != null) {
            this.cra.ak(this.mView);
            this.crd = null;
            return true;
        }
        return false;
    }

    private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (motionEvent3.getEventTime() - motionEvent2.getEventTime() > DOUBLE_TAP_TIMEOUT) {
            return false;
        }
        int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        return (x * x) + (y * y) < this.mDoubleTapSlopSquare;
    }

    private void endDrag() {
        this.cqZ = false;
        this.mActivePointerId = -1;
        lj();
    }

    private void x(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void lj() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void g(MotionEvent motionEvent) {
        if (!this.cqZ) {
            int i = this.mActivePointerId;
            int b2 = b(motionEvent, i);
            if (!a(motionEvent, b2, i)) {
                float x = MotionEventCompat.getX(motionEvent, b2);
                float f = x - this.mLastMotionX;
                float abs = Math.abs(f);
                float y = MotionEventCompat.getY(motionEvent, b2);
                float f2 = y - this.mLastMotionY;
                float abs2 = Math.abs(f2);
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                }
                float xVelocity = this.mVelocityTracker.getXVelocity();
                float yVelocity = this.mVelocityTracker.getYVelocity();
                float abs3 = Math.abs(xVelocity);
                if (Math.abs(yVelocity) > 200.0f && abs2 > abs && abs2 > 30.0f) {
                    if (f2 > 0.0f) {
                        if (this.crb != null) {
                            this.crb.al(this.mView);
                        }
                    } else if (this.crb != null) {
                        this.crb.am(this.mView);
                    }
                    this.cqZ = true;
                    this.mLastMotionX = x;
                    this.mLastMotionY = y;
                    Lg();
                } else if (abs3 > 200.0f && abs > abs2 && abs > 30.0f) {
                    if (f > 0.0f) {
                        if (this.crb != null) {
                            this.crb.ao(this.mView);
                        }
                    } else if (this.crb != null) {
                        this.crb.an(this.mView);
                    }
                    this.mLastMotionX = x;
                    this.mLastMotionY = y;
                    this.cqZ = true;
                    Lg();
                }
            }
        }
    }

    private int b(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private boolean a(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }
}
