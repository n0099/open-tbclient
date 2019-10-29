package com.baidu.tbadk.p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long cLQ;
    public long cLR;
    public long cLS;
    public int cLT;
    public int cLU;
    private a cLV = null;
    private final Handler cLW = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.p.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.cLV = new a();
            f.this.cLV.setSelfExecute(true);
            f.this.cLV.execute(new String[0]);
        }
    };
    public long costTime;
    public long oK;

    public void awG() {
        this.cLW.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awH() {
        j jVar = (j) m.awN().ki(this.mSubType);
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
            f.this.cLU = m.awN().getCpuUsageStatistic();
            f.this.awH();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
