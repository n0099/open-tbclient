package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float bQP;
    private float bQQ;
    private InterfaceC0062a bQR;
    private Handler.Callback aSC = new b(this);
    private Handler mHandler = new Handler(this.aSC);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        void ah(int i, int i2);

        void ai(int i, int i2);
    }

    public void a(InterfaceC0062a interfaceC0062a) {
        this.bQR = interfaceC0062a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bQQ = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.bQP);
                int i2 = (int) (rawY - this.bQQ);
                if (this.bQR != null) {
                    if (i2 > 0) {
                        af(i, i2);
                    } else {
                        ag(i, i2);
                    }
                }
                this.bQP = rawX;
                this.bQQ = rawY;
                return true;
        }
    }

    public void af(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void ag(int i, int i2) {
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
