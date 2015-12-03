package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class m extends r {
    public long GJ;
    public int axP;
    public long axX;
    public long axY;
    public long axZ;
    public int aya;
    private a ayb = null;
    private final Handler ayc = new n(this, Looper.getMainLooper());
    public long uL;

    public void EE() {
        this.ayc.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EF() {
        u uVar = (u) y.ES().eN(this.mSubType);
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
            m.this.axP = y.ES().EW();
            m.this.EF();
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
