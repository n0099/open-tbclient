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
    private View.OnLongClickListener avI;
    private float bKz;
    private b cro;
    private InterfaceC0098c crp;
    private MotionEvent crq;
    private a crr;
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
    private boolean crn = false;

    /* loaded from: classes.dex */
    public interface b {
        void am(View view);
    }

    /* renamed from: com.baidu.tieba.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0098c {
        void an(View view);

        void ao(View view);

        void ap(View view);

        void aq(View view);
    }

    public MotionEvent ago() {
        return this.crq;
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
                    if (!c.this.crn) {
                        c.this.performLongClick();
                        return;
                    }
                    return;
                case 3:
                    if (!c.this.mStillDown && !c.this.crn) {
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

    public void a(InterfaceC0098c interfaceC0098c) {
        this.crp = interfaceC0098c;
    }

    public c(View view) {
        if (view == null) {
            throw new NullPointerException("view is null");
        }
        this.mView = view;
        this.mView.setOnClickListener(null);
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
        this.crr = new a();
        this.mDoubleTapSlopSquare = 10000;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getPointerCount() > 1) {
            cancel();
        } else {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.crq = MotionEvent.obtain(motionEvent);
                    this.crn = false;
                    x(motionEvent);
                    boolean hasMessages = this.crr.hasMessages(3);
                    if (hasMessages) {
                        this.crr.removeMessages(3);
                    }
                    if (this.cro != null && this.mCurrentDownEvent != null && this.mPreviousUpEvent != null && hasMessages && isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, motionEvent)) {
                        this.mIsDoubleTapping = true;
                    } else {
                        this.crr.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
                    }
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mLastMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.EP = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.bKz = MotionEventCompat.getY(motionEvent, actionIndex);
                    if (this.mCurrentDownEvent != null) {
                        this.mCurrentDownEvent.recycle();
                    }
                    this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                    this.mStillDown = true;
                    this.mInLongPress = false;
                    if (this.avI != null) {
                        this.crr.removeMessages(2);
                        this.crr.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
                    }
                    this.crr.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
                    break;
                case 1:
                    this.mStillDown = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.mIsDoubleTapping) {
                        if (!this.crn) {
                            agq();
                        }
                    } else if (this.mInLongPress) {
                        this.crr.removeMessages(3);
                        this.mInLongPress = false;
                    }
                    if (this.mPreviousUpEvent != null) {
                        this.mPreviousUpEvent.recycle();
                    }
                    this.mPreviousUpEvent = obtain;
                    this.mIsDoubleTapping = false;
                    this.crr.removeMessages(1);
                    this.crr.removeMessages(2);
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
        agp();
        lj();
        this.mIsDoubleTapping = false;
        this.mStillDown = false;
        this.crn = false;
        this.mActivePointerId = -1;
        if (this.mInLongPress) {
            this.mInLongPress = false;
        }
    }

    private void agp() {
        this.crr.removeMessages(1);
        this.crr.removeMessages(2);
        this.crr.removeMessages(3);
    }

    private void Lg() {
        this.mIsDoubleTapping = false;
        this.mStillDown = false;
        this.mInLongPress = false;
        agp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLongPress() {
        this.crr.removeMessages(3);
        this.mInLongPress = true;
    }

    public boolean performLongClick() {
        if (this.avI != null) {
            this.avI.onLongClick(this.mView);
            this.crq = null;
            return true;
        }
        return false;
    }

    public boolean performClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mView);
            this.crq = null;
            return true;
        }
        return false;
    }

    public boolean agq() {
        if (this.cro != null) {
            this.cro.am(this.mView);
            this.crq = null;
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
        this.crn = false;
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
        if (!this.crn) {
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
                        if (this.crp != null) {
                            this.crp.an(this.mView);
                        }
                    } else if (this.crp != null) {
                        this.crp.ao(this.mView);
                    }
                    this.crn = true;
                    this.mLastMotionX = x;
                    this.mLastMotionY = y;
                    Lg();
                } else if (abs3 > 200.0f && abs > abs2 && abs > 30.0f) {
                    if (f > 0.0f) {
                        if (this.crp != null) {
                            this.crp.aq(this.mView);
                        }
                    } else if (this.crp != null) {
                        this.crp.ap(this.mView);
                    }
                    this.mLastMotionX = x;
                    this.mLastMotionY = y;
                    this.crn = true;
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
