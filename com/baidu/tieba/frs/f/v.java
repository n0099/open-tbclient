package com.baidu.tieba.frs.f;

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
public class v extends CustomMessageListener {
    final /* synthetic */ u bVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(u uVar, int i) {
        super(i);
        this.bVP = uVar;
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
        frsActivity = this.bVP.bLZ;
        com.baidu.tieba.tbadkCore.n XW = frsActivity.XW();
        if (XW != null && XW.aJY() != null) {
            String name = XW.aJY().getName();
            SignData signData = null;
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (signMessage == null || signMessage.signData == null) {
                z = false;
            } else {
                signData = signMessage.signData;
                com.baidu.tieba.tbadkCore.c.bfG().U(name, false);
                XW.d(signData);
                signData.forumId = XW.aJY().getId();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.bVP.adc();
            if (z) {
                if (XW.aJY() != null) {
                    this.bVP.j(XW);
                    int i = -1;
                    if (this.bVP.ade()) {
                        i = XW.aJY().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m9getInst().addSignedForum(XW.aJY().getName(), signData.sign_bonus_point, i);
                    if (AntiHelper.sa(signMessage.mSignErrorCode)) {
                        AntiHelper.T(this.bVP.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else if (!this.bVP.ada()) {
                        frsActivity4 = this.bVP.bLZ;
                        frsActivity4.showToast(this.bVP.getPageContext().getResources().getString(r.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                    } else {
                        frsActivity3 = this.bVP.bLZ;
                        frsActivity3.showToast(this.bVP.getPageContext().getResources().getString(r.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                    }
                }
            } else if (AntiHelper.sa(signMessage.mSignErrorCode)) {
                AntiHelper.T(this.bVP.getPageContext().getPageActivity(), signMessage.mSignErrorString);
            } else {
                if (signMessage.mSignErrorCode == 160002) {
                    this.bVP.iK(1);
                }
                frsActivity2 = this.bVP.bLZ;
                frsActivity2.showToast(signMessage.mSignErrorString);
            }
        }
    }
}
