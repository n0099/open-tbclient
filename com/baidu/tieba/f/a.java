package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0243a dMw;
    private float ezn;
    private float ezo;
    private float ezp;
    private float ezq;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.dMw.aR(i, i2);
                    return true;
                case 1:
                    a.this.dMw.aS(i, i2);
                    return true;
                case 2:
                    a.this.dMw.aT(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0243a {
        void aR(int i, int i2);

        void aS(int i, int i2);

        void aT(int i, int i2);
    }

    public void a(InterfaceC0243a interfaceC0243a) {
        this.dMw = interfaceC0243a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ezp = motionEvent.getRawX();
                this.ezq = motionEvent.getRawY();
                this.ezn = this.ezp;
                this.ezo = this.ezq;
                return true;
            case 1:
            case 3:
                if (this.dMw != null) {
                    int i = (int) (this.ezn - this.ezp);
                    if (Math.abs(i) >= Math.abs((int) (this.ezo - this.ezq))) {
                        bd(i, (int) this.ezp);
                    }
                }
                this.ezp = 0.0f;
                this.ezq = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.ezn);
                int i3 = (int) (rawY - this.ezo);
                if (this.dMw != null) {
                    if (i3 > 0) {
                        bb(i2, i3);
                    } else {
                        bc(i2, i3);
                    }
                }
                this.ezn = rawX;
                this.ezo = rawY;
                return true;
            default:
                return true;
        }
    }

    public void bb(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void bc(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void bd(int i, int i2) {
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
