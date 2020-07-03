package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Kp;
    public long costTime;
    public long eAF;
    public long eAG;
    public long eAH;
    public int eAI;
    public int eAJ;
    private a eAK = null;
    private final Handler eAL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.eAK = new a();
            f.this.eAK.setSelfExecute(true);
            f.this.eAK.execute(new String[0]);
        }
    };

    public void bhI() {
        this.eAL.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhJ() {
        j jVar = (j) m.bhP().nZ(this.mSubType);
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
            f.this.eAJ = m.bhP().getCpuUsageStatistic();
            f.this.bhJ();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
