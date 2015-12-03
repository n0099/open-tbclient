package com.baidu.tieba.frs.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class m implements a.b {
    final /* synthetic */ FrsHeaderView bkF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsHeaderView frsHeaderView) {
        this.bkF = frsHeaderView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(this.bkF.mContext.getPageActivity(), this.bkF.mMemberType, "exp_acce", 2)));
        aVar.dismiss();
    }
}
