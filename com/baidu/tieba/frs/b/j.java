package com.baidu.tieba.frs.b;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.eh;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.g {
    final /* synthetic */ a bbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.bbY = aVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FrsActivity frsActivity;
        SignData signData;
        boolean z;
        eh ehVar;
        eh ehVar2;
        FrsActivity frsActivity2;
        eh ehVar3;
        eh ehVar4;
        eh ehVar5;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        eh ehVar6;
        frsActivity = this.bbY.baR;
        com.baidu.tieba.tbadkCore.o Ld = frsActivity.Ld();
        if (Ld != null && Ld.aeJ() != null) {
            String name = Ld.aeJ().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.d.avp().H(name, false);
                Ld.d(signData);
                signData.setForumId(Ld.aeJ().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.bbY.Nu();
            if (!z) {
                ehVar = this.bbY.bbS;
                if (!AntiHelper.lc(ehVar.getErrorCode())) {
                    ehVar2 = this.bbY.bbS;
                    if (ehVar2.getErrorCode() == 160002) {
                        this.bbY.fY(1);
                    }
                    frsActivity2 = this.bbY.baR;
                    ehVar3 = this.bbY.bbS;
                    frsActivity2.showToast(ehVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.bbY.getPageContext().getPageActivity();
                ehVar4 = this.bbY.bbS;
                AntiHelper.P(pageActivity, ehVar4.getErrorString());
            } else if (Ld != null && Ld.aeJ() != null) {
                this.bbY.d(Ld);
                if (signData != null) {
                    int i = -1;
                    if (this.bbY.NA()) {
                        i = Ld.aeJ().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(Ld.aeJ().getName(), signData.getBonusPoint(), i);
                }
                ehVar5 = this.bbY.bbS;
                if (AntiHelper.lc(ehVar5.getErrorCode())) {
                    Activity pageActivity2 = this.bbY.getPageContext().getPageActivity();
                    ehVar6 = this.bbY.bbS;
                    AntiHelper.P(pageActivity2, ehVar6.getErrorString());
                } else if (signData != null) {
                    if (!this.bbY.Ns()) {
                        frsActivity4 = this.bbY.baR;
                        frsActivity4.showToast(this.bbY.getPageContext().getResources().getString(i.h.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.bbY.baR;
                    frsActivity3.showToast(this.bbY.getPageContext().getResources().getString(i.h.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
