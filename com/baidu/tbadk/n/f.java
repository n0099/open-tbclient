package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long LN;
    public long costTime;
    public long fGS;
    public long fGT;
    public long fGU;
    public int fGV;
    public int fGW;
    private a fGX = null;
    private final Handler fGY = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.fGX = new a();
            f.this.fGX.setSelfExecute(true);
            f.this.fGX.execute(new String[0]);
        }
    };

    public void bDJ() {
        this.fGY.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDK() {
        i iVar = (i) k.bDO().rq(this.mSubType);
        if (iVar != null) {
            iVar.c(this);
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
            f.this.fGW = k.bDO().getCpuUsageStatistic();
            f.this.bDK();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
