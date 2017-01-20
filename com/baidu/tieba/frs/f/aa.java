package com.baidu.tieba.frs.f;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.f {
    final /* synthetic */ u bVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.bVP = uVar;
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
        likeModel = this.bVP.Fq;
        if (!AntiHelper.sa(likeModel.getErrorCode())) {
            frsActivity = this.bVP.bLZ;
            com.baidu.tieba.tbadkCore.n XW = frsActivity.XW();
            if (XW != null && XW.aJY() != null) {
                String name = XW.aJY().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.v)) {
                    com.baidu.tieba.tbadkCore.c.bfG().U(name, false);
                    ((com.baidu.tieba.tbadkCore.v) obj).setLike(1);
                    XW.c((com.baidu.tieba.tbadkCore.v) obj);
                    XW.db(((com.baidu.tieba.tbadkCore.v) obj).bfI());
                    z2 = true;
                }
                frsActivity2 = this.bVP.bLZ;
                frsActivity2.P(Boolean.valueOf(z2));
                if (!z2) {
                    likeModel2 = this.bVP.Fq;
                    if (likeModel2.getErrorCode() == 22) {
                        frsActivity4 = this.bVP.bLZ;
                        frsActivity4.showToast(this.bVP.getPageContext().getString(r.l.had_liked_forum));
                        return;
                    }
                    likeModel3 = this.bVP.Fq;
                    if (!AntiHelper.sa(likeModel3.getErrorCode())) {
                        frsActivity3 = this.bVP.bLZ;
                        likeModel4 = this.bVP.Fq;
                        frsActivity3.showToast(likeModel4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.bVP.getPageContext().getPageActivity();
                    likeModel5 = this.bVP.Fq;
                    AntiHelper.T(pageActivity, likeModel5.getErrorString());
                    return;
                }
                u uVar = this.bVP;
                z = this.bVP.bVN;
                uVar.a(XW, z);
                this.bVP.bVN = true;
                frsActivity5 = this.bVP.bLZ;
                frsActivity5.showToast(this.bVP.getPageContext().getString(r.l.attention_success));
                TbadkCoreApplication.m9getInst().addLikeForum(name);
                this.bVP.f(true, XW.aJY().getId());
                com.baidu.tieba.tbadkCore.v vVar = (com.baidu.tieba.tbadkCore.v) obj;
                vVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.bVP.getPageContext().getPageActivity();
        likeModel6 = this.bVP.Fq;
        AntiHelper.T(pageActivity2, likeModel6.getErrorString());
    }
}
