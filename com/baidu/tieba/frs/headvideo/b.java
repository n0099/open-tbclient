package com.baidu.tieba.frs.headvideo;

import com.baidu.tieba.frs.f.u;
/* loaded from: classes.dex */
public class b {
    private u bJd;
    private boolean bQF = false;
    private boolean bQG = false;

    public boolean abp() {
        return this.bQF;
    }

    public void ef(boolean z) {
        this.bQF = z;
    }

    public b(u uVar) {
        this.bJd = uVar;
    }

    public void eg(boolean z) {
        ForumHeadVideoView adB;
        this.bQG = z;
        if (this.bQG && this.bJd != null && this.bJd.acU() != null && (adB = this.bJd.acU().adB()) != null) {
            adB.stopPlay();
        }
    }

    public boolean abq() {
        return this.bQG;
    }
}
