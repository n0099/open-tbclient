package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
final class an extends com.baidu.adp.framework.c.g {
    final /* synthetic */ OfficialBarInfoActivity a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        ap apVar;
        ap apVar2;
        com.baidu.tbadk.editortool.aa aaVar;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 != null && socketResponsedMessage2.g() == 208001 && (socketResponsedMessage2 instanceof ResponseOfficialBarInfoMessage)) {
            ResponseOfficialBarInfoMessage responseOfficialBarInfoMessage = (ResponseOfficialBarInfoMessage) socketResponsedMessage2;
            com.baidu.adp.lib.util.f.e("portrait:" + responseOfficialBarInfoMessage.d());
            apVar = this.a.f;
            apVar.a(responseOfficialBarInfoMessage.i());
            apVar2 = this.a.f;
            String d = responseOfficialBarInfoMessage.d();
            aaVar = this.a.e;
            aaVar.b(d, new aq(apVar2));
        }
        this.a.hideProgressBar();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(OfficialBarInfoActivity officialBarInfoActivity) {
        super(208001);
        this.a = officialBarInfoActivity;
    }
}
