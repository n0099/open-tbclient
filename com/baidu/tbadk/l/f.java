package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Ct;
    public long NI;
    public long bbr;
    public long bbs;
    public long bbt;
    public int bbu;
    public int bbv;
    private a bbw = null;
    private final Handler bbx = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.bbw = new a();
            f.this.bbw.setSelfExecute(true);
            f.this.bbw.execute(new String[0]);
        }
    };

    public void NQ() {
        this.bbx.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NR() {
        j jVar = (j) m.NX().fJ(this.mSubType);
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
            f.this.bbv = m.NX().Oa();
            f.this.NR();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
