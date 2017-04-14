package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0055a aRm;
    private float bCg;
    private float bCh;
    private Handler.Callback aQN = new b(this);
    private Handler mHandler = new Handler(this.aQN);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0055a {
        void V(int i, int i2);

        void W(int i, int i2);
    }

    public void a(InterfaceC0055a interfaceC0055a) {
        this.aRm = interfaceC0055a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bCh = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.bCg);
                int i2 = (int) (rawY - this.bCh);
                if (this.aRm != null) {
                    if (i2 > 0) {
                        aa(i, i2);
                    } else {
                        ab(i, i2);
                    }
                }
                this.bCg = rawX;
                this.bCh = rawY;
                return true;
        }
    }

    public void aa(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void ab(int i, int i2) {
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
