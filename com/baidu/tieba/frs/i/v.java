package com.baidu.tieba.frs.i;

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
public class v extends com.baidu.adp.base.g {
    final /* synthetic */ p cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(p pVar) {
        this.cft = pVar;
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
        FrsActivity frsActivity5;
        com.baidu.tieba.tbadkCore.x xVar6;
        boolean z = false;
        xVar = this.cft.Ge;
        if (!AntiHelper.rU(xVar.getErrorCode())) {
            frsActivity = this.cft.bWH;
            com.baidu.tieba.tbadkCore.p abe = frsActivity.abe();
            if (abe != null && abe.aMr() != null) {
                String name = abe.aMr().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.y)) {
                    com.baidu.tieba.tbadkCore.d.bhH().R(name, false);
                    ((com.baidu.tieba.tbadkCore.y) obj).setLike(1);
                    abe.c((com.baidu.tieba.tbadkCore.y) obj);
                    abe.dc(((com.baidu.tieba.tbadkCore.y) obj).bhJ());
                    z = true;
                }
                frsActivity2 = this.cft.bWH;
                frsActivity2.bQg.g(Boolean.valueOf(z));
                if (!z) {
                    xVar2 = this.cft.Ge;
                    if (xVar2.getErrorCode() == 22) {
                        frsActivity4 = this.cft.bWH;
                        frsActivity4.showToast(this.cft.getPageContext().getString(r.j.had_liked_forum));
                        return;
                    }
                    xVar3 = this.cft.Ge;
                    if (!AntiHelper.rU(xVar3.getErrorCode())) {
                        frsActivity3 = this.cft.bWH;
                        xVar4 = this.cft.Ge;
                        frsActivity3.showToast(xVar4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.cft.getPageContext().getPageActivity();
                    xVar5 = this.cft.Ge;
                    AntiHelper.R(pageActivity, xVar5.getErrorString());
                    return;
                }
                this.cft.a(abe, true);
                frsActivity5 = this.cft.bWH;
                frsActivity5.showToast(this.cft.getPageContext().getString(r.j.like_success));
                TbadkCoreApplication.m9getInst().addLikeForum(name);
                this.cft.f(true, abe.aMr().getId());
                com.baidu.tieba.tbadkCore.y yVar = (com.baidu.tieba.tbadkCore.y) obj;
                yVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.cft.getPageContext().getPageActivity();
        xVar6 = this.cft.Ge;
        AntiHelper.R(pageActivity2, xVar6.getErrorString());
    }
}
