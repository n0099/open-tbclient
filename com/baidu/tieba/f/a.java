package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float ayB;
    private float ayC;
    private InterfaceC0499a fSv;
    private float mLastTouchX;
    private float mLastTouchY;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.fSv.z(i, i2);
                    return true;
                case 1:
                    a.this.fSv.A(i, i2);
                    return true;
                case 2:
                    a.this.fSv.bB(i, i2);
                    return true;
                case 3:
                    a.this.fSv.B(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0499a {
        void A(int i, int i2);

        void B(int i, int i2);

        void bB(int i, int i2);

        void z(int i, int i2);
    }

    public void a(InterfaceC0499a interfaceC0499a) {
        this.fSv = interfaceC0499a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ayB = motionEvent.getRawX();
                this.ayC = motionEvent.getRawY();
                this.mLastTouchX = this.ayB;
                this.mLastTouchY = this.ayC;
                return true;
            case 1:
            case 3:
                if (this.fSv != null) {
                    int i = (int) (this.mLastTouchX - this.ayB);
                    int i2 = (int) (this.mLastTouchY - this.ayC);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        y(i, (int) this.ayB);
                    } else {
                        bA(i, i2);
                    }
                }
                this.ayB = 0.0f;
                this.ayC = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.ayB == 0.0f || this.ayC == 0.0f) {
                    this.ayB = motionEvent.getRawX();
                    this.ayC = motionEvent.getRawY();
                    this.mLastTouchX = this.ayB;
                    this.mLastTouchY = this.ayC;
                }
                int i3 = (int) (rawY - this.mLastTouchY);
                int i4 = (int) (rawY - this.ayC);
                if (this.fSv != null) {
                    if (i3 > 0) {
                        x(i4, i3);
                    } else {
                        w(i4, i3);
                    }
                }
                this.mLastTouchX = rawX;
                this.mLastTouchY = rawY;
                return true;
            default:
                return true;
        }
    }

    private void w(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void x(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void bA(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void y(int i, int i2) {
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
