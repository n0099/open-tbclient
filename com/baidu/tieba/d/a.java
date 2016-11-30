package com.baidu.tieba.d;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0058a aMT;
    private float bob;
    private float boc;
    private Handler.Callback aMt = new b(this);
    private Handler mHandler = new Handler(this.aMt);

    /* renamed from: com.baidu.tieba.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0058a {
        void P(int i, int i2);

        void Q(int i, int i2);
    }

    public void a(InterfaceC0058a interfaceC0058a) {
        this.aMT = interfaceC0058a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.boc = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.bob);
                int i2 = (int) (rawY - this.boc);
                if (this.aMT != null) {
                    if (i2 > 0) {
                        V(i, i2);
                    } else {
                        W(i, i2);
                    }
                }
                this.bob = rawX;
                this.boc = rawY;
                return true;
        }
    }

    public void V(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void W(int i, int i2) {
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
