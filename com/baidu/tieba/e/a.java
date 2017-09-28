package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float caC;
    private float caD;
    private float caE;
    private float caF;
    private InterfaceC0081a caG;
    private Handler.Callback aWn = new Handler.Callback() { // from class: com.baidu.tieba.e.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.caG.ao(i, i2);
                    return true;
                case 1:
                    a.this.caG.ap(i, i2);
                    return true;
                case 2:
                    a.this.caG.aq(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.aWn);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0081a {
        void ao(int i, int i2);

        void ap(int i, int i2);

        void aq(int i, int i2);
    }

    public void a(InterfaceC0081a interfaceC0081a) {
        this.caG = interfaceC0081a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.caE = motionEvent.getRawX();
                this.caF = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.caG != null) {
                    int i = (int) (this.caC - this.caE);
                    if (Math.abs(i) >= Math.abs((int) (this.caD - this.caF))) {
                        an(i, (int) this.caE);
                    }
                }
                this.caE = 0.0f;
                this.caF = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.caC);
                int i3 = (int) (rawY - this.caD);
                if (this.caG != null) {
                    if (i3 > 0) {
                        al(i2, i3);
                    } else {
                        am(i2, i3);
                    }
                }
                this.caC = rawX;
                this.caD = rawY;
                return true;
            default:
                return true;
        }
    }

    public void al(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void am(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void an(int i, int i2) {
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
