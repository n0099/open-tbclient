package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarInfoActivity aRJ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(OfficialBarInfoActivity officialBarInfoActivity) {
        super(208001);
        this.aRJ = officialBarInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        am amVar;
        am amVar2;
        if (socketResponsedMessage == null) {
            this.aRJ.hideProgressBar();
            return;
        }
        if (socketResponsedMessage.getCmd() == 208001 && (socketResponsedMessage instanceof ResponseOfficialBarInfoMessage)) {
            ResponseOfficialBarInfoMessage responseOfficialBarInfoMessage = (ResponseOfficialBarInfoMessage) socketResponsedMessage;
            amVar = this.aRJ.aRH;
            amVar.fC(responseOfficialBarInfoMessage.getAuthen());
            amVar2 = this.aRJ.aRH;
            amVar2.fD(responseOfficialBarInfoMessage.getPortrait());
        }
        this.aRJ.hideProgressBar();
    }
}
