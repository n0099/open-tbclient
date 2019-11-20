package com.baidu.tbadk.p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long cKZ;
    public long cLa;
    public long cLb;
    public int cLc;
    public int cLd;
    private a cLe = null;
    private final Handler cLf = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.p.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.cLe = new a();
            f.this.cLe.setSelfExecute(true);
            f.this.cLe.execute(new String[0]);
        }
    };
    public long costTime;
    public long oi;

    public void awE() {
        this.cLf.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awF() {
        j jVar = (j) m.awL().kh(this.mSubType);
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
            f.this.cLd = m.awL().getCpuUsageStatistic();
            f.this.awF();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
