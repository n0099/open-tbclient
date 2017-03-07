package com.baidu.tieba.frs.f;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.f {
    final /* synthetic */ u cdh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.cdh = uVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        LikeModel likeModel;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        LikeModel likeModel2;
        LikeModel likeModel3;
        FrsActivity frsActivity3;
        LikeModel likeModel4;
        LikeModel likeModel5;
        FrsActivity frsActivity4;
        boolean z;
        FrsActivity frsActivity5;
        LikeModel likeModel6;
        boolean z2 = false;
        likeModel = this.cdh.brY;
        if (!AntiHelper.rZ(likeModel.getErrorCode())) {
            frsActivity = this.cdh.bTf;
            com.baidu.tieba.tbadkCore.n YV = frsActivity.YV();
            if (YV != null && YV.aJp() != null) {
                String name = YV.aJp().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.v)) {
                    com.baidu.tieba.tbadkCore.c.bft().V(name, false);
                    ((com.baidu.tieba.tbadkCore.v) obj).setLike(1);
                    YV.c((com.baidu.tieba.tbadkCore.v) obj);
                    YV.cI(((com.baidu.tieba.tbadkCore.v) obj).bfv());
                    z2 = true;
                }
                frsActivity2 = this.cdh.bTf;
                frsActivity2.P(Boolean.valueOf(z2));
                if (!z2) {
                    likeModel2 = this.cdh.brY;
                    if (likeModel2.getErrorCode() == 22) {
                        frsActivity4 = this.cdh.bTf;
                        frsActivity4.showToast(this.cdh.getPageContext().getString(w.l.had_liked_forum));
                        return;
                    }
                    likeModel3 = this.cdh.brY;
                    if (!AntiHelper.rZ(likeModel3.getErrorCode())) {
                        frsActivity3 = this.cdh.bTf;
                        likeModel4 = this.cdh.brY;
                        frsActivity3.showToast(likeModel4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.cdh.getPageContext().getPageActivity();
                    likeModel5 = this.cdh.brY;
                    AntiHelper.an(pageActivity, likeModel5.getErrorString());
                    return;
                }
                u uVar = this.cdh;
                z = this.cdh.cdf;
                uVar.a(YV, z);
                this.cdh.cdf = true;
                frsActivity5 = this.cdh.bTf;
                frsActivity5.showToast(this.cdh.getPageContext().getString(w.l.attention_success));
                TbadkCoreApplication.m9getInst().addLikeForum(name);
                this.cdh.f(true, YV.aJp().getId());
                com.baidu.tieba.tbadkCore.v vVar = (com.baidu.tieba.tbadkCore.v) obj;
                vVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.cdh.getPageContext().getPageActivity();
        likeModel6 = this.cdh.brY;
        AntiHelper.an(pageActivity2, likeModel6.getErrorString());
    }
}
