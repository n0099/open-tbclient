package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Void, Boolean> {
    Process agm;
    final /* synthetic */ j agn;

    private k(j jVar) {
        this.agn = jVar;
        this.agm = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(j jVar, k kVar) {
        this(jVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        boolean z = false;
        if (strArr != null && strArr.length >= 1) {
            try {
                try {
                    this.agm = Runtime.getRuntime().exec(strArr[0]);
                    boolean z2 = this.agm.waitFor() == 0;
                    this.agm.destroy();
                    z = z2;
                } catch (IOException e) {
                    e.printStackTrace();
                    this.agm.destroy();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    this.agm.destroy();
                }
            } catch (Throwable th) {
                this.agm.destroy();
                throw th;
            }
        }
        return Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        l lVar;
        m mVar;
        m mVar2;
        l lVar2;
        super.onCancelled();
        if (this.agm != null) {
            try {
                this.agm.destroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        lVar = this.agn.agk;
        if (lVar != null) {
            lVar2 = this.agn.agk;
            lVar2.aJ(false);
        }
        mVar = this.agn.agj;
        if (mVar != null) {
            mVar2 = this.agn.agj;
            mVar2.removeMessages(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        l lVar;
        m mVar;
        m mVar2;
        l lVar2;
        lVar = this.agn.agk;
        if (lVar != null) {
            lVar2 = this.agn.agk;
            lVar2.aJ(bool == null ? false : bool.booleanValue());
        }
        mVar = this.agn.agj;
        if (mVar != null) {
            mVar2 = this.agn.agj;
            mVar2.removeMessages(0);
        }
    }
}
