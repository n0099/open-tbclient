package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float bkN;
    private float bkO;
    private float bkP;
    private float bkQ;
    private InterfaceC0674a hrF;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.hrF.H(i, i2);
                    return true;
                case 1:
                    a.this.hrF.I(i, i2);
                    return true;
                case 2:
                    a.this.hrF.bZ(i, i2);
                    return true;
                case 3:
                    a.this.hrF.J(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0674a {
        void H(int i, int i2);

        void I(int i, int i2);

        void J(int i, int i2);

        void bZ(int i, int i2);
    }

    public void a(InterfaceC0674a interfaceC0674a) {
        this.hrF = interfaceC0674a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bkP = motionEvent.getRawX();
                this.bkQ = motionEvent.getRawY();
                this.bkN = this.bkP;
                this.bkO = this.bkQ;
                return true;
            case 1:
            case 3:
                if (this.hrF != null) {
                    int i = (int) (this.bkN - this.bkP);
                    int i2 = (int) (this.bkO - this.bkQ);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        G(i, (int) this.bkP);
                    } else {
                        bY(i, i2);
                    }
                }
                this.bkP = 0.0f;
                this.bkQ = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.bkP == 0.0f || this.bkQ == 0.0f) {
                    this.bkP = motionEvent.getRawX();
                    this.bkQ = motionEvent.getRawY();
                    this.bkN = this.bkP;
                    this.bkO = this.bkQ;
                }
                int i3 = (int) (rawY - this.bkO);
                int i4 = (int) (rawY - this.bkQ);
                if (this.hrF != null) {
                    if (i3 > 0) {
                        F(i4, i3);
                    } else {
                        E(i4, i3);
                    }
                }
                this.bkN = rawX;
                this.bkO = rawY;
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
