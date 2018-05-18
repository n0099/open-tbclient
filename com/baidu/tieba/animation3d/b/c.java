package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.animation3d.b.a {
    private int clQ;
    private a clR;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void ej(boolean z);
    }

    public c(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.clQ = 1;
        this.clR = null;
        eL();
    }

    private void eL() {
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.animation3d.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (c.this.clR != null) {
                            c.this.clR.ej(true);
                            return true;
                        }
                        return true;
                    case 2:
                        if (c.this.clR != null) {
                            c.this.clR.ej(false);
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
        this.clG = this.mRadius;
        this.clF = this.mRadius;
    }

    private void aeJ() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public int getViewStatus() {
        return this.clQ;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void wq() {
        super.wq();
        this.clG = this.mRadius;
        this.clF = this.mRadius;
        this.clQ = 1;
        aeJ();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.clR = aVar;
    }
}
