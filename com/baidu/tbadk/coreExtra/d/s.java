package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends com.baidu.adp.framework.b.j {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(q qVar, int i) {
        super(1001);
        this.a = qVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.f' to match base method */
    @Override // com.baidu.adp.framework.b.g
    public final /* synthetic */ SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (!(socketResponsedMessage2 instanceof ResponseOnlineMessage)) {
            q.a(this.a, socketResponsedMessage2.g(), -1, null);
            return null;
        }
        ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage2;
        if (responseOnlineMessage.e() != 0) {
            q.a(this.a, socketResponsedMessage2.g(), responseOnlineMessage.e(), responseOnlineMessage.f());
            return null;
        }
        q.c(this.a);
        TiebaStatic.a(1001, 0, null, "online succ", null, responseOnlineMessage.e(), responseOnlineMessage.f());
        com.baidu.adp.framework.e.c.a();
        com.baidu.adp.framework.e.c.a(false);
        com.baidu.adp.lib.util.f.d("----online succ");
        return socketResponsedMessage2;
    }
}
