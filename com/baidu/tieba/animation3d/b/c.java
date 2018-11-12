package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.animation3d.b.a {
    private int cKc;
    private a cKd;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void fj(boolean z);
    }

    public c(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.cKc = 1;
        this.cKd = null;
        initHandler();
    }

    private void initHandler() {
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.animation3d.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (c.this.cKd != null) {
                            c.this.cKd.fj(true);
                            return true;
                        }
                        return true;
                    case 2:
                        if (c.this.cKd != null) {
                            c.this.cKd.fj(false);
                            return true;
                        }
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.cJS = this.mRadius;
        this.cJR = this.mRadius;
    }

    private void amS() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public int getViewStatus() {
        return this.cKc;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void Dm() {
        super.Dm();
        this.cJS = this.mRadius;
        this.cJR = this.mRadius;
        this.cKc = 1;
        amS();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.cKd = aVar;
    }
}
