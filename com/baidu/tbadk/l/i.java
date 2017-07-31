package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends k {
    public long Hc;
    public long IF;
    public int aJH;
    public long aJP;
    public long aJQ;
    public int aJR;
    private a aJS = null;
    private final Handler aJT = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.aJS = new a();
            i.this.aJS.setSelfExecute(true);
            i.this.aJS.execute(new String[0]);
        }
    };
    public long wP;

    public void Gq() {
        this.aJT.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gr() {
        n nVar = (n) r.Gz().fk(this.mSubType);
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
            i.this.aJH = r.Gz().GD();
            i.this.Gr();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
