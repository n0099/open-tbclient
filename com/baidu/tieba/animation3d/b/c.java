package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.animation3d.b.a {
    private int ctX;
    private a ctY;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void en(boolean z);
    }

    public c(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.ctX = 1;
        this.ctY = null;
        hC();
    }

    private void hC() {
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.animation3d.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (c.this.ctY != null) {
                            c.this.ctY.en(true);
                            return true;
                        }
                        return true;
                    case 2:
                        if (c.this.ctY != null) {
                            c.this.ctY.en(false);
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
        this.ctN = this.mRadius;
        this.ctM = this.mRadius;
    }

    private void aig() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public int getViewStatus() {
        return this.ctX;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void zR() {
        super.zR();
        this.ctN = this.mRadius;
        this.ctM = this.mRadius;
        this.ctX = 1;
        aig();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.ctY = aVar;
    }
}
