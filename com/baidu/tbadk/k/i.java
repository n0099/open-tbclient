package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends k {
    public long aiV;
    public long asP;
    public long aup;
    public int bxV;
    public long byd;
    public long bye;
    public int byf;
    private a byg = null;
    private final Handler byh = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.k.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.byg = new a();
            i.this.byg.setSelfExecute(true);
            i.this.byg.execute(new String[0]);
        }
    };

    public void NF() {
        this.byh.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NG() {
        n nVar = (n) r.NO().io(this.mSubType);
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
            i.this.bxV = r.NO().NS();
            i.this.NG();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
