package com.baidu.tieba.frs.headvideo;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.frs.j.n bVB;
    private boolean ceE = false;
    private boolean ceF = false;

    public boolean afO() {
        return this.ceE;
    }

    public void eq(boolean z) {
        this.ceE = z;
    }

    public b(com.baidu.tieba.frs.j.n nVar) {
        this.bVB = nVar;
    }

    public void er(boolean z) {
        ForumHeadVideoView ahV;
        this.ceF = z;
        if (this.ceF && this.bVB != null && this.bVB.ahq() != null && (ahV = this.bVB.ahq().ahV()) != null) {
            ahV.stopPlay();
        }
    }

    public boolean afP() {
        return this.ceF;
    }
}
