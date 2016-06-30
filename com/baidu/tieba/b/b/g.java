package com.baidu.tieba.b.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.b.b.a {
    private int aPU;
    private a aPV;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void cf(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.aPU = 1;
        this.aPV = null;
        db();
    }

    private void db() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.aPK = this.mRadius;
        this.aPJ = this.mRadius;
    }

    public void Ke() {
        JZ();
        this.aPK = this.mRadius;
        this.aPJ = this.mRadius;
        fC(4);
        a(new i(this));
        a(new j(this));
    }

    public void Kf() {
        JZ();
        fC(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.aPU;
    }

    public void fC(int i) {
        this.aPU = i;
    }

    @Override // com.baidu.tieba.b.b.a
    public void uE() {
        super.uE();
        this.aPK = this.mRadius;
        this.aPJ = this.mRadius;
        this.aPU = 1;
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.aPV = aVar;
    }
}
