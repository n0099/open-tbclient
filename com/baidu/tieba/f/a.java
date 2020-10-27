package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float btA;
    private float btB;
    private float btC;
    private float btz;
    private InterfaceC0705a iac;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.iac.H(i, i2);
                    return true;
                case 1:
                    a.this.iac.I(i, i2);
                    return true;
                case 2:
                    a.this.iac.ce(i, i2);
                    return true;
                case 3:
                    a.this.iac.J(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0705a {
        void H(int i, int i2);

        void I(int i, int i2);

        void J(int i, int i2);

        void ce(int i, int i2);
    }

    public void a(InterfaceC0705a interfaceC0705a) {
        this.iac = interfaceC0705a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.btB = motionEvent.getRawX();
                this.btC = motionEvent.getRawY();
                this.btz = this.btB;
                this.btA = this.btC;
                return true;
            case 1:
            case 3:
                if (this.iac != null) {
                    int i = (int) (this.btz - this.btB);
                    int i2 = (int) (this.btA - this.btC);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        G(i, (int) this.btB);
                    } else {
                        cd(i, i2);
                    }
                }
                this.btB = 0.0f;
                this.btC = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.btB == 0.0f || this.btC == 0.0f) {
                    this.btB = motionEvent.getRawX();
                    this.btC = motionEvent.getRawY();
                    this.btz = this.btB;
                    this.btA = this.btC;
                }
                int i3 = (int) (rawY - this.btA);
                int i4 = (int) (rawY - this.btC);
                if (this.iac != null) {
                    if (i3 > 0) {
                        F(i4, i3);
                    } else {
                        E(i4, i3);
                    }
                }
                this.btz = rawX;
                this.btA = rawY;
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

    private void cd(int i, int i2) {
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
