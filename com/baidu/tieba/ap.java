package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class ap extends BdAsyncTask<String, Integer, String> {
    private ap() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ap(ap apVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = TiebaApplication.aq;
        synchronized (bArr) {
            TiebaApplication.ar = Boolean.valueOf(UtilHelper.a());
            bArr2 = TiebaApplication.aq;
            bArr2.notifyAll();
        }
        return null;
    }
}
