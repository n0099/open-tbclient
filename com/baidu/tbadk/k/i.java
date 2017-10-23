package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends k {
    public long Fb;
    public long GC;
    public long aIG;
    public long aIH;
    public int aII;
    private a aIJ = null;
    private final Handler aIK = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.k.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.aIJ = new a();
            i.this.aIJ.setSelfExecute(true);
            i.this.aIJ.execute(new String[0]);
        }
    };
    public int aIy;
    public long uK;

    public void FN() {
        this.aIK.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FO() {
        n nVar = (n) r.FW().fu(this.mSubType);
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
            i.this.aIy = r.FW().Ga();
            i.this.FO();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
