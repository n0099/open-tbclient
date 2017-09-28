package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends k {
    public long Fa;
    public long GB;
    public int aIL;
    public long aIT;
    public long aIU;
    public int aIV;
    private a aIW = null;
    private final Handler aIX = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.k.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.aIW = new a();
            i.this.aIW.setSelfExecute(true);
            i.this.aIW.execute(new String[0]);
        }
    };
    public long uJ;

    public void FT() {
        this.aIX.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FU() {
        n nVar = (n) r.Gc().fv(this.mSubType);
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
            i.this.aIL = r.Gc().Gg();
            i.this.FU();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
