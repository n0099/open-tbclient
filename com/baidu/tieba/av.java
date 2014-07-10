package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends BdAsyncTask<String, Integer, String> {
    private av() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ av(av avVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = ai.J;
        synchronized (bArr) {
            ai.K = Boolean.valueOf(com.baidu.tieba.util.r.a());
            bArr2 = ai.J;
            bArr2.notifyAll();
        }
        return null;
    }
}
