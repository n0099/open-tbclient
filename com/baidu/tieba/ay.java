package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class ay extends BdAsyncTask<String, Integer, String> {
    private ay() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ay(as asVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = TiebaApplication.as;
        synchronized (bArr) {
            Boolean unused = TiebaApplication.at = Boolean.valueOf(UtilHelper.a());
            bArr2 = TiebaApplication.as;
            bArr2.notifyAll();
        }
        return null;
    }
}
