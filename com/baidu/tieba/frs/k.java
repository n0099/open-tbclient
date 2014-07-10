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
        di diVar;
        di diVar2;
        diVar = this.b.l;
        if (diVar != null) {
            diVar2 = this.b.l;
            diVar2.a(this.d);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Object... objArr) {
        boolean z;
        try {
            z = this.b.q;
            if (z && f.a().a(this.c)) {
                if (!f.a().c(String.valueOf(TbadkApplication.getCurrentAccount()) + this.c)) {
                    f.a().b().g().getSignData().setIsSigned(0);
                }
                publishProgress(f.a().b());
            }
            this.b.t = System.currentTimeMillis();
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
        di diVar;
        di diVar2;
        diVar = this.b.l;
        if (diVar != null) {
            diVar2 = this.b.l;
            diVar2.a(gVarArr.length > 0 ? gVarArr[0] : null);
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
        z = this.b.q;
        fRSPageRequestMessage.setNeedCache(z);
        if (this.e != null && this.e.get() != null) {
            this.e.get().sendMessage(this.a);
        }
        this.b.o = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        di diVar;
        di diVar2;
        super.cancel(true);
        diVar = this.b.l;
        if (diVar != null) {
            diVar2 = this.b.l;
            diVar2.a(this.d, true, null);
        }
    }
}
