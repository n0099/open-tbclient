package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.animation3d.b.a {
    private int cUm;
    private a cUn;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void fp(boolean z);
    }

    public c(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.cUm = 1;
        this.cUn = null;
        initHandler();
    }

    private void initHandler() {
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.animation3d.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (c.this.cUn != null) {
                            c.this.cUn.fp(true);
                            return true;
                        }
                        return true;
                    case 2:
                        if (c.this.cUn != null) {
                            c.this.cUn.fp(false);
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
        this.cUc = this.mRadius;
        this.cUb = this.mRadius;
    }

    private void apR() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public int getViewStatus() {
        return this.cUm;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void ED() {
        super.ED();
        this.cUc = this.mRadius;
        this.cUb = this.mRadius;
        this.cUm = 1;
        apR();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.cUn = aVar;
    }
}
