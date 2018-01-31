package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0109a ckU;
    private float dkG;
    private float dkH;
    private float dkI;
    private float dkJ;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.e.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.ckU.aY(i, i2);
                    return true;
                case 1:
                    a.this.ckU.aZ(i, i2);
                    return true;
                case 2:
                    a.this.ckU.ba(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0109a {
        void aY(int i, int i2);

        void aZ(int i, int i2);

        void ba(int i, int i2);
    }

    public void a(InterfaceC0109a interfaceC0109a) {
        this.ckU = interfaceC0109a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.dkI = motionEvent.getRawX();
                this.dkJ = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.ckU != null) {
                    int i = (int) (this.dkG - this.dkI);
                    if (Math.abs(i) >= Math.abs((int) (this.dkH - this.dkJ))) {
                        bq(i, (int) this.dkI);
                    }
                }
                this.dkI = 0.0f;
                this.dkJ = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.dkG);
                int i3 = (int) (rawY - this.dkH);
                if (this.ckU != null) {
                    if (i3 > 0) {
                        bo(i2, i3);
                    } else {
                        bp(i2, i3);
                    }
                }
                this.dkG = rawX;
                this.dkH = rawY;
                return true;
            default:
                return true;
        }
    }

    public void bo(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void bp(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void bq(int i, int i2) {
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
