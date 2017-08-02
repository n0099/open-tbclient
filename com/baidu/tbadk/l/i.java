package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends k {
    public long FD;
    public long Hf;
    public long aIA;
    public long aIB;
    public int aIC;
    private a aID = null;
    private final Handler aIE = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.aID = new a();
            i.this.aID.setSelfExecute(true);
            i.this.aID.execute(new String[0]);
        }
    };
    public int aIs;
    public long vm;

    public void Gi() {
        this.aIE.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gj() {
        n nVar = (n) r.Gr().fi(this.mSubType);
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
            i.this.aIs = r.Gr().Gv();
            i.this.Gj();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
