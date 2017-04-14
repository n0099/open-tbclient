package com.baidu.tieba.frs.g;

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
    final /* synthetic */ u cbI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.cbI = uVar;
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
        likeModel = this.cbI.brQ;
        if (!AntiHelper.rX(likeModel.getErrorCode())) {
            frsActivity = this.cbI.bST;
            com.baidu.tieba.tbadkCore.n Zr = frsActivity.Zr();
            if (Zr != null && Zr.aJw() != null) {
                String name = Zr.aJw().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.v)) {
                    com.baidu.tieba.tbadkCore.c.bgh().V(name, false);
                    ((com.baidu.tieba.tbadkCore.v) obj).setLike(1);
                    Zr.c((com.baidu.tieba.tbadkCore.v) obj);
                    Zr.cH(((com.baidu.tieba.tbadkCore.v) obj).bgj());
                    z2 = true;
                }
                frsActivity2 = this.cbI.bST;
                frsActivity2.P(Boolean.valueOf(z2));
                if (!z2) {
                    likeModel2 = this.cbI.brQ;
                    if (likeModel2.getErrorCode() == 22) {
                        frsActivity4 = this.cbI.bST;
                        frsActivity4.showToast(this.cbI.getPageContext().getString(w.l.had_liked_forum));
                        return;
                    }
                    likeModel3 = this.cbI.brQ;
                    if (!AntiHelper.rX(likeModel3.getErrorCode())) {
                        frsActivity3 = this.cbI.bST;
                        likeModel4 = this.cbI.brQ;
                        frsActivity3.showToast(likeModel4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.cbI.getPageContext().getPageActivity();
                    likeModel5 = this.cbI.brQ;
                    AntiHelper.aq(pageActivity, likeModel5.getErrorString());
                    return;
                }
                u uVar = this.cbI;
                z = this.cbI.cbG;
                uVar.a(Zr, z);
                this.cbI.cbG = true;
                frsActivity5 = this.cbI.bST;
                frsActivity5.showToast(this.cbI.getPageContext().getString(w.l.attention_success));
                TbadkCoreApplication.m9getInst().addLikeForum(name);
                this.cbI.e(true, Zr.aJw().getId());
                com.baidu.tieba.tbadkCore.v vVar = (com.baidu.tieba.tbadkCore.v) obj;
                vVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.cbI.getPageContext().getPageActivity();
        likeModel6 = this.cbI.brQ;
        AntiHelper.aq(pageActivity2, likeModel6.getErrorString());
    }
}
