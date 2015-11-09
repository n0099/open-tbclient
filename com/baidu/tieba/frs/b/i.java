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
public class i extends com.baidu.adp.base.g {
    final /* synthetic */ a bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bcD = aVar;
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
        frsActivity = this.bcD.bbk;
        com.baidu.tieba.tbadkCore.o Lt = frsActivity.Lt();
        if (Lt != null && Lt.afg() != null) {
            String name = Lt.afg().getName();
            if (obj != null && (obj instanceof x)) {
                com.baidu.tieba.tbadkCore.d.avW().H(name, false);
                ((x) obj).setLike(1);
                Lt.c((x) obj);
                z = true;
            }
            frsActivity2 = this.bcD.bbk;
            frsActivity2.aUR.d(Boolean.valueOf(z));
            if (!z) {
                wVar = this.bcD.LU;
                if (wVar.getErrorCode() == 22) {
                    frsActivity4 = this.bcD.bbk;
                    frsActivity4.showToast(this.bcD.getPageContext().getString(i.h.had_liked_forum));
                    return;
                }
                wVar2 = this.bcD.LU;
                if (!AntiHelper.lr(wVar2.getErrorCode())) {
                    frsActivity3 = this.bcD.bbk;
                    wVar3 = this.bcD.LU;
                    frsActivity3.showToast(wVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.bcD.getPageContext().getPageActivity();
                wVar4 = this.bcD.LU;
                AntiHelper.Q(pageActivity, wVar4.getErrorString());
                return;
            }
            this.bcD.a(Lt, true);
            frsActivity5 = this.bcD.bbk;
            frsActivity5.showToast(this.bcD.getPageContext().getString(i.h.like_success));
            TbadkCoreApplication.m411getInst().addLikeForum(name);
            this.bcD.e(true, Lt.afg().getId());
            x xVar = (x) obj;
            xVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
        }
    }
}
