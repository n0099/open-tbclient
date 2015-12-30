package com.baidu.tieba.frs.collect;

import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
class h implements Runnable {
    private final /* synthetic */ String bew;
    final /* synthetic */ g bkd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, String str) {
        this.bkd = gVar;
        this.bew = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ab abVar = new ab(this.bew);
        abVar.uw().vp().mIsNeedAddCommenParam = false;
        abVar.uw().vp().mIsUseCurrentBDUSS = false;
        abVar.tW();
    }
}
