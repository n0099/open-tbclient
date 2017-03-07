package com.baidu.tieba.b.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.b.b.a {
    private int boU;
    private a boV;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void cD(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.boU = 1;
        this.boV = null;
        fb();
    }

    private void fb() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.boK = this.mRadius;
        this.boJ = this.mRadius;
    }

    public void Re() {
        QZ();
        this.boK = this.mRadius;
        this.boJ = this.mRadius;
        gz(4);
        a(new i(this));
        a(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rf() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public void Rg() {
        QZ();
        gz(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.boU;
    }

    public void gz(int i) {
        this.boU = i;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wc() {
        super.wc();
        this.boK = this.mRadius;
        this.boJ = this.mRadius;
        this.boU = 1;
        Rf();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.boV = aVar;
    }
}
