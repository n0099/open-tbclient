package com.baidu.tieba.frs.h;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ai;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.g {
    final /* synthetic */ m buB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(m mVar) {
        this.buB = mVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FrsActivity frsActivity;
        SignData signData;
        boolean z;
        ai aiVar;
        ai aiVar2;
        FrsActivity frsActivity2;
        ai aiVar3;
        ai aiVar4;
        ai aiVar5;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        ai aiVar6;
        frsActivity = this.buB.bpj;
        com.baidu.tieba.tbadkCore.o PZ = frsActivity.PZ();
        if (PZ != null && PZ.avA() != null) {
            String name = PZ.avA().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.c.aRW().L(name, false);
                PZ.d(signData);
                signData.setForumId(PZ.avA().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.buB.TR();
            if (!z) {
                aiVar = this.buB.bux;
                if (!AntiHelper.pw(aiVar.getErrorCode())) {
                    aiVar2 = this.buB.bux;
                    if (aiVar2.getErrorCode() == 160002) {
                        this.buB.gU(1);
                    }
                    frsActivity2 = this.buB.bpj;
                    aiVar3 = this.buB.bux;
                    frsActivity2.showToast(aiVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.buB.getPageContext().getPageActivity();
                aiVar4 = this.buB.bux;
                AntiHelper.O(pageActivity, aiVar4.getErrorString());
            } else if (PZ.avA() != null) {
                this.buB.f(PZ);
                int i = -1;
                if (this.buB.TT()) {
                    i = PZ.avA().getUser_level() + 1;
                }
                TbadkCoreApplication.m11getInst().addSignedForum(PZ.avA().getName(), signData.getBonusPoint(), i);
                aiVar5 = this.buB.bux;
                if (AntiHelper.pw(aiVar5.getErrorCode())) {
                    Activity pageActivity2 = this.buB.getPageContext().getPageActivity();
                    aiVar6 = this.buB.bux;
                    AntiHelper.O(pageActivity2, aiVar6.getErrorString());
                } else if (!this.buB.TP()) {
                    frsActivity4 = this.buB.bpj;
                    frsActivity4.showToast(this.buB.getPageContext().getResources().getString(t.j.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                } else {
                    frsActivity3 = this.buB.bpj;
                    frsActivity3.showToast(this.buB.getPageContext().getResources().getString(t.j.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
