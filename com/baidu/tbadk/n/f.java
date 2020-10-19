package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Ls;
    public long costTime;
    public long fgD;
    public long fgE;
    public long fgF;
    public int fgG;
    public int fgH;
    private a fgI = null;
    private final Handler fgJ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.fgI = new a();
            f.this.fgI.setSelfExecute(true);
            f.this.fgI.execute(new String[0]);
        }
    };

    public void bxV() {
        this.fgJ.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxW() {
        j jVar = (j) m.byc().rr(this.mSubType);
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
            f.this.fgH = m.byc().getCpuUsageStatistic();
            f.this.bxW();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
