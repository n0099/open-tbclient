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
    final /* synthetic */ a bji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bji = aVar;
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
        frsActivity = this.bji.bhN;
        com.baidu.tieba.tbadkCore.p MT = frsActivity.MT();
        if (MT != null && MT.ajy() != null) {
            String name = MT.ajy().getName();
            if (obj != null && (obj instanceof y)) {
                com.baidu.tieba.tbadkCore.d.aBA().J(name, false);
                ((y) obj).setLike(1);
                MT.c((y) obj);
                MT.bN(((y) obj).aBB());
                z = true;
            }
            frsActivity2 = this.bji.bhN;
            frsActivity2.baf.d(Boolean.valueOf(z));
            if (!z) {
                xVar = this.bji.Ml;
                if (xVar.getErrorCode() == 22) {
                    frsActivity4 = this.bji.bhN;
                    frsActivity4.showToast(this.bji.getPageContext().getString(n.i.had_liked_forum));
                    return;
                }
                xVar2 = this.bji.Ml;
                if (!AntiHelper.mC(xVar2.getErrorCode())) {
                    frsActivity3 = this.bji.bhN;
                    xVar3 = this.bji.Ml;
                    frsActivity3.showToast(xVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.bji.getPageContext().getPageActivity();
                xVar4 = this.bji.Ml;
                AntiHelper.Q(pageActivity, xVar4.getErrorString());
                return;
            }
            this.bji.a(MT, true);
            frsActivity5 = this.bji.bhN;
            frsActivity5.showToast(this.bji.getPageContext().getString(n.i.like_success));
            TbadkCoreApplication.m411getInst().addLikeForum(name);
            this.bji.e(true, MT.ajy().getId());
            y yVar = (y) obj;
            yVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
        }
    }
}
