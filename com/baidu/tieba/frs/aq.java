package com.baidu.tieba.frs;

import com.baidu.tieba.frs.r;
/* loaded from: classes.dex */
class aq implements Runnable {
    final /* synthetic */ r.a bPq;
    private final /* synthetic */ String bPr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(r.a aVar, String str) {
        this.bPq = aVar;
        this.bPr = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(this.bPr);
        zVar.uJ().vD().mIsNeedAddCommenParam = false;
        zVar.uJ().vD().mIsUseCurrentBDUSS = false;
        zVar.um();
    }
}
