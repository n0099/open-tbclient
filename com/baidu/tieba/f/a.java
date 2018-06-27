package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0147a bJo;
    private float cNj;
    private float cNk;
    private float cNl;
    private float cNm;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bJo.W(i, i2);
                    return true;
                case 1:
                    a.this.bJo.X(i, i2);
                    return true;
                case 2:
                    a.this.bJo.Y(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0147a {
        void W(int i, int i2);

        void X(int i, int i2);

        void Y(int i, int i2);
    }

    public void a(InterfaceC0147a interfaceC0147a) {
        this.bJo = interfaceC0147a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.cNl = motionEvent.getRawX();
                this.cNm = motionEvent.getRawY();
                this.cNj = this.cNl;
                this.cNk = this.cNm;
                return true;
            case 1:
            case 3:
                if (this.bJo != null) {
                    int i = (int) (this.cNj - this.cNl);
                    if (Math.abs(i) >= Math.abs((int) (this.cNk - this.cNm))) {
                        ar(i, (int) this.cNl);
                    }
                }
                this.cNl = 0.0f;
                this.cNm = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.cNj);
                int i3 = (int) (rawY - this.cNk);
                if (this.bJo != null) {
                    if (i3 > 0) {
                        ap(i2, i3);
                    } else {
                        aq(i2, i3);
                    }
                }
                this.cNj = rawX;
                this.cNk = rawY;
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
