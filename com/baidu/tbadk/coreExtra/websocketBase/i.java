package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
class i {
    public int VV;
    public boolean VW;
    public long VX;

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(i iVar) {
        this();
    }

    public void reset() {
        this.VV = 0;
        if (this.VW) {
            this.VW = false;
            this.VX = 0L;
        }
    }

    public void onError(int i) {
        this.VV++;
        if (!this.VW && this.VV >= i) {
            this.VW = true;
            this.VX = System.currentTimeMillis();
        }
    }
}
