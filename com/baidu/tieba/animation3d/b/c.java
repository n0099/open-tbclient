package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.animation3d.b.a {
    private int cUl;
    private a cUm;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void fp(boolean z);
    }

    public c(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.cUl = 1;
        this.cUm = null;
        initHandler();
    }

    private void initHandler() {
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.animation3d.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (c.this.cUm != null) {
                            c.this.cUm.fp(true);
                            return true;
                        }
                        return true;
                    case 2:
                        if (c.this.cUm != null) {
                            c.this.cUm.fp(false);
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
        this.cUb = this.mRadius;
        this.cUa = this.mRadius;
    }

    private void apR() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public int getViewStatus() {
        return this.cUl;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void ED() {
        super.ED();
        this.cUb = this.mRadius;
        this.cUa = this.mRadius;
        this.cUl = 1;
        apR();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.cUm = aVar;
    }
}
