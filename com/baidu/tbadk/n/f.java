package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Ls;
    public long costTime;
    public long fpc;
    public long fpd;
    public long fpe;
    public int fpf;
    public int fpg;
    private a fph = null;
    private final Handler fpi = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.fph = new a();
            f.this.fph.setSelfExecute(true);
            f.this.fph.execute(new String[0]);
        }
    };

    public void bzO() {
        this.fpi.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzP() {
        j jVar = (j) m.bzV().rC(this.mSubType);
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
            f.this.fpg = m.bzV().getCpuUsageStatistic();
            f.this.bzP();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
