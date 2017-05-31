package com.baidu.tbadk.j;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class p extends t {
    public long FD;
    public long Hg;
    public int aFW;
    public long aGe;
    public long aGf;
    public int aGg;
    private a aGh = null;
    private final Handler aGi = new q(this, Looper.getMainLooper());
    public long vm;

    public void Fv() {
        this.aGi.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fw() {
        w wVar = (w) aa.FE().fd(this.mSubType);
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
            p.this.aFW = aa.FE().FI();
            p.this.Fw();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
