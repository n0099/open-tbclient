package com.baidu.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0054a aLt;
    private float aZu;
    private float aZv;
    private Handler.Callback aZw = new b(this);
    private Handler mHandler = new Handler(this.aZw);

    /* renamed from: com.baidu.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0054a {
        void K(int i, int i2);

        void L(int i, int i2);
    }

    public void a(InterfaceC0054a interfaceC0054a) {
        this.aLt = interfaceC0054a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aZv = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.aZu);
                int i2 = (int) (rawY - this.aZv);
                if (this.aLt != null) {
                    if (i2 > 0) {
                        O(i, i2);
                    } else {
                        P(i, i2);
                    }
                }
                this.aZu = rawX;
                this.aZv = rawY;
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
