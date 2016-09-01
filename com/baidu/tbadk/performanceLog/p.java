package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class p extends t {
    public long AA;
    public int aBP;
    public long aBX;
    public long aBY;
    public int aBZ;
    private a aCa = null;
    private final Handler aCb = new q(this, Looper.getMainLooper());
    public long nU;
    public long yU;

    public void Gg() {
        this.aCb.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh() {
        w wVar = (w) aa.Gp().fg(this.aCh);
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
            p.this.aBP = aa.Gp().Gt();
            p.this.Gh();
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
