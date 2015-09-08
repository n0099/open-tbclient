package com.baidu.tieba.frs.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.g {
    final /* synthetic */ a bbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bbT = aVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        w wVar;
        FrsActivity frsActivity3;
        w wVar2;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        boolean z = false;
        frsActivity = this.bbT.baN;
        com.baidu.tieba.tbadkCore.o Ll = frsActivity.Ll();
        if (Ll != null && Ll.acP() != null) {
            String name = Ll.acP().getName();
            if (obj != null && (obj instanceof x)) {
                com.baidu.tieba.tbadkCore.d.asX().G(name, false);
                ((x) obj).setLike(1);
                Ll.b((x) obj);
                z = true;
            }
            frsActivity2 = this.bbT.baN;
            frsActivity2.aVy.d(Boolean.valueOf(z));
            if (!z) {
                wVar = this.bbT.LS;
                if (wVar.getErrorCode() == 22) {
                    frsActivity4 = this.bbT.baN;
                    frsActivity4.showToast(this.bbT.getPageContext().getString(i.h.had_liked_forum));
                    return;
                }
                frsActivity3 = this.bbT.baN;
                wVar2 = this.bbT.LS;
                frsActivity3.showToast(wVar2.getErrorString());
                return;
            }
            this.bbT.a(Ll, true);
            frsActivity5 = this.bbT.baN;
            frsActivity5.showToast(this.bbT.getPageContext().getString(i.h.like_success));
            TbadkCoreApplication.m411getInst().addLikeForum(name);
            this.bbT.e(true, Ll.acP().getId());
            x xVar = (x) obj;
            xVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
        }
    }
}
