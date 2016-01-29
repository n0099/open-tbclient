package com.baidu.tieba.frs.c;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.fl;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.g {
    final /* synthetic */ a bpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bpO = aVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FrsActivity frsActivity;
        SignData signData;
        boolean z;
        fl flVar;
        fl flVar2;
        FrsActivity frsActivity2;
        fl flVar3;
        fl flVar4;
        fl flVar5;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        fl flVar6;
        frsActivity = this.bpO.bot;
        com.baidu.tieba.tbadkCore.o Pk = frsActivity.Pk();
        if (Pk != null && Pk.aoE() != null) {
            String name = Pk.aoE().getName();
            if (obj == null || !(obj instanceof SignData)) {
                signData = null;
                z = false;
            } else {
                signData = (SignData) obj;
                com.baidu.tieba.tbadkCore.c.aKN().I(name, false);
                Pk.d(signData);
                signData.setForumId(Pk.aoE().getId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.bpO.RS();
            if (!z) {
                flVar = this.bpO.bpH;
                if (!AntiHelper.or(flVar.getErrorCode())) {
                    flVar2 = this.bpO.bpH;
                    if (flVar2.getErrorCode() == 160002) {
                        this.bpO.gW(1);
                    }
                    frsActivity2 = this.bpO.bot;
                    flVar3 = this.bpO.bpH;
                    frsActivity2.showToast(flVar3.getErrorString());
                    return;
                }
                Activity pageActivity = this.bpO.getPageContext().getPageActivity();
                flVar4 = this.bpO.bpH;
                AntiHelper.X(pageActivity, flVar4.getErrorString());
            } else if (Pk != null && Pk.aoE() != null) {
                this.bpO.e(Pk);
                if (signData != null) {
                    int i = -1;
                    if (this.bpO.RY()) {
                        i = Pk.aoE().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m411getInst().addSignedForum(Pk.aoE().getName(), signData.getBonusPoint(), i);
                }
                flVar5 = this.bpO.bpH;
                if (AntiHelper.or(flVar5.getErrorCode())) {
                    Activity pageActivity2 = this.bpO.getPageContext().getPageActivity();
                    flVar6 = this.bpO.bpH;
                    AntiHelper.X(pageActivity2, flVar6.getErrorString());
                } else if (signData != null) {
                    if (!this.bpO.RQ()) {
                        frsActivity4 = this.bpO.bot;
                        frsActivity4.showToast(this.bpO.getPageContext().getResources().getString(t.j.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                        return;
                    }
                    frsActivity3 = this.bpO.bot;
                    frsActivity3.showToast(this.bpO.getPageContext().getResources().getString(t.j.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                }
            }
        }
    }
}
