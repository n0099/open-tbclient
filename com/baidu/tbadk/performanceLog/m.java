package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class m extends r {
    public long Gs;
    public int avK;
    public long avS;
    public long avT;
    public long avU;
    public int avV;
    private a avW = null;
    private final Handler avX = new n(this, Looper.getMainLooper());
    public long uF;

    public void DD() {
        this.avX.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DE() {
        u uVar = (u) y.DR().ez(this.mSubType);
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
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            m.this.avK = y.DR().DV();
            m.this.DE();
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
