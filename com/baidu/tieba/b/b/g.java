package com.baidu.tieba.b.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.b.b.a {
    private int aYM;
    private a aYN;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void cr(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.aYM = 1;
        this.aYN = null;
        dV();
    }

    private void dV() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.aYC = this.mRadius;
        this.aYB = this.mRadius;
    }

    public void Nv() {
        Nq();
        this.aYC = this.mRadius;
        this.aYB = this.mRadius;
        gd(4);
        a(new i(this));
        a(new j(this));
    }

    public void Nw() {
        Nq();
        gd(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.aYM;
    }

    public void gd(int i) {
        this.aYM = i;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vL() {
        super.vL();
        this.aYC = this.mRadius;
        this.aYB = this.mRadius;
        this.aYM = 1;
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.aYN = aVar;
    }
}
