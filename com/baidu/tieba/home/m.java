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
    final /* synthetic */ f aMo;
    private y aMp;
    private ac yV = null;

    public m(f fVar, y yVar) {
        this.aMo = fVar;
        this.aMp = null;
        this.aMp = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(y... yVarArr) {
        y yVar = this.aMp;
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
        this.aMo.aMe = null;
        if (this.yV != null) {
            if (this.yV.mc().nb().jq()) {
                baseFragmentActivity2 = this.aMo.axV;
                baseFragmentActivity2.showToast(this.aMo.getString(com.baidu.tieba.y.success));
                aj.wk().aR(true);
                rVar = this.aMo.aMd;
                rVar.hO();
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.aMp.getId()));
                return;
            }
            baseFragmentActivity = this.aMo.axV;
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
        this.aMo.aMe = null;
        super.cancel(true);
    }
}
