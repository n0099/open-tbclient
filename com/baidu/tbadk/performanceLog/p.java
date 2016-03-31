package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class p extends t {
    public long FN;
    public long Hs;
    public int aAZ;
    public long aBh;
    public long aBi;
    public int aBj;
    private a aBk = null;
    private final Handler aBl = new q(this, Looper.getMainLooper());
    public long vh;

    public void GL() {
        this.aBl.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GM() {
        w wVar = (w) aa.GU().fj(this.aBr);
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
            p.this.aAZ = aa.GU().GY();
            p.this.GM();
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
