package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class bl extends BdAsyncTask<String, Integer, String> {
    private bl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bl(az azVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = TiebaApplication.aC;
        synchronized (bArr) {
            Boolean unused = TiebaApplication.aD = Boolean.valueOf(UtilHelper.a());
            bArr2 = TiebaApplication.aC;
            bArr2.notifyAll();
        }
        return null;
    }
}
