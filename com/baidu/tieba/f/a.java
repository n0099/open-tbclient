package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float bGS;
    private float bGT;
    private float bGU;
    private float bGV;
    private InterfaceC0711a iFs;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.iFs.G(i, i2);
                    return true;
                case 1:
                    a.this.iFs.H(i, i2);
                    return true;
                case 2:
                    a.this.iFs.ch(i, i2);
                    return true;
                case 3:
                    a.this.iFs.I(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0711a {
        void G(int i, int i2);

        void H(int i, int i2);

        void I(int i, int i2);

        void ch(int i, int i2);
    }

    public void a(InterfaceC0711a interfaceC0711a) {
        this.iFs = interfaceC0711a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bGU = motionEvent.getRawX();
                this.bGV = motionEvent.getRawY();
                this.bGS = this.bGU;
                this.bGT = this.bGV;
                return true;
            case 1:
            case 3:
                if (this.iFs != null) {
                    int i = (int) (this.bGS - this.bGU);
                    int i2 = (int) (this.bGT - this.bGV);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        F(i, (int) this.bGU);
                    } else {
                        cg(i, i2);
                    }
                }
                this.bGU = 0.0f;
                this.bGV = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.bGU == 0.0f || this.bGV == 0.0f) {
                    this.bGU = motionEvent.getRawX();
                    this.bGV = motionEvent.getRawY();
                    this.bGS = this.bGU;
                    this.bGT = this.bGV;
                }
                int i3 = (int) (rawY - this.bGT);
                int i4 = (int) (rawY - this.bGV);
                if (this.iFs != null) {
                    if (i3 > 0) {
                        E(i4, i3);
                    } else {
                        D(i4, i3);
                    }
                }
                this.bGS = rawX;
                this.bGT = rawY;
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

    private void cg(int i, int i2) {
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
