package com.baidu.tbadk.j;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class p extends t {
    public long FD;
    public long Hf;
    public int aHk;
    public long aHs;
    public long aHt;
    public int aHu;
    private a aHv = null;
    private final Handler aHw = new q(this, Looper.getMainLooper());
    public long vl;

    public void FS() {
        this.aHw.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FT() {
        w wVar = (w) aa.Gb().ff(this.mSubType);
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
            p.this.aHk = aa.Gb().Gf();
            p.this.FT();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
