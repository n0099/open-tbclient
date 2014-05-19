package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Void, Boolean> {
    Process a;
    final /* synthetic */ i b;

    private j(i iVar) {
        this.b = iVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(i iVar, j jVar) {
        this(iVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [114=4] */
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
        k kVar;
        l lVar;
        l lVar2;
        k kVar2;
        super.onCancelled();
        if (this.a != null) {
            try {
                this.a.destroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        kVar = this.b.b;
        if (kVar != null) {
            kVar2 = this.b.b;
            kVar2.a(false);
        }
        lVar = this.b.a;
        if (lVar != null) {
            lVar2 = this.b.a;
            lVar2.removeMessages(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        k kVar;
        l lVar;
        l lVar2;
        k kVar2;
        kVar = this.b.b;
        if (kVar != null) {
            kVar2 = this.b.b;
            kVar2.a(bool == null ? false : bool.booleanValue());
        }
        lVar = this.b.a;
        if (lVar != null) {
            lVar2 = this.b.a;
            lVar2.removeMessages(0);
        }
    }
}
