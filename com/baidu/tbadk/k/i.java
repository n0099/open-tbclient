package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends j {
    public long EI;
    public long aKF;
    public long aKG;
    public long aKH;
    public int aKI;
    private a aKJ = null;
    private final Handler aKK = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.k.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.aKJ = new a();
            i.this.aKJ.setSelfExecute(true);
            i.this.aKJ.execute(new String[0]);
        }
    };
    public int aKx;
    public long tq;

    public void GP() {
        this.aKK.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GQ() {
        m mVar = (m) p.Ha().fl(this.mSubType);
        if (mVar != null) {
            mVar.c(this);
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
            i.this.aKx = p.Ha().Hd();
            i.this.GQ();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
