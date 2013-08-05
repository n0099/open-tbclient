package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class ax extends BdAsyncTask {
    private ax() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(ax axVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = TiebaApplication.aD;
        synchronized (bArr) {
            TiebaApplication.aE = Boolean.valueOf(com.baidu.tieba.util.am.a());
            bArr2 = TiebaApplication.aD;
            bArr2.notifyAll();
        }
        return null;
    }
}
