package com.baidu.tieba.b.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.b.b.a {
    private int aZY;
    private a aZZ;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void cs(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.aZY = 1;
        this.aZZ = null;
        dV();
    }

    private void dV() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.aZO = this.mRadius;
        this.aZN = this.mRadius;
    }

    public void Oj() {
        Oe();
        this.aZO = this.mRadius;
        this.aZN = this.mRadius;
        ge(4);
        a(new i(this));
        a(new j(this));
    }

    public void Ok() {
        Oe();
        ge(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.aZY;
    }

    public void ge(int i) {
        this.aZY = i;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wb() {
        super.wb();
        this.aZO = this.mRadius;
        this.aZN = this.mRadius;
        this.aZY = 1;
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.aZZ = aVar;
    }
}
