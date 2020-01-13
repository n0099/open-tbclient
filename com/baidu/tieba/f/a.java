package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float atV;
    private float atW;
    private InterfaceC0492a fPc;
    private float mLastTouchX;
    private float mLastTouchY;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.fPc.y(i, i2);
                    return true;
                case 1:
                    a.this.fPc.z(i, i2);
                    return true;
                case 2:
                    a.this.fPc.bz(i, i2);
                    return true;
                case 3:
                    a.this.fPc.A(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0492a {
        void A(int i, int i2);

        void bz(int i, int i2);

        void y(int i, int i2);

        void z(int i, int i2);
    }

    public void a(InterfaceC0492a interfaceC0492a) {
        this.fPc = interfaceC0492a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.atV = motionEvent.getRawX();
                this.atW = motionEvent.getRawY();
                this.mLastTouchX = this.atV;
                this.mLastTouchY = this.atW;
                return true;
            case 1:
            case 3:
                if (this.fPc != null) {
                    int i = (int) (this.mLastTouchX - this.atV);
                    int i2 = (int) (this.mLastTouchY - this.atW);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        x(i, (int) this.atV);
                    } else {
                        by(i, i2);
                    }
                }
                this.atV = 0.0f;
                this.atW = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.atV == 0.0f || this.atW == 0.0f) {
                    this.atV = motionEvent.getRawX();
                    this.atW = motionEvent.getRawY();
                    this.mLastTouchX = this.atV;
                    this.mLastTouchY = this.atW;
                }
                int i3 = (int) (rawY - this.mLastTouchY);
                int i4 = (int) (rawY - this.atW);
                if (this.fPc != null) {
                    if (i3 > 0) {
                        w(i4, i3);
                    } else {
                        v(i4, i3);
                    }
                }
                this.mLastTouchX = rawX;
                this.mLastTouchY = rawY;
                return true;
            default:
                return true;
        }
    }

    private void v(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void w(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void by(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void x(int i, int i2) {
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
