package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0214a cxC;
    private float dpq;
    private float dpr;
    private float dps;
    private float dpt;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.cxC.ar(i, i2);
                    return true;
                case 1:
                    a.this.cxC.as(i, i2);
                    return true;
                case 2:
                    a.this.cxC.at(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0214a {
        void ar(int i, int i2);

        void as(int i, int i2);

        void at(int i, int i2);
    }

    public void a(InterfaceC0214a interfaceC0214a) {
        this.cxC = interfaceC0214a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.dps = motionEvent.getRawX();
                this.dpt = motionEvent.getRawY();
                this.dpq = this.dps;
                this.dpr = this.dpt;
                return true;
            case 1:
            case 3:
                if (this.cxC != null) {
                    int i = (int) (this.dpq - this.dps);
                    if (Math.abs(i) >= Math.abs((int) (this.dpr - this.dpt))) {
                        aF(i, (int) this.dps);
                    }
                }
                this.dps = 0.0f;
                this.dpt = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.dpq);
                int i3 = (int) (rawY - this.dpr);
                if (this.cxC != null) {
                    if (i3 > 0) {
                        aD(i2, i3);
                    } else {
                        aE(i2, i3);
                    }
                }
                this.dpq = rawX;
                this.dpr = rawY;
                return true;
            default:
                return true;
        }
    }

    public void aD(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void aE(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void aF(int i, int i2) {
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
