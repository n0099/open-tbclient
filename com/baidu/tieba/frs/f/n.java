package com.baidu.tieba.frs.f;

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
public class n extends CustomMessageListener {
    final /* synthetic */ m cpZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, int i) {
        super(i);
        this.cpZ = mVar;
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
        rVar = this.cpZ.cbE;
        com.baidu.tieba.tbadkCore.n aek = rVar.aek();
        if (aek != null && aek.aMt() != null && aek.aMt().getName() != null && aek.aMt().getName().equals(FrsActivityStatic.forumName)) {
            TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            String name = aek.aMt().getName();
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (signMessage == null || signMessage.signData == null) {
                signData = null;
                z = false;
            } else {
                SignData signData2 = signMessage.signData;
                if (signData2.forumId != null && signData2.forumId.equals(aek.aMt().getId())) {
                    com.baidu.tieba.tbadkCore.c.bkt().X(name, false);
                    aek.d(signData2);
                    signData2.forumId = aek.aMt().getId();
                    signData2.forumName = aek.aMt().getName();
                    signData = signData2;
                    z = true;
                } else {
                    return;
                }
            }
            if (z) {
                int user_level = aek.aMt().getUser_level();
                if (this.cpZ.ahQ()) {
                    i = aek.aMt().getUser_level();
                    if (user_level >= i) {
                        i++;
                    }
                } else {
                    i = user_level;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(name, signData.sign_bonus_point, i);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                if (AntiHelper.sK(signMessage.mSignErrorCode)) {
                    AntiHelper.ar(this.cpZ.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                } else if (!this.cpZ.ahO()) {
                    rVar4 = this.cpZ.cbE;
                    rVar4.showToast(this.cpZ.getPageContext().getResources().getString(w.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                } else {
                    rVar3 = this.cpZ.cbE;
                    rVar3.showToast(this.cpZ.getPageContext().getResources().getString(w.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                }
            } else if (AntiHelper.sK(signMessage.mSignErrorCode)) {
                AntiHelper.ar(this.cpZ.getPageContext().getPageActivity(), signMessage.mSignErrorString);
            } else {
                if (signMessage.mSignErrorCode == 160002) {
                    this.cpZ.jp(1);
                }
                rVar2 = this.cpZ.cbE;
                rVar2.showToast(signMessage.mSignErrorString);
            }
        }
    }
}
