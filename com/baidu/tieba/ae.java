package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ae extends BdAsyncTask<String, Integer, String> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(String... strArr) {
        return a();
    }

    private ae() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ae(byte b) {
        this();
    }

    private static String a() {
        byte[] bArr;
        byte[] bArr2;
        bArr = r.L;
        synchronized (bArr) {
            r.M = Boolean.valueOf(UtilHelper.isARM());
            bArr2 = r.L;
            bArr2.notifyAll();
        }
        return null;
    }
}
