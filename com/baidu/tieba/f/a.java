package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float brt;
    private float bru;
    private float brv;
    private float brw;
    private InterfaceC0689a hNF;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.hNF.H(i, i2);
                    return true;
                case 1:
                    a.this.hNF.I(i, i2);
                    return true;
                case 2:
                    a.this.hNF.cc(i, i2);
                    return true;
                case 3:
                    a.this.hNF.J(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0689a {
        void H(int i, int i2);

        void I(int i, int i2);

        void J(int i, int i2);

        void cc(int i, int i2);
    }

    public void a(InterfaceC0689a interfaceC0689a) {
        this.hNF = interfaceC0689a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.brv = motionEvent.getRawX();
                this.brw = motionEvent.getRawY();
                this.brt = this.brv;
                this.bru = this.brw;
                return true;
            case 1:
            case 3:
                if (this.hNF != null) {
                    int i = (int) (this.brt - this.brv);
                    int i2 = (int) (this.bru - this.brw);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        G(i, (int) this.brv);
                    } else {
                        cb(i, i2);
                    }
                }
                this.brv = 0.0f;
                this.brw = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.brv == 0.0f || this.brw == 0.0f) {
                    this.brv = motionEvent.getRawX();
                    this.brw = motionEvent.getRawY();
                    this.brt = this.brv;
                    this.bru = this.brw;
                }
                int i3 = (int) (rawY - this.bru);
                int i4 = (int) (rawY - this.brw);
                if (this.hNF != null) {
                    if (i3 > 0) {
                        F(i4, i3);
                    } else {
                        E(i4, i3);
                    }
                }
                this.brt = rawX;
                this.bru = rawY;
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

    private void cb(int i, int i2) {
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
