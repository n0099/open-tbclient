package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Void, Boolean> {
    Process PL;
    final /* synthetic */ j PM;

    private k(j jVar) {
        this.PM = jVar;
        this.PL = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(j jVar, k kVar) {
        this(jVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public Boolean doInBackground(String... strArr) {
        boolean z = false;
        if (strArr != null && strArr.length >= 1) {
            try {
                try {
                    this.PL = Runtime.getRuntime().exec(strArr[0]);
                    boolean z2 = this.PL.waitFor() == 0;
                    this.PL.destroy();
                    z = z2;
                } catch (IOException e) {
                    e.printStackTrace();
                    this.PL.destroy();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    this.PL.destroy();
                }
            } catch (Throwable th) {
                this.PL.destroy();
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
        if (this.PL != null) {
            try {
                this.PL.destroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        lVar = this.PM.PJ;
        if (lVar != null) {
            lVar2 = this.PM.PJ;
            lVar2.an(false);
        }
        mVar = this.PM.PI;
        if (mVar != null) {
            mVar2 = this.PM.PI;
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
        lVar = this.PM.PJ;
        if (lVar != null) {
            lVar2 = this.PM.PJ;
            lVar2.an(bool == null ? false : bool.booleanValue());
        }
        mVar = this.PM.PI;
        if (mVar != null) {
            mVar2 = this.PM.PI;
            mVar2.removeMessages(0);
        }
    }
}
