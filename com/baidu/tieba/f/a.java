package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes2.dex */
public class a {
    private float bkK;
    private float bkL;
    private float bkM;
    private float bkN;
    private InterfaceC0674a hrz;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.hrz.H(i, i2);
                    return true;
                case 1:
                    a.this.hrz.I(i, i2);
                    return true;
                case 2:
                    a.this.hrz.bZ(i, i2);
                    return true;
                case 3:
                    a.this.hrz.J(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0674a {
        void H(int i, int i2);

        void I(int i, int i2);

        void J(int i, int i2);

        void bZ(int i, int i2);
    }

    public void a(InterfaceC0674a interfaceC0674a) {
        this.hrz = interfaceC0674a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bkM = motionEvent.getRawX();
                this.bkN = motionEvent.getRawY();
                this.bkK = this.bkM;
                this.bkL = this.bkN;
                return true;
            case 1:
            case 3:
                if (this.hrz != null) {
                    int i = (int) (this.bkK - this.bkM);
                    int i2 = (int) (this.bkL - this.bkN);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        G(i, (int) this.bkM);
                    } else {
                        bY(i, i2);
                    }
                }
                this.bkM = 0.0f;
                this.bkN = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.bkM == 0.0f || this.bkN == 0.0f) {
                    this.bkM = motionEvent.getRawX();
                    this.bkN = motionEvent.getRawY();
                    this.bkK = this.bkM;
                    this.bkL = this.bkN;
                }
                int i3 = (int) (rawY - this.bkL);
                int i4 = (int) (rawY - this.bkN);
                if (this.hrz != null) {
                    if (i3 > 0) {
                        F(i4, i3);
                    } else {
                        E(i4, i3);
                    }
                }
                this.bkK = rawX;
                this.bkL = rawY;
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

    private void bY(int i, int i2) {
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
