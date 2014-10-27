package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, b, Void> {
    FRSPageRequestMessage aAe;
    private int aAf;
    private final WeakReference<FrsActivity> aAg;
    final /* synthetic */ b azX;
    private String mName;

    public f(b bVar, FrsActivity frsActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, String str) {
        this.azX = bVar;
        this.mName = null;
        this.aAf = 3;
        this.aAg = new WeakReference<>(frsActivity);
        this.aAe = fRSPageRequestMessage;
        this.mName = str;
        this.aAf = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        dd ddVar;
        dd ddVar2;
        ddVar = this.azX.azK;
        if (ddVar != null) {
            ddVar2 = this.azX.azK;
            ddVar2.eH(this.aAf);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public Void doInBackground(Object... objArr) {
        boolean z;
        try {
            z = this.azX.azP;
            if (z && a.EV().fd(this.mName)) {
                if (!a.EV().isSameDay(String.valueOf(TbadkApplication.getCurrentAccount()) + this.mName)) {
                    a.EV().getForumModel().zJ().getSignData().setIsSigned(0);
                }
                publishProgress(a.EV().getForumModel());
            }
            this.azX.azR = System.currentTimeMillis();
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
    public void onProgressUpdate(b... bVarArr) {
        dd ddVar;
        dd ddVar2;
        ddVar = this.azX.azK;
        if (ddVar != null) {
            ddVar2 = this.azX.azK;
            ddVar2.g(bVarArr.length > 0 ? bVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Void r3) {
        boolean z;
        this.aAe.setUpdateType(this.aAf);
        FRSPageRequestMessage fRSPageRequestMessage = this.aAe;
        z = this.azX.azP;
        fRSPageRequestMessage.setNeedCache(z);
        if (this.aAg != null && this.aAg.get() != null) {
            this.aAg.get().sendMessage(this.aAe);
        }
        this.azX.azN = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        dd ddVar;
        dd ddVar2;
        super.cancel(true);
        ddVar = this.azX.azK;
        if (ddVar != null) {
            ddVar2 = this.azX.azK;
            ddVar2.a(this.aAf, true, null);
        }
    }
}
