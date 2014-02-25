package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BdAsyncTask<String, Integer, String> {
    private ba() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(ba baVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = TiebaApplication.aA;
        synchronized (bArr) {
            TiebaApplication.aB = Boolean.valueOf(UtilHelper.a());
            bArr2 = TiebaApplication.aA;
            bArr2.notifyAll();
        }
        return null;
    }
}
