package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0059a aRJ;
    private float bEE;
    private float bEF;
    private Handler.Callback aRi = new b(this);
    private Handler mHandler = new Handler(this.aRi);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void W(int i, int i2);

        void X(int i, int i2);
    }

    public void a(InterfaceC0059a interfaceC0059a) {
        this.aRJ = interfaceC0059a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bEF = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.bEE);
                int i2 = (int) (rawY - this.bEF);
                if (this.aRJ != null) {
                    if (i2 > 0) {
                        ab(i, i2);
                    } else {
                        ac(i, i2);
                    }
                }
                this.bEE = rawX;
                this.bEF = rawY;
                return true;
        }
    }

    public void ab(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void ac(int i, int i2) {
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
