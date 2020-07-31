package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class a {
    private float beZ;
    private float bfa;
    private float bfc;
    private float bfd;
    private InterfaceC0623a heG;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.f.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            switch (message.what) {
                case 0:
                    a.this.heG.D(i, i2);
                    return true;
                case 1:
                    a.this.heG.E(i, i2);
                    return true;
                case 2:
                    a.this.heG.bR(i, i2);
                    return true;
                case 3:
                    a.this.heG.F(i, i2);
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);

    /* renamed from: com.baidu.tieba.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0623a {
        void D(int i, int i2);

        void E(int i, int i2);

        void F(int i, int i2);

        void bR(int i, int i2);
    }

    public void a(InterfaceC0623a interfaceC0623a) {
        this.heG = interfaceC0623a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.bfc = motionEvent.getRawX();
                this.bfd = motionEvent.getRawY();
                this.beZ = this.bfc;
                this.bfa = this.bfd;
                return true;
            case 1:
            case 3:
                if (this.heG != null) {
                    int i = (int) (this.beZ - this.bfc);
                    int i2 = (int) (this.bfa - this.bfd);
                    if (Math.abs(i) >= Math.abs(i2)) {
                        C(i, (int) this.bfc);
                    } else {
                        bQ(i, i2);
                    }
                }
                this.bfc = 0.0f;
                this.bfd = 0.0f;
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (this.bfc == 0.0f || this.bfd == 0.0f) {
                    this.bfc = motionEvent.getRawX();
                    this.bfd = motionEvent.getRawY();
                    this.beZ = this.bfc;
                    this.bfa = this.bfd;
                }
                int i3 = (int) (rawY - this.bfa);
                int i4 = (int) (rawY - this.bfd);
                if (this.heG != null) {
                    if (i3 > 0) {
                        B(i4, i3);
                    } else {
                        A(i4, i3);
                    }
                }
                this.beZ = rawX;
                this.bfa = rawY;
                return true;
            default:
                return true;
        }
    }

    private void A(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void B(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void bQ(int i, int i2) {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(2)) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    private void C(int i, int i2) {
        this.mHandler.removeMessages(3);
        if (!this.mHandler.hasMessages(3)) {
            Message message = new Message();
            message.what = 3;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }
}
