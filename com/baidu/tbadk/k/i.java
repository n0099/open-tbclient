package com.baidu.tbadk.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends j {
    public long aiR;
    public long aue;
    public long bAg;
    public long bAh;
    public long bAi;
    public int bAj;
    private a bAk = null;
    private final Handler bAl = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.k.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.bAk = new a();
            i.this.bAk.setSelfExecute(true);
            i.this.bAk.execute(new String[0]);
        }
    };
    public int bzY;

    public void Om() {
        this.bAl.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void On() {
        m mVar = (m) p.Ov().il(this.mSubType);
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
            i.this.bzY = p.Ov().Oy();
            i.this.On();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
