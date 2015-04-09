package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
class i {
    public int agg;
    public boolean agh;
    public long agi;

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(i iVar) {
        this();
    }

    public void reset() {
        this.agg = 0;
        if (this.agh) {
            this.agh = false;
            this.agi = 0L;
        }
    }

    public void onError(int i) {
        this.agg++;
        if (!this.agh && this.agg >= i) {
            this.agh = true;
            this.agi = System.currentTimeMillis();
        }
    }
}
