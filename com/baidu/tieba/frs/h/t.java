package com.baidu.tieba.frs.h;

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
public class t extends CustomMessageListener {
    final /* synthetic */ s bPp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, int i) {
        super(i);
        this.bPp = sVar;
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
        frsActivity = this.bPp.bFI;
        com.baidu.tieba.tbadkCore.o WF = frsActivity.WF();
        if (WF != null && WF.aIk() != null) {
            String name = WF.aIk().getName();
            SignData signData = null;
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (signMessage == null || signMessage.signData == null) {
                z = false;
            } else {
                signData = signMessage.signData;
                com.baidu.tieba.tbadkCore.c.bdT().U(name, false);
                WF.d(signData);
                signData.forumId = WF.aIk().getId();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.bPp.abV();
            if (z) {
                if (WF.aIk() != null) {
                    this.bPp.k(WF);
                    int i = -1;
                    if (this.bPp.abX()) {
                        i = WF.aIk().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m9getInst().addSignedForum(WF.aIk().getName(), signData.sign_bonus_point, i);
                    if (AntiHelper.rp(signMessage.mSignErrorCode)) {
                        AntiHelper.S(this.bPp.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else if (!this.bPp.abT()) {
                        frsActivity4 = this.bPp.bFI;
                        frsActivity4.showToast(this.bPp.getPageContext().getResources().getString(r.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                    } else {
                        frsActivity3 = this.bPp.bFI;
                        frsActivity3.showToast(this.bPp.getPageContext().getResources().getString(r.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                    }
                }
            } else if (AntiHelper.rp(signMessage.mSignErrorCode)) {
                AntiHelper.S(this.bPp.getPageContext().getPageActivity(), signMessage.mSignErrorString);
            } else {
                if (signMessage.mSignErrorCode == 160002) {
                    this.bPp.hX(1);
                }
                frsActivity2 = this.bPp.bFI;
                frsActivity2.showToast(signMessage.mSignErrorString);
            }
        }
    }
}
