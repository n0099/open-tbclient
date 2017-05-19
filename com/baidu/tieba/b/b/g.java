package com.baidu.tieba.b.b;

import android.content.Context;
import android.os.Handler;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.b.b.a {
    private int brB;
    private a brC;
    private Handler mHandler;
    private float mRadius;

    /* loaded from: classes.dex */
    public interface a {
        void cR(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mRadius = 0.0f;
        this.brB = 1;
        this.brC = null;
        fh();
    }

    private void fh() {
        this.mHandler = new Handler(new h(this));
    }

    public void setRotateRadius(float f) {
        this.mRadius = f;
        this.brr = this.mRadius;
        this.brq = this.mRadius;
    }

    public void RZ() {
        RU();
        this.brr = this.mRadius;
        this.brq = this.mRadius;
        gF(4);
        a(new i(this));
        a(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sa() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public void Sb() {
        RU();
        gF(2);
        a(new k(this));
        a(new l(this));
    }

    public int getViewStatus() {
        return this.brB;
    }

    public void gF(int i) {
        this.brB = i;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vN() {
        super.vN();
        this.brr = this.mRadius;
        this.brq = this.mRadius;
        this.brB = 1;
        Sa();
        this.mHandler.sendEmptyMessage(1);
    }

    public void setWriteEndCallBack(a aVar) {
        this.brC = aVar;
    }
}
