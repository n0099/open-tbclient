package com.baidu.tieba.frs.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ o aRB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar) {
        this.aRB = oVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.eventStat(this.aRB.aMl.getPageContext().getPageActivity(), "consume_8", "click");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.aRB.LH.getPageActivity(), this.aRB.aRc, "exp_acce", 2)));
        aVar.dismiss();
    }
}
