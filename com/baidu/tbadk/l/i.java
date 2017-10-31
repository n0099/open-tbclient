package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends k {
    public long EM;
    public long Gn;
    public int aJi;
    public long aJq;
    public long aJr;
    public int aJs;
    private a aJt = null;
    private final Handler aJu = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.aJt = new a();
            i.this.aJt.setSelfExecute(true);
            i.this.aJt.execute(new String[0]);
        }
    };
    public long uK;

    public void FZ() {
        this.aJu.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga() {
        n nVar = (n) r.Gi().fv(this.mSubType);
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
            i.this.aJi = r.Gi().Gm();
            i.this.Ga();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
