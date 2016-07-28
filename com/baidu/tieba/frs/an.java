package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.EcommSellerErrorActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.b;
import com.baidu.tieba.frs.ecomm.EcommCanSendThreadResponseMessage;
import com.baidu.tieba.frs.ecomm.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements a.InterfaceC0056a {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ecomm.a.InterfaceC0056a
    public void a(int i, String str, EcommCanSendThreadResponseMessage ecommCanSendThreadResponseMessage) {
        b bVar;
        b bVar2;
        bVar = this.bEL.bdy;
        if (bVar != null) {
            bVar2 = this.bEL.bdy;
            bVar2.aE(false);
        }
        if (ecommCanSendThreadResponseMessage != null && (ecommCanSendThreadResponseMessage instanceof EcommCanSendThreadResponseMessage)) {
            if (ecommCanSendThreadResponseMessage.getError() == 0) {
                this.bEL.bDH = ecommCanSendThreadResponseMessage.address;
                this.bEL.VI();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EcommSellerErrorActivityConfig(this.bEL.getPageContext().getPageActivity(), ecommCanSendThreadResponseMessage.getError(), ecommCanSendThreadResponseMessage.getErrorString())));
        }
    }
}
