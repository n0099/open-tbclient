package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long costTime;
    public long dzc;
    public long dzd;
    public long dze;
    public int dzf;
    public int dzg;
    private a dzh = null;
    private final Handler dzi = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.dzh = new a();
            f.this.dzh.setSelfExecute(true);
            f.this.dzh.execute(new String[0]);
        }
    };
    public long qE;

    public void aOt() {
        this.dzi.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOu() {
        j jVar = (j) m.aOA().mw(this.mSubType);
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
            f.this.dzg = m.aOA().getCpuUsageStatistic();
            f.this.aOu();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
