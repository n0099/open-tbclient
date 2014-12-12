package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Integer, Integer, String> {
    private ad CV;
    private boolean QP;
    final /* synthetic */ a Rh;
    private String portrait;
    private String toUid;

    private b(a aVar) {
        this.Rh = aVar;
        this.CV = null;
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

    public void au(boolean z) {
        this.QP = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public String doInBackground(Integer... numArr) {
        try {
            if (this.portrait != null) {
                this.CV = new ad();
                if (this.QP) {
                    this.CV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                } else {
                    this.CV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                }
                this.CV.o(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, this.portrait);
                this.CV.oW().pV().mIsNeedTbs = true;
                this.CV.ov();
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
        this.Rh.Rg = null;
        if (this.CV != null) {
            com.baidu.tbadk.coreExtra.message.a aVar = new com.baidu.tbadk.coreExtra.message.a();
            aVar.QO = this.CV.oW().pW().ma();
            aVar.errorString = this.CV.getErrorString();
            aVar.QP = this.QP;
            aVar.toUid = this.toUid;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        com.baidu.adp.base.i iVar2;
        super.cancel(true);
        if (this.CV != null) {
            this.CV.dL();
            this.CV = null;
        }
        this.Rh.Rg = null;
        iVar = this.Rh.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.Rh.mLoadDataCallBack;
            iVar2.c(false);
        }
    }
}
