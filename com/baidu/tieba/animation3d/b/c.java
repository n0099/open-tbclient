package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.animation3d.b.a {
    private int cTA;
    private a cTB;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void fm(boolean z);
    }

    public c(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.cTA = 1;
        this.cTB = null;
        initHandler();
    }

    private void initHandler() {
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.animation3d.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (c.this.cTB != null) {
                            c.this.cTB.fm(true);
                            return true;
                        }
                        return true;
                    case 2:
                        if (c.this.cTB != null) {
                            c.this.cTB.fm(false);
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
        this.cTq = this.mRadius;
        this.cTp = this.mRadius;
    }

    private void apu() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public int getViewStatus() {
        return this.cTA;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void Eq() {
        super.Eq();
        this.cTq = this.mRadius;
        this.cTp = this.mRadius;
        this.cTA = 1;
        apu();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.cTB = aVar;
    }
}
