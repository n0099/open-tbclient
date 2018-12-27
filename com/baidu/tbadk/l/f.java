package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Cw;
    public long NL;
    public long bfH;
    public long bfI;
    public long bfJ;
    public int bfK;
    public int bfL;
    private a bfM = null;
    private final Handler bfN = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.bfM = new a();
            f.this.bfM.setSelfExecute(true);
            f.this.bfM.execute(new String[0]);
        }
    };

    public void Pe() {
        this.bfN.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pf() {
        j jVar = (j) m.Pl().gm(this.mSubType);
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
            f.this.bfL = m.Pl().Po();
            f.this.Pf();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
