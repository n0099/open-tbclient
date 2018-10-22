package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.animation3d.b.a {
    private float IQ;
    private int cIW;
    private a cIX;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void eY(boolean z);
    }

    public c(Context context) {
        super(context);
        this.IQ = 0.0f;
        this.cIW = 1;
        this.cIX = null;
        initHandler();
    }

    private void initHandler() {
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.animation3d.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (c.this.cIX != null) {
                            c.this.cIX.eY(true);
                            return true;
                        }
                        return true;
                    case 2:
                        if (c.this.cIX != null) {
                            c.this.cIX.eY(false);
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
        this.IQ = f;
        this.cIM = this.IQ;
        this.cIL = this.IQ;
    }

    private void ans() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public int getViewStatus() {
        return this.cIW;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void Df() {
        super.Df();
        this.cIM = this.IQ;
        this.cIL = this.IQ;
        this.cIW = 1;
        ans();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.cIX = aVar;
    }
}
