package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long costTime;
    public long dDO;
    public long dDP;
    public long dDQ;
    public int dDR;
    public int dDS;
    private a dDT = null;
    private final Handler dDU = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.dDT = new a();
            f.this.dDT.setSelfExecute(true);
            f.this.dDT.execute(new String[0]);
        }
    };
    public long qB;

    public void aRj() {
        this.dDU.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRk() {
        j jVar = (j) m.aRq().mP(this.mSubType);
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
            f.this.dDS = m.aRq().getCpuUsageStatistic();
            f.this.aRk();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
