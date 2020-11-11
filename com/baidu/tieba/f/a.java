package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float bzL;
    private float bzM;
    private float bzN;
    private float bzO;
    private InterfaceC0719a igd;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.igd.H(i, i2);
                    return true;
                case 1:
                    a.this.igd.I(i, i2);
                    return true;
                case 2:
                    a.this.igd.cg(i, i2);
                    return true;
                case 3:
                    a.this.igd.J(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0719a {
        void H(int i, int i2);

        void I(int i, int i2);

        void J(int i, int i2);

        void cg(int i, int i2);
    }

    public void a(InterfaceC0719a interfaceC0719a) {
        this.igd = interfaceC0719a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bzN = motionEvent.getRawX();
                this.bzO = motionEvent.getRawY();
                this.bzL = this.bzN;
                this.bzM = this.bzO;
                return true;
            case 1:
            case 3:
                if (this.igd != null) {
                    int i = (int) (this.bzL - this.bzN);
                    int i2 = (int) (this.bzM - this.bzO);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        G(i, (int) this.bzN);
                    } else {
                        cf(i, i2);
                    }
                }
                this.bzN = 0.0f;
                this.bzO = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.bzN == 0.0f || this.bzO == 0.0f) {
                    this.bzN = motionEvent.getRawX();
                    this.bzO = motionEvent.getRawY();
                    this.bzL = this.bzN;
                    this.bzM = this.bzO;
                }
                int i3 = (int) (rawY - this.bzM);
                int i4 = (int) (rawY - this.bzO);
                if (this.igd != null) {
                    if (i3 > 0) {
                        F(i4, i3);
                    } else {
                        E(i4, i3);
                    }
                }
                this.bzL = rawX;
                this.bzM = rawY;
                return true;
            default:
                return true;
        }
    }

    private void E(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void F(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void cf(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void G(int i, int i2) {
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
