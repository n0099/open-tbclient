package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float bIs;
    private float bIt;
    private float bIu;
    private float bIv;
    private InterfaceC0717a iHb;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.iHb.G(i, i2);
                    return true;
                case 1:
                    a.this.iHb.H(i, i2);
                    return true;
                case 2:
                    a.this.iHb.ch(i, i2);
                    return true;
                case 3:
                    a.this.iHb.I(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0717a {
        void G(int i, int i2);

        void H(int i, int i2);

        void I(int i, int i2);

        void ch(int i, int i2);
    }

    public void a(InterfaceC0717a interfaceC0717a) {
        this.iHb = interfaceC0717a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bIu = motionEvent.getRawX();
                this.bIv = motionEvent.getRawY();
                this.bIs = this.bIu;
                this.bIt = this.bIv;
                return true;
            case 1:
            case 3:
                if (this.iHb != null) {
                    int i = (int) (this.bIs - this.bIu);
                    int i2 = (int) (this.bIt - this.bIv);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        F(i, (int) this.bIu);
                    } else {
                        cg(i, i2);
                    }
                }
                this.bIu = 0.0f;
                this.bIv = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.bIu == 0.0f || this.bIv == 0.0f) {
                    this.bIu = motionEvent.getRawX();
                    this.bIv = motionEvent.getRawY();
                    this.bIs = this.bIu;
                    this.bIt = this.bIv;
                }
                int i3 = (int) (rawY - this.bIt);
                int i4 = (int) (rawY - this.bIv);
                if (this.iHb != null) {
                    if (i3 > 0) {
                        E(i4, i3);
                    } else {
                        D(i4, i3);
                    }
                }
                this.bIs = rawX;
                this.bIt = rawY;
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

    private void cg(int i, int i2) {
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
