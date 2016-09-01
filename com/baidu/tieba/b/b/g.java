package com.baidu.tieba.b.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.b.b.a {
    private int aWm;
    private a aWn;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void cn(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.aWm = 1;
        this.aWn = null;
        dV();
    }

    private void dV() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.aWc = this.mRadius;
        this.aWb = this.mRadius;
    }

    public void MF() {
        MA();
        this.aWc = this.mRadius;
        this.aWb = this.mRadius;
        fZ(4);
        a(new i(this));
        a(new j(this));
    }

    public void MG() {
        MA();
        fZ(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.aWm;
    }

    public void fZ(int i) {
        this.aWm = i;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vJ() {
        super.vJ();
        this.aWc = this.mRadius;
        this.aWb = this.mRadius;
        this.aWm = 1;
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.aWn = aVar;
    }
}
