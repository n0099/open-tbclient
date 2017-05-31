package com.baidu.tieba.b.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.b.b.a {
    private int bsI;
    private a bsJ;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void cX(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.bsI = 1;
        this.bsJ = null;
        fh();
    }

    private void fh() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.bsy = this.mRadius;
        this.bsx = this.mRadius;
    }

    public void Sl() {
        Sg();
        this.bsy = this.mRadius;
        this.bsx = this.mRadius;
        gW(4);
        a(new i(this));
        a(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sm() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public void Sn() {
        Sg();
        gW(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.bsI;
    }

    public void gW(int i) {
        this.bsI = i;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vK() {
        super.vK();
        this.bsy = this.mRadius;
        this.bsx = this.mRadius;
        this.bsI = 1;
        Sm();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.bsJ = aVar;
    }
}
