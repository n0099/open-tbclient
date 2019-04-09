package com.baidu.tbadk.o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Cv;
    public long Oi;
    public long cqh;
    public long cqi;
    public long cqj;
    public int cqk;
    public int cql;
    private a cqm = null;
    private final Handler cqn = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.o.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.cqm = new a();
            f.this.cqm.setSelfExecute(true);
            f.this.cqm.execute(new String[0]);
        }
    };

    public void aoZ() {
        this.cqn.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apa() {
        j jVar = (j) m.apg().jZ(this.mSubType);
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
            f.this.cql = m.apg().apk();
            f.this.apa();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
