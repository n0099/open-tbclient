package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends k {
    public long EM;
    public long Gn;
    public int aJA;
    private a aJB = null;
    private final Handler aJC = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.aJB = new a();
            i.this.aJB.setSelfExecute(true);
            i.this.aJB.execute(new String[0]);
        }
    };
    public int aJq;
    public long aJy;
    public long aJz;
    public long uK;

    public void Gk() {
        this.aJC.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gl() {
        n nVar = (n) r.Gt().fu(this.mSubType);
        if (nVar != null) {
            nVar.c(this);
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
            i.this.aJq = r.Gt().Gx();
            i.this.Gl();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
