package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float eTA;
    private float eTB;
    private float eTy;
    private float eTz;
    private InterfaceC0299a eac;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.eac.aY(i, i2);
                    return true;
                case 1:
                    a.this.eac.aZ(i, i2);
                    return true;
                case 2:
                    a.this.eac.ba(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0299a {
        void aY(int i, int i2);

        void aZ(int i, int i2);

        void ba(int i, int i2);
    }

    public void a(InterfaceC0299a interfaceC0299a) {
        this.eac = interfaceC0299a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.eTA = motionEvent.getRawX();
                this.eTB = motionEvent.getRawY();
                this.eTy = this.eTA;
                this.eTz = this.eTB;
                return true;
            case 1:
            case 3:
                if (this.eac != null) {
                    int i = (int) (this.eTy - this.eTA);
                    if (Math.abs(i) >= Math.abs((int) (this.eTz - this.eTB))) {
                        bo(i, (int) this.eTA);
                    }
                }
                this.eTA = 0.0f;
                this.eTB = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.eTy);
                int i3 = (int) (rawY - this.eTz);
                if (this.eac != null) {
                    if (i3 > 0) {
                        bm(i2, i3);
                    } else {
                        bn(i2, i3);
                    }
                }
                this.eTy = rawX;
                this.eTz = rawY;
                return true;
            default:
                return true;
        }
    }

    public void bm(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void bn(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void bo(int i, int i2) {
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
