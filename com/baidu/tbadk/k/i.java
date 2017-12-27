package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends k {
    public long aiV;
    public long asQ;
    public long auq;
    public int bxM;
    public long bxU;
    public long bxV;
    public int bxW;
    private a bxX = null;
    private final Handler bxY = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.k.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.bxX = new a();
            i.this.bxX.setSelfExecute(true);
            i.this.bxX.execute(new String[0]);
        }
    };

    public void NR() {
        this.bxY.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NS() {
        n nVar = (n) r.Oa().is(this.mSubType);
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
            i.this.bxM = r.Oa().Oe();
            i.this.NS();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
