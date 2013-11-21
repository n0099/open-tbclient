package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class bb extends BdAsyncTask<String, Integer, String> {
    private bb() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bb(av avVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = TiebaApplication.at;
        synchronized (bArr) {
            Boolean unused = TiebaApplication.au = Boolean.valueOf(UtilHelper.a());
            bArr2 = TiebaApplication.at;
            bArr2.notifyAll();
        }
        return null;
    }
}
