package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
class i {
    public int PA;
    public boolean PC;
    public long PD;

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(i iVar) {
        this();
    }

    public void reset() {
        this.PA = 0;
        if (this.PC) {
            this.PC = false;
            this.PD = 0L;
        }
    }

    public void onError(int i) {
        this.PA++;
        if (!this.PC && this.PA >= i) {
            this.PC = true;
            this.PD = System.currentTimeMillis();
        }
    }
}
