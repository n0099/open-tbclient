package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float bHU;
    private float bHV;
    private float bHW;
    private float bHX;
    private InterfaceC0727a iEb;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.iEb.G(i, i2);
                    return true;
                case 1:
                    a.this.iEb.H(i, i2);
                    return true;
                case 2:
                    a.this.iEb.cj(i, i2);
                    return true;
                case 3:
                    a.this.iEb.I(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0727a {
        void G(int i, int i2);

        void H(int i, int i2);

        void I(int i, int i2);

        void cj(int i, int i2);
    }

    public void a(InterfaceC0727a interfaceC0727a) {
        this.iEb = interfaceC0727a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bHW = motionEvent.getRawX();
                this.bHX = motionEvent.getRawY();
                this.bHU = this.bHW;
                this.bHV = this.bHX;
                return true;
            case 1:
            case 3:
                if (this.iEb != null) {
                    int i = (int) (this.bHU - this.bHW);
                    int i2 = (int) (this.bHV - this.bHX);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        F(i, (int) this.bHW);
                    } else {
                        ci(i, i2);
                    }
                }
                this.bHW = 0.0f;
                this.bHX = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.bHW == 0.0f || this.bHX == 0.0f) {
                    this.bHW = motionEvent.getRawX();
                    this.bHX = motionEvent.getRawY();
                    this.bHU = this.bHW;
                    this.bHV = this.bHX;
                }
                int i3 = (int) (rawY - this.bHV);
                int i4 = (int) (rawY - this.bHX);
                if (this.iEb != null) {
                    if (i3 > 0) {
                        E(i4, i3);
                    } else {
                        D(i4, i3);
                    }
                }
                this.bHU = rawX;
                this.bHV = rawY;
                return true;
            default:
                return true;
        }
    }

    private void D(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void E(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void ci(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void F(int i, int i2) {
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
