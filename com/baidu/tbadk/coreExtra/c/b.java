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
    private ad CX;
    final /* synthetic */ a RL;
    private boolean Rt;
    private String portrait;
    private String toUid;

    private b(a aVar) {
        this.RL = aVar;
        this.CX = null;
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

    public void aw(boolean z) {
        this.Rt = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public String doInBackground(Integer... numArr) {
        try {
            if (this.portrait != null) {
                this.CX = new ad();
                if (this.Rt) {
                    this.CX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                } else {
                    this.CX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                }
                this.CX.o(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, this.portrait);
                this.CX.oZ().qg().mIsNeedTbs = true;
                this.CX.oy();
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
        this.RL.RK = null;
        if (this.CX != null) {
            com.baidu.tbadk.coreExtra.message.a aVar = new com.baidu.tbadk.coreExtra.message.a();
            aVar.Rs = this.CX.oZ().qh().ma();
            aVar.errorString = this.CX.getErrorString();
            aVar.Rt = this.Rt;
            aVar.toUid = this.toUid;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        com.baidu.adp.base.i iVar2;
        super.cancel(true);
        if (this.CX != null) {
            this.CX.dJ();
            this.CX = null;
        }
        this.RL.RK = null;
        iVar = this.RL.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.RL.mLoadDataCallBack;
            iVar2.c(false);
        }
    }
}
