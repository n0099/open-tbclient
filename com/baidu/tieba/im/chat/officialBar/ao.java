package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ OfficialBarInfoActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(OfficialBarInfoActivity officialBarInfoActivity) {
        super(208001);
        this.a = officialBarInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        aq aqVar;
        aq aqVar2;
        com.baidu.tbadk.editortool.aa aaVar;
        if (socketResponsedMessage == null) {
            this.a.hideProgressBar();
            return;
        }
        if (socketResponsedMessage.getCmd() == 208001 && (socketResponsedMessage instanceof ResponseOfficialBarInfoMessage)) {
            ResponseOfficialBarInfoMessage responseOfficialBarInfoMessage = (ResponseOfficialBarInfoMessage) socketResponsedMessage;
            aqVar = this.a.f;
            aqVar.a(responseOfficialBarInfoMessage.getAuthen());
            aqVar2 = this.a.f;
            String portrait = responseOfficialBarInfoMessage.getPortrait();
            aaVar = this.a.e;
            aqVar2.a(portrait, aaVar);
        }
        this.a.hideProgressBar();
    }
}
