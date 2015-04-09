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
    private aa ZF = null;
    final /* synthetic */ a aDb;
    private ae aDf;

    public s(a aVar, ae aeVar) {
        this.aDb = aVar;
        this.aDf = null;
        this.aDf = aeVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(ae... aeVarArr) {
        ae aeVar = this.aDf;
        if (aeVar != null) {
            try {
                if (aeVar.getId() != null && aeVar.getName() != null) {
                    this.ZF = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                    this.ZF.o(ImageViewerConfig.FORUM_ID, aeVar.getId());
                    this.ZF.o("kw", aeVar.getName());
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
        this.aDb.bx(false);
        if (this.ZF != null) {
            if (this.ZF.sp().tq().pv()) {
                this.aDb.aCQ = true;
                baseFragmentActivity3 = this.aDb.aCN;
                baseFragmentActivity3.showToast(this.aDb.getString(y.delete_like_success));
                TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
                this.aDb.f(false, this.aDf.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.aDf.getId()));
                eVar = this.aDb.aCJ;
                eVar.b(this.aDf);
            } else if (!StringUtils.isNull(this.ZF.getErrorString())) {
                baseFragmentActivity2 = this.aDb.aCN;
                baseFragmentActivity2.showToast(this.ZF.getErrorString());
            } else {
                baseFragmentActivity = this.aDb.aCN;
                baseFragmentActivity.showToast(this.aDb.getString(y.delete_like_fail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.aDb.bx(true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.ZF != null) {
            this.ZF.hh();
            this.ZF = null;
        }
        super.cancel(true);
    }
}
