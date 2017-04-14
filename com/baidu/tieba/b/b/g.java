package com.baidu.tieba.b.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.b.b.a {
    private int boN;
    private a boO;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void cF(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.boN = 1;
        this.boO = null;
        fg();
    }

    private void fg() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.boD = this.mRadius;
        this.boC = this.mRadius;
    }

    public void RC() {
        Rx();
        this.boD = this.mRadius;
        this.boC = this.mRadius;
        gC(4);
        a(new i(this));
        a(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RD() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public void RE() {
        Rx();
        gC(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.boN;
    }

    public void gC(int i) {
        this.boN = i;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wz() {
        super.wz();
        this.boD = this.mRadius;
        this.boC = this.mRadius;
        this.boN = 1;
        RD();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.boO = aVar;
    }
}
