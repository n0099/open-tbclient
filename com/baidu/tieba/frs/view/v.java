package com.baidu.tieba.frs.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ o aPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar) {
        this.aPq = oVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.aPq.LP.getPageActivity(), this.aPq.aOQ, "exp_acce")));
        aVar.dismiss();
    }
}
