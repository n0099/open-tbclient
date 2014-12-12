package com.baidu.tieba.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tieba.tbadkCore.ab;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<ab, Integer, String> {
    private ad CV = null;
    final /* synthetic */ f aOG;
    private ab aOH;

    public n(f fVar, ab abVar) {
        this.aOG = fVar;
        this.aOH = null;
        this.aOH = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(ab... abVarArr) {
        ab abVar = this.aOH;
        if (abVar != null) {
            try {
                if (abVar.getId() != null && abVar.getName() != null) {
                    this.CV = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                    this.CV.o(ImageViewerConfig.FORUM_ID, abVar.getId());
                    this.CV.o("kw", abVar.getName());
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
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        s sVar;
        super.onPostExecute((n) str);
        this.aOG.aOt = null;
        if (this.CV != null) {
            if (this.CV.oW().pW().ma()) {
                baseFragmentActivity2 = this.aOG.aOz;
                baseFragmentActivity2.showToast(this.aOG.getString(z.success));
                TbadkCoreApplication.m255getInst().setLikeBarChanged(true);
                sVar = this.aOG.aOs;
                sVar.jK();
                this.aOG.g(false, this.aOH.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.aOH.getId()));
                return;
            }
            baseFragmentActivity = this.aOG.aOz;
            baseFragmentActivity.showToast(this.CV.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.CV != null) {
            this.CV.dL();
            this.CV = null;
        }
        this.aOG.aOt = null;
        super.cancel(true);
    }
}
