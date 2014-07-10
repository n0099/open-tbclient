package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Void, Boolean> {
    Process a;
    final /* synthetic */ j b;

    private k(j jVar) {
        this.b = jVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(j jVar, k kVar) {
        this(jVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [115=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        boolean z = false;
        if (strArr != null && strArr.length >= 1) {
            try {
                try {
                    this.a = Runtime.getRuntime().exec(strArr[0]);
                    boolean z2 = this.a.waitFor() == 0;
                    this.a.destroy();
                    z = z2;
                } catch (IOException e) {
                    e.printStackTrace();
                    this.a.destroy();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    this.a.destroy();
                }
            } catch (Throwable th) {
                this.a.destroy();
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
        if (this.a != null) {
            try {
                this.a.destroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        lVar = this.b.b;
        if (lVar != null) {
            lVar2 = this.b.b;
            lVar2.a(false);
        }
        mVar = this.b.a;
        if (mVar != null) {
            mVar2 = this.b.a;
            mVar2.removeMessages(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        l lVar;
        m mVar;
        m mVar2;
        l lVar2;
        lVar = this.b.b;
        if (lVar != null) {
            lVar2 = this.b.b;
            lVar2.a(bool == null ? false : bool.booleanValue());
        }
        mVar = this.b.a;
        if (mVar != null) {
            mVar2 = this.b.a;
            mVar2.removeMessages(0);
        }
    }
}
