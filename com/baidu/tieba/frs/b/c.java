package com.baidu.tieba.frs.b;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ej;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.g {
    final /* synthetic */ a bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bcD = aVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FrsActivity frsActivity;
        SignData signData;
        boolean z;
        ej ejVar;
        ej ejVar2;
        FrsActivity frsActivity2;
        ej ejVar3;
        ej ejVar4;
        ej ejVar5;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        ej ejVar6;
        frsActivity = this.bcD.bbk;
        com.baidu.tieba.tbadkCore.o Lt = frsActivity.Lt();
        if (Lt != null && Lt.afg() != null) {
            String name = Lt.afg().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.d.avW().H(name, false);
                Lt.d(signData);
                signData.setForumId(Lt.afg().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.bcD.NQ();
            if (!z) {
                ejVar = this.bcD.bcw;
                if (!AntiHelper.lr(ejVar.getErrorCode())) {
                    ejVar2 = this.bcD.bcw;
                    if (ejVar2.getErrorCode() == 160002) {
                        this.bcD.gk(1);
                    }
                    frsActivity2 = this.bcD.bbk;
                    ejVar3 = this.bcD.bcw;
                    frsActivity2.showToast(ejVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.bcD.getPageContext().getPageActivity();
                ejVar4 = this.bcD.bcw;
                AntiHelper.Q(pageActivity, ejVar4.getErrorString());
            } else if (Lt != null && Lt.afg() != null) {
                this.bcD.d(Lt);
                if (signData != null) {
                    int i = -1;
                    if (this.bcD.NW()) {
                        i = Lt.afg().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(Lt.afg().getName(), signData.getBonusPoint(), i);
                }
                ejVar5 = this.bcD.bcw;
                if (AntiHelper.lr(ejVar5.getErrorCode())) {
                    Activity pageActivity2 = this.bcD.getPageContext().getPageActivity();
                    ejVar6 = this.bcD.bcw;
                    AntiHelper.Q(pageActivity2, ejVar6.getErrorString());
                } else if (signData != null) {
                    if (!this.bcD.NO()) {
                        frsActivity4 = this.bcD.bbk;
                        frsActivity4.showToast(this.bcD.getPageContext().getResources().getString(i.h.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.bcD.bbk;
                    frsActivity3.showToast(this.bcD.getPageContext().getResources().getString(i.h.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
