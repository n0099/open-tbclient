package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
final class ba extends BdAsyncTask<String, Integer, String> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        return d();
    }

    private ba() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(byte b) {
        this();
    }

    private static String d() {
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
