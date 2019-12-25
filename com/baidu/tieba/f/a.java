package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float atj;
    private float atk;
    private InterfaceC0488a fLT;
    private float mLastTouchX;
    private float mLastTouchY;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.fLT.u(i, i2);
                    return true;
                case 1:
                    a.this.fLT.v(i, i2);
                    return true;
                case 2:
                    a.this.fLT.bA(i, i2);
                    return true;
                case 3:
                    a.this.fLT.w(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0488a {
        void bA(int i, int i2);

        void u(int i, int i2);

        void v(int i, int i2);

        void w(int i, int i2);
    }

    public void a(InterfaceC0488a interfaceC0488a) {
        this.fLT = interfaceC0488a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.atj = motionEvent.getRawX();
                this.atk = motionEvent.getRawY();
                this.mLastTouchX = this.atj;
                this.mLastTouchY = this.atk;
                return true;
            case 1:
            case 3:
                if (this.fLT != null) {
                    int i = (int) (this.mLastTouchX - this.atj);
                    int i2 = (int) (this.mLastTouchY - this.atk);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        t(i, (int) this.atj);
                    } else {
                        bz(i, i2);
                    }
                }
                this.atj = 0.0f;
                this.atk = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.atj == 0.0f || this.atk == 0.0f) {
                    this.atj = motionEvent.getRawX();
                    this.atk = motionEvent.getRawY();
                    this.mLastTouchX = this.atj;
                    this.mLastTouchY = this.atk;
                }
                int i3 = (int) (rawY - this.mLastTouchY);
                int i4 = (int) (rawY - this.atk);
                if (this.fLT != null) {
                    if (i3 > 0) {
                        s(i4, i3);
                    } else {
                        r(i4, i3);
                    }
                }
                this.mLastTouchX = rawX;
                this.mLastTouchY = rawY;
                return true;
            default:
                return true;
        }
    }

    private void r(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void s(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void bz(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void t(int i, int i2) {
        this.mHandler.removeMessages(3);
        if (!this.mHandler.hasMessages(3)) {
            Message message = new Message();
            message.what = 3;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }
}
