package com.baidu.tieba.frs.collect;

import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
class h implements Runnable {
    private final /* synthetic */ String bax;
    final /* synthetic */ g bgl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, String str) {
        this.bgl = gVar;
        this.bax = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ab abVar = new ab(this.bax);
        abVar.uM().vF().mIsNeedAddCommenParam = false;
        abVar.uM().vF().mIsUseCurrentBDUSS = false;
        abVar.um();
    }
}
