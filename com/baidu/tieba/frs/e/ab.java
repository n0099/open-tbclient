package com.baidu.tieba.frs.e;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.f {
    final /* synthetic */ u cbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.cbL = uVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        LikeModel likeModel;
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        LikeModel likeModel2;
        LikeModel likeModel3;
        com.baidu.tieba.frs.r rVar3;
        LikeModel likeModel4;
        LikeModel likeModel5;
        com.baidu.tieba.frs.r rVar4;
        boolean z;
        com.baidu.tieba.frs.r rVar5;
        LikeModel likeModel6;
        boolean z2 = false;
        likeModel = this.cbL.bue;
        if (!AntiHelper.rV(likeModel.getErrorCode())) {
            rVar = this.cbL.bNK;
            com.baidu.tieba.tbadkCore.n Zq = rVar.Zq();
            if (Zq != null && Zq.aHE() != null) {
                String name = Zq.aHE().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.t)) {
                    com.baidu.tieba.tbadkCore.c.beL().V(name, false);
                    ((com.baidu.tieba.tbadkCore.t) obj).setLike(1);
                    Zq.c((com.baidu.tieba.tbadkCore.t) obj);
                    Zq.cy(((com.baidu.tieba.tbadkCore.t) obj).beN());
                    z2 = true;
                }
                rVar2 = this.cbL.bNK;
                rVar2.O(Boolean.valueOf(z2));
                if (!z2) {
                    likeModel2 = this.cbL.bue;
                    if (likeModel2.getErrorCode() == 22) {
                        rVar4 = this.cbL.bNK;
                        rVar4.showToast(this.cbL.getPageContext().getString(w.l.had_liked_forum));
                        return;
                    }
                    likeModel3 = this.cbL.bue;
                    if (!AntiHelper.rV(likeModel3.getErrorCode())) {
                        rVar3 = this.cbL.bNK;
                        likeModel4 = this.cbL.bue;
                        rVar3.showToast(likeModel4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.cbL.getPageContext().getPageActivity();
                    likeModel5 = this.cbL.bue;
                    AntiHelper.aq(pageActivity, likeModel5.getErrorString());
                    return;
                }
                u uVar = this.cbL;
                z = this.cbL.cbI;
                uVar.a(Zq, z);
                this.cbL.cbI = true;
                rVar5 = this.cbL.bNK;
                rVar5.showToast(this.cbL.getPageContext().getResources().getString(w.l.attention_success));
                TbadkCoreApplication.m9getInst().addLikeForum(name);
                this.cbL.d(true, Zq.aHE().getId());
                com.baidu.tieba.tbadkCore.t tVar = (com.baidu.tieba.tbadkCore.t) obj;
                tVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.cbL.getPageContext().getPageActivity();
        likeModel6 = this.cbL.bue;
        AntiHelper.aq(pageActivity2, likeModel6.getErrorString());
    }
}
