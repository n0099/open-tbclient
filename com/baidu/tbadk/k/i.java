package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends j {
    public long aiR;
    public long auf;
    public int bAb;
    public long bAj;
    public long bAk;
    public long bAl;
    public int bAm;
    private a bAn = null;
    private final Handler bAo = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.k.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.bAn = new a();
            i.this.bAn.setSelfExecute(true);
            i.this.bAn.execute(new String[0]);
        }
    };

    public void On() {
        this.bAo.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oo() {
        m mVar = (m) p.Ow().il(this.mSubType);
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
            i.this.bAb = p.Ow().Oz();
            i.this.Oo();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
