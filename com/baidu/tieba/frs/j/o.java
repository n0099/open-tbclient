package com.baidu.tieba.frs.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ n ckg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(n nVar, int i) {
        super(i);
        this.ckg = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        FrsActivity frsActivity;
        boolean z;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        frsActivity = this.ckg.bZY;
        com.baidu.tieba.tbadkCore.p acr = frsActivity.acr();
        if (acr != null && acr.aOk() != null) {
            String name = acr.aOk().getName();
            SignData signData = null;
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (signMessage == null || signMessage.signData == null) {
                z = false;
            } else {
                signData = signMessage.signData;
                com.baidu.tieba.tbadkCore.d.bkd().R(name, false);
                acr.d(signData);
                signData.forumId = acr.aOk().getId();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.ckg.ahy();
            if (z) {
                if (acr.aOk() != null) {
                    this.ckg.k(acr);
                    int i = -1;
                    if (this.ckg.ahA()) {
                        i = acr.aOk().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m9getInst().addSignedForum(acr.aOk().getName(), signData.sign_bonus_point, i);
                    if (AntiHelper.sm(signMessage.mSignErrorCode)) {
                        AntiHelper.S(this.ckg.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else if (!this.ckg.ahw()) {
                        frsActivity4 = this.ckg.bZY;
                        frsActivity4.showToast(this.ckg.getPageContext().getResources().getString(r.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                    } else {
                        frsActivity3 = this.ckg.bZY;
                        frsActivity3.showToast(this.ckg.getPageContext().getResources().getString(r.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                    }
                }
            } else if (AntiHelper.sm(signMessage.mSignErrorCode)) {
                AntiHelper.S(this.ckg.getPageContext().getPageActivity(), signMessage.mSignErrorString);
            } else {
                if (signMessage.mSignErrorCode == 160002) {
                    this.ckg.iN(1);
                }
                frsActivity2 = this.ckg.bZY;
                frsActivity2.showToast(signMessage.mSignErrorString);
            }
        }
    }
}
