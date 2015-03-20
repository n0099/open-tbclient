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
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class s extends BdAsyncTask<ae, Integer, String> {
    private aa ZD = null;
    final /* synthetic */ a aCT;
    private ae aCX;

    public s(a aVar, ae aeVar) {
        this.aCT = aVar;
        this.aCX = null;
        this.aCX = aeVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(ae... aeVarArr) {
        ae aeVar = this.aCX;
        if (aeVar != null) {
            try {
                if (aeVar.getId() != null && aeVar.getName() != null) {
                    this.ZD = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                    this.ZD.o(ImageViewerConfig.FORUM_ID, aeVar.getId());
                    this.ZD.o("kw", aeVar.getName());
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
        super.onPostExecute((s) str);
        this.aCT.bx(false);
        if (this.ZD != null) {
            if (this.ZD.sp().tq().pv()) {
                this.aCT.aCI = true;
                baseFragmentActivity3 = this.aCT.aCF;
                baseFragmentActivity3.showToast(this.aCT.getString(y.delete_like_success));
                TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
                this.aCT.f(false, this.aCX.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.aCX.getId()));
                eVar = this.aCT.aCB;
                eVar.b(this.aCX);
            } else if (!StringUtils.isNull(this.ZD.getErrorString())) {
                baseFragmentActivity2 = this.aCT.aCF;
                baseFragmentActivity2.showToast(this.ZD.getErrorString());
            } else {
                baseFragmentActivity = this.aCT.aCF;
                baseFragmentActivity.showToast(this.aCT.getString(y.delete_like_fail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.aCT.bx(true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.ZD != null) {
            this.ZD.hh();
            this.ZD = null;
        }
        super.cancel(true);
    }
}
