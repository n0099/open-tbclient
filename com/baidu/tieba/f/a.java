package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0146a bHv;
    private float cPp;
    private float cPq;
    private float cPr;
    private float cPs;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bHv.X(i, i2);
                    return true;
                case 1:
                    a.this.bHv.Y(i, i2);
                    return true;
                case 2:
                    a.this.bHv.Z(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0146a {
        void X(int i, int i2);

        void Y(int i, int i2);

        void Z(int i, int i2);
    }

    public void a(InterfaceC0146a interfaceC0146a) {
        this.bHv = interfaceC0146a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.cPr = motionEvent.getRawX();
                this.cPs = motionEvent.getRawY();
                this.cPp = this.cPr;
                this.cPq = this.cPs;
                return true;
            case 1:
            case 3:
                if (this.bHv != null) {
                    int i = (int) (this.cPp - this.cPr);
                    if (Math.abs(i) >= Math.abs((int) (this.cPq - this.cPs))) {
                        as(i, (int) this.cPr);
                    }
                }
                this.cPr = 0.0f;
                this.cPs = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.cPp);
                int i3 = (int) (rawY - this.cPq);
                if (this.bHv != null) {
                    if (i3 > 0) {
                        aq(i2, i3);
                    } else {
                        ar(i2, i3);
                    }
                }
                this.cPp = rawX;
                this.cPq = rawY;
                return true;
            default:
                return true;
        }
    }

    public void aq(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void ar(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void as(int i, int i2) {
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
