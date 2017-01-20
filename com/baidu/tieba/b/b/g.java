package com.baidu.tieba.b.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.b.b.a {
    private int bil;
    private a bim;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void cE(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.bil = 1;
        this.bim = null;
        dT();
    }

    private void dT() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.bhZ = this.mRadius;
        this.bhY = this.mRadius;
    }

    public void Ql() {
        Qg();
        this.bhZ = this.mRadius;
        this.bhY = this.mRadius;
        gC(4);
        a(new i(this));
        a(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qm() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public void Qn() {
        Qg();
        gC(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.bil;
    }

    public void gC(int i) {
        this.bil = i;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vF() {
        super.vF();
        this.bhZ = this.mRadius;
        this.bhY = this.mRadius;
        this.bil = 1;
        Qm();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.bim = aVar;
    }
}
