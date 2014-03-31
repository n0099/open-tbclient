package com.baidu.tieba.im.searchGroup;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
/* loaded from: classes.dex */
final class d extends com.baidu.adp.framework.c.g {
    final /* synthetic */ SearchGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(SearchGroupActivity searchGroupActivity, int i) {
        super(103007);
        this.a = searchGroupActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        g gVar;
        g gVar2;
        g gVar3;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        gVar = this.a.b;
        gVar.c();
        if (socketResponsedMessage2 == null) {
            this.a.showToast(com.baidu.tieba.im.j.neterror);
        } else if (socketResponsedMessage2.g() == 103007) {
            try {
                if (socketResponsedMessage2 instanceof ResponseSearchGroupMessage) {
                    ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) socketResponsedMessage2;
                    if (responseSearchGroupMessage.e() == 0) {
                        gVar3 = this.a.b;
                        gVar3.a(responseSearchGroupMessage);
                        this.a.a();
                    }
                    gVar2 = this.a.b;
                    gVar2.d();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.d("ResponseGroupInfoMessage invalid");
            }
        }
    }
}
