package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends BdAsyncTask<String, Integer, String> {
    private be() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ be(be beVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = aj.adY;
        synchronized (bArr) {
            aj.adZ = Boolean.valueOf(com.baidu.tieba.util.q.aeO());
            bArr2 = aj.adY;
            bArr2.notifyAll();
        }
        return null;
    }
}
