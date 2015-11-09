package com.baidu.tieba.frs.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements a.b {
    final /* synthetic */ q bes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.bes = qVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.eventStat(this.bes.aVn.getPageContext().getPageActivity(), "consume_8", "click");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(this.bes.mContext.getPageActivity(), this.bes.mMemberType, "exp_acce", 2)));
        aVar.dismiss();
    }
}
