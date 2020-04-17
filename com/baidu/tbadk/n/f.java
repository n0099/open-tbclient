package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long JC;
    public long costTime;
    private a edA = null;
    private final Handler edB = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.edA = new a();
            f.this.edA.setSelfExecute(true);
            f.this.edA.execute(new String[0]);
        }
    };
    public long edv;
    public long edw;
    public long edx;
    public int edy;
    public int edz;

    public void aZt() {
        this.edB.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZu() {
        j jVar = (j) m.aZA().na(this.mSubType);
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
            f.this.edz = m.aZA().getCpuUsageStatistic();
            f.this.aZu();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
