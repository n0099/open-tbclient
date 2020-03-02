package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long costTime;
    public long dDn;
    public long dDo;
    public long dDp;
    public int dDq;
    public int dDr;
    private a dDs = null;
    private final Handler dDt = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.dDs = new a();
            f.this.dDs.setSelfExecute(true);
            f.this.dDs.execute(new String[0]);
        }
    };
    public long qC;

    public void aRe() {
        this.dDt.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRf() {
        j jVar = (j) m.aRl().mN(this.mSubType);
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
            f.this.dDr = m.aRl().getCpuUsageStatistic();
            f.this.aRf();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
