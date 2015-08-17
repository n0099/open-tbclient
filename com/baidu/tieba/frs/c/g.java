package com.baidu.tieba.frs.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tbadkCore.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.g {
    final /* synthetic */ a bbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bbz = aVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        v vVar;
        FrsActivity frsActivity3;
        v vVar2;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        boolean z = false;
        frsActivity = this.bbz.bat;
        com.baidu.tieba.tbadkCore.n Lu = frsActivity.Lu();
        if (Lu != null && Lu.acG() != null) {
            String name = Lu.acG().getName();
            if (obj != null && (obj instanceof w)) {
                com.baidu.tieba.tbadkCore.c.aoQ().E(name, false);
                ((w) obj).setLike(1);
                Lu.b((w) obj);
                z = true;
            }
            frsActivity2 = this.bbz.bat;
            frsActivity2.aVk.d(Boolean.valueOf(z));
            if (!z) {
                vVar = this.bbz.LT;
                if (vVar.getErrorCode() == 22) {
                    frsActivity4 = this.bbz.bat;
                    frsActivity4.showToast(this.bbz.getPageContext().getString(i.C0057i.had_liked_forum));
                    return;
                }
                frsActivity3 = this.bbz.bat;
                vVar2 = this.bbz.LT;
                frsActivity3.showToast(vVar2.getErrorString());
                return;
            }
            this.bbz.a(Lu, true);
            frsActivity5 = this.bbz.bat;
            frsActivity5.showToast(this.bbz.getPageContext().getString(i.C0057i.like_success));
            TbadkCoreApplication.m411getInst().addLikeForum(name);
            this.bbz.f(true, Lu.acG().getId());
            w wVar = (w) obj;
            wVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
        }
    }
}
