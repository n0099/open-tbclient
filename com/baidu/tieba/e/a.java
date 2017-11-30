package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0083a bHI;
    private float cqR;
    private float cqS;
    private float cqT;
    private float cqU;
    private Handler.Callback aZy = new Handler.Callback() { // from class: com.baidu.tieba.e.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bHI.af(i, i2);
                    return true;
                case 1:
                    a.this.bHI.ag(i, i2);
                    return true;
                case 2:
                    a.this.bHI.ah(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.aZy);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0083a {
        void af(int i, int i2);

        void ag(int i, int i2);

        void ah(int i, int i2);
    }

    public void a(InterfaceC0083a interfaceC0083a) {
        this.bHI = interfaceC0083a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.cqT = motionEvent.getRawX();
                this.cqU = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.bHI != null) {
                    int i = (int) (this.cqR - this.cqT);
                    if (Math.abs(i) >= Math.abs((int) (this.cqS - this.cqU))) {
                        aq(i, (int) this.cqT);
                    }
                }
                this.cqT = 0.0f;
                this.cqU = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.cqR);
                int i3 = (int) (rawY - this.cqS);
                if (this.bHI != null) {
                    if (i3 > 0) {
                        ao(i2, i3);
                    } else {
                        ap(i2, i3);
                    }
                }
                this.cqR = rawX;
                this.cqS = rawY;
                return true;
            default:
                return true;
        }
    }

    public void ao(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void ap(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void aq(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }
}
