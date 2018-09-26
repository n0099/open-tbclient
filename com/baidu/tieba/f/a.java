package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0145a bPQ;
    private float cVG;
    private float cVH;
    private float cVI;
    private float cVJ;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.bPQ.ac(i, i2);
                    return true;
                case 1:
                    a.this.bPQ.ad(i, i2);
                    return true;
                case 2:
                    a.this.bPQ.ae(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0145a {
        void ac(int i, int i2);

        void ad(int i, int i2);

        void ae(int i, int i2);
    }

    public void a(InterfaceC0145a interfaceC0145a) {
        this.bPQ = interfaceC0145a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.cVI = motionEvent.getRawX();
                this.cVJ = motionEvent.getRawY();
                this.cVG = this.cVI;
                this.cVH = this.cVJ;
                return true;
            case 1:
            case 3:
                if (this.bPQ != null) {
                    int i = (int) (this.cVG - this.cVI);
                    if (Math.abs(i) >= Math.abs((int) (this.cVH - this.cVJ))) {
                        ay(i, (int) this.cVI);
                    }
                }
                this.cVI = 0.0f;
                this.cVJ = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i2 = (int) (rawX - this.cVG);
                int i3 = (int) (rawY - this.cVH);
                if (this.bPQ != null) {
                    if (i3 > 0) {
                        aw(i2, i3);
                    } else {
                        ax(i2, i3);
                    }
                }
                this.cVG = rawX;
                this.cVH = rawY;
                return true;
            default:
                return true;
        }
    }

    public void aw(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void ax(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }

    public void ay(int i, int i2) {
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
