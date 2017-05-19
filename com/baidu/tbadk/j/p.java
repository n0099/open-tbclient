package com.baidu.tbadk.j;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class p extends t {
    public long FD;
    public long Hg;
    public int aGj;
    public long aGr;
    public long aGs;
    public int aGt;
    private a aGu = null;
    private final Handler aGv = new q(this, Looper.getMainLooper());
    public long vm;

    public void FB() {
        this.aGv.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FC() {
        w wVar = (w) aa.FK().fc(this.mSubType);
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
        public Boolean doInBackground(String... strArr) {
            p.this.aGj = aa.FK().FO();
            p.this.FC();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
