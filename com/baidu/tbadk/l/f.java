package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long KM;
    public long aTC;
    public long aTD;
    public long aTE;
    public int aTF;
    public int aTG;
    private a aTH = null;
    private final Handler aTI = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.aTH = new a();
            f.this.aTH.setSelfExecute(true);
            f.this.aTH.execute(new String[0]);
        }
    };
    public long zq;

    public void KC() {
        this.aTI.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KD() {
        j jVar = (j) m.KJ().fo(this.mSubType);
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
            f.this.aTG = m.KJ().KM();
            f.this.KD();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
