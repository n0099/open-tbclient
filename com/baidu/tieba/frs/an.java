package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.EcommSellerErrorActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.ecomm.EcommCanSendThreadResponseMessage;
import com.baidu.tieba.frs.ecomm.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements a.InterfaceC0057a {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ecomm.a.InterfaceC0057a
    public void a(int i, String str, EcommCanSendThreadResponseMessage ecommCanSendThreadResponseMessage) {
        com.baidu.tbadk.core.view.a aVar;
        com.baidu.tbadk.core.view.a aVar2;
        aVar = this.bQp.boU;
        if (aVar != null) {
            aVar2 = this.bQp.boU;
            aVar2.aF(false);
        }
        if (ecommCanSendThreadResponseMessage != null && (ecommCanSendThreadResponseMessage instanceof EcommCanSendThreadResponseMessage)) {
            if (ecommCanSendThreadResponseMessage.getError() == 0) {
                this.bQp.bPl = ecommCanSendThreadResponseMessage.address;
                this.bQp.aaD();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EcommSellerErrorActivityConfig(this.bQp.getPageContext().getPageActivity(), ecommCanSendThreadResponseMessage.getError(), ecommCanSendThreadResponseMessage.getErrorString())));
        }
    }
}
