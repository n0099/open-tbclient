package com.baidu.tieba.frs;

import com.baidu.tieba.frs.r;
/* loaded from: classes.dex */
class as implements Runnable {
    final /* synthetic */ r.a cdp;
    private final /* synthetic */ String cdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(r.a aVar, String str) {
        this.cdp = aVar;
        this.cdq = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(this.cdq);
        abVar.uV().vR().mIsNeedAddCommenParam = false;
        abVar.uV().vR().mIsUseCurrentBDUSS = false;
        abVar.tP();
    }
}
