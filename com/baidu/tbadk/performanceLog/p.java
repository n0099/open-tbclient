package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class p extends t {
    public int ayI;
    public long ayQ;
    public long ayR;
    public int ayS;
    private a ayT = null;
    private final Handler ayU = new q(this, Looper.getMainLooper());
    public long lB;
    public long wI;
    public long yn;

    public void EM() {
        this.ayU.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EN() {
        w wVar = (w) aa.EV().eS(this.aza);
        if (wVar != null) {
            wVar.c(this);
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
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            p.this.ayI = aa.EV().EZ();
            p.this.EN();
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
        }
    }
}
