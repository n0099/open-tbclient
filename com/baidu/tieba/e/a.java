package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float bZM;
    private float bZN;
    private InterfaceC0082a bZO;
    private Handler.Callback aUC = new Handler.Callback() { // from class: com.baidu.tieba.e.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bZO.ag(i, i2);
                    return true;
                case 1:
                    a.this.bZO.ah(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.aUC);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0082a {
        void ag(int i, int i2);

        void ah(int i, int i2);
    }

    public void a(InterfaceC0082a interfaceC0082a) {
        this.bZO = interfaceC0082a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bZN = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.bZM);
                int i2 = (int) (rawY - this.bZN);
                if (this.bZO != null) {
                    if (i2 > 0) {
                        ae(i, i2);
                    } else {
                        af(i, i2);
                    }
                }
                this.bZM = rawX;
                this.bZN = rawY;
                return true;
        }
    }

    public void ae(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void af(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }
}
