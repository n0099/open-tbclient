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
    private ad CX = null;
    final /* synthetic */ f aPP;
    private ab aPQ;

    public n(f fVar, ab abVar) {
        this.aPP = fVar;
        this.aPQ = null;
        this.aPQ = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(ab... abVarArr) {
        ab abVar = this.aPQ;
        if (abVar != null) {
            try {
                if (abVar.getId() != null && abVar.getName() != null) {
                    this.CX = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavo");
                    this.CX.o(ImageViewerConfig.FORUM_ID, abVar.getId());
                    this.CX.o("kw", abVar.getName());
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
        this.aPP.aPC = null;
        if (this.CX != null) {
            if (this.CX.oZ().qh().ma()) {
                baseFragmentActivity2 = this.aPP.aPI;
                baseFragmentActivity2.showToast(this.aPP.getString(z.success));
                TbadkCoreApplication.m255getInst().setLikeBarChanged(true);
                rVar = this.aPP.aPB;
                rVar.jJ();
                this.aPP.g(false, this.aPQ.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.aPQ.getId()));
                return;
            }
            baseFragmentActivity = this.aPP.aPI;
            baseFragmentActivity.showToast(this.CX.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.CX != null) {
            this.CX.dJ();
            this.CX = null;
        }
        this.aPP.aPC = null;
        super.cancel(true);
    }
}
