package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0081a bzM;
    private float cil;
    private float cim;
    private float cin;
    private float cio;
    private Handler.Callback aWv = new Handler.Callback() { // from class: com.baidu.tieba.e.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bzM.ag(i, i2);
                    return true;
                case 1:
                    a.this.bzM.ah(i, i2);
                    return true;
                case 2:
                    a.this.bzM.ai(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.aWv);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0081a {
        void ag(int i, int i2);

        void ah(int i, int i2);

        void ai(int i, int i2);
    }

    public void a(InterfaceC0081a interfaceC0081a) {
        this.bzM = interfaceC0081a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.cin = motionEvent.getRawX();
                this.cio = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.bzM != null) {
                    int i = (int) (this.cil - this.cin);
                    if (Math.abs(i) >= Math.abs((int) (this.cim - this.cio))) {
                        ar(i, (int) this.cin);
                    }
                }
                this.cin = 0.0f;
                this.cio = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.cil);
                int i3 = (int) (rawY - this.cim);
                if (this.bzM != null) {
                    if (i3 > 0) {
                        ap(i2, i3);
                    } else {
                        aq(i2, i3);
                    }
                }
                this.cil = rawX;
                this.cim = rawY;
                return true;
            default:
                return true;
        }
    }

    public void ap(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void aq(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void ar(int i, int i2) {
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
