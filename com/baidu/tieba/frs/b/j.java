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
    final /* synthetic */ a bbN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.bbN = aVar;
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
        frsActivity = this.bbN.baG;
        com.baidu.tieba.tbadkCore.o Lh = frsActivity.Lh();
        if (Lh != null && Lh.aeN() != null) {
            String name = Lh.aeN().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.d.avn().H(name, false);
                Lh.d(signData);
                signData.setForumId(Lh.aeN().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.bbN.Ny();
            if (!z) {
                ehVar = this.bbN.bbH;
                if (!AntiHelper.la(ehVar.getErrorCode())) {
                    ehVar2 = this.bbN.bbH;
                    if (ehVar2.getErrorCode() == 160002) {
                        this.bbN.fY(1);
                    }
                    frsActivity2 = this.bbN.baG;
                    ehVar3 = this.bbN.bbH;
                    frsActivity2.showToast(ehVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.bbN.getPageContext().getPageActivity();
                ehVar4 = this.bbN.bbH;
                AntiHelper.P(pageActivity, ehVar4.getErrorString());
            } else if (Lh != null && Lh.aeN() != null) {
                this.bbN.d(Lh);
                if (signData != null) {
                    int i = -1;
                    if (this.bbN.NE()) {
                        i = Lh.aeN().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(Lh.aeN().getName(), signData.getBonusPoint(), i);
                }
                ehVar5 = this.bbN.bbH;
                if (AntiHelper.la(ehVar5.getErrorCode())) {
                    Activity pageActivity2 = this.bbN.getPageContext().getPageActivity();
                    ehVar6 = this.bbN.bbH;
                    AntiHelper.P(pageActivity2, ehVar6.getErrorString());
                } else if (signData != null) {
                    if (!this.bbN.Nw()) {
                        frsActivity4 = this.bbN.baG;
                        frsActivity4.showToast(this.bbN.getPageContext().getResources().getString(i.h.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.bbN.baG;
                    frsActivity3.showToast(this.bbN.getPageContext().getResources().getString(i.h.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
