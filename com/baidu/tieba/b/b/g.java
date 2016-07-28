package com.baidu.tieba.b.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.b.b.a {
    private int aQO;
    private a aQP;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void ch(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.aQO = 1;
        this.aQP = null;
        da();
    }

    private void da() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.aQE = this.mRadius;
        this.aQD = this.mRadius;
    }

    public void Kd() {
        JY();
        this.aQE = this.mRadius;
        this.aQD = this.mRadius;
        fB(4);
        a(new i(this));
        a(new j(this));
    }

    public void Ke() {
        JY();
        fB(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.aQO;
    }

    public void fB(int i) {
        this.aQO = i;
    }

    @Override // com.baidu.tieba.b.b.a
    public void uE() {
        super.uE();
        this.aQE = this.mRadius;
        this.aQD = this.mRadius;
        this.aQO = 1;
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.aQP = aVar;
    }
}
