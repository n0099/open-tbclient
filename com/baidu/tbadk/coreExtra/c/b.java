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
    private aa aaG;
    final /* synthetic */ a acX;
    private boolean acr;
    private String portrait;
    private String toUid;

    private b(a aVar) {
        this.acX = aVar;
        this.aaG = null;
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

    public void aJ(boolean z) {
        this.acr = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public String doInBackground(Integer... numArr) {
        try {
            if (this.portrait != null) {
                this.aaG = new aa();
                if (this.acr) {
                    this.aaG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                } else {
                    this.aaG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                }
                this.aaG.o(com.baidu.tbadk.core.frameworkData.c.PORTRAIT, this.portrait);
                this.aaG.sX().tS().mIsNeedTbs = true;
                this.aaG.sw();
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
        this.acX.acW = null;
        if (this.aaG != null) {
            com.baidu.tbadk.coreExtra.message.a aVar = new com.baidu.tbadk.coreExtra.message.a();
            aVar.acq = this.aaG.sX().tT().qa();
            aVar.errorString = this.aaG.getErrorString();
            aVar.acr = this.acr;
            aVar.toUid = this.toUid;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        com.baidu.adp.base.i iVar2;
        super.cancel(true);
        if (this.aaG != null) {
            this.aaG.gS();
            this.aaG = null;
        }
        this.acX.acW = null;
        iVar = this.acX.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.acX.mLoadDataCallBack;
            iVar2.c(false);
        }
    }
}
