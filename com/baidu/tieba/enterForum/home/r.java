package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes.dex */
class r extends BdAsyncTask<ae, Integer, String> {
    final /* synthetic */ a aFe;
    private ae aFi;
    private aa aaG = null;

    public r(a aVar, ae aeVar) {
        this.aFe = aVar;
        this.aFi = null;
        this.aFi = aeVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(ae... aeVarArr) {
        ae aeVar = this.aFi;
        if (aeVar != null) {
            try {
                if (aeVar.getId() != null && aeVar.getName() != null) {
                    this.aaG = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                    this.aaG.o(ImageViewerConfig.FORUM_ID, aeVar.getId());
                    this.aaG.o("kw", aeVar.getName());
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
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        com.baidu.tieba.enterForum.d.e eVar;
        super.onPostExecute((r) str);
        this.aFe.bH(false);
        if (this.aaG != null) {
            if (this.aaG.sX().tT().qa()) {
                this.aFe.aES = true;
                baseFragmentActivity3 = this.aFe.azl;
                baseFragmentActivity3.showToast(this.aFe.getString(t.delete_like_success));
                TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
                this.aFe.f(false, this.aFi.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.aFi.getId()));
                eVar = this.aFe.aEM;
                eVar.b(this.aFi);
            } else if (!StringUtils.isNull(this.aaG.getErrorString())) {
                baseFragmentActivity2 = this.aFe.azl;
                baseFragmentActivity2.showToast(this.aaG.getErrorString());
            } else {
                baseFragmentActivity = this.aFe.azl;
                baseFragmentActivity.showToast(this.aFe.getString(t.delete_like_fail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.aFe.bH(true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.aaG != null) {
            this.aaG.gS();
            this.aaG = null;
        }
        super.cancel(true);
    }
}
