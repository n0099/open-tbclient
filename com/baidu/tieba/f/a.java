package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0057a aLl;
    private float bvh;
    private float bvi;
    private Handler.Callback aKM = new b(this);
    private Handler mHandler = new Handler(this.aKM);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0057a {
        void Q(int i, int i2);

        void R(int i, int i2);
    }

    public void a(InterfaceC0057a interfaceC0057a) {
        this.aLl = interfaceC0057a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bvi = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.bvh);
                int i2 = (int) (rawY - this.bvi);
                if (this.aLl != null) {
                    if (i2 > 0) {
                        U(i, i2);
                    } else {
                        V(i, i2);
                    }
                }
                this.bvh = rawX;
                this.bvi = rawY;
                return true;
        }
    }

    public void U(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void V(int i, int i2) {
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
