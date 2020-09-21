package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float bnG;
    private float bnH;
    private float bnI;
    private float bnJ;
    private InterfaceC0671a hyK;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.hyK.H(i, i2);
                    return true;
                case 1:
                    a.this.hyK.I(i, i2);
                    return true;
                case 2:
                    a.this.hyK.cc(i, i2);
                    return true;
                case 3:
                    a.this.hyK.J(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0671a {
        void H(int i, int i2);

        void I(int i, int i2);

        void J(int i, int i2);

        void cc(int i, int i2);
    }

    public void a(InterfaceC0671a interfaceC0671a) {
        this.hyK = interfaceC0671a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bnI = motionEvent.getRawX();
                this.bnJ = motionEvent.getRawY();
                this.bnG = this.bnI;
                this.bnH = this.bnJ;
                return true;
            case 1:
            case 3:
                if (this.hyK != null) {
                    int i = (int) (this.bnG - this.bnI);
                    int i2 = (int) (this.bnH - this.bnJ);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        G(i, (int) this.bnI);
                    } else {
                        cb(i, i2);
                    }
                }
                this.bnI = 0.0f;
                this.bnJ = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.bnI == 0.0f || this.bnJ == 0.0f) {
                    this.bnI = motionEvent.getRawX();
                    this.bnJ = motionEvent.getRawY();
                    this.bnG = this.bnI;
                    this.bnH = this.bnJ;
                }
                int i3 = (int) (rawY - this.bnH);
                int i4 = (int) (rawY - this.bnJ);
                if (this.hyK != null) {
                    if (i3 > 0) {
                        F(i4, i3);
                    } else {
                        E(i4, i3);
                    }
                }
                this.bnG = rawX;
                this.bnH = rawY;
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
