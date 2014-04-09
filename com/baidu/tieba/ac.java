package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac extends BdAsyncTask<String, Integer, String> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(String... strArr) {
        return a();
    }

    private ac() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(byte b) {
        this();
    }

    private static String a() {
        byte[] bArr;
        byte[] bArr2;
        bArr = p.J;
        synchronized (bArr) {
            p.K = Boolean.valueOf(com.baidu.tieba.util.r.a());
            bArr2 = p.J;
            bArr2.notifyAll();
        }
        return null;
    }
}
