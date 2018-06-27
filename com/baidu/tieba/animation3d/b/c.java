package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.animation3d.b.a {
    private int cse;
    private a csf;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void em(boolean z);
    }

    public c(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.cse = 1;
        this.csf = null;
        hC();
    }

    private void hC() {
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.animation3d.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (c.this.csf != null) {
                            c.this.csf.em(true);
                            return true;
                        }
                        return true;
                    case 2:
                        if (c.this.csf != null) {
                            c.this.csf.em(false);
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
        this.crU = this.mRadius;
        this.crT = this.mRadius;
    }

    private void ahz() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public int getViewStatus() {
        return this.cse;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void Ag() {
        super.Ag();
        this.crU = this.mRadius;
        this.crT = this.mRadius;
        this.cse = 1;
        ahz();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.csf = aVar;
    }
}
