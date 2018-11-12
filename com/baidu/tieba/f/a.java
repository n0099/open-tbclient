package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0204a crS;
    private float dfe;
    private float dff;
    private float dfg;
    private float dfh;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.crS.ap(i, i2);
                    return true;
                case 1:
                    a.this.crS.aq(i, i2);
                    return true;
                case 2:
                    a.this.crS.ar(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0204a {
        void ap(int i, int i2);

        void aq(int i, int i2);

        void ar(int i, int i2);
    }

    public void a(InterfaceC0204a interfaceC0204a) {
        this.crS = interfaceC0204a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.dfg = motionEvent.getRawX();
                this.dfh = motionEvent.getRawY();
                this.dfe = this.dfg;
                this.dff = this.dfh;
                return true;
            case 1:
            case 3:
                if (this.crS != null) {
                    int i = (int) (this.dfe - this.dfg);
                    if (Math.abs(i) >= Math.abs((int) (this.dff - this.dfh))) {
                        aD(i, (int) this.dfg);
                    }
                }
                this.dfg = 0.0f;
                this.dfh = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.dfe);
                int i3 = (int) (rawY - this.dff);
                if (this.crS != null) {
                    if (i3 > 0) {
                        aB(i2, i3);
                    } else {
                        aC(i2, i3);
                    }
                }
                this.dfe = rawX;
                this.dff = rawY;
                return true;
            default:
                return true;
        }
    }

    public void aB(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void aC(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void aD(int i, int i2) {
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
