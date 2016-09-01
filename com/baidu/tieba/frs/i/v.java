package com.baidu.tieba.frs.i;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.g {
    final /* synthetic */ p cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(p pVar) {
        this.cfw = pVar;
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
        xVar = this.cfw.Ge;
        if (!AntiHelper.rG(xVar.getErrorCode())) {
            frsActivity = this.cfw.bWH;
            com.baidu.tieba.tbadkCore.p aaR = frsActivity.aaR();
            if (aaR != null && aaR.aLP() != null) {
                String name = aaR.aLP().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.y)) {
                    com.baidu.tieba.tbadkCore.d.bgZ().R(name, false);
                    ((com.baidu.tieba.tbadkCore.y) obj).setLike(1);
                    aaR.c((com.baidu.tieba.tbadkCore.y) obj);
                    aaR.db(((com.baidu.tieba.tbadkCore.y) obj).bhb());
                    z = true;
                }
                frsActivity2 = this.cfw.bWH;
                frsActivity2.bQn.g(Boolean.valueOf(z));
                if (!z) {
                    xVar2 = this.cfw.Ge;
                    if (xVar2.getErrorCode() == 22) {
                        frsActivity4 = this.cfw.bWH;
                        frsActivity4.showToast(this.cfw.getPageContext().getString(t.j.had_liked_forum));
                        return;
                    }
                    xVar3 = this.cfw.Ge;
                    if (!AntiHelper.rG(xVar3.getErrorCode())) {
                        frsActivity3 = this.cfw.bWH;
                        xVar4 = this.cfw.Ge;
                        frsActivity3.showToast(xVar4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.cfw.getPageContext().getPageActivity();
                    xVar5 = this.cfw.Ge;
                    AntiHelper.R(pageActivity, xVar5.getErrorString());
                    return;
                }
                this.cfw.a(aaR, true);
                frsActivity5 = this.cfw.bWH;
                frsActivity5.showToast(this.cfw.getPageContext().getString(t.j.like_success));
                TbadkCoreApplication.m9getInst().addLikeForum(name);
                this.cfw.f(true, aaR.aLP().getId());
                com.baidu.tieba.tbadkCore.y yVar = (com.baidu.tieba.tbadkCore.y) obj;
                yVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.cfw.getPageContext().getPageActivity();
        xVar6 = this.cfw.Ge;
        AntiHelper.R(pageActivity2, xVar6.getErrorString());
    }
}
