package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class i extends k {
    public long EY;
    public long GA;
    public int aJn;
    public long aJv;
    public long aJw;
    public int aJx;
    private a aJy = null;
    private final Handler aJz = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.aJy = new a();
            i.this.aJy.setSelfExecute(true);
            i.this.aJy.execute(new String[0]);
        }
    };
    public long uH;

    public void Go() {
        this.aJz.sendEmptyMessage(0);
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
            i.this.aJn = r.Gx().GB();
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
