package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0142a cop;
    private float dnw;
    private float dnx;
    private float dny;
    private float dnz;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.e.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.cop.aY(i, i2);
                    return true;
                case 1:
                    a.this.cop.aZ(i, i2);
                    return true;
                case 2:
                    a.this.cop.ba(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0142a {
        void aY(int i, int i2);

        void aZ(int i, int i2);

        void ba(int i, int i2);
    }

    public void a(InterfaceC0142a interfaceC0142a) {
        this.cop = interfaceC0142a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.dny = motionEvent.getRawX();
                this.dnz = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.cop != null) {
                    int i = (int) (this.dnw - this.dny);
                    if (Math.abs(i) >= Math.abs((int) (this.dnx - this.dnz))) {
                        bo(i, (int) this.dny);
                    }
                }
                this.dny = 0.0f;
                this.dnz = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.dnw);
                int i3 = (int) (rawY - this.dnx);
                if (this.cop != null) {
                    if (i3 > 0) {
                        bm(i2, i3);
                    } else {
                        bn(i2, i3);
                    }
                }
                this.dnw = rawX;
                this.dnx = rawY;
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
