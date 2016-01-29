package com.baidu.tieba.frs.collect;

import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
class h implements Runnable {
    private final /* synthetic */ String bgQ;
    final /* synthetic */ g bmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, String str) {
        this.bmZ = gVar;
        this.bgQ = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        aa aaVar = new aa(this.bgQ);
        aaVar.vB().wv().mIsNeedAddCommenParam = false;
        aaVar.vB().wv().mIsUseCurrentBDUSS = false;
        aaVar.va();
    }
}
