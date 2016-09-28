package com.baidu.tieba.b.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.b.b.a {
    private int aWQ;
    private a aWR;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void cn(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.aWQ = 1;
        this.aWR = null;
        dV();
    }

    private void dV() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.aWG = this.mRadius;
        this.aWF = this.mRadius;
    }

    public void Ng() {
        Nb();
        this.aWG = this.mRadius;
        this.aWF = this.mRadius;
        ge(4);
        a(new i(this));
        a(new j(this));
    }

    public void Nh() {
        Nb();
        ge(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.aWQ;
    }

    public void ge(int i) {
        this.aWQ = i;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vX() {
        super.vX();
        this.aWG = this.mRadius;
        this.aWF = this.mRadius;
        this.aWQ = 1;
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.aWR = aVar;
    }
}
