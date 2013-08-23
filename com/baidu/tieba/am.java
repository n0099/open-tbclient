package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class am extends BdAsyncTask {
    private am() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ am(am amVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = TiebaApplication.ay;
        synchronized (bArr) {
            TiebaApplication.az = Boolean.valueOf(UtilHelper.a());
            bArr2 = TiebaApplication.ay;
            bArr2.notifyAll();
        }
        return null;
    }
}
