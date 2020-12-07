package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Mq;
    public long costTime;
    public long fBT;
    public long fBU;
    public long fBV;
    public int fBW;
    public int fBX;
    private a fBY = null;
    private final Handler fBZ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.fBY = new a();
            f.this.fBY.setSelfExecute(true);
            f.this.fBY.execute(new String[0]);
        }
    };

    public void bFg() {
        this.fBZ.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFh() {
        i iVar = (i) l.bFl().sL(this.mSubType);
        if (iVar != null) {
            iVar.c(this);
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
            f.this.fBX = l.bFl().getCpuUsageStatistic();
            f.this.bFh();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
