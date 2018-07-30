package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.animation3d.b.a {
    private float FT;
    private int cuH;
    private a cuI;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void en(boolean z);
    }

    public c(Context context) {
        super(context);
        this.FT = 0.0f;
        this.cuH = 1;
        this.cuI = null;
        hC();
    }

    private void hC() {
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.animation3d.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (c.this.cuI != null) {
                            c.this.cuI.en(true);
                            return true;
                        }
                        return true;
                    case 2:
                        if (c.this.cuI != null) {
                            c.this.cuI.en(false);
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
        this.cux = this.FT;
        this.cuw = this.FT;
    }

    private void ahY() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public int getViewStatus() {
        return this.cuH;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void zV() {
        super.zV();
        this.cux = this.FT;
        this.cuw = this.FT;
        this.cuH = 1;
        ahY();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.cuI = aVar;
    }
}
