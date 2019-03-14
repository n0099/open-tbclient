package com.baidu.tbadk.o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Cw;
    public long Oi;
    public long cqe;
    public long cqf;
    public long cqg;
    public int cqh;
    public int cqi;
    private a cqj = null;
    private final Handler cqk = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.o.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.cqj = new a();
            f.this.cqj.setSelfExecute(true);
            f.this.cqj.execute(new String[0]);
        }
    };

    public void apc() {
        this.cqk.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apd() {
        j jVar = (j) m.apk().ka(this.mSubType);
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
            f.this.cqi = m.apk().apn();
            f.this.apd();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
