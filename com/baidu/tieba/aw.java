package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class aw extends BdAsyncTask {
    private aw() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(aw awVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = TiebaApplication.aB;
        synchronized (bArr) {
            TiebaApplication.aC = Boolean.valueOf(com.baidu.tieba.util.ab.a());
            bArr2 = TiebaApplication.aB;
            bArr2.notifyAll();
        }
        return null;
    }
}
