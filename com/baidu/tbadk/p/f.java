package com.baidu.tbadk.p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Ak;
    public long Me;
    public long cAH;
    public long cAI;
    public long cAJ;
    public int cAK;
    public int cAL;
    private a cAM = null;
    private final Handler cAN = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.p.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.cAM = new a();
            f.this.cAM.setSelfExecute(true);
            f.this.cAM.execute(new String[0]);
        }
    };

    public void avA() {
        this.cAN.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avB() {
        j jVar = (j) m.avH().kX(this.mSubType);
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
            f.this.cAL = m.avH().avK();
            f.this.avB();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
