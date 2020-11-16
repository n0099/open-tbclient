package com.baidu.tbadk.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Ls;
    public long costTime;
    public long fuh;
    public long fui;
    public long fuj;
    public int fuk;
    public int ful;
    private a fum = null;
    private final Handler fun = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.n.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.fum = new a();
            f.this.fum.setSelfExecute(true);
            f.this.fum.execute(new String[0]);
        }
    };

    public void bBD() {
        this.fun.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBE() {
        j jVar = (j) m.bBK().sk(this.mSubType);
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
            f.this.ful = m.bBK().getCpuUsageStatistic();
            f.this.bBE();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
