package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends k {
    public long EY;
    public long GA;
    public int aJk;
    public long aJs;
    public long aJt;
    public int aJu;
    private a aJv = null;
    private final Handler aJw = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.aJv = new a();
            i.this.aJv.setSelfExecute(true);
            i.this.aJv.execute(new String[0]);
        }
    };
    public long uH;

    public void Go() {
        this.aJw.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gp() {
        n nVar = (n) r.Gx().fk(this.mSubType);
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
            i.this.aJk = r.Gx().GB();
            i.this.Gp();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
