package com.baidu.tbadk.p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Af;
    public long LR;
    public long cyn;
    public long cyo;
    public long cyp;
    public int cyq;
    public int cyr;
    private a cys = null;
    private final Handler cyt = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.p.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.cys = new a();
            f.this.cys.setSelfExecute(true);
            f.this.cys.execute(new String[0]);
        }
    };

    public void aud() {
        this.cyt.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aue() {
        j jVar = (j) m.auk().kN(this.mSubType);
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
            f.this.cyr = m.auk().aun();
            f.this.aue();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
