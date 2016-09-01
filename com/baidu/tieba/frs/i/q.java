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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.cfw = pVar;
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
        frsActivity = this.cfw.bWH;
        com.baidu.tieba.tbadkCore.p aaR = frsActivity.aaR();
        if (aaR != null && aaR.aLP() != null) {
            String name = aaR.aLP().getName();
            SignData signData = null;
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (signMessage == null || signMessage.signData == null) {
                z = false;
            } else {
                signData = signMessage.signData;
                com.baidu.tieba.tbadkCore.d.bgZ().R(name, false);
                aaR.d(signData);
                signData.forumId = aaR.aLP().getId();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.cfw.afx();
            if (z) {
                if (aaR.aLP() != null) {
                    this.cfw.h(aaR);
                    int i = -1;
                    if (this.cfw.afz()) {
                        i = aaR.aLP().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m9getInst().addSignedForum(aaR.aLP().getName(), signData.sign_bonus_point, i);
                    if (AntiHelper.rG(signMessage.mSignErrorCode)) {
                        AntiHelper.R(this.cfw.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else if (!this.cfw.afv()) {
                        frsActivity4 = this.cfw.bWH;
                        frsActivity4.showToast(this.cfw.getPageContext().getResources().getString(t.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                    } else {
                        frsActivity3 = this.cfw.bWH;
                        frsActivity3.showToast(this.cfw.getPageContext().getResources().getString(t.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                    }
                }
            } else if (AntiHelper.rG(signMessage.mSignErrorCode)) {
                AntiHelper.R(this.cfw.getPageContext().getPageActivity(), signMessage.mSignErrorString);
            } else {
                if (signMessage.mSignErrorCode == 160002) {
                    this.cfw.iC(1);
                }
                frsActivity2 = this.cfw.bWH;
                frsActivity2.showToast(signMessage.mSignErrorString);
            }
        }
    }
}
