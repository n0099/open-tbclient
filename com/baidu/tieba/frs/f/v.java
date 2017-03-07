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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ u cdh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(u uVar, int i) {
        super(i);
        this.cdh = uVar;
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
        frsActivity = this.cdh.bTf;
        com.baidu.tieba.tbadkCore.n YV = frsActivity.YV();
        if (YV != null && YV.aJp() != null) {
            String name = YV.aJp().getName();
            SignData signData = null;
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (signMessage == null || signMessage.signData == null) {
                z = false;
            } else {
                signData = signMessage.signData;
                com.baidu.tieba.tbadkCore.c.bft().V(name, false);
                YV.d(signData);
                signData.forumId = YV.aJp().getId();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                z = true;
            }
            this.cdh.aec();
            if (z) {
                if (YV.aJp() != null) {
                    this.cdh.j(YV);
                    int i = -1;
                    if (this.cdh.aee()) {
                        i = YV.aJp().getUser_level() + 1;
                    }
                    TbadkCoreApplication.m9getInst().addSignedForum(YV.aJp().getName(), signData.sign_bonus_point, i);
                    if (AntiHelper.rZ(signMessage.mSignErrorCode)) {
                        AntiHelper.an(this.cdh.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                    } else if (!this.cdh.aea()) {
                        frsActivity4 = this.cdh.bTf;
                        frsActivity4.showToast(this.cdh.getPageContext().getResources().getString(w.l.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                    } else {
                        frsActivity3 = this.cdh.bTf;
                        frsActivity3.showToast(this.cdh.getPageContext().getResources().getString(w.l.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                    }
                }
            } else if (AntiHelper.rZ(signMessage.mSignErrorCode)) {
                AntiHelper.an(this.cdh.getPageContext().getPageActivity(), signMessage.mSignErrorString);
            } else {
                if (signMessage.mSignErrorCode == 160002) {
                    this.cdh.iG(1);
                }
                frsActivity2 = this.cdh.bTf;
                frsActivity2.showToast(signMessage.mSignErrorString);
            }
        }
    }
}
