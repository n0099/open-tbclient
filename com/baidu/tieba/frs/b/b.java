package com.baidu.tieba.frs.b;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, u, Void> {
    private a aPQ;
    private String mName;
    private boolean needCache;

    public b(a aVar, boolean z, String str) {
        this.mName = null;
        this.mName = str;
        this.aPQ = aVar;
        this.needCache = z;
        setSelfExecute(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Object... objArr) {
        if (this.needCache && d.amp().jo(this.mName)) {
            if (!d.amp().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.mName)) {
                d.amp().getResponseData().aas().getSignData().setIsSigned(0);
            }
            publishProgress(d.amp().getResponseData());
            return null;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(u... uVarArr) {
        super.onProgressUpdate(uVarArr);
        this.aPQ.c(uVarArr.length > 0 ? uVarArr[0] : null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Void r2) {
        super.onPostExecute(r2);
        this.aPQ.Ma();
    }
}
