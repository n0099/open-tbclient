package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class m extends r {
    public long Gq;
    public long ayD;
    public long ayE;
    public long ayF;
    public int ayG;
    private a ayH = null;
    private final Handler ayI = new n(this, Looper.getMainLooper());
    public int ayv;
    public long uF;

    public void Ea() {
        this.ayI.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eb() {
        u uVar = (u) y.Eo().eA(this.mSubType);
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
            m.this.ayv = y.Eo().Es();
            m.this.Eb();
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
