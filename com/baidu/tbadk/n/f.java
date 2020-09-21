package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Lc;
    public long costTime;
    private a eUA = null;
    private final Handler eUB = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.eUA = new a();
            f.this.eUA.setSelfExecute(true);
            f.this.eUA.execute(new String[0]);
        }
    };
    public long eUv;
    public long eUw;
    public long eUx;
    public int eUy;
    public int eUz;

    public void bvl() {
        this.eUB.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvm() {
        j jVar = (j) m.bvs().qT(this.mSubType);
        if (jVar != null) {
            jVar.c(this);
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            f.this.eUz = m.bvs().getCpuUsageStatistic();
            f.this.bvm();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
