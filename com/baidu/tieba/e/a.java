package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0081a bzA;
    private float chX;
    private float chY;
    private float chZ;
    private float cia;
    private Handler.Callback aWm = new Handler.Callback() { // from class: com.baidu.tieba.e.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bzA.ag(i, i2);
                    return true;
                case 1:
                    a.this.bzA.ah(i, i2);
                    return true;
                case 2:
                    a.this.bzA.ai(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.aWm);

    /* renamed from: com.baidu.tieba.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0081a {
        void ag(int i, int i2);

        void ah(int i, int i2);

        void ai(int i, int i2);
    }

    public void a(InterfaceC0081a interfaceC0081a) {
        this.bzA = interfaceC0081a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.chZ = motionEvent.getRawX();
                this.cia = motionEvent.getRawY();
                return true;
            case 1:
            case 3:
                if (this.bzA != null) {
                    int i = (int) (this.chX - this.chZ);
                    if (Math.abs(i) >= Math.abs((int) (this.chY - this.cia))) {
                        ar(i, (int) this.chZ);
                    }
                }
                this.chZ = 0.0f;
                this.cia = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.chX);
                int i3 = (int) (rawY - this.chY);
                if (this.bzA != null) {
                    if (i3 > 0) {
                        ap(i2, i3);
                    } else {
                        aq(i2, i3);
                    }
                }
                this.chX = rawX;
                this.chY = rawY;
                return true;
            default:
                return true;
        }
    }

    public void ap(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void aq(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void ar(int i, int i2) {
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
