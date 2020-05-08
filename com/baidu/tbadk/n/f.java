package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long JF;
    public long costTime;
    public long edA;
    public long edB;
    public long edC;
    public int edD;
    public int edE;
    private a edF = null;
    private final Handler edG = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.edF = new a();
            f.this.edF.setSelfExecute(true);
            f.this.edF.execute(new String[0]);
        }
    };

    public void aZr() {
        this.edG.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZs() {
        j jVar = (j) m.aZy().na(this.mSubType);
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
            f.this.edE = m.aZy().getCpuUsageStatistic();
            f.this.aZs();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
