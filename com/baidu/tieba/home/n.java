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
    private ad CU = null;
    final /* synthetic */ f aPO;
    private ab aPP;

    public n(f fVar, ab abVar) {
        this.aPO = fVar;
        this.aPP = null;
        this.aPP = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(ab... abVarArr) {
        ab abVar = this.aPP;
        if (abVar != null) {
            try {
                if (abVar.getId() != null && abVar.getName() != null) {
                    this.CU = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                    this.CU.o(ImageViewerConfig.FORUM_ID, abVar.getId());
                    this.CU.o("kw", abVar.getName());
                    this.CU.oS().pZ().mIsNeedTbs = true;
                    this.CU.or();
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
        super.onPostExecute((n) str);
        this.aPO.aPB = null;
        if (this.CU != null) {
            if (this.CU.oS().qa().lT()) {
                baseFragmentActivity2 = this.aPO.aPH;
                baseFragmentActivity2.showToast(this.aPO.getString(z.success));
                TbadkCoreApplication.m255getInst().setLikeBarChanged(true);
                rVar = this.aPO.aPA;
                rVar.jC();
                this.aPO.g(false, this.aPP.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.aPP.getId()));
                return;
            }
            baseFragmentActivity = this.aPO.aPH;
            baseFragmentActivity.showToast(this.CU.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.CU != null) {
            this.CU.dJ();
            this.CU = null;
        }
        this.aPO.aPB = null;
        super.cancel(true);
    }
}
