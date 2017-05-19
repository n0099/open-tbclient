package com.baidu.tieba.frs.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ u cbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(u uVar, int i) {
        super(i);
        this.cbL = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.r rVar;
        SignData signData;
        boolean z;
        com.baidu.tieba.frs.r rVar2;
        int i;
        com.baidu.tieba.frs.r rVar3;
        com.baidu.tieba.frs.r rVar4;
        rVar = this.cbL.bNK;
        com.baidu.tieba.tbadkCore.n Zq = rVar.Zq();
        if (Zq != null && Zq.aHE() != null && Zq.aHE().getName() != null && Zq.aHE().getName().equals(FrsActivityStatic.forumName)) {
            TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            String name = Zq.aHE().getName();
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (signMessage == null || signMessage.signData == null) {
                signData = null;
                z = false;
            } else {
                SignData signData2 = signMessage.signData;
                if (signData2.forumId != null && signData2.forumId.equals(Zq.aHE().getId())) {
                    com.baidu.tieba.tbadkCore.c.beL().V(name, false);
                    Zq.d(signData2);
                    signData2.forumId = Zq.aHE().getId();
                    signData2.forumName = Zq.aHE().getName();
                    signData = signData2;
                    z = true;
                } else {
                    return;
                }
            }
            if (z) {
                int user_level = Zq.aHE().getUser_level();
                if (this.cbL.acZ()) {
                    i = Zq.aHE().getUser_level();
                    if (user_level >= i) {
                        i++;
                    }
                } else {
                    i = user_level;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(name, signData.sign_bonus_point, i);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                if (AntiHelper.rV(signMessage.mSignErrorCode)) {
                    AntiHelper.aq(this.cbL.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                } else if (!this.cbL.acX()) {
                    rVar4 = this.cbL.bNK;
                    rVar4.showToast(this.cbL.getPageContext().getResources().getString(w.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                } else {
                    rVar3 = this.cbL.bNK;
                    rVar3.showToast(this.cbL.getPageContext().getResources().getString(w.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                }
            } else if (AntiHelper.rV(signMessage.mSignErrorCode)) {
                AntiHelper.aq(this.cbL.getPageContext().getPageActivity(), signMessage.mSignErrorString);
            } else {
                if (signMessage.mSignErrorCode == 160002) {
                    this.cbL.iG(1);
                }
                rVar2 = this.cbL.bNK;
                rVar2.showToast(signMessage.mSignErrorString);
            }
        }
    }
}
