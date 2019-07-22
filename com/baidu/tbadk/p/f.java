package com.baidu.tbadk.p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class f extends g {
    public long Ak;
    public long Me;
    public long czE;
    public long czF;
    public long czG;
    public int czH;
    public int czI;
    private a czJ = null;
    private final Handler czK = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.p.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.czJ = new a();
            f.this.czJ.setSelfExecute(true);
            f.this.czJ.execute(new String[0]);
        }
    };

    public void avm() {
        this.czK.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avn() {
        j jVar = (j) m.avt().kT(this.mSubType);
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
            f.this.czI = m.avt().avw();
            f.this.avn();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }
    }
}
