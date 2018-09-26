package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.animation3d.b.a {
    private float Io;
    private int cAu;
    private a cAv;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void eE(boolean z);
    }

    public c(Context context) {
        super(context);
        this.Io = 0.0f;
        this.cAu = 1;
        this.cAv = null;
        iI();
    }

    private void iI() {
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.animation3d.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (c.this.cAv != null) {
                            c.this.cAv.eE(true);
                            return true;
                        }
                        return true;
                    case 2:
                        if (c.this.cAv != null) {
                            c.this.cAv.eE(false);
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
        this.Io = f;
        this.cAk = this.Io;
        this.cAj = this.Io;
    }

    private void ajN() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public int getViewStatus() {
        return this.cAu;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void AY() {
        super.AY();
        this.cAk = this.Io;
        this.cAj = this.Io;
        this.cAu = 1;
        ajN();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.cAv = aVar;
    }
}
