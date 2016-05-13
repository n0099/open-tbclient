package com.baidu.tieba.a.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.a.b.a {
    private int aMB;
    private a aMC;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void cc(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.aMB = 1;
        this.aMC = null;
        da();
    }

    private void da() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.aMr = this.mRadius;
        this.aMq = this.mRadius;
    }

    public void Jg() {
        Jb();
        this.aMr = this.mRadius;
        this.aMq = this.mRadius;
        fq(4);
        a(new i(this));
        a(new j(this));
    }

    public void Jh() {
        Jb();
        fq(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.aMB;
    }

    public void fq(int i) {
        this.aMB = i;
    }

    @Override // com.baidu.tieba.a.b.a
    public void uF() {
        super.uF();
        this.aMr = this.mRadius;
        this.aMq = this.mRadius;
        this.aMB = 1;
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.aMC = aVar;
    }
}
