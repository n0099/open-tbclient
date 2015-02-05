package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
class i {
    public int VS;
    public boolean VT;
    public long VU;

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(i iVar) {
        this();
    }

    public void reset() {
        this.VS = 0;
        if (this.VT) {
            this.VT = false;
            this.VU = 0L;
        }
    }

    public void onError(int i) {
        this.VS++;
        if (!this.VT && this.VS >= i) {
            this.VT = true;
            this.VU = System.currentTimeMillis();
        }
    }
}
