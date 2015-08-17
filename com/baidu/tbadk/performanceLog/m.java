package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class m extends r {
    public long Gq;
    public int awN;
    public long awV;
    public long awW;
    public long awX;
    public int awY;
    private a awZ = null;
    private final Handler axa = new n(this, Looper.getMainLooper());
    public long uH;

    public void DQ() {
        this.axa.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DR() {
        u uVar = (u) y.Ee().es(this.mSubType);
        if (uVar != null) {
            uVar.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Boolean doInBackground(String... strArr) {
            m.this.awN = y.Ee().Ei();
            m.this.DR();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
        }
    }
}
