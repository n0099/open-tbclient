package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class p extends t {
    public long FH;
    public long Hm;
    public int aAk;
    public long aAs;
    public long aAt;
    public int aAu;
    private a aAv = null;
    private final Handler aAw = new q(this, Looper.getMainLooper());
    public long uW;

    public void FO() {
        this.aAw.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP() {
        w wVar = (w) aa.FY().fb(this.aAC);
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
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            p.this.aAk = aa.FY().Gc();
            p.this.FP();
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
