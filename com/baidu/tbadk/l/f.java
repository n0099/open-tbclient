package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long BL;
    public long Nm;
    public long aWR;
    public long aWS;
    public long aWT;
    public int aWU;
    public int aWV;
    private a aWW = null;
    private final Handler aWX = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.aWW = new a();
            f.this.aWW.setSelfExecute(true);
            f.this.aWW.execute(new String[0]);
        }
    };

    public void LS() {
        this.aWX.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LT() {
        j jVar = (j) m.LZ().fA(this.mSubType);
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
            f.this.aWV = m.LZ().Mc();
            f.this.LT();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
