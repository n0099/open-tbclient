package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float aSl;
    private float aSm;
    private float aSn;
    private float aSo;
    private InterfaceC0557a gxj;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.gxj.y(i, i2);
                    return true;
                case 1:
                    a.this.gxj.z(i, i2);
                    return true;
                case 2:
                    a.this.gxj.bG(i, i2);
                    return true;
                case 3:
                    a.this.gxj.A(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0557a {
        void A(int i, int i2);

        void bG(int i, int i2);

        void y(int i, int i2);

        void z(int i, int i2);
    }

    public void a(InterfaceC0557a interfaceC0557a) {
        this.gxj = interfaceC0557a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aSn = motionEvent.getRawX();
                this.aSo = motionEvent.getRawY();
                this.aSl = this.aSn;
                this.aSm = this.aSo;
                return true;
            case 1:
            case 3:
                if (this.gxj != null) {
                    int i = (int) (this.aSl - this.aSn);
                    int i2 = (int) (this.aSm - this.aSo);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        x(i, (int) this.aSn);
                    } else {
                        bF(i, i2);
                    }
                }
                this.aSn = 0.0f;
                this.aSo = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.aSn == 0.0f || this.aSo == 0.0f) {
                    this.aSn = motionEvent.getRawX();
                    this.aSo = motionEvent.getRawY();
                    this.aSl = this.aSn;
                    this.aSm = this.aSo;
                }
                int i3 = (int) (rawY - this.aSm);
                int i4 = (int) (rawY - this.aSo);
                if (this.gxj != null) {
                    if (i3 > 0) {
                        w(i4, i3);
                    } else {
                        v(i4, i3);
                    }
                }
                this.aSl = rawX;
                this.aSm = rawY;
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
