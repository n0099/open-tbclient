package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long costTime;
    public long dDA;
    public long dDB;
    public long dDC;
    public int dDD;
    public int dDE;
    private a dDF = null;
    private final Handler dDG = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.dDF = new a();
            f.this.dDF.setSelfExecute(true);
            f.this.dDF.execute(new String[0]);
        }
    };
    public long qC;

    public void aRf() {
        this.dDG.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRg() {
        j jVar = (j) m.aRm().mN(this.mSubType);
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
            f.this.dDE = m.aRm().getCpuUsageStatistic();
            f.this.aRg();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
