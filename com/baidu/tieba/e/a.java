package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0096a bHQ;
    private float crf;
    private float crg;
    private float crh;
    private float cri;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.e.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bHQ.ag(i, i2);
                    return true;
                case 1:
                    a.this.bHQ.ah(i, i2);
                    return true;
                case 2:
                    a.this.bHQ.ai(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0096a {
        void ag(int i, int i2);

        void ah(int i, int i2);

        void ai(int i, int i2);
    }

    public void a(InterfaceC0096a interfaceC0096a) {
        this.bHQ = interfaceC0096a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.crh = motionEvent.getRawX();
                this.cri = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.bHQ != null) {
                    int i = (int) (this.crf - this.crh);
                    if (Math.abs(i) >= Math.abs((int) (this.crg - this.cri))) {
                        ar(i, (int) this.crh);
                    }
                }
                this.crh = 0.0f;
                this.cri = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.crf);
                int i3 = (int) (rawY - this.crg);
                if (this.bHQ != null) {
                    if (i3 > 0) {
                        ap(i2, i3);
                    } else {
                        aq(i2, i3);
                    }
                }
                this.crf = rawX;
                this.crg = rawY;
                return true;
            default:
                return true;
        }
    }

    public void ap(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void aq(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void ar(int i, int i2) {
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
