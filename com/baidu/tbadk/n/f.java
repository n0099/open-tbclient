package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long JP;
    public long costTime;
    public long erN;
    public long erO;
    public long erP;
    public int erQ;
    public int erR;
    private a erS = null;
    private final Handler erT = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.erS = new a();
            f.this.erS.setSelfExecute(true);
            f.this.erS.execute(new String[0]);
        }
    };

    public void bfC() {
        this.erT.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfD() {
        j jVar = (j) m.bfJ().nE(this.mSubType);
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
            f.this.erR = m.bfJ().getCpuUsageStatistic();
            f.this.bfD();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
