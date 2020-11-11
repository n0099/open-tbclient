package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Ls;
    public long costTime;
    public long fuX;
    public long fuY;
    public long fuZ;
    public int fva;
    public int fvb;
    private a fvc = null;
    private final Handler fvd = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.fvc = new a();
            f.this.fvc.setSelfExecute(true);
            f.this.fvc.execute(new String[0]);
        }
    };

    public void bCn() {
        this.fvd.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCo() {
        j jVar = (j) m.bCu().rM(this.mSubType);
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
            f.this.fvb = m.bCu().getCpuUsageStatistic();
            f.this.bCo();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
