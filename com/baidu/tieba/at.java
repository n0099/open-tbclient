package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<String, Integer, String> {
    private at() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ at(at atVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        byte[] bArr;
        byte[] bArr2;
        bArr = al.als;
        synchronized (bArr) {
            al.alt = Boolean.valueOf(UtilHelper.isARM());
            bArr2 = al.als;
            bArr2.notifyAll();
        }
        return null;
    }
}
