package com.baidu.tieba.frs.b;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.tbadkCore.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.g {
    final /* synthetic */ a bmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bmZ = aVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        x xVar;
        x xVar2;
        FrsActivity frsActivity3;
        x xVar3;
        x xVar4;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        boolean z = false;
        frsActivity = this.bmZ.blE;
        com.baidu.tieba.tbadkCore.p Nn = frsActivity.Nn();
        if (Nn != null && Nn.akG() != null) {
            String name = Nn.akG().getName();
            if (obj != null && (obj instanceof y)) {
                com.baidu.tieba.tbadkCore.d.aDI().I(name, false);
                ((y) obj).setLike(1);
                Nn.c((y) obj);
                Nn.bQ(((y) obj).aDJ());
                z = true;
            }
            frsActivity2 = this.bmZ.blE;
            frsActivity2.bec.d(Boolean.valueOf(z));
            if (!z) {
                xVar = this.bmZ.MB;
                if (xVar.getErrorCode() == 22) {
                    frsActivity4 = this.bmZ.blE;
                    frsActivity4.showToast(this.bmZ.getPageContext().getString(n.j.had_liked_forum));
                    return;
                }
                xVar2 = this.bmZ.MB;
                if (!AntiHelper.ne(xVar2.getErrorCode())) {
                    frsActivity3 = this.bmZ.blE;
                    xVar3 = this.bmZ.MB;
                    frsActivity3.showToast(xVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.bmZ.getPageContext().getPageActivity();
                xVar4 = this.bmZ.MB;
                AntiHelper.Q(pageActivity, xVar4.getErrorString());
                return;
            }
            this.bmZ.a(Nn, true);
            frsActivity5 = this.bmZ.blE;
            frsActivity5.showToast(this.bmZ.getPageContext().getString(n.j.like_success));
            TbadkCoreApplication.m411getInst().addLikeForum(name);
            this.bmZ.e(true, Nn.akG().getId());
            y yVar = (y) obj;
            yVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
        }
    }
}
