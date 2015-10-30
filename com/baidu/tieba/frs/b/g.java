package com.baidu.tieba.frs.b;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.g {
    final /* synthetic */ a bbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bbY = aVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        w wVar;
        w wVar2;
        FrsActivity frsActivity3;
        w wVar3;
        w wVar4;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        boolean z = false;
        frsActivity = this.bbY.baR;
        com.baidu.tieba.tbadkCore.o Ld = frsActivity.Ld();
        if (Ld != null && Ld.aeJ() != null) {
            String name = Ld.aeJ().getName();
            if (obj != null && (obj instanceof x)) {
                com.baidu.tieba.tbadkCore.d.avp().H(name, false);
                ((x) obj).setLike(1);
                Ld.b((x) obj);
                z = true;
            }
            frsActivity2 = this.bbY.baR;
            frsActivity2.aUJ.d(Boolean.valueOf(z));
            if (!z) {
                wVar = this.bbY.LT;
                if (wVar.getErrorCode() == 22) {
                    frsActivity4 = this.bbY.baR;
                    frsActivity4.showToast(this.bbY.getPageContext().getString(i.h.had_liked_forum));
                    return;
                }
                wVar2 = this.bbY.LT;
                if (!AntiHelper.lc(wVar2.getErrorCode())) {
                    frsActivity3 = this.bbY.baR;
                    wVar3 = this.bbY.LT;
                    frsActivity3.showToast(wVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.bbY.getPageContext().getPageActivity();
                wVar4 = this.bbY.LT;
                AntiHelper.P(pageActivity, wVar4.getErrorString());
                return;
            }
            this.bbY.a(Ld, true);
            frsActivity5 = this.bbY.baR;
            frsActivity5.showToast(this.bbY.getPageContext().getString(i.h.like_success));
            TbadkCoreApplication.m411getInst().addLikeForum(name);
            this.bbY.e(true, Ld.aeJ().getId());
            x xVar = (x) obj;
            xVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
        }
    }
}
