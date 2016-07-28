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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p bUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.bUo = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        FrsActivity frsActivity;
        boolean z;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        TiebaStatic.eventStat(TbadkCoreApplication.m10getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        frsActivity = this.bUo.bLx;
        com.baidu.tieba.tbadkCore.p VU = frsActivity.VU();
        if (VU != null && VU.aGX() != null) {
            String name = VU.aGX().getName();
            SignData signData = null;
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (signMessage == null || signMessage.signData == null) {
                z = false;
            } else {
                signData = signMessage.signData;
                com.baidu.tieba.tbadkCore.d.bdv().N(name, false);
                VU.d(signData);
                signData.forumId = VU.aGX().getId();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.bUo.aaM();
            if (z) {
                if (VU.aGX() != null) {
                    this.bUo.g(VU);
                    int i = -1;
                    if (this.bUo.aaO()) {
                        i = VU.aGX().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m10getInst().addSignedForum(VU.aGX().getName(), signData.sign_bonus_point, i);
                    if (AntiHelper.rg(signMessage.mSignErrorCode)) {
                        AntiHelper.O(this.bUo.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else if (!this.bUo.aaK()) {
                        frsActivity4 = this.bUo.bLx;
                        frsActivity4.showToast(this.bUo.getPageContext().getResources().getString(u.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                    } else {
                        frsActivity3 = this.bUo.bLx;
                        frsActivity3.showToast(this.bUo.getPageContext().getResources().getString(u.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                    }
                }
            } else if (AntiHelper.rg(signMessage.mSignErrorCode)) {
                AntiHelper.O(this.bUo.getPageContext().getPageActivity(), signMessage.mSignErrorString);
            } else {
                if (signMessage.mSignErrorCode == 160002) {
                    this.bUo.ia(1);
                }
                frsActivity2 = this.bUo.bLx;
                frsActivity2.showToast(signMessage.mSignErrorString);
            }
        }
    }
}
