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
public class v extends CustomMessageListener {
    final /* synthetic */ u chY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(u uVar, int i) {
        super(i);
        this.chY = uVar;
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
        rVar = this.chY.bTw;
        com.baidu.tieba.tbadkCore.n aau = rVar.aau();
        if (aau != null && aau.aIz() != null && aau.aIz().getName() != null && aau.aIz().getName().equals(FrsActivityStatic.forumName)) {
            TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            String name = aau.aIz().getName();
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (signMessage == null || signMessage.signData == null) {
                signData = null;
                z = false;
            } else {
                SignData signData2 = signMessage.signData;
                if (signData2.forumId != null && signData2.forumId.equals(aau.aIz().getId())) {
                    com.baidu.tieba.tbadkCore.c.bgf().S(name, false);
                    aau.d(signData2);
                    signData2.forumId = aau.aIz().getId();
                    signData2.forumName = aau.aIz().getName();
                    signData = signData2;
                    z = true;
                } else {
                    return;
                }
            }
            if (z) {
                int user_level = aau.aIz().getUser_level();
                if (this.chY.aec()) {
                    i = aau.aIz().getUser_level();
                    if (user_level >= i) {
                        i++;
                    }
                } else {
                    i = user_level;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(name, signData.sign_bonus_point, i);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                if (AntiHelper.sr(signMessage.mSignErrorCode)) {
                    AntiHelper.ap(this.chY.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                } else if (!this.chY.aea()) {
                    rVar4 = this.chY.bTw;
                    rVar4.showToast(this.chY.getPageContext().getResources().getString(w.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                } else {
                    rVar3 = this.chY.bTw;
                    rVar3.showToast(this.chY.getPageContext().getResources().getString(w.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                }
            } else if (AntiHelper.sr(signMessage.mSignErrorCode)) {
                AntiHelper.ap(this.chY.getPageContext().getPageActivity(), signMessage.mSignErrorString);
            } else {
                if (signMessage.mSignErrorCode == 160002) {
                    this.chY.je(1);
                }
                rVar2 = this.chY.bTw;
                rVar2.showToast(signMessage.mSignErrorString);
            }
        }
    }
}
