package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Void, Boolean> {
    Process ahn;
    final /* synthetic */ j aho;

    private k(j jVar) {
        this.aho = jVar;
        this.ahn = null;
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
                    this.ahn = Runtime.getRuntime().exec(strArr[0]);
                    boolean z2 = this.ahn.waitFor() == 0;
                    this.ahn.destroy();
                    z = z2;
                } catch (IOException e) {
                    e.printStackTrace();
                    this.ahn.destroy();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    this.ahn.destroy();
                }
            } catch (Throwable th) {
                this.ahn.destroy();
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
        if (this.ahn != null) {
            try {
                this.ahn.destroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        lVar = this.aho.ahl;
        if (lVar != null) {
            lVar2 = this.aho.ahl;
            lVar2.aQ(false);
        }
        mVar = this.aho.ahk;
        if (mVar != null) {
            mVar2 = this.aho.ahk;
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
        lVar = this.aho.ahl;
        if (lVar != null) {
            lVar2 = this.aho.ahl;
            lVar2.aQ(bool == null ? false : bool.booleanValue());
        }
        mVar = this.aho.ahk;
        if (mVar != null) {
            mVar2 = this.aho.ahk;
            mVar2.removeMessages(0);
        }
    }
}
