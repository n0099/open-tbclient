package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
class i {
    public int ahh;
    public boolean ahi;
    public long ahj;

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(i iVar) {
        this();
    }

    public void reset() {
        this.ahh = 0;
        if (this.ahi) {
            this.ahi = false;
            this.ahj = 0L;
        }
    }

    public void onError(int i) {
        this.ahh++;
        if (!this.ahi && this.ahh >= i) {
            this.ahi = true;
            this.ahj = System.currentTimeMillis();
        }
    }
}
