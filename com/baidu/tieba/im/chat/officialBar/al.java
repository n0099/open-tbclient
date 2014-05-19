package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ OfficialBarInfoActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(OfficialBarInfoActivity officialBarInfoActivity) {
        super(MessageTypes.CMD_QUERY_OFFICIAL_BAR_INFO);
        this.a = officialBarInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        an anVar;
        an anVar2;
        com.baidu.tbadk.editortool.ab abVar;
        if (socketResponsedMessage == null) {
            this.a.hideProgressBar();
            return;
        }
        if (socketResponsedMessage.getCmd() == 208001 && (socketResponsedMessage instanceof ResponseOfficialBarInfoMessage)) {
            ResponseOfficialBarInfoMessage responseOfficialBarInfoMessage = (ResponseOfficialBarInfoMessage) socketResponsedMessage;
            BdLog.d("portrait:" + responseOfficialBarInfoMessage.getPortrait());
            anVar = this.a.f;
            anVar.a(responseOfficialBarInfoMessage.getAuthen());
            anVar2 = this.a.f;
            String portrait = responseOfficialBarInfoMessage.getPortrait();
            abVar = this.a.e;
            anVar2.a(portrait, abVar);
        }
        this.a.hideProgressBar();
    }
}
