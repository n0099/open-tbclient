package com.baidu.tieba.b;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float aZd;
    private float aZe;
    private InterfaceC0059a aZg;
    private Handler.Callback aZf = new b(this);
    private Handler mHandler = new Handler(this.aZf);

    /* renamed from: com.baidu.tieba.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void N(int i, int i2);

        void O(int i, int i2);
    }

    public void a(InterfaceC0059a interfaceC0059a) {
        this.aZg = interfaceC0059a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i = (int) (x - this.aZd);
                int i2 = (int) (y - this.aZe);
                if (this.aZg != null) {
                    if (i2 > 0) {
                        L(i, i2);
                    } else {
                        M(i, i2);
                    }
                }
                this.aZd = x;
                this.aZe = y;
                return true;
            default:
                return true;
        }
    }

    public void L(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void M(int i, int i2) {
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
