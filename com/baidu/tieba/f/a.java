package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0144a bKb;
    private float cPP;
    private float cPQ;
    private float cPR;
    private float cPS;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bKb.Y(i, i2);
                    return true;
                case 1:
                    a.this.bKb.Z(i, i2);
                    return true;
                case 2:
                    a.this.bKb.aa(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0144a {
        void Y(int i, int i2);

        void Z(int i, int i2);

        void aa(int i, int i2);
    }

    public void a(InterfaceC0144a interfaceC0144a) {
        this.bKb = interfaceC0144a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.cPR = motionEvent.getRawX();
                this.cPS = motionEvent.getRawY();
                this.cPP = this.cPR;
                this.cPQ = this.cPS;
                return true;
            case 1:
            case 3:
                if (this.bKb != null) {
                    int i = (int) (this.cPP - this.cPR);
                    if (Math.abs(i) >= Math.abs((int) (this.cPQ - this.cPS))) {
                        au(i, (int) this.cPR);
                    }
                }
                this.cPR = 0.0f;
                this.cPS = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.cPP);
                int i3 = (int) (rawY - this.cPQ);
                if (this.bKb != null) {
                    if (i3 > 0) {
                        as(i2, i3);
                    } else {
                        at(i2, i3);
                    }
                }
                this.cPP = rawX;
                this.cPQ = rawY;
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
