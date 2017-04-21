package com.baidu.tieba.b.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.b.b.a {
    private int bre;
    private a brf;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void cP(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.bre = 1;
        this.brf = null;
        fh();
    }

    private void fh() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.bqU = this.mRadius;
        this.bqT = this.mRadius;
    }

    public void SE() {
        Sz();
        this.bqU = this.mRadius;
        this.bqT = this.mRadius;
        gI(4);
        a(new i(this));
        a(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SF() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public void SG() {
        Sz();
        gI(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.bre;
    }

    public void gI(int i) {
        this.bre = i;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wz() {
        super.wz();
        this.bqU = this.mRadius;
        this.bqT = this.mRadius;
        this.bre = 1;
        SF();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.brf = aVar;
    }
}
