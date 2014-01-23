package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class bj extends BdAsyncTask<String, Integer, String> {
    private bj() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bj(ay ayVar) {
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
            Boolean unused = TiebaApplication.aE = Boolean.valueOf(UtilHelper.a());
            bArr2 = TiebaApplication.aD;
            bArr2.notifyAll();
        }
        return null;
    }
}
