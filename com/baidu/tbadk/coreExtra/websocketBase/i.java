package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
class i {
    public int Vq;
    public boolean Vr;
    public long Vs;

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(i iVar) {
        this();
    }

    public void reset() {
        this.Vq = 0;
        if (this.Vr) {
            this.Vr = false;
            this.Vs = 0L;
        }
    }

    public void onError(int i) {
        this.Vq++;
        if (!this.Vr && this.Vq >= i) {
            this.Vr = true;
            this.Vs = System.currentTimeMillis();
        }
    }
}
