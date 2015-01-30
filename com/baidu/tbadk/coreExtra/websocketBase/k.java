package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Void, Boolean> {
    Process Wb;
    final /* synthetic */ j Wc;

    private k(j jVar) {
        this.Wc = jVar;
        this.Wb = null;
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
                    this.Wb = Runtime.getRuntime().exec(strArr[0]);
                    boolean z2 = this.Wb.waitFor() == 0;
                    this.Wb.destroy();
                    z = z2;
                } catch (IOException e) {
                    e.printStackTrace();
                    this.Wb.destroy();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    this.Wb.destroy();
                }
            } catch (Throwable th) {
                this.Wb.destroy();
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
        if (this.Wb != null) {
            try {
                this.Wb.destroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        lVar = this.Wc.VZ;
        if (lVar != null) {
            lVar2 = this.Wc.VZ;
            lVar2.aD(false);
        }
        mVar = this.Wc.VY;
        if (mVar != null) {
            mVar2 = this.Wc.VY;
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
        lVar = this.Wc.VZ;
        if (lVar != null) {
            lVar2 = this.Wc.VZ;
            lVar2.aD(bool == null ? false : bool.booleanValue());
        }
        mVar = this.Wc.VY;
        if (mVar != null) {
            mVar2 = this.Wc.VY;
            mVar2.removeMessages(0);
        }
    }
}
