package com.baidu.tieba.frs.j;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.g {
    final /* synthetic */ n ckg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(n nVar) {
        this.ckg = nVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        FrsActivity frsActivity3;
        com.baidu.tieba.tbadkCore.x xVar4;
        com.baidu.tieba.tbadkCore.x xVar5;
        FrsActivity frsActivity4;
        boolean z;
        FrsActivity frsActivity5;
        com.baidu.tieba.tbadkCore.x xVar6;
        boolean z2 = false;
        xVar = this.ckg.Gg;
        if (!AntiHelper.sm(xVar.getErrorCode())) {
            frsActivity = this.ckg.bZY;
            com.baidu.tieba.tbadkCore.p acr = frsActivity.acr();
            if (acr != null && acr.aOk() != null) {
                String name = acr.aOk().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.y)) {
                    com.baidu.tieba.tbadkCore.d.bkd().R(name, false);
                    ((com.baidu.tieba.tbadkCore.y) obj).setLike(1);
                    acr.c((com.baidu.tieba.tbadkCore.y) obj);
                    acr.dg(((com.baidu.tieba.tbadkCore.y) obj).bkf());
                    z2 = true;
                }
                frsActivity2 = this.ckg.bZY;
                frsActivity2.L(Boolean.valueOf(z2));
                if (!z2) {
                    xVar2 = this.ckg.Gg;
                    if (xVar2.getErrorCode() == 22) {
                        frsActivity4 = this.ckg.bZY;
                        frsActivity4.showToast(this.ckg.getPageContext().getString(r.j.had_liked_forum));
                        return;
                    }
                    xVar3 = this.ckg.Gg;
                    if (!AntiHelper.sm(xVar3.getErrorCode())) {
                        frsActivity3 = this.ckg.bZY;
                        xVar4 = this.ckg.Gg;
                        frsActivity3.showToast(xVar4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.ckg.getPageContext().getPageActivity();
                    xVar5 = this.ckg.Gg;
                    AntiHelper.S(pageActivity, xVar5.getErrorString());
                    return;
                }
                n nVar = this.ckg;
                z = this.ckg.ckd;
                nVar.a(acr, z);
                this.ckg.ckd = true;
                frsActivity5 = this.ckg.bZY;
                frsActivity5.showToast(this.ckg.getPageContext().getString(r.j.like_success));
                TbadkCoreApplication.m9getInst().addLikeForum(name);
                this.ckg.f(true, acr.aOk().getId());
                com.baidu.tieba.tbadkCore.y yVar = (com.baidu.tieba.tbadkCore.y) obj;
                yVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.ckg.getPageContext().getPageActivity();
        xVar6 = this.ckg.Gg;
        AntiHelper.S(pageActivity2, xVar6.getErrorString());
    }
}
