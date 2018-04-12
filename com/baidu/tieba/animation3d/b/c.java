package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.animation3d.b.a {
    private int ckK;
    private a ckL;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void ei(boolean z);
    }

    public c(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.ckK = 1;
        this.ckL = null;
        eL();
    }

    private void eL() {
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.animation3d.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (c.this.ckL != null) {
                            c.this.ckL.ei(true);
                            return true;
                        }
                        return true;
                    case 2:
                        if (c.this.ckL != null) {
                            c.this.ckL.ei(false);
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
        this.ckA = this.mRadius;
        this.ckz = this.mRadius;
    }

    private void aeJ() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public int getViewStatus() {
        return this.ckK;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void wr() {
        super.wr();
        this.ckA = this.mRadius;
        this.ckz = this.mRadius;
        this.ckK = 1;
        aeJ();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.ckL = aVar;
    }
}
