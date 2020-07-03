package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float beG;
    private float beH;
    private float beI;
    private float beJ;
    private InterfaceC0614a gZb;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.gZb.D(i, i2);
                    return true;
                case 1:
                    a.this.gZb.E(i, i2);
                    return true;
                case 2:
                    a.this.gZb.bO(i, i2);
                    return true;
                case 3:
                    a.this.gZb.F(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0614a {
        void D(int i, int i2);

        void E(int i, int i2);

        void F(int i, int i2);

        void bO(int i, int i2);
    }

    public void a(InterfaceC0614a interfaceC0614a) {
        this.gZb = interfaceC0614a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.beI = motionEvent.getRawX();
                this.beJ = motionEvent.getRawY();
                this.beG = this.beI;
                this.beH = this.beJ;
                return true;
            case 1:
            case 3:
                if (this.gZb != null) {
                    int i = (int) (this.beG - this.beI);
                    int i2 = (int) (this.beH - this.beJ);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        C(i, (int) this.beI);
                    } else {
                        bN(i, i2);
                    }
                }
                this.beI = 0.0f;
                this.beJ = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.beI == 0.0f || this.beJ == 0.0f) {
                    this.beI = motionEvent.getRawX();
                    this.beJ = motionEvent.getRawY();
                    this.beG = this.beI;
                    this.beH = this.beJ;
                }
                int i3 = (int) (rawY - this.beH);
                int i4 = (int) (rawY - this.beJ);
                if (this.gZb != null) {
                    if (i3 > 0) {
                        B(i4, i3);
                    } else {
                        A(i4, i3);
                    }
                }
                this.beG = rawX;
                this.beH = rawY;
                return true;
            default:
                return true;
        }
    }

    private void A(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void B(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void bN(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void C(int i, int i2) {
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
