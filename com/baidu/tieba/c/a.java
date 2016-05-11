package com.baidu.tieba.c;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float aVb;
    private float aVc;
    private InterfaceC0052a aVe;
    private Handler.Callback aVd = new b(this);
    private Handler mHandler = new Handler(this.aVd);

    /* renamed from: com.baidu.tieba.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0052a {
        void O(int i, int i2);

        void P(int i, int i2);
    }

    public void a(InterfaceC0052a interfaceC0052a) {
        this.aVe = interfaceC0052a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aVc = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.aVb);
                int i2 = (int) (rawY - this.aVc);
                if (this.aVe != null) {
                    if (i2 > 0) {
                        M(i, i2);
                    } else {
                        N(i, i2);
                    }
                }
                this.aVb = rawX;
                this.aVc = rawY;
                return true;
        }
    }

    public void M(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void N(int i, int i2) {
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
