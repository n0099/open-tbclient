package com.baidu.tieba.frs.g;

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
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ u cdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(u uVar, int i) {
        super(i);
        this.cdZ = uVar;
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
        frsActivity = this.cdZ.bVk;
        com.baidu.tieba.tbadkCore.n aas = frsActivity.aas();
        if (aas != null && aas.aKx() != null) {
            String name = aas.aKx().getName();
            SignData signData = null;
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (signMessage == null || signMessage.signData == null) {
                z = false;
            } else {
                signData = signMessage.signData;
                com.baidu.tieba.tbadkCore.c.bhj().V(name, false);
                aas.d(signData);
                signData.forumId = aas.aKx().getId();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.cdZ.aeY();
            if (z) {
                if (aas.aKx() != null) {
                    this.cdZ.j(aas);
                    int i = -1;
                    if (this.cdZ.afa()) {
                        i = aas.aKx().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m9getInst().addSignedForum(aas.aKx().getName(), signData.sign_bonus_point, i);
                    if (AntiHelper.sd(signMessage.mSignErrorCode)) {
                        AntiHelper.aq(this.cdZ.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else if (!this.cdZ.aeW()) {
                        frsActivity4 = this.cdZ.bVk;
                        frsActivity4.showToast(this.cdZ.getPageContext().getResources().getString(w.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                    } else {
                        frsActivity3 = this.cdZ.bVk;
                        frsActivity3.showToast(this.cdZ.getPageContext().getResources().getString(w.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                    }
                }
            } else if (AntiHelper.sd(signMessage.mSignErrorCode)) {
                AntiHelper.aq(this.cdZ.getPageContext().getPageActivity(), signMessage.mSignErrorString);
            } else {
                if (signMessage.mSignErrorCode == 160002) {
                    this.cdZ.iN(1);
                }
                frsActivity2 = this.cdZ.bVk;
                frsActivity2.showToast(signMessage.mSignErrorString);
            }
        }
    }
}
