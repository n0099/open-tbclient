package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class p extends t {
    public long FZ;
    public long HD;
    public int aFN;
    public long aFV;
    public long aFW;
    public int aFX;
    private a aFY = null;
    private final Handler aFZ = new q(this, Looper.getMainLooper());
    public long vD;

    public void FZ() {
        this.aFZ.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga() {
        w wVar = (w) aa.Gi().fd(this.aGf);
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
            p.this.aFN = aa.Gi().Gm();
            p.this.Ga();
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
