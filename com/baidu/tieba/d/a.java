package com.baidu.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0058a aMy;
    private float blf;
    private float blg;
    private Handler.Callback aLz = new b(this);
    private Handler mHandler = new Handler(this.aLz);

    /* renamed from: com.baidu.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0058a {
        void O(int i, int i2);

        void P(int i, int i2);
    }

    public void a(InterfaceC0058a interfaceC0058a) {
        this.aMy = interfaceC0058a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.blg = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.blf);
                int i2 = (int) (rawY - this.blg);
                if (this.aMy != null) {
                    if (i2 > 0) {
                        U(i, i2);
                    } else {
                        V(i, i2);
                    }
                }
                this.blf = rawX;
                this.blg = rawY;
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
