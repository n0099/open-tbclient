package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends j {
    public long aiX;
    public long aun;
    public int bAl;
    public long bAt;
    public long bAu;
    public long bAv;
    public int bAw;
    private a bAx = null;
    private final Handler bAy = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.k.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.bAx = new a();
            i.this.bAx.setSelfExecute(true);
            i.this.bAx.execute(new String[0]);
        }
    };

    public void On() {
        this.bAy.sendEmptyMessage(0);
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
            i.this.bAl = p.Ow().Oz();
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
