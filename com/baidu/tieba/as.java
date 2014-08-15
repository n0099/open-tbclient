package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask<String, Integer, String> {
    private as() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ as(as asVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = ai.K;
        synchronized (bArr) {
            ai.L = Boolean.valueOf(com.baidu.tieba.util.r.a());
            bArr2 = ai.K;
            bArr2.notifyAll();
        }
        return null;
    }
}
