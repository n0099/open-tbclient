package com.baidu.tbadk.o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Cv;
    public long Oi;
    public long cqg;
    public long cqh;
    public long cqi;
    public int cqj;
    public int cqk;
    private a cql = null;
    private final Handler cqm = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.o.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.cql = new a();
            f.this.cql.setSelfExecute(true);
            f.this.cql.execute(new String[0]);
        }
    };

    public void aoZ() {
        this.cqm.sendEmptyMessage(0);
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
            f.this.cqk = m.apg().apk();
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
