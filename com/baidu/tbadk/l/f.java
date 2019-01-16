package com.baidu.tbadk.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Cw;
    public long NW;
    public long bgr;
    public long bgt;
    public long bgu;
    public int bgv;
    public int bgw;
    private a bgx = null;
    private final Handler bgy = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.l.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.bgx = new a();
            f.this.bgx.setSelfExecute(true);
            f.this.bgx.execute(new String[0]);
        }
    };

    public void Pw() {
        this.bgy.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Px() {
        j jVar = (j) m.PD().gm(this.mSubType);
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
            f.this.bgw = m.PD().PG();
            f.this.Px();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
