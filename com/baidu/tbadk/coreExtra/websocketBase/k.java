package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Void, Boolean> {
    Process Vw;
    final /* synthetic */ j Vx;

    private k(j jVar) {
        this.Vx = jVar;
        this.Vw = null;
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
                    this.Vw = Runtime.getRuntime().exec(strArr[0]);
                    boolean z2 = this.Vw.waitFor() == 0;
                    this.Vw.destroy();
                    z = z2;
                } catch (IOException e) {
                    e.printStackTrace();
                    this.Vw.destroy();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    this.Vw.destroy();
                }
            } catch (Throwable th) {
                this.Vw.destroy();
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
        if (this.Vw != null) {
            try {
                this.Vw.destroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        lVar = this.Vx.Vu;
        if (lVar != null) {
            lVar2 = this.Vx.Vu;
            lVar2.aB(false);
        }
        mVar = this.Vx.Vt;
        if (mVar != null) {
            mVar2 = this.Vx.Vt;
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
        lVar = this.Vx.Vu;
        if (lVar != null) {
            lVar2 = this.Vx.Vu;
            lVar2.aB(bool == null ? false : bool.booleanValue());
        }
        mVar = this.Vx.Vt;
        if (mVar != null) {
            mVar2 = this.Vx.Vt;
            mVar2.removeMessages(0);
        }
    }
}
