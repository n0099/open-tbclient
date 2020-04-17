package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float aSg;
    private float aSh;
    private float aSi;
    private float aSj;
    private InterfaceC0536a gxd;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.gxd.y(i, i2);
                    return true;
                case 1:
                    a.this.gxd.z(i, i2);
                    return true;
                case 2:
                    a.this.gxd.bG(i, i2);
                    return true;
                case 3:
                    a.this.gxd.A(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0536a {
        void A(int i, int i2);

        void bG(int i, int i2);

        void y(int i, int i2);

        void z(int i, int i2);
    }

    public void a(InterfaceC0536a interfaceC0536a) {
        this.gxd = interfaceC0536a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aSi = motionEvent.getRawX();
                this.aSj = motionEvent.getRawY();
                this.aSg = this.aSi;
                this.aSh = this.aSj;
                return true;
            case 1:
            case 3:
                if (this.gxd != null) {
                    int i = (int) (this.aSg - this.aSi);
                    int i2 = (int) (this.aSh - this.aSj);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        x(i, (int) this.aSi);
                    } else {
                        bF(i, i2);
                    }
                }
                this.aSi = 0.0f;
                this.aSj = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.aSi == 0.0f || this.aSj == 0.0f) {
                    this.aSi = motionEvent.getRawX();
                    this.aSj = motionEvent.getRawY();
                    this.aSg = this.aSi;
                    this.aSh = this.aSj;
                }
                int i3 = (int) (rawY - this.aSh);
                int i4 = (int) (rawY - this.aSj);
                if (this.gxd != null) {
                    if (i3 > 0) {
                        w(i4, i3);
                    } else {
                        v(i4, i3);
                    }
                }
                this.aSg = rawX;
                this.aSh = rawY;
                return true;
            default:
                return true;
        }
    }

    private void v(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void w(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void bF(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void x(int i, int i2) {
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
