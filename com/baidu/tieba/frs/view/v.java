package com.baidu.tieba.frs.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ o aRA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar) {
        this.aRA = oVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.eventStat(this.aRA.aMk.getPageContext().getPageActivity(), "consume_8", "click");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.aRA.LH.getPageActivity(), this.aRA.aRb, "exp_acce", 2)));
        aVar.dismiss();
    }
}
