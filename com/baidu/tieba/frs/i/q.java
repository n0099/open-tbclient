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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p bSo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.bSo = pVar;
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
        frsActivity = this.bSo.bJR;
        com.baidu.tieba.tbadkCore.p VC = frsActivity.VC();
        if (VC != null && VC.aDN() != null) {
            String name = VC.aDN().getName();
            SignData signData = null;
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (signMessage == null || signMessage.signData == null) {
                z = false;
            } else {
                signData = signMessage.signData;
                com.baidu.tieba.tbadkCore.d.bah().N(name, false);
                VC.d(signData);
                signData.forumId = VC.aDN().getId();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.bSo.aak();
            if (z) {
                if (VC.aDN() != null) {
                    this.bSo.g(VC);
                    int i = -1;
                    if (this.bSo.aam()) {
                        i = VC.aDN().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m9getInst().addSignedForum(VC.aDN().getName(), signData.sign_bonus_point, i);
                    if (AntiHelper.qL(signMessage.mSignErrorCode)) {
                        AntiHelper.O(this.bSo.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else if (!this.bSo.aai()) {
                        frsActivity4 = this.bSo.bJR;
                        frsActivity4.showToast(this.bSo.getPageContext().getResources().getString(u.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                    } else {
                        frsActivity3 = this.bSo.bJR;
                        frsActivity3.showToast(this.bSo.getPageContext().getResources().getString(u.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                    }
                }
            } else if (AntiHelper.qL(signMessage.mSignErrorCode)) {
                AntiHelper.O(this.bSo.getPageContext().getPageActivity(), signMessage.mSignErrorString);
            } else {
                if (signMessage.mSignErrorCode == 160002) {
                    this.bSo.hZ(1);
                }
                frsActivity2 = this.bSo.bJR;
                frsActivity2.showToast(signMessage.mSignErrorString);
            }
        }
    }
}
