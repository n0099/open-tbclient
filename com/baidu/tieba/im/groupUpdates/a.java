package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
import com.baidu.tieba.im.groupInfo.al;
/* loaded from: classes.dex */
final class a extends com.baidu.adp.framework.c.g {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(UpdatesActivity updatesActivity, int i) {
        super(0);
        this.a = updatesActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        t tVar;
        UpdatesItemData updatesItemData;
        p pVar;
        com.baidu.tieba.im.a aVar;
        p pVar2;
        p pVar3;
        com.baidu.tieba.im.a aVar2;
        UpdatesItemData updatesItemData2;
        com.baidu.tieba.im.a aVar3;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        tVar = this.a.b;
        tVar.a(false);
        if (socketResponsedMessage2 != null && (socketResponsedMessage2 instanceof com.baidu.adp.framework.message.f) && 202004 == socketResponsedMessage2.g()) {
            ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage2;
            al alVar = (al) responseDelSystemMessage.h();
            if (responseDelSystemMessage.e() != 0) {
                com.baidu.adp.lib.util.f.b("del group info err:" + responseDelSystemMessage.f());
                return;
            }
            com.baidu.adp.lib.util.f.e("del group info: gid" + alVar.i() + " msgid:" + alVar.j());
            updatesItemData = this.a.i;
            if (updatesItemData != null) {
                updatesItemData2 = this.a.i;
                aVar3 = this.a.e;
                if (updatesItemData2 != null) {
                    com.baidu.tieba.im.r.a(new q(updatesItemData2), aVar3);
                }
                this.a.i = null;
            }
            pVar = this.a.j;
            if (pVar != null) {
                pVar2 = this.a.j;
                if (pVar2.c() > 0) {
                    pVar3 = this.a.j;
                    aVar2 = this.a.e;
                    com.baidu.tieba.im.r.a(new r(pVar3), aVar2);
                }
            }
            aVar = this.a.d;
            com.baidu.tieba.im.validate.n.a(Integer.MAX_VALUE, 0, aVar);
            com.baidu.tieba.im.pushNotify.a.a(false, (com.baidu.tieba.im.a<Void>) null);
        }
    }
}
