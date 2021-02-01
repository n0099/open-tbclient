package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long LK;
    public long azI;
    public long costTime;
    public long fJe;
    public long fJf;
    public int fJg;
    public int fJh;
    private a fJi = null;
    private final Handler fJj = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.fJi = new a();
            f.this.fJi.setSelfExecute(true);
            f.this.fJi.execute(new String[0]);
        }
    };

    public void bEb() {
        this.fJj.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEc() {
        i iVar = (i) k.bEg().rv(this.mSubType);
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
            f.this.fJh = k.bEg().getCpuUsageStatistic();
            f.this.bEc();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
