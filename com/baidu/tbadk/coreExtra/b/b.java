package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.base.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Integer, Integer, String> {
    final /* synthetic */ a LF;
    private boolean Lo;
    private String portrait;
    private String toUid;
    private ac yV;

    private b(a aVar) {
        this.LF = aVar;
        this.yV = null;
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

    public void ag(boolean z) {
        this.Lo = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(Integer... numArr) {
        try {
            if (this.portrait != null) {
                this.yV = new ac();
                if (this.Lo) {
                    this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FOLLOW_ADDRESS);
                } else {
                    this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFOLLOW_ADDRESS);
                }
                this.yV.k(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, this.portrait);
                this.yV.mc().na().mIsNeedTbs = true;
                this.yV.lA();
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
        this.LF.LE = null;
        if (this.yV != null) {
            com.baidu.tbadk.coreExtra.message.a aVar = new com.baidu.tbadk.coreExtra.message.a();
            aVar.Ln = this.yV.mc().nb().jq();
            aVar.errorString = this.yV.getErrorString();
            aVar.Lo = this.Lo;
            aVar.toUid = this.toUid;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        h hVar;
        h hVar2;
        super.cancel(true);
        if (this.yV != null) {
            this.yV.dM();
            this.yV = null;
        }
        this.LF.LE = null;
        hVar = this.LF.mLoadDataCallBack;
        if (hVar != null) {
            hVar2 = this.LF.mLoadDataCallBack;
            hVar2.a(false);
        }
    }
}
