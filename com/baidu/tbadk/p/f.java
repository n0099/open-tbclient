package com.baidu.tbadk.p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Ae;
    public long LQ;
    public long cyo;
    public long cyp;
    public long cyq;
    public int cyr;
    public int cys;
    private a cyt = null;
    private final Handler cyu = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.p.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.cyt = new a();
            f.this.cyt.setSelfExecute(true);
            f.this.cyt.execute(new String[0]);
        }
    };

    public void aud() {
        this.cyu.sendEmptyMessage(0);
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
            f.this.cys = m.auk().aun();
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
