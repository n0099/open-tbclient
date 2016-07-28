package com.baidu.tieba.frs.j;

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
    final /* synthetic */ p bUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(p pVar) {
        this.bUo = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
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
        yVar = this.bUo.DR;
        if (!AntiHelper.rg(yVar.getErrorCode())) {
            frsActivity = this.bUo.bLx;
            com.baidu.tieba.tbadkCore.p VU = frsActivity.VU();
            if (VU != null && VU.aGX() != null) {
                String name = VU.aGX().getName();
                if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.z)) {
                    com.baidu.tieba.tbadkCore.d.bdv().N(name, false);
                    ((com.baidu.tieba.tbadkCore.z) obj).setLike(1);
                    VU.c((com.baidu.tieba.tbadkCore.z) obj);
                    VU.cX(((com.baidu.tieba.tbadkCore.z) obj).bdx());
                    z = true;
                }
                frsActivity2 = this.bUo.bLx;
                frsActivity2.bEJ.g(Boolean.valueOf(z));
                if (!z) {
                    yVar2 = this.bUo.DR;
                    if (yVar2.getErrorCode() == 22) {
                        frsActivity4 = this.bUo.bLx;
                        frsActivity4.showToast(this.bUo.getPageContext().getString(u.j.had_liked_forum));
                        return;
                    }
                    yVar3 = this.bUo.DR;
                    if (!AntiHelper.rg(yVar3.getErrorCode())) {
                        frsActivity3 = this.bUo.bLx;
                        yVar4 = this.bUo.DR;
                        frsActivity3.showToast(yVar4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.bUo.getPageContext().getPageActivity();
                    yVar5 = this.bUo.DR;
                    AntiHelper.O(pageActivity, yVar5.getErrorString());
                    return;
                }
                this.bUo.a(VU, true);
                frsActivity5 = this.bUo.bLx;
                frsActivity5.showToast(this.bUo.getPageContext().getString(u.j.like_success));
                TbadkCoreApplication.m10getInst().addLikeForum(name);
                this.bUo.g(true, VU.aGX().getId());
                com.baidu.tieba.tbadkCore.z zVar = (com.baidu.tieba.tbadkCore.z) obj;
                zVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, zVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.bUo.getPageContext().getPageActivity();
        yVar6 = this.bUo.DR;
        AntiHelper.O(pageActivity2, yVar6.getErrorString());
    }
}
