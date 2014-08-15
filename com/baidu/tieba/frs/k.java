package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, g, Void> {
    FRSPageRequestMessage a;
    final /* synthetic */ g b;
    private String c;
    private int d;
    private final WeakReference<FrsActivity> e;

    public k(g gVar, FrsActivity frsActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, String str) {
        this.b = gVar;
        this.c = null;
        this.d = 3;
        this.e = new WeakReference<>(frsActivity);
        this.a = fRSPageRequestMessage;
        this.c = str;
        this.d = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        dl dlVar;
        dl dlVar2;
        dlVar = this.b.n;
        if (dlVar != null) {
            dlVar2 = this.b.n;
            dlVar2.a(this.d);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Object... objArr) {
        boolean z;
        try {
            z = this.b.s;
            if (z && f.a().a(this.c)) {
                if (!f.a().b(String.valueOf(TbadkApplication.getCurrentAccount()) + this.c)) {
                    f.a().b().i().getSignData().setIsSigned(0);
                }
                publishProgress(f.a().b());
            }
            this.b.v = System.currentTimeMillis();
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(g... gVarArr) {
        dl dlVar;
        dl dlVar2;
        dlVar = this.b.n;
        if (dlVar != null) {
            dlVar2 = this.b.n;
            dlVar2.a(gVarArr.length > 0 ? gVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Void r3) {
        boolean z;
        this.a.setUpdateType(this.d);
        FRSPageRequestMessage fRSPageRequestMessage = this.a;
        z = this.b.s;
        fRSPageRequestMessage.setNeedCache(z);
        if (this.e != null && this.e.get() != null) {
            this.e.get().sendMessage(this.a);
        }
        this.b.q = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        dl dlVar;
        dl dlVar2;
        super.cancel(true);
        dlVar = this.b.n;
        if (dlVar != null) {
            dlVar2 = this.b.n;
            dlVar2.a(this.d, true, null);
        }
    }
}
