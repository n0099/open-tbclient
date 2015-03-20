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
    private aa ZD;
    final /* synthetic */ a abK;
    private boolean abf;
    private String portrait;
    private String toUid;

    private b(a aVar) {
        this.abK = aVar;
        this.ZD = null;
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
        this.abf = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public String doInBackground(Integer... numArr) {
        try {
            if (this.portrait != null) {
                this.ZD = new aa();
                if (this.abf) {
                    this.ZD.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                } else {
                    this.ZD.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                }
                this.ZD.o(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, this.portrait);
                this.ZD.sp().tp().mIsNeedTbs = true;
                this.ZD.rO();
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
        this.abK.abJ = null;
        if (this.ZD != null) {
            com.baidu.tbadk.coreExtra.message.a aVar = new com.baidu.tbadk.coreExtra.message.a();
            aVar.abe = this.ZD.sp().tq().pv();
            aVar.errorString = this.ZD.getErrorString();
            aVar.abf = this.abf;
            aVar.toUid = this.toUid;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.i iVar;
        com.baidu.adp.base.i iVar2;
        super.cancel(true);
        if (this.ZD != null) {
            this.ZD.hh();
            this.ZD = null;
        }
        this.abK.abJ = null;
        iVar = this.abK.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.abK.mLoadDataCallBack;
            iVar2.c(false);
        }
    }
}
