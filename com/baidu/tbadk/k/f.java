package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long KQ;
    public long aTB;
    public long aTC;
    public long aTD;
    public int aTE;
    public int aTF;
    private a aTG = null;
    private final Handler aTH = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.k.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.aTG = new a();
            f.this.aTG.setSelfExecute(true);
            f.this.aTG.execute(new String[0]);
        }
    };
    public long zu;

    public void KD() {
        this.aTH.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KE() {
        j jVar = (j) m.KK().fo(this.mSubType);
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
            f.this.aTF = m.KK().KN();
            f.this.KE();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
