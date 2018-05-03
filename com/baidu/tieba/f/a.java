package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0131a byz;
    private float cFq;
    private float cFr;
    private float cFs;
    private float cFt;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.byz.W(i, i2);
                    return true;
                case 1:
                    a.this.byz.X(i, i2);
                    return true;
                case 2:
                    a.this.byz.Y(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0131a {
        void W(int i, int i2);

        void X(int i, int i2);

        void Y(int i, int i2);
    }

    public void a(InterfaceC0131a interfaceC0131a) {
        this.byz = interfaceC0131a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.cFs = motionEvent.getRawX();
                this.cFt = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.byz != null) {
                    int i = (int) (this.cFq - this.cFs);
                    if (Math.abs(i) >= Math.abs((int) (this.cFr - this.cFt))) {
                        aq(i, (int) this.cFs);
                    }
                }
                this.cFs = 0.0f;
                this.cFt = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.cFq);
                int i3 = (int) (rawY - this.cFr);
                if (this.byz != null) {
                    if (i3 > 0) {
                        ao(i2, i3);
                    } else {
                        ap(i2, i3);
                    }
                }
                this.cFq = rawX;
                this.cFr = rawY;
                return true;
            default:
                return true;
        }
    }

    public void ao(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void ap(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void aq(int i, int i2) {
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
