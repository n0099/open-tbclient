package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long LQ;
    public long costTime;
    public long fLA;
    public long fLB;
    public int fLC;
    public int fLD;
    private a fLE = null;
    private final Handler fLF = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.fLE = new a();
            f.this.fLE.setSelfExecute(true);
            f.this.fLE.execute(new String[0]);
        }
    };
    public long fLz;

    public void bHB() {
        this.fLF.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHC() {
        i iVar = (i) k.bHG().sW(this.mSubType);
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
            f.this.fLD = k.bHG().getCpuUsageStatistic();
            f.this.bHC();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
