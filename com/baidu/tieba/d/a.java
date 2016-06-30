package com.baidu.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0053a aKA;
    private float aYw;
    private float aYx;
    private Handler.Callback aYy = new b(this);
    private Handler mHandler = new Handler(this.aYy);

    /* renamed from: com.baidu.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0053a {
        void K(int i, int i2);

        void L(int i, int i2);
    }

    public void a(InterfaceC0053a interfaceC0053a) {
        this.aKA = interfaceC0053a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aYx = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.aYw);
                int i2 = (int) (rawY - this.aYx);
                if (this.aKA != null) {
                    if (i2 > 0) {
                        O(i, i2);
                    } else {
                        P(i, i2);
                    }
                }
                this.aYw = rawX;
                this.aYx = rawY;
                return true;
        }
    }

    public void O(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void P(int i, int i2) {
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
