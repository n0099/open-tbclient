package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends k {
    public long aiY;
    public long asS;
    public long aus;
    public int bye;
    public long bym;
    public long byn;
    public int byo;
    private a byp = null;
    private final Handler byq = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.k.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.byp = new a();
            i.this.byp.setSelfExecute(true);
            i.this.byp.execute(new String[0]);
        }
    };

    public void NH() {
        this.byq.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NI() {
        n nVar = (n) r.NQ().io(this.mSubType);
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
            i.this.bye = r.NQ().NU();
            i.this.NI();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
