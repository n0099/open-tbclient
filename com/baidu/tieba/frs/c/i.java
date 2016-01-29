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
    final /* synthetic */ a bpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bpO = aVar;
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
        wVar = this.bpO.MS;
        if (!AntiHelper.or(wVar.getErrorCode())) {
            frsActivity = this.bpO.bot;
            com.baidu.tieba.tbadkCore.o Pk = frsActivity.Pk();
            if (Pk != null && Pk.aoE() != null) {
                String name = Pk.aoE().getName();
                if (obj != null && (obj instanceof x)) {
                    com.baidu.tieba.tbadkCore.c.aKN().I(name, false);
                    ((x) obj).setLike(1);
                    Pk.c((x) obj);
                    Pk.cc(((x) obj).aKO());
                    z = true;
                }
                frsActivity2 = this.bpO.bot;
                frsActivity2.bgy.d(Boolean.valueOf(z));
                if (!z) {
                    wVar2 = this.bpO.MS;
                    if (wVar2.getErrorCode() == 22) {
                        frsActivity4 = this.bpO.bot;
                        frsActivity4.showToast(this.bpO.getPageContext().getString(t.j.had_liked_forum));
                        return;
                    }
                    wVar3 = this.bpO.MS;
                    if (!AntiHelper.or(wVar3.getErrorCode())) {
                        frsActivity3 = this.bpO.bot;
                        wVar4 = this.bpO.MS;
                        frsActivity3.showToast(wVar4.getErrorString());
                        return;
                    }
                    Activity pageActivity = this.bpO.getPageContext().getPageActivity();
                    wVar5 = this.bpO.MS;
                    AntiHelper.X(pageActivity, wVar5.getErrorString());
                    return;
                }
                this.bpO.a(Pk, true);
                frsActivity5 = this.bpO.bot;
                frsActivity5.showToast(this.bpO.getPageContext().getString(t.j.like_success));
                TbadkCoreApplication.m411getInst().addLikeForum(name);
                this.bpO.f(true, Pk.aoE().getId());
                x xVar = (x) obj;
                xVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.bpO.getPageContext().getPageActivity();
        wVar6 = this.bpO.MS;
        AntiHelper.X(pageActivity2, wVar6.getErrorString());
    }
}
