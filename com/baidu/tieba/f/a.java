package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float bDi;
    private float bDj;
    private float bDk;
    private float bDl;
    private InterfaceC0710a izu;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.izu.G(i, i2);
                    return true;
                case 1:
                    a.this.izu.H(i, i2);
                    return true;
                case 2:
                    a.this.izu.cj(i, i2);
                    return true;
                case 3:
                    a.this.izu.I(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0710a {
        void G(int i, int i2);

        void H(int i, int i2);

        void I(int i, int i2);

        void cj(int i, int i2);
    }

    public void a(InterfaceC0710a interfaceC0710a) {
        this.izu = interfaceC0710a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bDk = motionEvent.getRawX();
                this.bDl = motionEvent.getRawY();
                this.bDi = this.bDk;
                this.bDj = this.bDl;
                return true;
            case 1:
            case 3:
                if (this.izu != null) {
                    int i = (int) (this.bDi - this.bDk);
                    int i2 = (int) (this.bDj - this.bDl);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        F(i, (int) this.bDk);
                    } else {
                        ci(i, i2);
                    }
                }
                this.bDk = 0.0f;
                this.bDl = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.bDk == 0.0f || this.bDl == 0.0f) {
                    this.bDk = motionEvent.getRawX();
                    this.bDl = motionEvent.getRawY();
                    this.bDi = this.bDk;
                    this.bDj = this.bDl;
                }
                int i3 = (int) (rawY - this.bDj);
                int i4 = (int) (rawY - this.bDl);
                if (this.izu != null) {
                    if (i3 > 0) {
                        E(i4, i3);
                    } else {
                        D(i4, i3);
                    }
                }
                this.bDi = rawX;
                this.bDj = rawY;
                return true;
            default:
                return true;
        }
    }

    private void D(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void E(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void ci(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void F(int i, int i2) {
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
