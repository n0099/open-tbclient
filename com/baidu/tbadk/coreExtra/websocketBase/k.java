package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Void, Boolean> {
    Process age;
    final /* synthetic */ j agf;

    private k(j jVar) {
        this.agf = jVar;
        this.age = null;
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
                    this.age = Runtime.getRuntime().exec(strArr[0]);
                    boolean z2 = this.age.waitFor() == 0;
                    this.age.destroy();
                    z = z2;
                } catch (IOException e) {
                    e.printStackTrace();
                    this.age.destroy();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    this.age.destroy();
                }
            } catch (Throwable th) {
                this.age.destroy();
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
        if (this.age != null) {
            try {
                this.age.destroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        lVar = this.agf.agc;
        if (lVar != null) {
            lVar2 = this.agf.agc;
            lVar2.aJ(false);
        }
        mVar = this.agf.agb;
        if (mVar != null) {
            mVar2 = this.agf.agb;
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
        lVar = this.agf.agc;
        if (lVar != null) {
            lVar2 = this.agf.agc;
            lVar2.aJ(bool == null ? false : bool.booleanValue());
        }
        mVar = this.agf.agb;
        if (mVar != null) {
            mVar2 = this.agf.agb;
            mVar2.removeMessages(0);
        }
    }
}
