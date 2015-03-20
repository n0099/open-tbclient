package com.baidu.tieba.frs.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsHeaderView aOU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsHeaderView frsHeaderView) {
        this.aOU = frsHeaderView;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.aOU.LN.getPageActivity(), this.aOU.aOz, "exp_acce")));
        aVar.dismiss();
    }
}
