package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends com.baidu.adp.framework.c.g {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(b bVar, int i) {
        super(0);
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 != null && socketResponsedMessage2.g() == 103104 && (socketResponsedMessage2 instanceof ResponseDismissGroupMessage)) {
            ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage2;
            if (responseDismissGroupMessage.e() > 0) {
                this.a.showToast(responseDismissGroupMessage.f());
            } else if (responseDismissGroupMessage.e() < 0) {
                this.a.showToast(com.baidu.tieba.im.j.neterror);
            } else {
                new StringBuilder(String.valueOf(responseDismissGroupMessage.d())).toString();
                this.a.b();
            }
        }
    }
}
