package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Cw;
    public long NL;
    public long bfE;
    public long bfF;
    public long bfG;
    public int bfH;
    public int bfI;
    private a bfJ = null;
    private final Handler bfK = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.bfJ = new a();
            f.this.bfJ.setSelfExecute(true);
            f.this.bfJ.execute(new String[0]);
        }
    };

    public void Pd() {
        this.bfK.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pe() {
        j jVar = (j) m.Pk().gl(this.mSubType);
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
            f.this.bfI = m.Pk().Pn();
            f.this.Pe();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
