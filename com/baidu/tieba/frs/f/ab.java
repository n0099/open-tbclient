package com.baidu.tieba.frs.f;

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
    final /* synthetic */ u chY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.chY = uVar;
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
        likeModel = this.chY.bzS;
        if (!AntiHelper.sr(likeModel.getErrorCode())) {
            rVar = this.chY.bTw;
            com.baidu.tieba.tbadkCore.n aau = rVar.aau();
            if (aau != null && aau.aIz() != null) {
                String name = aau.aIz().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.t)) {
                    com.baidu.tieba.tbadkCore.c.bgf().S(name, false);
                    ((com.baidu.tieba.tbadkCore.t) obj).setLike(1);
                    aau.c((com.baidu.tieba.tbadkCore.t) obj);
                    aau.cB(((com.baidu.tieba.tbadkCore.t) obj).bgh());
                    z2 = true;
                }
                rVar2 = this.chY.bTw;
                rVar2.O(Boolean.valueOf(z2));
                if (!z2) {
                    likeModel2 = this.chY.bzS;
                    if (likeModel2.getErrorCode() == 22) {
                        rVar4 = this.chY.bTw;
                        rVar4.showToast(this.chY.getPageContext().getString(w.l.had_liked_forum));
                        return;
                    }
                    likeModel3 = this.chY.bzS;
                    if (!AntiHelper.sr(likeModel3.getErrorCode())) {
                        rVar3 = this.chY.bTw;
                        likeModel4 = this.chY.bzS;
                        rVar3.showToast(likeModel4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.chY.getPageContext().getPageActivity();
                    likeModel5 = this.chY.bzS;
                    AntiHelper.ap(pageActivity, likeModel5.getErrorString());
                    return;
                }
                u uVar = this.chY;
                z = this.chY.chU;
                uVar.a(aau, z);
                this.chY.chU = true;
                rVar5 = this.chY.bTw;
                rVar5.showToast(this.chY.getPageContext().getResources().getString(w.l.attention_success));
                TbadkCoreApplication.m9getInst().addLikeForum(name);
                this.chY.d(true, aau.aIz().getId());
                com.baidu.tieba.tbadkCore.t tVar = (com.baidu.tieba.tbadkCore.t) obj;
                tVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.chY.getPageContext().getPageActivity();
        likeModel6 = this.chY.bzS;
        AntiHelper.ap(pageActivity2, likeModel6.getErrorString());
    }
}
