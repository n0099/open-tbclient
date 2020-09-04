package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long KT;
    public long costTime;
    public long eRE;
    public long eRF;
    public long eRG;
    public int eRH;
    public int eRI;
    private a eRJ = null;
    private final Handler eRK = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.eRJ = new a();
            f.this.eRJ.setSelfExecute(true);
            f.this.eRJ.execute(new String[0]);
        }
    };

    public void buh() {
        this.eRK.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bui() {
        j jVar = (j) m.buo().qC(this.mSubType);
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
            f.this.eRI = m.buo().getCpuUsageStatistic();
            f.this.bui();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
