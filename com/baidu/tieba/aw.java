package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<String, Integer, String> {
    private aw() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(aw awVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = ao.amm;
        synchronized (bArr) {
            ao.amn = Boolean.valueOf(UtilHelper.isARM());
            bArr2 = ao.amm;
            bArr2.notifyAll();
        }
        return null;
    }
}
