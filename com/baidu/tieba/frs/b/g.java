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
    final /* synthetic */ a bbN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bbN = aVar;
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
        frsActivity = this.bbN.baG;
        com.baidu.tieba.tbadkCore.o Lh = frsActivity.Lh();
        if (Lh != null && Lh.aeN() != null) {
            String name = Lh.aeN().getName();
            if (obj != null && (obj instanceof x)) {
                com.baidu.tieba.tbadkCore.d.avn().H(name, false);
                ((x) obj).setLike(1);
                Lh.b((x) obj);
                z = true;
            }
            frsActivity2 = this.bbN.baG;
            frsActivity2.aUy.d(Boolean.valueOf(z));
            if (!z) {
                wVar = this.bbN.LS;
                if (wVar.getErrorCode() == 22) {
                    frsActivity4 = this.bbN.baG;
                    frsActivity4.showToast(this.bbN.getPageContext().getString(i.h.had_liked_forum));
                    return;
                }
                wVar2 = this.bbN.LS;
                if (!AntiHelper.la(wVar2.getErrorCode())) {
                    frsActivity3 = this.bbN.baG;
                    wVar3 = this.bbN.LS;
                    frsActivity3.showToast(wVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.bbN.getPageContext().getPageActivity();
                wVar4 = this.bbN.LS;
                AntiHelper.P(pageActivity, wVar4.getErrorString());
                return;
            }
            this.bbN.a(Lh, true);
            frsActivity5 = this.bbN.baG;
            frsActivity5.showToast(this.bbN.getPageContext().getString(i.h.like_success));
            TbadkCoreApplication.m411getInst().addLikeForum(name);
            this.bbN.e(true, Lh.aeN().getId());
            x xVar = (x) obj;
            xVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
        }
    }
}
