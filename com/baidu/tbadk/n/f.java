package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Ni;
    public long aBi;
    public long costTime;
    public long fKE;
    public long fKF;
    public int fKG;
    public int fKH;
    private a fKI = null;
    private final Handler fKJ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.fKI = new a();
            f.this.fKI.setSelfExecute(true);
            f.this.fKI.execute(new String[0]);
        }
    };

    public void bEf() {
        this.fKJ.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEg() {
        i iVar = (i) k.bEk().rx(this.mSubType);
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
            f.this.fKH = k.bEk().getCpuUsageStatistic();
            f.this.bEg();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
