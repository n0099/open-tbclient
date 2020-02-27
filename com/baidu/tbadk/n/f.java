package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long costTime;
    public long dDm;
    public long dDn;
    public long dDo;
    public int dDp;
    public int dDq;
    private a dDr = null;
    private final Handler dDs = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.dDr = new a();
            f.this.dDr.setSelfExecute(true);
            f.this.dDr.execute(new String[0]);
        }
    };
    public long qC;

    public void aRc() {
        this.dDs.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRd() {
        j jVar = (j) m.aRj().mN(this.mSubType);
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
            f.this.dDq = m.aRj().getCpuUsageStatistic();
            f.this.aRd();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
