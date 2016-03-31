package com.baidu.tieba.frs.c;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.g {
    final /* synthetic */ a buP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.buP = aVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        w wVar;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        w wVar2;
        w wVar3;
        FrsActivity frsActivity3;
        w wVar4;
        w wVar5;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        w wVar6;
        boolean z = false;
        wVar = this.buP.MY;
        if (!AntiHelper.pB(wVar.getErrorCode())) {
            frsActivity = this.buP.bts;
            com.baidu.tieba.tbadkCore.o QZ = frsActivity.QZ();
            if (QZ != null && QZ.avu() != null) {
                String name = QZ.avu().getName();
                if (obj != null && (obj instanceof x)) {
                    com.baidu.tieba.tbadkCore.c.aRC().J(name, false);
                    ((x) obj).setLike(1);
                    QZ.c((x) obj);
                    QZ.cs(((x) obj).aRD());
                    z = true;
                }
                frsActivity2 = this.buP.bts;
                frsActivity2.blj.d(Boolean.valueOf(z));
                if (!z) {
                    wVar2 = this.buP.MY;
                    if (wVar2.getErrorCode() == 22) {
                        frsActivity4 = this.buP.bts;
                        frsActivity4.showToast(this.buP.getPageContext().getString(t.j.had_liked_forum));
                        return;
                    }
                    wVar3 = this.buP.MY;
                    if (!AntiHelper.pB(wVar3.getErrorCode())) {
                        frsActivity3 = this.buP.bts;
                        wVar4 = this.buP.MY;
                        frsActivity3.showToast(wVar4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.buP.getPageContext().getPageActivity();
                    wVar5 = this.buP.MY;
                    AntiHelper.O(pageActivity, wVar5.getErrorString());
                    return;
                }
                this.buP.a(QZ, true);
                frsActivity5 = this.buP.bts;
                frsActivity5.showToast(this.buP.getPageContext().getString(t.j.like_success));
                TbadkCoreApplication.m411getInst().addLikeForum(name);
                this.buP.f(true, QZ.avu().getId());
                x xVar = (x) obj;
                xVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.buP.getPageContext().getPageActivity();
        wVar6 = this.buP.MY;
        AntiHelper.O(pageActivity2, wVar6.getErrorString());
    }
}
