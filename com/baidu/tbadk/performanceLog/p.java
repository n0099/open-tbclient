package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class p extends t {
    public int axc;
    public long axk;
    public long axl;
    public int axm;
    private a axn = null;
    private final Handler axo = new q(this, Looper.getMainLooper());
    public long kY;
    public long wf;
    public long xK;

    public void EE() {
        this.axo.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EF() {
        w wVar = (w) aa.EN().eN(this.axu);
        if (wVar != null) {
            wVar.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            p.this.axc = aa.EN().ER();
            p.this.EF();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
        }
    }
}
