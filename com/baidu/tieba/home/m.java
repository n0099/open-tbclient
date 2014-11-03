package com.baidu.tieba.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tieba.aj;
import com.baidu.tieba.data.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<y, Integer, String> {
    final /* synthetic */ f aMC;
    private y aMD;
    private ac yV = null;

    public m(f fVar, y yVar) {
        this.aMC = fVar;
        this.aMD = null;
        this.aMD = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(y... yVarArr) {
        y yVar = this.aMD;
        if (yVar != null) {
            try {
                if (yVar.getId() != null && yVar.getName() != null) {
                    this.yV = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                    this.yV.k(ImageViewerConfig.FORUM_ID, yVar.getId());
                    this.yV.k("kw", yVar.getName());
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
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        r rVar;
        super.onPostExecute((m) str);
        this.aMC.aMs = null;
        if (this.yV != null) {
            if (this.yV.mc().nb().jq()) {
                baseFragmentActivity2 = this.aMC.aye;
                baseFragmentActivity2.showToast(this.aMC.getString(com.baidu.tieba.y.success));
                aj.wm().aR(true);
                rVar = this.aMC.aMr;
                rVar.hO();
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.aMD.getId()));
                return;
            }
            baseFragmentActivity = this.aMC.aye;
            baseFragmentActivity.showToast(this.yV.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.yV != null) {
            this.yV.dM();
            this.yV = null;
        }
        this.aMC.aMs = null;
        super.cancel(true);
    }
}
