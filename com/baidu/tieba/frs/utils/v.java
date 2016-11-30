package com.baidu.tieba.frs.utils;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.EcommSellerErrorActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ecomm.EcommCanSendThreadResponseMessage;
import com.baidu.tieba.frs.ecomm.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements a.InterfaceC0060a {
    private final /* synthetic */ FrsActivity ciY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.ciY = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ecomm.a.InterfaceC0060a
    public void a(int i, String str, EcommCanSendThreadResponseMessage ecommCanSendThreadResponseMessage) {
        if (this.ciY != null) {
            this.ciY.aI(false);
            if (ecommCanSendThreadResponseMessage != null) {
                if (ecommCanSendThreadResponseMessage.getError() == 0) {
                    this.ciY.jT(ecommCanSendThreadResponseMessage.address);
                    u.a(this.ciY, this.ciY.acr(), this.ciY.abS());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EcommSellerErrorActivityConfig(this.ciY.getPageContext().getPageActivity(), ecommCanSendThreadResponseMessage.getError(), ecommCanSendThreadResponseMessage.getErrorString())));
            }
        }
    }
}
