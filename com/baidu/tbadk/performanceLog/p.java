package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class p extends t {
    public long Aq;
    public long aAD;
    public long aAE;
    public int aAF;
    private a aAG = null;
    private final Handler aAH = new q(this, Looper.getMainLooper());
    public int aAv;
    public long nO;
    public long yL;

    public void FF() {
        this.aAH.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FG() {
        w wVar = (w) aa.FO().fj(this.aAN);
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
            p.this.aAv = aa.FO().FS();
            p.this.FG();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
        }
    }
}
