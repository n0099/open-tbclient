package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, b, Void> {
    final /* synthetic */ b aAg;
    FRSPageRequestMessage aAn;
    private int aAo;
    private final WeakReference<FrsActivity> aAp;
    private String mName;

    public f(b bVar, FrsActivity frsActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, String str) {
        this.aAg = bVar;
        this.mName = null;
        this.aAo = 3;
        this.aAp = new WeakReference<>(frsActivity);
        this.aAn = fRSPageRequestMessage;
        this.mName = str;
        this.aAo = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        dd ddVar;
        dd ddVar2;
        ddVar = this.aAg.azT;
        if (ddVar != null) {
            ddVar2 = this.aAg.azT;
            ddVar2.eH(this.aAo);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public Void doInBackground(Object... objArr) {
        boolean z;
        try {
            z = this.aAg.azY;
            if (z && a.EX().fd(this.mName)) {
                if (!a.EX().isSameDay(String.valueOf(TbadkApplication.getCurrentAccount()) + this.mName)) {
                    a.EX().getForumModel().zL().getSignData().setIsSigned(0);
                }
                publishProgress(a.EX().getForumModel());
            }
            this.aAg.aAa = System.currentTimeMillis();
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
        ddVar = this.aAg.azT;
        if (ddVar != null) {
            ddVar2 = this.aAg.azT;
            ddVar2.g(bVarArr.length > 0 ? bVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Void r3) {
        boolean z;
        this.aAn.setUpdateType(this.aAo);
        FRSPageRequestMessage fRSPageRequestMessage = this.aAn;
        z = this.aAg.azY;
        fRSPageRequestMessage.setNeedCache(z);
        if (this.aAp != null && this.aAp.get() != null) {
            this.aAp.get().sendMessage(this.aAn);
        }
        this.aAg.azW = null;
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
        ddVar = this.aAg.azT;
        if (ddVar != null) {
            ddVar2 = this.aAg.azT;
            ddVar2.a(this.aAo, true, null);
        }
    }
}
