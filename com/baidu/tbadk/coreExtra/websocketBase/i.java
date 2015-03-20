package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
class i {
    public int afY;
    public boolean afZ;
    public long aga;

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(i iVar) {
        this();
    }

    public void reset() {
        this.afY = 0;
        if (this.afZ) {
            this.afZ = false;
            this.aga = 0L;
        }
    }

    public void onError(int i) {
        this.afY++;
        if (!this.afZ && this.afY >= i) {
            this.afZ = true;
            this.aga = System.currentTimeMillis();
        }
    }
}
