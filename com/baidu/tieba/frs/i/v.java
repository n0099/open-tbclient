package com.baidu.tieba.frs.i;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.g {
    final /* synthetic */ p bSo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(p pVar) {
        this.bSo = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.y yVar;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.tieba.tbadkCore.y yVar2;
        com.baidu.tieba.tbadkCore.y yVar3;
        FrsActivity frsActivity3;
        com.baidu.tieba.tbadkCore.y yVar4;
        com.baidu.tieba.tbadkCore.y yVar5;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        com.baidu.tieba.tbadkCore.y yVar6;
        boolean z = false;
        yVar = this.bSo.Dq;
        if (!AntiHelper.qL(yVar.getErrorCode())) {
            frsActivity = this.bSo.bJR;
            com.baidu.tieba.tbadkCore.p VC = frsActivity.VC();
            if (VC != null && VC.aDN() != null) {
                String name = VC.aDN().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.z)) {
                    com.baidu.tieba.tbadkCore.d.bah().N(name, false);
                    ((com.baidu.tieba.tbadkCore.z) obj).setLike(1);
                    VC.c((com.baidu.tieba.tbadkCore.z) obj);
                    VC.cK(((com.baidu.tieba.tbadkCore.z) obj).baj());
                    z = true;
                }
                frsActivity2 = this.bSo.bJR;
                frsActivity2.bDz.d(Boolean.valueOf(z));
                if (!z) {
                    yVar2 = this.bSo.Dq;
                    if (yVar2.getErrorCode() == 22) {
                        frsActivity4 = this.bSo.bJR;
                        frsActivity4.showToast(this.bSo.getPageContext().getString(u.j.had_liked_forum));
                        return;
                    }
                    yVar3 = this.bSo.Dq;
                    if (!AntiHelper.qL(yVar3.getErrorCode())) {
                        frsActivity3 = this.bSo.bJR;
                        yVar4 = this.bSo.Dq;
                        frsActivity3.showToast(yVar4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.bSo.getPageContext().getPageActivity();
                    yVar5 = this.bSo.Dq;
                    AntiHelper.O(pageActivity, yVar5.getErrorString());
                    return;
                }
                this.bSo.a(VC, true);
                frsActivity5 = this.bSo.bJR;
                frsActivity5.showToast(this.bSo.getPageContext().getString(u.j.like_success));
                TbadkCoreApplication.m9getInst().addLikeForum(name);
                this.bSo.g(true, VC.aDN().getId());
                com.baidu.tieba.tbadkCore.z zVar = (com.baidu.tieba.tbadkCore.z) obj;
                zVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, zVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.bSo.getPageContext().getPageActivity();
        yVar6 = this.bSo.Dq;
        AntiHelper.O(pageActivity2, yVar6.getErrorString());
    }
}
