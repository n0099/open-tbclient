package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes2.dex */
public class f extends g {
    public long KT;
    public long costTime;
    public long eRA;
    public long eRB;
    public long eRC;
    public int eRD;
    public int eRE;
    private a eRF = null;
    private final Handler eRG = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.eRF = new a();
            f.this.eRF.setSelfExecute(true);
            f.this.eRF.execute(new String[0]);
        }
    };

    public void bug() {
        this.eRG.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buh() {
        j jVar = (j) m.bun().qC(this.mSubType);
        if (jVar != null) {
            jVar.c(this);
        }
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            f.this.eRE = m.bun().getCpuUsageStatistic();
            f.this.buh();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
