package com.baidu.tieba.frs.headvideo;

import com.baidu.tieba.frs.f.u;
/* loaded from: classes.dex */
public class b {
    private u bQm;
    private boolean bXN = false;
    private boolean bXO = false;

    public boolean acm() {
        return this.bXN;
    }

    public void ef(boolean z) {
        this.bXN = z;
    }

    public b(u uVar) {
        this.bQm = uVar;
    }

    public void eg(boolean z) {
        ForumHeadVideoView aeB;
        this.bXO = z;
        if (this.bXO && this.bQm != null && this.bQm.adU() != null && (aeB = this.bQm.adU().aeB()) != null) {
            aeB.stopPlay();
        }
    }

    public boolean acn() {
        return this.bXO;
    }
}
