package com.baidu.tieba.frs.c;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.g {
    final /* synthetic */ a buP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.buP = aVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FrsActivity frsActivity;
        SignData signData;
        boolean z;
        ah ahVar;
        ah ahVar2;
        FrsActivity frsActivity2;
        ah ahVar3;
        ah ahVar4;
        ah ahVar5;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        ah ahVar6;
        frsActivity = this.buP.bts;
        com.baidu.tieba.tbadkCore.o QZ = frsActivity.QZ();
        if (QZ != null && QZ.avu() != null) {
            String name = QZ.avu().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.c.aRC().J(name, false);
                QZ.d(signData);
                signData.setForumId(QZ.avu().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.buP.TG();
            if (!z) {
                ahVar = this.buP.buI;
                if (!AntiHelper.pB(ahVar.getErrorCode())) {
                    ahVar2 = this.buP.buI;
                    if (ahVar2.getErrorCode() == 160002) {
                        this.buP.hp(1);
                    }
                    frsActivity2 = this.buP.bts;
                    ahVar3 = this.buP.buI;
                    frsActivity2.showToast(ahVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.buP.getPageContext().getPageActivity();
                ahVar4 = this.buP.buI;
                AntiHelper.O(pageActivity, ahVar4.getErrorString());
            } else if (QZ != null && QZ.avu() != null) {
                this.buP.e(QZ);
                if (signData != null) {
                    int i = -1;
                    if (this.buP.TM()) {
                        i = QZ.avu().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(QZ.avu().getName(), signData.getBonusPoint(), i);
                }
                ahVar5 = this.buP.buI;
                if (AntiHelper.pB(ahVar5.getErrorCode())) {
                    Activity pageActivity2 = this.buP.getPageContext().getPageActivity();
                    ahVar6 = this.buP.buI;
                    AntiHelper.O(pageActivity2, ahVar6.getErrorString());
                } else if (signData != null) {
                    if (!this.buP.TE()) {
                        frsActivity4 = this.buP.bts;
                        frsActivity4.showToast(this.buP.getPageContext().getResources().getString(t.j.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.buP.bts;
                    frsActivity3.showToast(this.buP.getPageContext().getResources().getString(t.j.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
