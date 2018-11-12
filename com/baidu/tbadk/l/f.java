package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Cw;
    public long NL;
    public long bce;
    public long bcf;
    public long bcg;
    public int bch;
    public int bci;
    private a bcj = null;
    private final Handler bck = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.bcj = new a();
            f.this.bcj.setSelfExecute(true);
            f.this.bcj.execute(new String[0]);
        }
    };

    public void NZ() {
        this.bck.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oa() {
        j jVar = (j) m.Og().fX(this.mSubType);
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
            f.this.bci = m.Og().Oj();
            f.this.Oa();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
