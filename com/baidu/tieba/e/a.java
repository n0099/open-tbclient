package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0143a cod;
    private float dnk;
    private float dnl;
    private float dnm;
    private float dnn;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.e.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.cod.aY(i, i2);
                    return true;
                case 1:
                    a.this.cod.aZ(i, i2);
                    return true;
                case 2:
                    a.this.cod.ba(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0143a {
        void aY(int i, int i2);

        void aZ(int i, int i2);

        void ba(int i, int i2);
    }

    public void a(InterfaceC0143a interfaceC0143a) {
        this.cod = interfaceC0143a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.dnm = motionEvent.getRawX();
                this.dnn = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.cod != null) {
                    int i = (int) (this.dnk - this.dnm);
                    if (Math.abs(i) >= Math.abs((int) (this.dnl - this.dnn))) {
                        bo(i, (int) this.dnm);
                    }
                }
                this.dnm = 0.0f;
                this.dnn = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.dnk);
                int i3 = (int) (rawY - this.dnl);
                if (this.cod != null) {
                    if (i3 > 0) {
                        bm(i2, i3);
                    } else {
                        bn(i2, i3);
                    }
                }
                this.dnk = rawX;
                this.dnl = rawY;
                return true;
            default:
                return true;
        }
    }

    public void bm(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void bn(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void bo(int i, int i2) {
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
