package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Kp;
    public long costTime;
    public long eGU;
    public long eGV;
    public long eGW;
    public int eGX;
    public int eGY;
    private a eGZ = null;
    private final Handler eHa = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.eGZ = new a();
            f.this.eGZ.setSelfExecute(true);
            f.this.eGZ.execute(new String[0]);
        }
    };

    public void blt() {
        this.eHa.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blu() {
        j jVar = (j) m.blA().or(this.mSubType);
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
            f.this.eGY = m.blA().getCpuUsageStatistic();
            f.this.blu();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
