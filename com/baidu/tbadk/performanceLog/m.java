package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class m extends r {
    public long Gq;
    public int awU;
    public long axc;
    public long axd;
    public long axe;
    public int axf;
    private a axg = null;
    private final Handler axh = new n(this, Looper.getMainLooper());
    public long uF;

    public void DN() {
        this.axh.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DO() {
        u uVar = (u) y.Eb().eB(this.mSubType);
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
            m.this.awU = y.Eb().Ef();
            m.this.DO();
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
