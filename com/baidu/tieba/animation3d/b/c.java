package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.animation3d.b.a {
    private float FT;
    private int cuE;
    private a cuF;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void en(boolean z);
    }

    public c(Context context) {
        super(context);
        this.FT = 0.0f;
        this.cuE = 1;
        this.cuF = null;
        hC();
    }

    private void hC() {
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.animation3d.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (c.this.cuF != null) {
                            c.this.cuF.en(true);
                            return true;
                        }
                        return true;
                    case 2:
                        if (c.this.cuF != null) {
                            c.this.cuF.en(false);
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
        this.FT = f;
        this.cuu = this.FT;
        this.cut = this.FT;
    }

    private void aib() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public int getViewStatus() {
        return this.cuE;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void zT() {
        super.zT();
        this.cuu = this.FT;
        this.cut = this.FT;
        this.cuE = 1;
        aib();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.cuF = aVar;
    }
}
