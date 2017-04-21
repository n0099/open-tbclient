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
    final /* synthetic */ u cdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.cdZ = uVar;
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
        likeModel = this.cdZ.bui;
        if (!AntiHelper.sd(likeModel.getErrorCode())) {
            frsActivity = this.cdZ.bVk;
            com.baidu.tieba.tbadkCore.n aas = frsActivity.aas();
            if (aas != null && aas.aKx() != null) {
                String name = aas.aKx().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.v)) {
                    com.baidu.tieba.tbadkCore.c.bhj().V(name, false);
                    ((com.baidu.tieba.tbadkCore.v) obj).setLike(1);
                    aas.c((com.baidu.tieba.tbadkCore.v) obj);
                    aas.cI(((com.baidu.tieba.tbadkCore.v) obj).bhl());
                    z2 = true;
                }
                frsActivity2 = this.cdZ.bVk;
                frsActivity2.O(Boolean.valueOf(z2));
                if (!z2) {
                    likeModel2 = this.cdZ.bui;
                    if (likeModel2.getErrorCode() == 22) {
                        frsActivity4 = this.cdZ.bVk;
                        frsActivity4.showToast(this.cdZ.getPageContext().getString(w.l.had_liked_forum));
                        return;
                    }
                    likeModel3 = this.cdZ.bui;
                    if (!AntiHelper.sd(likeModel3.getErrorCode())) {
                        frsActivity3 = this.cdZ.bVk;
                        likeModel4 = this.cdZ.bui;
                        frsActivity3.showToast(likeModel4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.cdZ.getPageContext().getPageActivity();
                    likeModel5 = this.cdZ.bui;
                    AntiHelper.aq(pageActivity, likeModel5.getErrorString());
                    return;
                }
                u uVar = this.cdZ;
                z = this.cdZ.cdX;
                uVar.a(aas, z);
                this.cdZ.cdX = true;
                frsActivity5 = this.cdZ.bVk;
                frsActivity5.showToast(this.cdZ.getPageContext().getString(w.l.attention_success));
                TbadkCoreApplication.m9getInst().addLikeForum(name);
                this.cdZ.e(true, aas.aKx().getId());
                com.baidu.tieba.tbadkCore.v vVar = (com.baidu.tieba.tbadkCore.v) obj;
                vVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.cdZ.getPageContext().getPageActivity();
        likeModel6 = this.cdZ.bui;
        AntiHelper.aq(pageActivity2, likeModel6.getErrorString());
    }
}
