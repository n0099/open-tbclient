package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Integer, Integer, String> {
    private aa ZF;
    final /* synthetic */ a abS;
    private boolean abn;
    private String portrait;
    private String toUid;

    private b(a aVar) {
        this.abS = aVar;
        this.ZF = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, b bVar) {
        this(aVar);
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setToUid(String str) {
        this.toUid = str;
    }

    public void aC(boolean z) {
        this.abn = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public String doInBackground(Integer... numArr) {
        try {
            if (this.portrait != null) {
                this.ZF = new aa();
                if (this.abn) {
                    this.ZF.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                } else {
                    this.ZF.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                }
                this.ZF.o(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, this.portrait);
                this.ZF.sp().tp().mIsNeedTbs = true;
                this.ZF.rO();
                return null;
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((b) str);
        this.abS.abR = null;
        if (this.ZF != null) {
            com.baidu.tbadk.coreExtra.message.a aVar = new com.baidu.tbadk.coreExtra.message.a();
            aVar.abm = this.ZF.sp().tq().pv();
            aVar.errorString = this.ZF.getErrorString();
            aVar.abn = this.abn;
            aVar.toUid = this.toUid;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        com.baidu.adp.base.i iVar2;
        super.cancel(true);
        if (this.ZF != null) {
            this.ZF.hh();
            this.ZF = null;
        }
        this.abS.abR = null;
        iVar = this.abS.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.abS.mLoadDataCallBack;
            iVar2.c(false);
        }
    }
}
