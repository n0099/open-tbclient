package com.baidu.tieba.frs.h;

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
public class y extends com.baidu.adp.base.g {
    final /* synthetic */ s bPp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.bPp = sVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        FrsActivity frsActivity3;
        com.baidu.tieba.tbadkCore.w wVar4;
        com.baidu.tieba.tbadkCore.w wVar5;
        FrsActivity frsActivity4;
        boolean z;
        FrsActivity frsActivity5;
        com.baidu.tieba.tbadkCore.w wVar6;
        boolean z2 = false;
        wVar = this.bPp.Gg;
        if (!AntiHelper.rp(wVar.getErrorCode())) {
            frsActivity = this.bPp.bFI;
            com.baidu.tieba.tbadkCore.o WF = frsActivity.WF();
            if (WF != null && WF.aIk() != null) {
                String name = WF.aIk().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.x)) {
                    com.baidu.tieba.tbadkCore.c.bdT().U(name, false);
                    ((com.baidu.tieba.tbadkCore.x) obj).setLike(1);
                    WF.c((com.baidu.tieba.tbadkCore.x) obj);
                    WF.cW(((com.baidu.tieba.tbadkCore.x) obj).bdV());
                    z2 = true;
                }
                frsActivity2 = this.bPp.bFI;
                frsActivity2.L(Boolean.valueOf(z2));
                if (!z2) {
                    wVar2 = this.bPp.Gg;
                    if (wVar2.getErrorCode() == 22) {
                        frsActivity4 = this.bPp.bFI;
                        frsActivity4.showToast(this.bPp.getPageContext().getString(r.j.had_liked_forum));
                        return;
                    }
                    wVar3 = this.bPp.Gg;
                    if (!AntiHelper.rp(wVar3.getErrorCode())) {
                        frsActivity3 = this.bPp.bFI;
                        wVar4 = this.bPp.Gg;
                        frsActivity3.showToast(wVar4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.bPp.getPageContext().getPageActivity();
                    wVar5 = this.bPp.Gg;
                    AntiHelper.S(pageActivity, wVar5.getErrorString());
                    return;
                }
                s sVar = this.bPp;
                z = this.bPp.bPm;
                sVar.a(WF, z);
                this.bPp.bPm = true;
                frsActivity5 = this.bPp.bFI;
                frsActivity5.showToast(this.bPp.getPageContext().getString(r.j.attention_success));
                TbadkCoreApplication.m9getInst().addLikeForum(name);
                this.bPp.f(true, WF.aIk().getId());
                com.baidu.tieba.tbadkCore.x xVar = (com.baidu.tieba.tbadkCore.x) obj;
                xVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.bPp.getPageContext().getPageActivity();
        wVar6 = this.bPp.Gg;
        AntiHelper.S(pageActivity2, wVar6.getErrorString());
    }
}
