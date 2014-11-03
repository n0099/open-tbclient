package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
class i {
    public int PF;
    public boolean PG;
    public long PH;

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(i iVar) {
        this();
    }

    public void reset() {
        this.PF = 0;
        if (this.PG) {
            this.PG = false;
            this.PH = 0L;
        }
    }

    public void onError(int i) {
        this.PF++;
        if (!this.PG && this.PF >= i) {
            this.PG = true;
            this.PH = System.currentTimeMillis();
        }
    }
}
