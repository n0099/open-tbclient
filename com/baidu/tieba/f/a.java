package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0302a dWj;
    private float eOA;
    private float eOx;
    private float eOy;
    private float eOz;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.dWj.aT(i, i2);
                    return true;
                case 1:
                    a.this.dWj.aU(i, i2);
                    return true;
                case 2:
                    a.this.dWj.aV(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0302a {
        void aT(int i, int i2);

        void aU(int i, int i2);

        void aV(int i, int i2);
    }

    public void a(InterfaceC0302a interfaceC0302a) {
        this.dWj = interfaceC0302a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.eOz = motionEvent.getRawX();
                this.eOA = motionEvent.getRawY();
                this.eOx = this.eOz;
                this.eOy = this.eOA;
                return true;
            case 1:
            case 3:
                if (this.dWj != null) {
                    int i = (int) (this.eOx - this.eOz);
                    if (Math.abs(i) >= Math.abs((int) (this.eOy - this.eOA))) {
                        bj(i, (int) this.eOz);
                    }
                }
                this.eOz = 0.0f;
                this.eOA = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.eOx);
                int i3 = (int) (rawY - this.eOy);
                if (this.dWj != null) {
                    if (i3 > 0) {
                        bh(i2, i3);
                    } else {
                        bi(i2, i3);
                    }
                }
                this.eOx = rawX;
                this.eOy = rawY;
                return true;
            default:
                return true;
        }
    }

    public void bh(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void bi(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void bj(int i, int i2) {
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
