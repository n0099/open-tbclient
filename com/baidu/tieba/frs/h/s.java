package com.baidu.tieba.frs.h;

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
public class s extends com.baidu.adp.base.g {
    final /* synthetic */ m buB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(m mVar) {
        this.buB = mVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
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
        xVar = this.buB.Dp;
        if (!AntiHelper.pw(xVar.getErrorCode())) {
            frsActivity = this.buB.bpj;
            com.baidu.tieba.tbadkCore.o PZ = frsActivity.PZ();
            if (PZ != null && PZ.avA() != null) {
                String name = PZ.avA().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.y)) {
                    com.baidu.tieba.tbadkCore.c.aRW().L(name, false);
                    ((com.baidu.tieba.tbadkCore.y) obj).setLike(1);
                    PZ.c((com.baidu.tieba.tbadkCore.y) obj);
                    PZ.cu(((com.baidu.tieba.tbadkCore.y) obj).aRY());
                    z = true;
                }
                frsActivity2 = this.buB.bpj;
                frsActivity2.bhk.d(Boolean.valueOf(z));
                if (!z) {
                    xVar2 = this.buB.Dp;
                    if (xVar2.getErrorCode() == 22) {
                        frsActivity4 = this.buB.bpj;
                        frsActivity4.showToast(this.buB.getPageContext().getString(t.j.had_liked_forum));
                        return;
                    }
                    xVar3 = this.buB.Dp;
                    if (!AntiHelper.pw(xVar3.getErrorCode())) {
                        frsActivity3 = this.buB.bpj;
                        xVar4 = this.buB.Dp;
                        frsActivity3.showToast(xVar4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.buB.getPageContext().getPageActivity();
                    xVar5 = this.buB.Dp;
                    AntiHelper.O(pageActivity, xVar5.getErrorString());
                    return;
                }
                this.buB.a(PZ, true);
                frsActivity5 = this.buB.bpj;
                frsActivity5.showToast(this.buB.getPageContext().getString(t.j.like_success));
                TbadkCoreApplication.m11getInst().addLikeForum(name);
                this.buB.g(true, PZ.avA().getId());
                com.baidu.tieba.tbadkCore.y yVar = (com.baidu.tieba.tbadkCore.y) obj;
                yVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.buB.getPageContext().getPageActivity();
        xVar6 = this.buB.Dp;
        AntiHelper.O(pageActivity2, xVar6.getErrorString());
    }
}
