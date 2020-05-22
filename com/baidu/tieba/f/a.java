package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float aZA;
    private float aZB;
    private float aZC;
    private float aZz;
    private InterfaceC0607a gLT;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.gLT.B(i, i2);
                    return true;
                case 1:
                    a.this.gLT.C(i, i2);
                    return true;
                case 2:
                    a.this.gLT.bK(i, i2);
                    return true;
                case 3:
                    a.this.gLT.D(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0607a {
        void B(int i, int i2);

        void C(int i, int i2);

        void D(int i, int i2);

        void bK(int i, int i2);
    }

    public void a(InterfaceC0607a interfaceC0607a) {
        this.gLT = interfaceC0607a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aZB = motionEvent.getRawX();
                this.aZC = motionEvent.getRawY();
                this.aZz = this.aZB;
                this.aZA = this.aZC;
                return true;
            case 1:
            case 3:
                if (this.gLT != null) {
                    int i = (int) (this.aZz - this.aZB);
                    int i2 = (int) (this.aZA - this.aZC);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        A(i, (int) this.aZB);
                    } else {
                        bJ(i, i2);
                    }
                }
                this.aZB = 0.0f;
                this.aZC = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.aZB == 0.0f || this.aZC == 0.0f) {
                    this.aZB = motionEvent.getRawX();
                    this.aZC = motionEvent.getRawY();
                    this.aZz = this.aZB;
                    this.aZA = this.aZC;
                }
                int i3 = (int) (rawY - this.aZA);
                int i4 = (int) (rawY - this.aZC);
                if (this.gLT != null) {
                    if (i3 > 0) {
                        z(i4, i3);
                    } else {
                        y(i4, i3);
                    }
                }
                this.aZz = rawX;
                this.aZA = rawY;
                return true;
            default:
                return true;
        }
    }

    private void y(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void z(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void bJ(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void A(int i, int i2) {
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
