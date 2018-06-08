package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long KO;
    public long aSF;
    public long aSG;
    public long aSH;
    public int aSI;
    public int aSJ;
    private a aSK = null;
    private final Handler aSL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.k.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.aSK = new a();
            f.this.aSK.setSelfExecute(true);
            f.this.aSK.execute(new String[0]);
        }
    };
    public long zw;

    public void Kl() {
        this.aSL.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km() {
        j jVar = (j) m.Ks().fn(this.mSubType);
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
            f.this.aSJ = m.Ks().Kv();
            f.this.Km();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
