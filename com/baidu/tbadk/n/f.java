package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long costTime;
    public long dzk;
    public long dzl;
    public long dzm;
    public int dzn;
    public int dzo;
    private a dzp = null;
    private final Handler dzq = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.dzp = new a();
            f.this.dzp.setSelfExecute(true);
            f.this.dzp.execute(new String[0]);
        }
    };
    public long qB;

    public void aOM() {
        this.dzq.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aON() {
        j jVar = (j) m.aOT().mw(this.mSubType);
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
            f.this.dzo = m.aOT().getCpuUsageStatistic();
            f.this.aON();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
