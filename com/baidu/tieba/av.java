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
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = aj.adS;
        synchronized (bArr) {
            aj.adT = Boolean.valueOf(com.baidu.tieba.util.q.aeL());
            bArr2 = aj.adS;
            bArr2.notifyAll();
        }
        return null;
    }
}
