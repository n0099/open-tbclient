package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.EcommSellerErrorActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.ecomm.EcommCanSendThreadResponseMessage;
import com.baidu.tieba.frs.ecomm.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements a.InterfaceC0061a {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ecomm.a.InterfaceC0061a
    public void a(int i, String str, EcommCanSendThreadResponseMessage ecommCanSendThreadResponseMessage) {
        com.baidu.tbadk.core.view.a aVar;
        com.baidu.tbadk.core.view.a aVar2;
        aVar = this.bQi.bph;
        if (aVar != null) {
            aVar2 = this.bQi.bph;
            aVar2.aF(false);
        }
        if (ecommCanSendThreadResponseMessage != null) {
            if (ecommCanSendThreadResponseMessage.getError() == 0) {
                this.bQi.bPf = ecommCanSendThreadResponseMessage.address;
                this.bQi.aaR();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EcommSellerErrorActivityConfig(this.bQi.getPageContext().getPageActivity(), ecommCanSendThreadResponseMessage.getError(), ecommCanSendThreadResponseMessage.getErrorString())));
        }
    }
}
