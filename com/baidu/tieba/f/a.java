package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0145a bKc;
    private float cPS;
    private float cPT;
    private float cPU;
    private float cPV;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bKc.Y(i, i2);
                    return true;
                case 1:
                    a.this.bKc.Z(i, i2);
                    return true;
                case 2:
                    a.this.bKc.aa(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0145a {
        void Y(int i, int i2);

        void Z(int i, int i2);

        void aa(int i, int i2);
    }

    public void a(InterfaceC0145a interfaceC0145a) {
        this.bKc = interfaceC0145a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.cPU = motionEvent.getRawX();
                this.cPV = motionEvent.getRawY();
                this.cPS = this.cPU;
                this.cPT = this.cPV;
                return true;
            case 1:
            case 3:
                if (this.bKc != null) {
                    int i = (int) (this.cPS - this.cPU);
                    if (Math.abs(i) >= Math.abs((int) (this.cPT - this.cPV))) {
                        au(i, (int) this.cPU);
                    }
                }
                this.cPU = 0.0f;
                this.cPV = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.cPS);
                int i3 = (int) (rawY - this.cPT);
                if (this.bKc != null) {
                    if (i3 > 0) {
                        as(i2, i3);
                    } else {
                        at(i2, i3);
                    }
                }
                this.cPS = rawX;
                this.cPT = rawY;
                return true;
            default:
                return true;
        }
    }

    public void as(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void at(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void au(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }
}
