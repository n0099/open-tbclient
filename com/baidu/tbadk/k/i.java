package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends j {
    public long EE;
    public long aKG;
    public long aKH;
    public long aKI;
    public int aKJ;
    private a aKK = null;
    private final Handler aKL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.k.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.aKK = new a();
            i.this.aKK.setSelfExecute(true);
            i.this.aKK.execute(new String[0]);
        }
    };
    public int aKy;
    public long tp;

    public void GN() {
        this.aKL.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GO() {
        m mVar = (m) p.GY().fm(this.mSubType);
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
            i.this.aKy = p.GY().Hb();
            i.this.GO();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
