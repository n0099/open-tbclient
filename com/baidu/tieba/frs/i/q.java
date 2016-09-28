package com.baidu.tieba.frs.i;

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
public class q extends CustomMessageListener {
    final /* synthetic */ p cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.cft = pVar;
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
        frsActivity = this.cft.bWH;
        com.baidu.tieba.tbadkCore.p abe = frsActivity.abe();
        if (abe != null && abe.aMr() != null) {
            String name = abe.aMr().getName();
            SignData signData = null;
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (signMessage == null || signMessage.signData == null) {
                z = false;
            } else {
                signData = signMessage.signData;
                com.baidu.tieba.tbadkCore.d.bhH().R(name, false);
                abe.d(signData);
                signData.forumId = abe.aMr().getId();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.cft.afL();
            if (z) {
                if (abe.aMr() != null) {
                    this.cft.h(abe);
                    int i = -1;
                    if (this.cft.afN()) {
                        i = abe.aMr().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m9getInst().addSignedForum(abe.aMr().getName(), signData.sign_bonus_point, i);
                    if (AntiHelper.rU(signMessage.mSignErrorCode)) {
                        AntiHelper.R(this.cft.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else if (!this.cft.afJ()) {
                        frsActivity4 = this.cft.bWH;
                        frsActivity4.showToast(this.cft.getPageContext().getResources().getString(r.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                    } else {
                        frsActivity3 = this.cft.bWH;
                        frsActivity3.showToast(this.cft.getPageContext().getResources().getString(r.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                    }
                }
            } else if (AntiHelper.rU(signMessage.mSignErrorCode)) {
                AntiHelper.R(this.cft.getPageContext().getPageActivity(), signMessage.mSignErrorString);
            } else {
                if (signMessage.mSignErrorCode == 160002) {
                    this.cft.iH(1);
                }
                frsActivity2 = this.cft.bWH;
                frsActivity2.showToast(signMessage.mSignErrorString);
            }
        }
    }
}
