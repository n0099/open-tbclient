package com.baidu.tieba.frs.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ o aOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar) {
        this.aOZ = oVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.aOZ.LN.getPageActivity(), this.aOZ.aOz, "exp_acce")));
        aVar.dismiss();
    }
}
