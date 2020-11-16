package com.baidu.tieba.g;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float bya;
    private float byb;
    private float byc;
    private float byd;
    private InterfaceC0740a igS;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.g.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.igS.H(i, i2);
                    return true;
                case 1:
                    a.this.igS.I(i, i2);
                    return true;
                case 2:
                    a.this.igS.cg(i, i2);
                    return true;
                case 3:
                    a.this.igS.J(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0740a {
        void H(int i, int i2);

        void I(int i, int i2);

        void J(int i, int i2);

        void cg(int i, int i2);
    }

    public void a(InterfaceC0740a interfaceC0740a) {
        this.igS = interfaceC0740a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.byc = motionEvent.getRawX();
                this.byd = motionEvent.getRawY();
                this.bya = this.byc;
                this.byb = this.byd;
                return true;
            case 1:
            case 3:
                if (this.igS != null) {
                    int i = (int) (this.bya - this.byc);
                    int i2 = (int) (this.byb - this.byd);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        G(i, (int) this.byc);
                    } else {
                        cf(i, i2);
                    }
                }
                this.byc = 0.0f;
                this.byd = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.byc == 0.0f || this.byd == 0.0f) {
                    this.byc = motionEvent.getRawX();
                    this.byd = motionEvent.getRawY();
                    this.bya = this.byc;
                    this.byb = this.byd;
                }
                int i3 = (int) (rawY - this.byb);
                int i4 = (int) (rawY - this.byd);
                if (this.igS != null) {
                    if (i3 > 0) {
                        F(i4, i3);
                    } else {
                        E(i4, i3);
                    }
                }
                this.bya = rawX;
                this.byb = rawY;
                return true;
            default:
                return true;
        }
    }

    private void E(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void F(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void cf(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void G(int i, int i2) {
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
