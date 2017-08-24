package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float bWQ;
    private float bWR;
    private InterfaceC0080a bWS;
    private Handler.Callback aUT = new Handler.Callback() { // from class: com.baidu.tieba.e.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bWS.ah(i, i2);
                    return true;
                case 1:
                    a.this.bWS.ai(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.aUT);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0080a {
        void ah(int i, int i2);

        void ai(int i, int i2);
    }

    public void a(InterfaceC0080a interfaceC0080a) {
        this.bWS = interfaceC0080a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bWR = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.bWQ);
                int i2 = (int) (rawY - this.bWR);
                if (this.bWS != null) {
                    if (i2 > 0) {
                        af(i, i2);
                    } else {
                        ag(i, i2);
                    }
                }
                this.bWQ = rawX;
                this.bWR = rawY;
                return true;
        }
    }

    public void af(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void ag(int i, int i2) {
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
