package com.baidu.tbadk.p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Ak;
    public long Me;
    public long czL;
    public long czM;
    public long czN;
    public int czO;
    public int czP;
    private a czQ = null;
    private final Handler czR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.p.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.czQ = new a();
            f.this.czQ.setSelfExecute(true);
            f.this.czQ.execute(new String[0]);
        }
    };

    public void avo() {
        this.czR.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avp() {
        j jVar = (j) m.avv().kU(this.mSubType);
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
            f.this.czP = m.avv().avy();
            f.this.avp();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
