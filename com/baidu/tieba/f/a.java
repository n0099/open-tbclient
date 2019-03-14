package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0284a dMs;
    private float ezj;
    private float ezk;
    private float ezl;
    private float ezm;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.dMs.aR(i, i2);
                    return true;
                case 1:
                    a.this.dMs.aS(i, i2);
                    return true;
                case 2:
                    a.this.dMs.aT(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0284a {
        void aR(int i, int i2);

        void aS(int i, int i2);

        void aT(int i, int i2);
    }

    public void a(InterfaceC0284a interfaceC0284a) {
        this.dMs = interfaceC0284a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ezl = motionEvent.getRawX();
                this.ezm = motionEvent.getRawY();
                this.ezj = this.ezl;
                this.ezk = this.ezm;
                return true;
            case 1:
            case 3:
                if (this.dMs != null) {
                    int i = (int) (this.ezj - this.ezl);
                    if (Math.abs(i) >= Math.abs((int) (this.ezk - this.ezm))) {
                        bd(i, (int) this.ezl);
                    }
                }
                this.ezl = 0.0f;
                this.ezm = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.ezj);
                int i3 = (int) (rawY - this.ezk);
                if (this.dMs != null) {
                    if (i3 > 0) {
                        bb(i2, i3);
                    } else {
                        bc(i2, i3);
                    }
                }
                this.ezj = rawX;
                this.ezk = rawY;
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
