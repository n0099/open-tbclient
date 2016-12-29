package com.baidu.tieba.frs.headvideo;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.frs.h.s bBJ;
    private boolean bKn = false;
    private boolean bKo = false;

    public boolean aak() {
        return this.bKn;
    }

    public void ea(boolean z) {
        this.bKn = z;
    }

    public b(com.baidu.tieba.frs.h.s sVar) {
        this.bBJ = sVar;
    }

    public void eb(boolean z) {
        ForumHeadVideoView acs;
        this.bKo = z;
        if (this.bKo && this.bBJ != null && this.bBJ.abN() != null && (acs = this.bBJ.abN().acs()) != null) {
            acs.stopPlay();
        }
    }

    public boolean aal() {
        return this.bKo;
    }
}
