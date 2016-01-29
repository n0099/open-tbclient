package com.baidu.tieba.b;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float aUu;
    private float aUv;
    private InterfaceC0059a aUx;
    private Handler.Callback aUw = new b(this);
    private Handler mHandler = new Handler(this.aUw);

    /* renamed from: com.baidu.tieba.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void P(int i, int i2);

        void Q(int i, int i2);
    }

    public void a(InterfaceC0059a interfaceC0059a) {
        this.aUx = interfaceC0059a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i = (int) (x - this.aUu);
                int i2 = (int) (y - this.aUv);
                if (this.aUx != null) {
                    if (i2 > 0) {
                        N(i, i2);
                    } else {
                        O(i, i2);
                    }
                }
                this.aUu = x;
                this.aUv = y;
                return true;
            default:
                return true;
        }
    }

    public void N(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void O(int i, int i2) {
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
