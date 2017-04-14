package com.baidu.tbadk.j;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class p extends t {
    public long FA;
    public long He;
    public int aGd;
    public long aGl;
    public long aGm;
    public int aGn;
    private a aGo = null;
    private final Handler aGp = new q(this, Looper.getMainLooper());
    public long vg;

    public void Gx() {
        this.aGp.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gy() {
        w wVar = (w) aa.GG().fg(this.mSubType);
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
            p.this.aGd = aa.GG().GK();
            p.this.Gy();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
